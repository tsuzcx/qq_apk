import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.PublicAccountInfo;

class aiog
  implements DialogInterface.OnClickListener
{
  aiog(ainh paramainh, PublicAccountInfo paramPublicAccountInfo, aody paramaody) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs = false;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected = true;
    this.jdField_a_of_type_Aody.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
    this.jdField_a_of_type_Ainh.a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiog
 * JD-Core Version:    0.7.0.1
 */