import com.tencent.common.config.AppSetting;

public class alyy
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = b(paramString);
      str = bakz.a("RESPCONDITION", paramString);
      if (bakz.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
        return 3;
      }
      if (str.equals("MANUAL")) {
        return 0;
      }
      if (str.equals("AUTO")) {
        return 1;
      }
    } while (!str.equals("SEMIAUTO"));
    return 2;
  }
  
  public static amnn a(String paramString)
  {
    amnn localamnn = new amnn();
    paramString = b(paramString);
    localamnn.a = bakz.a(bakz.a("DESC", paramString));
    localamnn.b = bakz.a(bakz.a("SUBJECT", paramString));
    localamnn.c = bakz.a("RESPCONDITION", paramString);
    if ((!localamnn.c.equals("MANUAL")) && (!localamnn.c.equals("AUTO")) && (!localamnn.c.equals("SEMIAUTO"))) {
      return null;
    }
    localamnn.d = bakz.a("RESPDESC", paramString);
    localamnn.e = bakz.a("RESPCONTENTTYPES", paramString);
    localamnn.f = bakz.a("RESPDEST", paramString);
    localamnn.g = bakz.a("RESPCONTENTS", paramString);
    localamnn.d = bakz.a(localamnn.d);
    localamnn.f = bakz.a(localamnn.f).trim();
    localamnn.g = bakz.a(localamnn.g);
    return localamnn;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return bakz.a("RESPCONTENTTYPES", paramString);
  }
  
  public static amnn b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return paramString;
      if (paramString.c.equals("MANUAL"))
      {
        paramString.a(false);
        return paramString;
      }
      if (paramString.c.equals("AUTO"))
      {
        paramString.a();
        return paramString;
      }
    } while (!paramString.c.equals("SEMIAUTO"));
    paramString.a();
    return paramString;
  }
  
  private static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return bakz.a(bakz.a(paramString, 0, "||QQNO||", alzf.a()), 0, "||LICENCE||", AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyy
 * JD-Core Version:    0.7.0.1
 */