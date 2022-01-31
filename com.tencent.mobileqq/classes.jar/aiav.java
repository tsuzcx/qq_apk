import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.widget.Switch;

class aiav
  implements View.OnClickListener
{
  aiav(aiat paramaiat, RedTouch paramRedTouch, amnq paramamnq) {}
  
  public void onClick(View paramView)
  {
    Switch localSwitch;
    if (AppSetting.c)
    {
      localSwitch = (Switch)paramView.findViewById(2131298121);
      if (localSwitch != null) {
        if (localSwitch.isChecked()) {
          break label59;
        }
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      aiat.a(this.jdField_a_of_type_Aiat, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_Amnq, localSwitch.isChecked());
      paramView.sendAccessibilityEvent(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiav
 * JD-Core Version:    0.7.0.1
 */