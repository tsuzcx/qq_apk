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

class ahwr
  implements View.OnClickListener
{
  ahwr(ahwl paramahwl) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akos != null) {
        this.a.jdField_a_of_type_Akos.a(1);
      }
      long l = System.currentTimeMillis();
      if (akwv.a(ahwl.jdField_a_of_type_Long, l))
      {
        ahwl.jdField_a_of_type_Long = l;
        Object localObject = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
        aklj localaklj = (aklj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (njo.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localaklj.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          akli localakli = localaklj.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localakli != null) && ((localakli.jdField_a_of_type_Boolean) || (localakli.b) || (localakli.c) || (localakli.jdField_a_of_type_Long < l)))
          {
            localaklj.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
            localaklj.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakli, l, ((MessageForQQWalletMsg)localObject).fromHBList);
            localaklj.a(localQQWalletRedPacketMsg.redPacketId, true);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localakli.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localakli.b + ",isPasswdRedBagOverDue=" + localakli.c);
            }
          }
          else
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
            {
              localObject = (agmv)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
              if (localObject != null) {
                ((agmv)localObject).a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, anni.a(2131709949));
              }
            }
            localaklj.a(localQQWalletRedPacketMsg.redPacketId, false);
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
 * Qualified Name:     ahwr
 * JD-Core Version:    0.7.0.1
 */