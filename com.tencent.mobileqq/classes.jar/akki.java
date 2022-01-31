import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class akki
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!azzu.a()) {
        break label53;
      }
    }
    label53:
    for (String str = ajed.aU + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(akkc paramakkc)
  {
    if (paramakkc == null) {
      return null;
    }
    paramakkc = (akkd)paramakkc.a().get(Integer.valueOf(0));
    if (paramakkc == null) {
      return null;
    }
    return a(paramakkc);
  }
  
  public static String a(akkd paramakkd)
  {
    return paramakkd.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(akkc paramakkc)
  {
    paramakkc = (akkd)paramakkc.a().get(Integer.valueOf(0));
    if (paramakkc == null) {
      return null;
    }
    return b(paramakkc);
  }
  
  public static String b(akkd paramakkd)
  {
    return paramakkd.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akki
 * JD-Core Version:    0.7.0.1
 */