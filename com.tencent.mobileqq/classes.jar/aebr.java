import android.view.View;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;

public class aebr
  implements bfoq
{
  public aebr(StructingMsgItemBuilder paramStructingMsgItemBuilder, boolean paramBoolean, ChatMessage paramChatMessage, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        new ayfp(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.cancel();
      return;
      String str1;
      String str2;
      try
      {
        paramInt = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("peerType"));
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("filePath");
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("peerUin");
        str2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("strSendUin");
        if (1 != paramInt) {
          break label133;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, str1);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      continue;
      label133:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, str2, str1, paramInt, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aebr
 * JD-Core Version:    0.7.0.1
 */