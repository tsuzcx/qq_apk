import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class aljs
  implements View.OnClickListener
{
  aljs(aljq paramaljq, RedTouch paramRedTouch, aqmf paramaqmf) {}
  
  public void onClick(View paramView)
  {
    Switch localSwitch;
    if (AppSetting.c)
    {
      localSwitch = (Switch)paramView.findViewById(2131363982);
      if (localSwitch != null) {
        if (localSwitch.isChecked()) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      aljq.a(this.jdField_a_of_type_Aljq, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_Aqmf, localSwitch.isChecked());
      paramView.sendAccessibilityEvent(1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljs
 * JD-Core Version:    0.7.0.1
 */