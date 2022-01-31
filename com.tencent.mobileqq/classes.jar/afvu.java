import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment;

public class afvu
  implements Handler.Callback
{
  public afvu(ChatHistoryAuthDevForRoamMsgFragment paramChatHistoryAuthDevForRoamMsgFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ChatHistoryAuthDevForRoamMsgFragment.a(this.a).findViewById(2131378730).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      bcql.a(this.a.getActivity(), 2, ajya.a(2131701616), 0).b(this.a.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.a.getActivity().setResult(1);
      this.a.getActivity().finish();
      return false;
      bcql.a(this.a.getActivity(), 2, ajya.a(2131701626), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvu
 * JD-Core Version:    0.7.0.1
 */