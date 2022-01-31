import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;

public class ackb
  implements Runnable
{
  public ackb(ExtendFriendVoiceView paramExtendFriendVoiceView) {}
  
  public void run()
  {
    ExtendFriendVoiceView.b(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackb
 * JD-Core Version:    0.7.0.1
 */