import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class advg
  implements View.OnClickListener
{
  advg(advf paramadvf) {}
  
  public void onClick(View paramView)
  {
    advh localadvh = (advh)paramView.getTag();
    ChatMessage localChatMessage = actj.a(paramView);
    long l2 = -1L;
    long l1 = l2;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      paramView = (MessageForPubAccount)localChatMessage;
      l1 = l2;
      if (paramView.mPAMessage != null)
      {
        l1 = l2;
        if (paramView.mPAMessage.mMsgId > 0L) {
          l1 = paramView.mPAMessage.mMsgId;
        }
      }
    }
    if ((localadvh == null) || (!(localChatMessage instanceof MessageForPubAccount))) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener holder = " + localadvh + ", msg = " + localChatMessage);
      }
    }
    MessageForPubAccount localMessageForPubAccount;
    do
    {
      return;
      localMessageForPubAccount = (MessageForPubAccount)localChatMessage;
      if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.items != null) && (!localMessageForPubAccount.mPAMessage.items.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
    return;
    Object localObject1 = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localadvh.d);
    osx.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) {
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "mp_msg_msgpic_click", "aio_morpic_click", localadvh.d + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
    }
    if (((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) && (localMessageForPubAccount.istroop == 1))
    {
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      if (((bajo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localMessageForPubAccount.uniseq)) {
        axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      }
    }
    label437:
    Object localObject2;
    int i;
    if (TextUtils.isEmpty(((PAMessage.Item)localObject1).a_actionData))
    {
      paramView = ((PAMessage.Item)localObject1).actionData;
      if (TextUtils.isEmpty(paramView)) {
        break label1180;
      }
      localObject2 = bbex.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
      if (localObject2 != null) {
        break label956;
      }
      if (((PAMessage.Item)localObject1).appId != 0L) {
        break label864;
      }
      i = 0;
      label481:
      if (i == 0) {
        break label900;
      }
      if (advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((PAMessage.Item)localObject1).nativeJumpString, ((PAMessage.Item)localObject1).appId, paramView)) {
        break label869;
      }
      advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localadvh.a, localadvh.b, localadvh.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      label569:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
    }
    for (;;)
    {
      l1 = localMessageForPubAccount.mPAMessage.mMsgId;
      if (l1 > 0L) {
        axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(l1), "", "", "");
      }
      localObject1 = (nqn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      localObject2 = (nrf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if ((localChatMessage != null) && (localObject1 != null) && (localObject2 != null) && (((nqn)localObject1).a(localChatMessage.senderuin))) {
        ((nrf)localObject2).a(false, localChatMessage, localadvh.d + 1, paramView);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) == null) || (!((akdh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (localMessageForPubAccount.mPAMessage.items == null) || (localMessageForPubAccount.mPAMessage.items.size() <= 0)) {
        break;
      }
      xhb.a(localMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(0)).title });
      return;
      paramView = ((PAMessage.Item)localObject1).a_actionData;
      break label437;
      label864:
      i = 1;
      break label481;
      label869:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
      break label569;
      label900:
      advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localadvh.a, localadvh.b, localadvh.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      break label569;
      label956:
      if (TextUtils.isEmpty(((bbeg)localObject2).a()))
      {
        if (!advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((PAMessage.Item)localObject1).nativeJumpString, ((PAMessage.Item)localObject1).appId, paramView))
        {
          advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localadvh.a, localadvh.b, localadvh.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
          break label569;
        }
        PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        break label569;
      }
      if (!((bbeg)localObject2).c())
      {
        advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localadvh.a, localadvh.b, localadvh.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
        break label569;
      }
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
      break label569;
      label1180:
      advi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localadvh.a, localadvh.b, localadvh.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advg
 * JD-Core Version:    0.7.0.1
 */