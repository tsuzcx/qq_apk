import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment;

public class afjz
  implements Handler.Callback
{
  public afjz(ChatHistoryAuthDevForRoamMsgFragment paramChatHistoryAuthDevForRoamMsgFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ChatHistoryAuthDevForRoamMsgFragment.a(this.a).findViewById(2131312900).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      bbmy.a(this.a.getActivity(), 2, ajjy.a(2131635821), 0).b(this.a.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.a.getActivity().setResult(1);
      this.a.getActivity().finish();
      return false;
      bbmy.a(this.a.getActivity(), 2, ajjy.a(2131635831), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afjz
 * JD-Core Version:    0.7.0.1
 */