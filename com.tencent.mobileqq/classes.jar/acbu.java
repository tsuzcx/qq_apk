import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class acbu
  implements CompoundButton.OnCheckedChangeListener
{
  public acbu(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (((paramCompoundButton == this.a.a.a()) || (paramCompoundButton == this.a.b.a())) && (!bbfj.d(this.a.getActivity())))
    {
      this.a.a(2131694674, 0);
      SettingUncommUsedContactsActivity localSettingUncommUsedContactsActivity = this.a;
      if (!paramBoolean)
      {
        paramBoolean = bool;
        SettingUncommUsedContactsActivity.a(localSettingUncommUsedContactsActivity, paramCompoundButton, paramBoolean);
      }
    }
    do
    {
      return;
      paramBoolean = false;
      break;
      if (paramCompoundButton == this.a.a.a())
      {
        this.a.app.f(paramBoolean, true);
        return;
      }
    } while (paramCompoundButton != this.a.b.a());
    this.a.app.g(paramBoolean, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbu
 * JD-Core Version:    0.7.0.1
 */