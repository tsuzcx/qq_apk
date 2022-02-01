import com.tencent.qphone.base.util.QLog;

public class ache
  implements acgx
{
  private static achf a;
  
  public static void a(achf paramachf)
  {
    a = paramachf;
  }
  
  public static void c()
  {
    a = null;
  }
  
  protected String a(String paramString)
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onGetAdInfo mAction == null");
      return "";
    }
    return a.a(paramString);
  }
  
  protected void a()
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onVideoClose mAction == null");
      return;
    }
    a.a();
  }
  
  protected void a(String paramString)
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onReportAntiSpam mAction == null");
      return;
    }
    a.a(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onHandleRewardVideoClick mAction == null");
      return;
    }
    a.a(paramString, paramBoolean);
  }
  
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    return true;
  }
  
  protected void b()
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onVideoMute mAction == null");
      return;
    }
    a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ache
 * JD-Core Version:    0.7.0.1
 */