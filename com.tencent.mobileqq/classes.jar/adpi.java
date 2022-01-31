import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class adpi
  implements bfph
{
  adpi(adpg paramadpg, MessageForFile paramMessageForFile, bfpc parambfpc, BaseChatItemLayout paramBaseChatItemLayout, adpn paramadpn) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Adpg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop);
    if (paramView != null)
    {
      if (paramView.status == 16)
      {
        aptx.a(2131692857);
        this.jdField_a_of_type_Bfpc.cancel();
        return;
      }
      apug.a(this.jdField_a_of_type_Adpg.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_Adpg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    this.jdField_a_of_type_Adpg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Adpn, paramView, false);
    this.jdField_a_of_type_Bfpc.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpi
 * JD-Core Version:    0.7.0.1
 */