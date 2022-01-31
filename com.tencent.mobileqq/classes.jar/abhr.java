import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class abhr
  implements CompoundButton.OnCheckedChangeListener
{
  public abhr(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aylh.a(paramBoolean);
    if (paramBoolean) {
      aylh.a(new abhs(this.a.jdField_a_of_type_Accg, this.a.jdField_a_of_type_AndroidViewView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhr
 * JD-Core Version:    0.7.0.1
 */