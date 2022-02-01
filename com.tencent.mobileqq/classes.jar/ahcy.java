import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahcy
  implements View.OnClickListener
{
  ahcy(ahcp paramahcp) {}
  
  public void onClick(View paramView)
  {
    if (BaseChatItemLayout.a) {}
    label323:
    label846:
    label1104:
    label1107:
    label1123:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Ajxv != null) {
        this.a.jdField_a_of_type_Ajxv.a(0);
      }
      long l = System.currentTimeMillis();
      if (akgc.a(ahcp.jdField_a_of_type_Long, l))
      {
        ahcp.jdField_a_of_type_Long = l;
        int m = bkvx.a(paramView.getTag(2131378178), 0);
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        if ((localMessageForQQWalletMsg == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null))
        {
          QLog.i(ahcp.jdField_a_of_type_JavaLangString, 2, "error, qqWalletMsg: " + localMessageForQQWalletMsg + ", sessionInfo: " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          Object localObject2 = null;
          Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
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
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
            localObject3 = localObject1;
            localObject2 = null;
            localObject1 = localObject4;
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label1123;
            }
            if (QLog.isColorLevel()) {
              QLog.d(ahcp.jdField_a_of_type_JavaLangString, 2, "elem.actionsPriority: " + ((QQWalletBaseMsgElem)localObject1).actionsPriority);
            }
            int i;
            if (TextUtils.isEmpty(((QQWalletBaseMsgElem)localObject1).actionsPriority))
            {
              akgc.b(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).linkUrl);
              break;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
                break label1107;
              }
              if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 10002) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 10004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008))
              {
                i = 1;
                label510:
                if ((i == 0) || (localMessageForQQWalletMsg.isSend())) {
                  break label1104;
                }
                localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              }
            }
            for (;;)
            {
              if ((localMessageForQQWalletMsg.fromHBList != 1) && ((localMessageForQQWalletMsg.istroop == 1) || (localMessageForQQWalletMsg.istroop == 3000)) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)) {
                akat.a(localMessageForQQWalletMsg.frienduin, localMessageForQQWalletMsg.istroop, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
              }
              localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
              localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
              localMessageForQQWalletMsg.msgtype = -2025;
              localMessageForQQWalletMsg.mQQWalletRedPacketMsg.isOpened = true;
              localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForQQWalletMsg.uniseq, localMessageForQQWalletMsg.msgData);
              bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.templateId, "", "", "");
              if ((((QQWalletBaseMsgElem)localObject4).skinId > 0) && ((localMessageForQQWalletMsg.messageType == 2) || (localMessageForQQWalletMsg.messageType == 3))) {
                bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.click", 0, 0, "" + ((QQWalletBaseMsgElem)localObject4).skinId, "", "", "");
              }
              localObject3 = localObject1;
              localObject1 = localObject4;
              break label323;
              i = 0;
              break label510;
              localObject4 = ((QQWalletBaseMsgElem)localObject1).actionsPriority.split("\\|");
              int j = 0;
              i = 0;
              if (j < localObject4.length) {
                if (!TextUtils.isEmpty(localObject4[j])) {
                  break label870;
                }
              }
              for (;;)
              {
                for (;;)
                {
                  j += 1;
                  break label846;
                  break;
                  try
                  {
                    label870:
                    k = Integer.valueOf(localObject4[j]).intValue();
                    if (k == 1)
                    {
                      if (!akgc.b(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).linkUrl)) {
                        break label1099;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(ahcp.jdField_a_of_type_JavaLangString, 2, "start browser...");
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
                        QLog.d(ahcp.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject4[j] + " to Interger,", localException);
                        k = i;
                      }
                    }
                    if (k == 2)
                    {
                      String str = bkvx.a(((QQWalletBaseMsgElem)localObject1).jumpUrl, ahcp.a(this.a, m), true);
                      if (!akgc.a(paramView.getContext(), str)) {
                        break label1099;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(ahcp.jdField_a_of_type_JavaLangString, 2, "do jump action...");
                      break;
                    }
                    if ((k == 3) && (ahcp.a(this.a, paramView.getContext(), (QQWalletBaseMsgElem)localObject1, (String)localObject2, localObject3, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
                    {
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(ahcp.jdField_a_of_type_JavaLangString, 2, "do wallet action...");
                      break;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcy
 * JD-Core Version:    0.7.0.1
 */