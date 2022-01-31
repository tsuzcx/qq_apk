import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import mqq.os.MqqHandler;

public class aknd
  extends MqqHandler
{
  public aknd(HiddenChatFragment paramHiddenChatFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.getActivity() == null) || (!this.a.getActivity().app.isLogin())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aknd
 * JD-Core Version:    0.7.0.1
 */