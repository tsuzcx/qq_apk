import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aigf
  implements View.OnClickListener
{
  aigf(aifz paramaifz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Alad != null) {
        this.a.jdField_a_of_type_Alad.a(1);
      }
      long l = System.currentTimeMillis();
      if (alik.a(aifz.jdField_a_of_type_Long, l))
      {
        aifz.jdField_a_of_type_Long = l;
        Object localObject = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
        akwu localakwu = (akwu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (nlj.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          akwt localakwt = localakwu.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localakwt != null) && ((localakwt.jdField_a_of_type_Boolean) || (localakwt.b) || (localakwt.c) || (localakwt.jdField_a_of_type_Long < l)))
          {
            localakwu.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
            localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakwt, l, ((MessageForQQWalletMsg)localObject).fromHBList);
            localakwu.a(localQQWalletRedPacketMsg.redPacketId, true);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localakwt.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localakwt.b + ",isPasswdRedBagOverDue=" + localakwt.c);
            }
          }
          else
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
            {
              localObject = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
              if (localObject != null) {
                ((agvx)localObject).a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, anzj.a(2131710058));
              }
            }
            localakwu.a(localQQWalletRedPacketMsg.redPacketId, false);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigf
 * JD-Core Version:    0.7.0.1
 */