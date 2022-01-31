import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame;

public class aide
  extends Handler
{
  public aide(FriendListInnerFrame paramFriendListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a.setPadding(0, 0, 40, 0);
      return;
    }
    this.a.a.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aide
 * JD-Core Version:    0.7.0.1
 */