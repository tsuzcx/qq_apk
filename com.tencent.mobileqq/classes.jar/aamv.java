import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class aamv
{
  private static volatile aamv jdField_a_of_type_Aamv;
  private aamd jdField_a_of_type_Aamd;
  private aamf jdField_a_of_type_Aamf;
  private HashMap<String, aamy> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private aamd jdField_b_of_type_Aamd;
  private aamf jdField_b_of_type_Aamf;
  private HashMap<String, aamz> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  /* Error */
  public static aamv a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	aamv:jdField_a_of_type_Aamv	Laamv;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	aamv:jdField_a_of_type_Aamv	Laamv;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	aamv
    //   21: dup
    //   22: invokespecial 28	aamv:<init>	()V
    //   25: putstatic 27	aamv:jdField_a_of_type_Aamv	Laamv;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	aamv:jdField_a_of_type_Aamv	Laamv;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localaamv	aamv
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void a(aamd paramaamd)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramaamd != null)
    {
      str = paramaamd.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (aams.a().a(str))
    {
      a(paramaamd, aams.a().b(str));
      return;
    }
    aams.a().a(paramaamd.a(), new aamw(this, paramaamd, str));
  }
  
  private void a(aamd paramaamd, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramaamd.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aamy localaamy = new aamy(this, str, paramaamd.a().optJSONObject(str));
      localaamy.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localaamy);
    }
  }
  
  private void a(aamf paramaamf)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramaamf != null)
    {
      str = paramaamf.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (aams.a().a(str))
    {
      a(paramaamf, aams.a().b(str));
      return;
    }
    aams.a().a(paramaamf.a(), new aamx(this, paramaamf, str));
  }
  
  private void a(aamf paramaamf, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initWidgetConfigCache() path:" + paramString);
    Object localObject1 = new File(paramString);
    Object localObject2;
    if (((File)localObject1).exists())
    {
      localObject2 = Arrays.asList(((File)localObject1).list());
      if (!((List)localObject2).contains("widget@2x.png")) {
        break label195;
      }
    }
    label195:
    for (localObject1 = paramString + "/" + "widget@2x.png";; localObject1 = "")
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        String str;
        if (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (!"widget@2x.png".equals(str)) {}
        }
        else
        {
          return;
        }
        aamz localaamz = new aamz(this, str, paramaamf.c());
        localaamz.a(paramString + "/" + str);
        localaamz.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localaamz);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Aamd);
    a(this.jdField_b_of_type_Aamf);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public aamy a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aamy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public aamz a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aamz)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Aamd = aamd.a(str);
        if (this.jdField_a_of_type_Aamd != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Aamd.toString());
        }
      }
      str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Aamf = aamf.a(str);
        if (this.jdField_a_of_type_Aamf != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Aamf.toString());
        }
      }
      this.jdField_b_of_type_Aamd = ((aamd)aqxe.a().a(473));
      if (this.jdField_b_of_type_Aamd != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Aamd.toString());
      }
      this.jdField_b_of_type_Aamf = ((aamf)aqxe.a().a(474));
      if (this.jdField_b_of_type_Aamf != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Aamf.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Aamd != null) {
          this.jdField_b_of_type_Aamd = this.jdField_a_of_type_Aamd;
        }
        if (this.jdField_a_of_type_Aamf != null) {
          this.jdField_b_of_type_Aamf = this.jdField_a_of_type_Aamf;
        }
      }
      b();
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, new Object[] { "loadConfig error!" + localException.toString() });
    }
  }
  
  public boolean a()
  {
    return VSConfigManager.getInstance().isApplyWidgetConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamv
 * JD-Core Version:    0.7.0.1
 */