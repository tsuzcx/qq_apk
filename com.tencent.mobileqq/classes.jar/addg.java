import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class addg
  implements CompoundButton.OnCheckedChangeListener
{
  public addg(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    banm.a(paramBoolean);
    if (paramBoolean) {
      banm.a(new addh(this.a.jdField_a_of_type_Adyd, this.a.jdField_a_of_type_AndroidViewView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addg
 * JD-Core Version:    0.7.0.1
 */