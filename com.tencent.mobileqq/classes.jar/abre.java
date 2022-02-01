import com.tencent.qphone.base.util.QLog;

public class abre
  implements abqx
{
  private static abrf a;
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(abrf paramabrf)
  {
    a = paramabrf;
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
  
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abre
 * JD-Core Version:    0.7.0.1
 */