import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import java.util.TimerTask;

class adfm
  extends TimerTask
{
  adfm(adfl paramadfl) {}
  
  public void run()
  {
    if (adfl.a(this.a) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adfm
 * JD-Core Version:    0.7.0.1
 */