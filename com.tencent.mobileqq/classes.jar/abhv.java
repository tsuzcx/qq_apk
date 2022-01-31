import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class abhv
  implements CompoundButton.OnCheckedChangeListener
{
  public abhv(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aylf.a(paramBoolean);
    if (paramBoolean) {
      aylf.a(new abhw(this.a.jdField_a_of_type_Acck, this.a.jdField_a_of_type_AndroidViewView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhv
 * JD-Core Version:    0.7.0.1
 */