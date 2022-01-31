import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class afmh
  implements bhuk
{
  afmh(afmf paramafmf, MessageForFile paramMessageForFile, bhuf parambhuf, BaseChatItemLayout paramBaseChatItemLayout, afmm paramafmm) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Afmf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop);
    if (paramView != null)
    {
      if (paramView.status == 16)
      {
        arri.a(2131692941);
        this.jdField_a_of_type_Bhuf.cancel();
        return;
      }
      arrr.a(this.jdField_a_of_type_Afmf.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Afmf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    this.jdField_a_of_type_Afmf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Afmm, paramView, false);
    this.jdField_a_of_type_Bhuf.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmh
 * JD-Core Version:    0.7.0.1
 */