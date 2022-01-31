import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridgeService;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;

public final class akue
  extends Handler
{
  public akue(WadlJsBridgeService paramWadlJsBridgeService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    WLog.b(WadlJsBridgeService.a(), "The obj field of msg:" + paramMessage.what + "," + paramMessage.obj);
    switch (paramMessage.what)
    {
    case 2: 
    case 3: 
    default: 
    case 0: 
    case 4: 
      for (;;)
      {
        this.a.stopSelf(paramMessage.arg1);
        return;
        WadlProxyServiceUtil.a().b(4, str);
      }
    case 5: 
      WadlProxyServiceUtil.a().a(4, str);
      return;
    }
    paramMessage = new WadlParams(str, "");
    paramMessage.c = 4;
    WadlProxyServiceUtil.a().c(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akue
 * JD-Core Version:    0.7.0.1
 */