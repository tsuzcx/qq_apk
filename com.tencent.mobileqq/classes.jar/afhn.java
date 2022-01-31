import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder.6.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class afhn
  implements bhqd
{
  afhn(afhh paramafhh, MessageForFile paramMessageForFile, bhpy parambhpy, BaseChatItemLayout paramBaseChatItemLayout, afhp paramafhp) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L) != -1) {
      this.jdField_a_of_type_Afhh.b.post(new FileItemBuilder.6.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.cancel();
      return;
      paramView = arni.a(this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (paramView.status == 16)
      {
        armz.a(2131692939);
        this.jdField_a_of_type_Bhpy.cancel();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      paramInt = paramView.peerType;
      paramView.peerType = this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if ((paramView.nOpType != 21) && (paramView.nOpType != 22) && (paramView.nOpType != 27) && (paramView.nOpType != 20)) {
        paramView.selfUin = this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      arni.a(this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.selfUin, paramView.peerUin, paramView);
      if ((this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000)) {
        paramView.tmpSessionRelatedUin = this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
      }
      paramView.peerType = paramInt;
      arni.a(this.jdField_a_of_type_Afhh.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Afhh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_Afhh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Afhp, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhn
 * JD-Core Version:    0.7.0.1
 */