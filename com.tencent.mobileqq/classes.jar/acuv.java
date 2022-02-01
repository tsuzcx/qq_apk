import com.tencent.qphone.base.util.QLog;

public class acuv
  implements acun
{
  private static acuw a;
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(acuw paramacuw)
  {
    a = paramacuw;
  }
  
  protected String a(String paramString)
  {
    if (a == null)
    {
      QLog.i("EndCardWebGdtMvWebJsCallHandler", 1, "onGetAdInfo mAction == null");
      return "";
    }
    return a.a(paramString);
  }
  
  protected void a(String paramString)
  {
    if (a == null)
    {
      QLog.i("EndCardWebGdtMvWebJsCallHandler", 1, "onHandleRewardVideoClick mAction == null");
      return;
    }
    a.a(paramString);
  }
  
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuv
 * JD-Core Version:    0.7.0.1
 */