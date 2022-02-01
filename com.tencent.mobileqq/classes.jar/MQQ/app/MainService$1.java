package mqq.app;

import android.widget.Toast;
import com.tencent.qphone.base.remote.FromServiceMsg;

class MainService$1
  implements Runnable
{
  MainService$1(MainService paramMainService, FromServiceMsg paramFromServiceMsg, long paramLong) {}
  
  public void run()
  {
    MobileQQ localMobileQQ = MainService.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Caution! running too long. cmd=");
    localStringBuilder.append(this.val$response.getServiceCmd());
    localStringBuilder.append(" time=");
    localStringBuilder.append(this.val$notifyCost);
    localStringBuilder.append("ms.");
    Toast.makeText(localMobileQQ, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MainService.1
 * JD-Core Version:    0.7.0.1
 */