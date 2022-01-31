import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.widget.Switch;

class aino
  implements View.OnClickListener
{
  aino(ainm paramainm, RedTouch paramRedTouch, andx paramandx) {}
  
  public void onClick(View paramView)
  {
    Switch localSwitch;
    if (AppSetting.d)
    {
      localSwitch = (Switch)paramView.findViewById(2131363673);
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
      ainm.a(this.jdField_a_of_type_Ainm, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_Andx, localSwitch.isChecked());
      paramView.sendAccessibilityEvent(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aino
 * JD-Core Version:    0.7.0.1
 */