import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;

public class ahyy
  extends Handler
{
  public ahyy(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = new bety(this.a.getActivity(), this.a.getActivity().getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.c(2131691584);
      this.a.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyy
 * JD-Core Version:    0.7.0.1
 */