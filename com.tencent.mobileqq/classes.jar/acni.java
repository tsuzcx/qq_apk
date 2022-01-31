import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import java.util.TimerTask;

class acni
  extends TimerTask
{
  acni(acnh paramacnh) {}
  
  public void run()
  {
    if (acnh.a(this.a) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acni
 * JD-Core Version:    0.7.0.1
 */