import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;

class agoj
  implements DialogInterface.OnClickListener
{
  agoj(agof paramagof, View paramView, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = (agoe)this.jdField_a_of_type_AndroidViewView.getTag(2131362740);
    if (paramDialogInterface != null) {
      this.jdField_a_of_type_Agof.a.a(paramDialogInterface.e, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agoj
 * JD-Core Version:    0.7.0.1
 */