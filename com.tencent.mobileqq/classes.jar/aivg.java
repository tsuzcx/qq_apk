import android.os.Message;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;

public class aivg
  extends aywb
{
  public aivg(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivg
 * JD-Core Version:    0.7.0.1
 */