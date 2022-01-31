import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class adie
  implements CompoundButton.OnCheckedChangeListener
{
  public adie(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!bdee.g(this.a))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131694830, 0).b(this.a.getTitleBarHeight());
      paramCompoundButton = this.a.j;
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        return;
      }
    }
    ((alkv)this.a.app.a(2)).g(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adie
 * JD-Core Version:    0.7.0.1
 */