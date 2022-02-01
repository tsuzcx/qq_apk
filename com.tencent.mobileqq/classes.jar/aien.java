import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.37.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class aien
  implements DialogInterface.OnClickListener
{
  aien(aidp paramaidp, PublicAccountInfo paramPublicAccountInfo, anrs paramanrs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs = true;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected = true;
    this.jdField_a_of_type_Anrs.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
    this.jdField_a_of_type_Aidp.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.37.1(this);
    this.jdField_a_of_type_Aidp.a.a(paramDialogInterface);
    aidp.c(this.jdField_a_of_type_Aidp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aien
 * JD-Core Version:    0.7.0.1
 */