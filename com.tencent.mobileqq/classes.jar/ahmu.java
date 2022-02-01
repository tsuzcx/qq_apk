import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ahmu
  implements View.OnClickListener
{
  ahmu(ahmt paramahmt) {}
  
  public void onClick(View paramView)
  {
    ahmv localahmv = (ahmv)paramView.getTag();
    Object localObject = agej.a(paramView);
    MessageForPubAccount localMessageForPubAccount;
    if ((localObject instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localObject;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((localahmv == null) || (!(localObject instanceof MessageForPubAccount))) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener holder = " + localahmv + ", msg = " + localObject);
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
      PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localahmv.d);
      pfs.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "mp_msg_msgpic_click", "aio_morpic_click", localahmv.d + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
        if (localMessageForPubAccount.istroop == 1)
        {
          bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          if (((bgre)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localMessageForPubAccount.uniseq)) {
            bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          }
        }
      }
      if (TextUtils.isEmpty(localItem.a_actionData)) {}
      for (localObject = localItem.actionData;; localObject = localItem.a_actionData)
      {
        ahmt.a(this.a, localItem, localahmv, (String)localObject, l);
        ahmt.a(this.a, localMessageForPubAccount, localahmv, l, (String)localObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmu
 * JD-Core Version:    0.7.0.1
 */