import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeca
  implements CompoundButton.OnCheckedChangeListener
{
  public aeca(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, new Object[] { "mKidModeChatPINYINSwitch click, isChecked=", Boolean.valueOf(paramBoolean) });
    }
    GeneralSettingActivity.a(this.a).a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeca
 * JD-Core Version:    0.7.0.1
 */