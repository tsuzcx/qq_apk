import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class adpk
  implements bfoq
{
  adpk(adpi paramadpi, MessageForFile paramMessageForFile, bfol parambfol, BaseChatItemLayout paramBaseChatItemLayout, adpp paramadpp) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Adpi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop);
    if (paramView != null)
    {
      if (paramView.status == 16)
      {
        aptv.a(2131692856);
        this.jdField_a_of_type_Bfol.cancel();
        return;
      }
      apue.a(this.jdField_a_of_type_Adpi.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Adpi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    this.jdField_a_of_type_Adpi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Adpp, paramView, false);
    this.jdField_a_of_type_Bfol.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpk
 * JD-Core Version:    0.7.0.1
 */