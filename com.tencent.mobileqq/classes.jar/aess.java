import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.35.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class aess
  implements DialogInterface.OnClickListener
{
  aess(aerv paramaerv, PublicAccountInfo paramPublicAccountInfo, akdi paramakdi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs = true;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected = true;
    this.jdField_a_of_type_Akdi.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
    this.jdField_a_of_type_Aerv.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.35.1(this);
    this.jdField_a_of_type_Aerv.a.a(paramDialogInterface);
    aerv.c(this.jdField_a_of_type_Aerv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aess
 * JD-Core Version:    0.7.0.1
 */