import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeth
  implements CompoundButton.OnCheckedChangeListener
{
  public aeth(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!bgnt.g(this.a))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131693992, 0).b(this.a.getTitleBarHeight());
      FormSwitchItem localFormSwitchItem = this.a.j;
      if (!paramBoolean) {
        localFormSwitchItem.setChecked(bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((anip)this.a.app.a(2)).g(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeth
 * JD-Core Version:    0.7.0.1
 */