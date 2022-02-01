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

public class abay
{
  private static volatile abay jdField_a_of_type_Abay;
  private abag jdField_a_of_type_Abag;
  private abai jdField_a_of_type_Abai;
  private HashMap<String, abbb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private abag jdField_b_of_type_Abag;
  private abai jdField_b_of_type_Abai;
  private HashMap<String, abbc> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  /* Error */
  public static abay a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	abay:jdField_a_of_type_Abay	Labay;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 27	abay:jdField_a_of_type_Abay	Labay;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	abay
    //   21: dup
    //   22: invokespecial 28	abay:<init>	()V
    //   25: putstatic 27	abay:jdField_a_of_type_Abay	Labay;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 27	abay:jdField_a_of_type_Abay	Labay;
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
    //   34	5	0	localabay	abay
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
  
  private void a(abag paramabag)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig()");
    String str;
    if (paramabag != null)
    {
      str = paramabag.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleStyleConfig error!");
      }
    }
    else
    {
      return;
    }
    if (abav.a().a(str))
    {
      a(paramabag, abav.a().b(str));
      return;
    }
    abav.a().a(paramabag.a(), new abaz(this, paramabag, str));
  }
  
  private void a(abag paramabag, String paramString)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "initStyleConfigCache() path:" + paramString);
    Iterator localIterator = paramabag.a().keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      abbb localabbb = new abbb(this, str, paramabag.a().optJSONObject(str));
      localabbb.a(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localabbb);
    }
  }
  
  private void a(abai paramabai)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig()");
    String str;
    if (paramabai != null)
    {
      str = paramabai.a();
      if (TextUtils.isEmpty(str)) {
        QLog.e("Q.videostory.config.VSEntranceWidgetHelper", 1, "handleWidgetConfig error!");
      }
    }
    else
    {
      return;
    }
    if (abav.a().a(str))
    {
      a(paramabai, abav.a().b(str));
      return;
    }
    abav.a().a(paramabai.a(), new abba(this, paramabai, str));
  }
  
  private void a(abai paramabai, String paramString)
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
        abbc localabbc = new abbc(this, str, paramabai.c());
        localabbc.a(paramString + "/" + str);
        localabbc.f = ((String)localObject1);
        this.jdField_b_of_type_JavaUtilHashMap.put(str, localabbc);
      }
    }
  }
  
  private void b()
  {
    a(this.jdField_b_of_type_Abag);
    a(this.jdField_b_of_type_Abai);
  }
  
  private boolean b()
  {
    return BaseApplicationImpl.sProcessId == 2;
  }
  
  public abbb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (abbb)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public abbc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (abbc)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    try
    {
      String str = (String)abac.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Abag = abag.a(str);
        if (this.jdField_a_of_type_Abag != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old style config:" + this.jdField_a_of_type_Abag.toString());
        }
      }
      str = (String)abac.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", "");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Abai = abai.a(str);
        if (this.jdField_a_of_type_Abai != null) {
          QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "old widget config:" + this.jdField_a_of_type_Abai.toString());
        }
      }
      this.jdField_b_of_type_Abag = ((abag)aran.a().a(473));
      if (this.jdField_b_of_type_Abag != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load style config:" + this.jdField_b_of_type_Abag.toString());
      }
      this.jdField_b_of_type_Abai = ((abai)aran.a().a(474));
      if (this.jdField_b_of_type_Abai != null) {
        QLog.i("Q.videostory.config.VSEntranceWidgetHelper", 1, "load widget config:" + this.jdField_b_of_type_Abai.toString());
      }
      if (b())
      {
        if (this.jdField_a_of_type_Abag != null) {
          this.jdField_b_of_type_Abag = this.jdField_a_of_type_Abag;
        }
        if (this.jdField_a_of_type_Abai != null) {
          this.jdField_b_of_type_Abai = this.jdField_a_of_type_Abai;
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
    return abac.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abay
 * JD-Core Version:    0.7.0.1
 */