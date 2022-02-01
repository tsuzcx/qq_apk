import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahkb
  implements View.OnClickListener
{
  public ahkb(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 81) {
      yqu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, "clk_play");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 98)
    {
      afur.n = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a()) {
        break;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i;
    label86:
    Object localObject;
    label101:
    String str2;
    if ((bcyx.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mExtraData) & 0x2) != 0)
    {
      i = 1;
      if (!axbo.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "isFaceScoreSecondMember")) {
        break label156;
      }
      localObject = "2";
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
      if (i == 0) {
        break label162;
      }
    }
    label156:
    label162:
    for (String str1 = "2";; str1 = "1")
    {
      axbo.a("clk_obj", str2, new String[] { localObject, "", "", str1 });
      break;
      i = 0;
      break label86;
      localObject = "1";
      break label101;
    }
    if ((((bhkg)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).b(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 38)) {}
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing instanceof MessageForTroopNotification))
      {
        localObject = (MessageForTroopNotification)this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, ((MessageForTroopNotification)localObject).frienduin, "" + ((MessageForTroopNotification)localObject).feedType, "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      break;
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkb
 * JD-Core Version:    0.7.0.1
 */