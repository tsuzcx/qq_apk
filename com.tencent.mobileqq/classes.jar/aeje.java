import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeje
  implements CompoundButton.OnCheckedChangeListener
{
  public aeje(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bdoq.a(paramBoolean);
    if (paramBoolean) {
      bdoq.a(new aejf(this.a.jdField_a_of_type_Afen, this.a.jdField_a_of_type_AndroidViewView));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeje
 * JD-Core Version:    0.7.0.1
 */