import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agmb
  implements View.OnClickListener
{
  agmb(agma paramagma) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    label145:
    label166:
    label201:
    label608:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      if (akgc.a(this.a.c, l))
      {
        this.a.c = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((agmd)AIOUtils.getHolder(paramView)).a;
        String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
        if (localMessageForQQWalletMsg != null)
        {
          QQWalletBaseMsgElem localQQWalletBaseMsgElem;
          Object localObject;
          int i;
          if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
          {
            localQQWalletBaseMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            if (localMessageForQQWalletMsg.messageType == 9) {
              if (localMessageForQQWalletMsg.isSend())
              {
                bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.buyerclick", 0, 0, "", "", "", "");
                localObject = localMessageForQQWalletMsg.mQQWalletTransferMsg.body;
                if (localObject == null) {
                  break label298;
                }
                i = ((QQWalletAioBodyReserve)localObject).pfa_type;
                if (i != 1) {
                  break label303;
                }
                bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.qiukaitong.click", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d(agma.jdField_a_of_type_JavaLangString, 2, "onClick pfa_type=" + i);
                }
              }
            }
          }
          for (;;)
          {
            for (;;)
            {
              if (localQQWalletBaseMsgElem == null) {
                break label608;
              }
              if (TextUtils.isEmpty(localQQWalletBaseMsgElem.actionsPriority))
              {
                akgc.b(paramView.getContext(), localQQWalletBaseMsgElem.linkUrl);
                break;
                bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payerclick", 0, 0, "", "", "", "");
                break label145;
                i = 0;
                break label166;
                if (i != 2) {
                  break label201;
                }
                bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.yikaitong.click", 0, 0, "", "", "", "");
                break label201;
                bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletTransferMsg.templateId, "", "", "");
                continue;
              }
              localObject = localQQWalletBaseMsgElem.actionsPriority.split("\\|");
              int j = 0;
              i = 0;
              while (j < localObject.length)
              {
                if (!TextUtils.isEmpty(localObject[j])) {
                  break label438;
                }
                j += 1;
              }
              break;
              try
              {
                k = Integer.valueOf(localObject[j]).intValue();
                if (k == 1)
                {
                  if (akgc.b(paramView.getContext(), localQQWalletBaseMsgElem.linkUrl)) {
                    break;
                  }
                  i = -1;
                }
              }
              catch (Exception localException)
              {
                int k;
                do
                {
                  do
                  {
                    for (;;)
                    {
                      if (QLog.isDevelopLevel()) {
                        localException.printStackTrace();
                      }
                      k = i;
                      if (QLog.isColorLevel())
                      {
                        QLog.d(agma.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject[j] + " to Interger,", localException);
                        k = i;
                      }
                    }
                    if (k != 2) {
                      break;
                    }
                  } while (!akgc.a(paramView.getContext(), localQQWalletBaseMsgElem.jumpUrl));
                  break;
                } while ((k != 3) || (!agma.a(this.a, paramView.getContext(), localQQWalletBaseMsgElem.nativeAndroid, null, str, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)));
              }
            }
            break;
            localQQWalletBaseMsgElem = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmb
 * JD-Core Version:    0.7.0.1
 */