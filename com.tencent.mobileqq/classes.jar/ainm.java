import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.widget.Switch;

class ainm
  implements View.OnClickListener
{
  ainm(aink paramaink, RedTouch paramRedTouch, anec paramanec) {}
  
  public void onClick(View paramView)
  {
    Switch localSwitch;
    if (AppSetting.d)
    {
      localSwitch = (Switch)paramView.findViewById(2131363672);
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
      aink.a(this.jdField_a_of_type_Aink, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_Anec, localSwitch.isChecked());
      paramView.sendAccessibilityEvent(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ainm
 * JD-Core Version:    0.7.0.1
 */