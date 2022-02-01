import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adkt
  implements CompoundButton.OnCheckedChangeListener
{
  public adkt(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bdai.a(paramBoolean);
    if (paramBoolean) {
      bdai.a(new adlk(this.a.jdField_a_of_type_Aegj, this.a.jdField_a_of_type_AndroidViewView));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkt
 * JD-Core Version:    0.7.0.1
 */