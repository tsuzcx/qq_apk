import android.widget.TextView;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

public class admv
  extends ameq
{
  public admv(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
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
    for (int i = 2131693300;; i = 2131693301)
    {
      localTextView.setText(i);
      bdne.c(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
      return;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, alud.a(2131708311), 0).a();
      Switch localSwitch = this.a.f.a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    bdne.c(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admv
 * JD-Core Version:    0.7.0.1
 */