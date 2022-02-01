import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class aawv
{
  private static volatile aawv jdField_a_of_type_Aawv;
  private aawd jdField_a_of_type_Aawd;
  private aawf jdField_a_of_type_Aawf;
  private HashMap<String, aawy> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private aawd jdField_b_of_type_Aawd;
  private aawf jdField_b_of_type_Aawf;
  private HashMap<String, aawz> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  /* Error */
  public static aawv a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	aawv:jdField_a_of_type_Aawv	Laawv;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	aawv:jdField_a_of_type_Aawv	Laawv;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	aawv
    //   21: dup
    //   22: invokespecial 28	aawv:<init>	()V
    //   25: putstatic 27	aawv:jdField_a_of_type_Aawv	Laawv;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	aawv:jdField_a_of_type_Aawv	Laawv;
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
    //   34	5	0	localaawv	aawv
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
  
  private void a(aawd paramaawd)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramaawd != null)
    {
      str = paramaawd.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (aaws.a().a(str))
    {
      a(paramaawd, aaws.a().b(str));
      return;
    }
    aaws.a().a(paramaawd.a(), new aaww(this, paramaawd, str));
  }
  
  private void a(aawd paramaawd, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramaawd.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aawy localaawy = new aawy(this, str, paramaawd.a().optJSONObject(str));
      localaawy.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localaawy);
    }
  }
  
  private void a(aawf paramaawf)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramaawf != null)
    {
      str = paramaawf.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (aaws.a().a(str))
    {
      a(paramaawf, aaws.a().b(str));
      return;
    }
    aaws.a().a(paramaawf.a(), new aawx(this, paramaawf, str));
  }
  
  private void a(aawf paramaawf, String paramString)
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
        aawz localaawz = new aawz(this, str, paramaawf.c());
        localaawz.a(paramString + "/" + str);
        localaawz.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localaawz);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Aawd);
    a(this.jdField_b_of_type_Aawf);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public aawy a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aawy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public aawz a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aawz)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)aavz.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Aawd = aawd.a(str);
        if (this.jdField_a_of_type_Aawd != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Aawd.toString());
        }
      }
      str = (String)aavz.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Aawf = aawf.a(str);
        if (this.jdField_a_of_type_Aawf != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Aawf.toString());
        }
      }
      this.jdField_b_of_type_Aawd = ((aawd)aqlk.a().a(473));
      if (this.jdField_b_of_type_Aawd != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Aawd.toString());
      }
      this.jdField_b_of_type_Aawf = ((aawf)aqlk.a().a(474));
      if (this.jdField_b_of_type_Aawf != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Aawf.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Aawd != null) {
          this.jdField_b_of_type_Aawd = this.jdField_a_of_type_Aawd;
        }
        if (this.jdField_a_of_type_Aawf != null) {
          this.jdField_b_of_type_Aawf = this.jdField_a_of_type_Aawf;
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
    return aavz.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawv
 * JD-Core Version:    0.7.0.1
 */