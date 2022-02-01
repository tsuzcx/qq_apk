import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class agjh
  implements View.OnClickListener
{
  agjh(agjg paramagjg) {}
  
  public void onClick(View paramView)
  {
    agji localagji = (agji)paramView.getTag();
    Object localObject = AIOUtils.getMessage(paramView);
    MessageForPubAccount localMessageForPubAccount;
    if ((localObject instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localObject;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((localagji == null) || (!(localObject instanceof MessageForPubAccount))) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener holder = " + localagji + ", msg = " + localObject);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localMessageForPubAccount = (MessageForPubAccount)localObject;
        if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.items != null) && (!localMessageForPubAccount.mPAMessage.items.isEmpty())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
        }
      }
      PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localagji.d);
      ple.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, null);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "mp_msg_msgpic_click", "aio_morpic_click", localagji.d + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
        if (localMessageForPubAccount.istroop == 1)
        {
          bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
          if (((bfas)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localMessageForPubAccount.uniseq)) {
            bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
          }
        }
      }
      if (TextUtils.isEmpty(localItem.a_actionData)) {}
      for (localObject = localItem.actionData;; localObject = localItem.a_actionData)
      {
        agjg.a(this.a, localItem, localagji, (String)localObject, l);
        agjg.a(this.a, localMessageForPubAccount, localagji, l, (String)localObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjh
 * JD-Core Version:    0.7.0.1
 */