import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import java.util.TimerTask;

class acxf
  extends TimerTask
{
  acxf(acxe paramacxe) {}
  
  public void run()
  {
    if (acxe.a(this.a) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acxf
 * JD-Core Version:    0.7.0.1
 */