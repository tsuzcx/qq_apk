import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.38.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class aiof
  implements DialogInterface.OnClickListener
{
  aiof(ainh paramainh, PublicAccountInfo paramPublicAccountInfo, aody paramaody) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs = true;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsSyncLbsSelected = true;
    this.jdField_a_of_type_Aody.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
    this.jdField_a_of_type_Ainh.a(1, null);
    paramDialogInterface = new PublicAccountChatPie.38.1(this);
    this.jdField_a_of_type_Ainh.a.a(paramDialogInterface);
    ainh.i(this.jdField_a_of_type_Ainh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiof
 * JD-Core Version:    0.7.0.1
 */