import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahca
  implements View.OnClickListener
{
  ahca(ahbz paramahbz) {}
  
  public void onClick(View paramView)
  {
    pwb.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, null);
    ahcb localahcb = (ahcb)AIOUtils.getHolder(paramView);
    ChatMessage localChatMessage = localahcb.a;
    MessageForPubAccount localMessageForPubAccount;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localChatMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localChatMessage.istroop == 1))
      {
        bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
        if (((bgiy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localChatMessage.uniseq)) {
          bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
        }
      }
      ahbz.a(this.a, localahcb, localChatMessage, l);
      ahbz.a(this.a, localChatMessage);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahca
 * JD-Core Version:    0.7.0.1
 */