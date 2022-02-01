import com.tencent.qphone.base.util.QLog;

public class acqr
  implements acqj
{
  private static acqs a;
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(acqs paramacqs)
  {
    a = paramacqs;
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
  
  public boolean a(acpp paramacpp, String paramString, String... paramVarArgs)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqr
 * JD-Core Version:    0.7.0.1
 */