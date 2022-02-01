import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeww
  implements CompoundButton.OnCheckedChangeListener
{
  public aeww(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      ((axwo)this.a.app.a(66)).a(paramBoolean);
      this.a.app.reportClickEvent("CliOper", "0X8006729");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramCompoundButton == this.a.c.a())
      {
        this.a.app.e(true, paramBoolean);
      }
      else
      {
        QQAppInterface localQQAppInterface;
        String str;
        if (paramCompoundButton == this.a.b.a())
        {
          localQQAppInterface = this.a.app;
          if (paramBoolean) {}
          for (str = "1";; str = "0")
          {
            bdll.b(localQQAppInterface, "dc00898", "", "", "0X8007614", "0X8007614", 0, 0, str, "", "", "");
            this.a.jdField_a_of_type_Anum.h(paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == this.a.d.a())
        {
          localQQAppInterface = this.a.app;
          if (paramBoolean) {}
          for (str = "1";; str = "2")
          {
            bdll.b(localQQAppInterface, "dc00898", "", "", "0X800791B", "0X800791B", 0, 0, str, "", "", "");
            this.a.jdField_a_of_type_Anum.f(paramBoolean);
            if (paramBoolean) {
              break label249;
            }
            this.a.b.setVisibility(8);
            break;
          }
          label249:
          this.a.b.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeww
 * JD-Core Version:    0.7.0.1
 */