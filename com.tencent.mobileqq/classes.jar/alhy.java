import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.open.downloadnew.MyAppApi;
import mqq.os.MqqHandler;

public class alhy
  implements TicketUtils.TicketCallback
{
  public alhy(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, long paramLong, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void a()
  {
    LogUtility.a("MyAppApi", "onGetA1Fail ---");
    ThreadManager.getSubThreadHandler().post(new alia(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.a("MyAppApi", "onGetA1 ---");
    ThreadManager.getSubThreadHandler().post(new alhz(this, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhy
 * JD-Core Version:    0.7.0.1
 */