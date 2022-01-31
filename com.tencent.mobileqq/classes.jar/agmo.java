import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

class agmo
  implements View.OnClickListener
{
  agmo(agmg paramagmg) {}
  
  public void onClick(View paramView)
  {
    if (BaseChatItemLayout.a) {}
    label314:
    label834:
    label1105:
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Aixi != null) {
        this.a.jdField_a_of_type_Aixi.a(0);
      }
      long l = System.currentTimeMillis();
      if (ajet.a(agmg.jdField_a_of_type_Long, l))
      {
        agmg.jdField_a_of_type_Long = l;
        int m = bjcf.a(paramView.getTag(2131377425), 0);
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        if ((localMessageForQQWalletMsg == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null))
        {
          QLog.i(agmg.jdField_a_of_type_JavaLangString, 2, "error, qqWalletMsg: " + localMessageForQQWalletMsg + ", sessionInfo: " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
        Object localObject2 = null;
        Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        Object localObject4;
        Object localObject3;
        if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
        {
          localObject4 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
          localMessageForQQWalletMsg.msgtype = -2025;
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = "";
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = "";
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = 0;
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId = 0;
          localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
          localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
          localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
          localObject3 = localObject1;
          localObject2 = null;
          localObject1 = localObject4;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label1105;
          }
          if (QLog.isColorLevel()) {
            QLog.d(agmg.jdField_a_of_type_JavaLangString, 2, "elem.actionsPriority: " + ((QQWalletTransferMsgElem)localObject1).actionsPriority);
          }
          int i;
          if (TextUtils.isEmpty(((QQWalletTransferMsgElem)localObject1).actionsPriority))
          {
            ajet.b(paramView.getContext(), ((QQWalletTransferMsgElem)localObject1).linkUrl);
            return;
            if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
              break label1089;
            }
            if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
            {
              i = 1;
              label499:
              if ((i == 0) || (localMessageForQQWalletMsg.isSend())) {
                break label1086;
              }
              localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            }
          }
          for (;;)
          {
            if ((localMessageForQQWalletMsg.fromHBList != 1) && ((localMessageForQQWalletMsg.istroop == 1) || (localMessageForQQWalletMsg.istroop == 3000)) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)) {
              aizw.a(localMessageForQQWalletMsg.frienduin, localMessageForQQWalletMsg.istroop, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
            }
            localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
            localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
            localMessageForQQWalletMsg.msgtype = -2025;
            localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
            localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
            azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId, "", "", "");
            if ((((QQWalletTransferMsgElem)localObject4).skinId > 0) && ((localMessageForQQWalletMsg.messageType == 2) || (localMessageForQQWalletMsg.messageType == 3))) {
              azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.click", 0, 0, "" + ((QQWalletTransferMsgElem)localObject4).skinId, "", "", "");
            }
            localObject3 = localObject1;
            localObject1 = localObject4;
            break label314;
            i = 0;
            break label499;
            localObject4 = ((QQWalletTransferMsgElem)localObject1).actionsPriority.split("\\|");
            int j = 0;
            i = 0;
            if (j < localObject4.length) {
              if (!TextUtils.isEmpty(localObject4[j])) {
                break label858;
              }
            }
            for (;;)
            {
              for (;;)
              {
                j += 1;
                break label834;
                break;
                try
                {
                  label858:
                  k = Integer.valueOf(localObject4[j]).intValue();
                  if (k == 1)
                  {
                    if (!ajet.b(paramView.getContext(), ((QQWalletTransferMsgElem)localObject1).linkUrl)) {
                      break label1081;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(agmg.jdField_a_of_type_JavaLangString, 2, "start browser...");
                    return;
                  }
                }
                catch (Exception localException)
                {
                  int k;
                  for (;;)
                  {
                    if (QLog.isDevelopLevel()) {
                      localException.printStackTrace();
                    }
                    k = i;
                    if (QLog.isColorLevel())
                    {
                      QLog.d(agmg.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject4[j] + " to Interger,", localException);
                      k = i;
                    }
                  }
                  if (k == 2)
                  {
                    String str = bjcf.a(((QQWalletTransferMsgElem)localObject1).jumpUrl, agmg.a(this.a, m), true);
                    if (!ajet.a(paramView.getContext(), str)) {
                      break label1081;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(agmg.jdField_a_of_type_JavaLangString, 2, "do jump action...");
                    return;
                  }
                  if ((k == 3) && (agmg.a(this.a, paramView.getContext(), (QQWalletTransferMsgElem)localObject1, (String)localObject2, localObject3, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
                  {
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d(agmg.jdField_a_of_type_JavaLangString, 2, "do wallet action...");
                    return;
                  }
                  i = -1;
                }
              }
            }
          }
          localObject3 = localObject1;
          localObject4 = null;
          localObject1 = localObject2;
          localObject2 = localObject4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmo
 * JD-Core Version:    0.7.0.1
 */