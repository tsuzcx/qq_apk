import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class agcw
  implements View.OnClickListener
{
  public agcw(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg, MessageForStructing paramMessageForStructing, ChatMessage paramChatMessage, long paramLong, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 81) {
      wxj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, "clk_play");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID != 98)
    {
      aepi.n = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a()) {
        break;
      }
      return;
    }
    int i;
    label79:
    String str1;
    label94:
    String str3;
    if ((azxx.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mExtraData) & 0x2) != 0)
    {
      i = 1;
      if (!auuc.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "isFaceScoreSecondMember")) {
        break label149;
      }
      str1 = "2";
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
      if (i == 0) {
        break label155;
      }
    }
    label149:
    label155:
    for (String str2 = "2";; str2 = "1")
    {
      auuc.a("clk_obj", str3, new String[] { str1, "", "", str2 });
      break;
      i = 0;
      break label79;
      str1 = "1";
      break label94;
    }
    if ((((bede)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).b(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID == 38)) {}
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing instanceof MessageForTroopNotification))
      {
        paramView = (MessageForTroopNotification)this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "obj_clk", 0, 0, paramView.frienduin, "" + paramView.feedType, "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a((MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      return;
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcw
 * JD-Core Version:    0.7.0.1
 */