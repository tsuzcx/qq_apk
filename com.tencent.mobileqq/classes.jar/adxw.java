import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

class adxw
  implements View.OnClickListener
{
  adxw(adxv paramadxv) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a()) {}
    label138:
    label159:
    label194:
    label595:
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (ahiv.a(this.a.c, l))
      {
        this.a.c = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((adxy)actj.a(paramView)).a;
        String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (localMessageForQQWalletMsg != null)
        {
          QQWalletTransferMsgElem localQQWalletTransferMsgElem;
          Object localObject;
          int i;
          if (localMessageForQQWalletMsg.mQQWalletTransferMsg != null)
          {
            localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            if (localMessageForQQWalletMsg.messageType == 9) {
              if (localMessageForQQWalletMsg.isSend())
              {
                axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.buyerclick", 0, 0, "", "", "", "");
                localObject = localMessageForQQWalletMsg.mQQWalletTransferMsg.body;
                if (localObject == null) {
                  break label289;
                }
                i = ((QQWalletAioBodyReserve)localObject).pfa_type;
                if (i != 1) {
                  break label294;
                }
                axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.qiukaitong.click", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d(adxv.jdField_a_of_type_JavaLangString, 2, "onClick pfa_type=" + i);
                }
              }
            }
          }
          for (;;)
          {
            for (;;)
            {
              if (localQQWalletTransferMsgElem == null) {
                break label595;
              }
              if (TextUtils.isEmpty(localQQWalletTransferMsgElem.actionsPriority))
              {
                ahiv.b(paramView.getContext(), localQQWalletTransferMsgElem.linkUrl);
                return;
                axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payerclick", 0, 0, "", "", "", "");
                break label138;
                i = 0;
                break label159;
                if (i != 2) {
                  break label194;
                }
                axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.yikaitong.click", 0, 0, "", "", "", "");
                break label194;
                axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + localMessageForQQWalletMsg.mQQWalletTransferMsg.templateId, "", "", "");
                continue;
              }
              localObject = localQQWalletTransferMsgElem.actionsPriority.split("\\|");
              int j = 0;
              i = 0;
              while (j < localObject.length)
              {
                if (!TextUtils.isEmpty(localObject[j])) {
                  break label429;
                }
                j += 1;
              }
              break;
              try
              {
                k = Integer.valueOf(localObject[j]).intValue();
                if (k == 1)
                {
                  if (ahiv.b(paramView.getContext(), localQQWalletTransferMsgElem.linkUrl)) {
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
                        QLog.d(adxv.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject[j] + " to Interger,", localException);
                        k = i;
                      }
                    }
                    if (k != 2) {
                      break;
                    }
                  } while (!ahiv.a(paramView.getContext(), localQQWalletTransferMsgElem.jumpUrl));
                  return;
                } while ((k != 3) || (!adxv.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, null, str, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)));
                return;
              }
            }
            localQQWalletTransferMsgElem = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxw
 * JD-Core Version:    0.7.0.1
 */