import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.tmassistantbase.util.GlobalUtil;

public class alrf
  implements Runnable
{
  public alrf(WadlJsBridge paramWadlJsBridge) {}
  
  public void run()
  {
    try
    {
      WLog.b("WadlJsBridge", "initYYBSDKService start restoreTaskFromYYB=false");
      GlobalUtil.getInstance().setContext(WadlJsBridge.a(this.a));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      WLog.b("WadlJsBridge", "initYYBSDKService end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alrf
 * JD-Core Version:    0.7.0.1
 */