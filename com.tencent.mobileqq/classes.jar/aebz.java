import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aebz
  implements CompoundButton.OnCheckedChangeListener
{
  public aebz(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    behh.a(paramBoolean);
    if (paramBoolean) {
      behh.a(new aecq(this.a.jdField_a_of_type_Aexr, this.a.jdField_a_of_type_AndroidViewView));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebz
 * JD-Core Version:    0.7.0.1
 */