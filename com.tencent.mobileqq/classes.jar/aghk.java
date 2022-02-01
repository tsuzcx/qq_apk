import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class aghk
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private aghk(aghi paramaghi) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EnterForSendHelper", 2, "IME_ACTION_SEND");
      }
      aghi.a(this.a).clickSendTextButton();
      return true;
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = aghi.a(this.a).input;
    if (paramKeyEvent.getKeyCode() == 66)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramView = paramView.getText().toString();
        if (QLog.isColorLevel()) {
          QLog.d("EnterForSendHelper", 2, " sendOnEnterEnabled = " + this.a.a);
        }
        if ((this.a.a) && (paramView.length() > 0)) {
          aghi.a(this.a).send();
        }
      }
      if (this.a.a) {
        return true;
      }
    }
    else if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EnterForSendHelper", 2, "on delete, start: " + paramView.getSelectionStart() + ", end: " + paramView.getSelectionEnd() + ", span: " + paramView.getTag(2131374006));
      }
      if ((paramView.getSelectionStart() == 0) && (paramView.getSelectionEnd() == 0) && (paramView.getTag(2131374006) != null))
      {
        paramKeyEvent = paramView.getCompoundDrawables();
        paramView.setCompoundDrawables(paramKeyEvent[0], null, paramKeyEvent[2], paramKeyEvent[3]);
        paramView.setTag(2131374006, null);
        paramView.setSelection(0);
        aghi.a(this.a).mSourceMsgInfo = null;
        aghi.a(this.a).shouldHideLightVideoBtn(2);
        bdla.b(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 1, "", "", "", "");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghk
 * JD-Core Version:    0.7.0.1
 */