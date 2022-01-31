import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class akyu
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!bbay.a()) {
        break label56;
      }
    }
    label56:
    for (String str = bbuv.a(ajsf.aW) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(akyo paramakyo)
  {
    if (paramakyo == null) {
      return null;
    }
    paramakyo = (akyp)paramakyo.a().get(Integer.valueOf(0));
    if (paramakyo == null) {
      return null;
    }
    return a(paramakyo);
  }
  
  public static String a(akyp paramakyp)
  {
    return paramakyp.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(akyo paramakyo)
  {
    paramakyo = (akyp)paramakyo.a().get(Integer.valueOf(0));
    if (paramakyo == null) {
      return null;
    }
    return b(paramakyo);
  }
  
  public static String b(akyp paramakyp)
  {
    return paramakyp.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyu
 * JD-Core Version:    0.7.0.1
 */