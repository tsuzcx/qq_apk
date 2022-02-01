import android.widget.TextView;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

public class aemk
  extends aofu
{
  public aemk(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetAutoAgreeInvite2GroupIn50Flag(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.a.f.a().setChecked(paramBoolean2);
      localTextView = this.a.a;
      if (!paramBoolean2) {
        break label59;
      }
    }
    label59:
    for (int i = 2131692960;; i = 2131692961)
    {
      localTextView.setText(i);
      bhhr.c(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
      return;
    }
  }
  
  protected void onSend0x4ff_86Rsp(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, anvx.a(2131707376), 0).a();
      Switch localSwitch = this.a.f.a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    bhhr.c(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemk
 * JD-Core Version:    0.7.0.1
 */