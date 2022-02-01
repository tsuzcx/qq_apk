import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment;
import com.tencent.mobileqq.widget.QQToast;

public class ajqp
  implements Handler.Callback
{
  public ajqp(ChatHistoryAuthDevForRoamMsgFragment paramChatHistoryAuthDevForRoamMsgFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ChatHistoryAuthDevForRoamMsgFragment.a(this.a).findViewById(2131380577).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      QQToast.a(this.a.getActivity(), 2, anvx.a(2131701114), 0).b(this.a.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.a.getActivity().setResult(1);
      this.a.getActivity().finish();
      return false;
      QQToast.a(this.a.getActivity(), 2, anvx.a(2131701124), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqp
 * JD-Core Version:    0.7.0.1
 */