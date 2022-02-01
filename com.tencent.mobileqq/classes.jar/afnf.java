import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afnf
  implements CompoundButton.OnCheckedChangeListener
{
  public afnf(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (((paramCompoundButton == this.a.a.a()) || (paramCompoundButton == this.a.b.a())) && (!bhnv.d(this.a.getActivity())))
    {
      this.a.a(2131694009, 0);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      if (!paramBoolean) {
        SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, paramCompoundButton, bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramCompoundButton == this.a.a.a()) {
        this.a.app.f(paramBoolean, true);
      } else if (paramCompoundButton == this.a.b.a()) {
        this.a.app.g(paramBoolean, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnf
 * JD-Core Version:    0.7.0.1
 */