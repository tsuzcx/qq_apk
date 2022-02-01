import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aesh
  implements CompoundButton.OnCheckedChangeListener
{
  public aesh(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    behm.a(paramBoolean);
    if (paramBoolean) {
      behm.a(new aesi(this.a.jdField_a_of_type_Afnr, this.a.jdField_a_of_type_AndroidViewView));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesh
 * JD-Core Version:    0.7.0.1
 */