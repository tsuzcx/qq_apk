import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aetk
  implements DialogInterface.OnClickListener
{
  aetk(aetj paramaetj, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_Aetj.a.f();
    new ReportTask(this.jdField_a_of_type_Aetj.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_change_click").a(new String[] { "", "" + (this.jdField_a_of_type_Aetj.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "2" }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetk
 * JD-Core Version:    0.7.0.1
 */