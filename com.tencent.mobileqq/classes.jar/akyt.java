import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.TreeMap;

public class akyt
{
  static String a;
  
  public static String a()
  {
    if (a == null) {
      if (!bbbm.a()) {
        break label56;
      }
    }
    label56:
    for (String str = bbvj.a(ajsd.aW) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(akyn paramakyn)
  {
    if (paramakyn == null) {
      return null;
    }
    paramakyn = (akyo)paramakyn.a().get(Integer.valueOf(0));
    if (paramakyn == null) {
      return null;
    }
    return a(paramakyn);
  }
  
  public static String a(akyo paramakyo)
  {
    return paramakyo.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(akyn paramakyn)
  {
    paramakyn = (akyo)paramakyn.a().get(Integer.valueOf(0));
    if (paramakyn == null) {
      return null;
    }
    return b(paramakyn);
  }
  
  public static String b(akyo paramakyo)
  {
    return paramakyo.d + "guide" + File.separator;
  }
  
  public static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyt
 * JD-Core Version:    0.7.0.1
 */