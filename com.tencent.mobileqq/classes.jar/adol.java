import android.widget.ToggleButton;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import java.util.List;

public class adol
  implements awvm
{
  public adol(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton, Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if ((this.a.a(paramProfileLabelInfo.labelId, this.a.jdField_a_of_type_JavaUtilList)) || (this.a.a(this.a.jdField_a_of_type_JavaUtilList)))
      {
        if (this.a.a(this.a.jdField_a_of_type_JavaUtilList)) {
          this.a.b(2131693656);
        }
        return;
      }
      azqs.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "1", "", "", "");
      this.a.jdField_a_of_type_JavaUtilList.add(paramProfileLabelInfo);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Awvn.c(paramProfileLabelInfo, paramToggleButton);
      this.a.a(this.a.jdField_a_of_type_JavaUtilList.size());
      if (this.a.jdField_a_of_type_Adop == null) {
        break;
      }
      this.a.jdField_a_of_type_Adop.notifyDataSetChanged();
      return;
      if (!this.a.a(paramProfileLabelInfo.labelId, this.a.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      this.a.a(paramProfileLabelInfo, this.a.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adol
 * JD-Core Version:    0.7.0.1
 */