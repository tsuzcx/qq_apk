import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adhd
  implements CompoundButton.OnCheckedChangeListener
{
  public adhd(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      ((auwm)this.a.app.a(66)).a(paramBoolean);
      this.a.app.reportClickEvent("CliOper", "0X8006729");
    }
    do
    {
      return;
      if (paramCompoundButton == this.a.c.a())
      {
        this.a.app.e(true, paramBoolean);
        return;
      }
      if (paramCompoundButton == this.a.b.a())
      {
        localQQAppInterface = this.a.app;
        if (paramBoolean) {}
        for (paramCompoundButton = "1";; paramCompoundButton = "0")
        {
          azqs.b(localQQAppInterface, "dc00898", "", "", "0X8007614", "0X8007614", 0, 0, paramCompoundButton, "", "", "");
          this.a.jdField_a_of_type_Alpk.h(paramBoolean);
          return;
        }
      }
    } while (paramCompoundButton != this.a.d.a());
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "2")
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X800791B", "0X800791B", 0, 0, paramCompoundButton, "", "", "");
      this.a.jdField_a_of_type_Alpk.f(paramBoolean);
      if (paramBoolean) {
        break;
      }
      this.a.b.setVisibility(8);
      return;
    }
    this.a.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhd
 * JD-Core Version:    0.7.0.1
 */