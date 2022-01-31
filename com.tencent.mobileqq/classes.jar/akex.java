import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.widget.Switch;

class akex
  implements View.OnClickListener
{
  akex(akev paramakev, RedTouch paramRedTouch, aovj paramaovj) {}
  
  public void onClick(View paramView)
  {
    Switch localSwitch;
    if (AppSetting.c)
    {
      localSwitch = (Switch)paramView.findViewById(2131363726);
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
      akev.a(this.jdField_a_of_type_Akev, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_Aovj, localSwitch.isChecked());
      paramView.sendAccessibilityEvent(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akex
 * JD-Core Version:    0.7.0.1
 */