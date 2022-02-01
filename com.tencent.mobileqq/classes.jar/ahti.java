import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class ahti
  implements DialogInterface.OnClickListener
{
  public ahti(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))
    {
      paramDialogInterface = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 35)) {
        axpf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, "", paramDialogInterface.structingMsg, paramDialogInterface.uniseq, true, 0);
      }
      do
      {
        return;
        if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 107))
        {
          axpf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, "", paramDialogInterface.structingMsg, paramDialogInterface.uniseq, true, 5);
          return;
        }
      } while ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 95) && (new bebw(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramDialogInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)));
    }
    aean.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahti
 * JD-Core Version:    0.7.0.1
 */