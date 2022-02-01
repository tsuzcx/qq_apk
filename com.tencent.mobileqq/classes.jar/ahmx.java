import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahmx
  implements View.OnClickListener
{
  ahmx(ahmw paramahmw) {}
  
  public void onClick(View paramView)
  {
    pfs.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null);
    ahmy localahmy = (ahmy)agej.a(paramView);
    ChatMessage localChatMessage = localahmy.a;
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
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        if (((bgre)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localChatMessage.uniseq)) {
          bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        }
      }
      ahmw.a(this.a, localahmy, localChatMessage, l);
      ahmw.a(this.a, localChatMessage);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmx
 * JD-Core Version:    0.7.0.1
 */