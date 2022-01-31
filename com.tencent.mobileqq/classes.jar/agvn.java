import GROUP.MessageRemindRsp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

public class agvn
  extends amcd
{
  public agvn(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, MessageRemindRsp paramMessageRemindRsp)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("vip_pretty." + this.a.jdField_a_of_type_JavaLangString, 2, "SVIPObserver.onGetBigTroopExpiredInfo, troopUin: " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " iFreezedType=" + paramMessageRemindRsp.iFreezedType + " iLhGroupExpiredTime=" + paramMessageRemindRsp.iLhGroupExpiredTime + " iGroupType=" + paramMessageRemindRsp.iGroupType);
      }
      ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRemindRsp);
      TroopManager.a(paramMessageRemindRsp, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidContentContext, this.a, TroopChatPie.b(this.a));
      return;
    }
    QLog.e("vip_pretty." + this.a.jdField_a_of_type_JavaLangString, 2, String.format("SVIPObserver.onGetBigTroopExpiredInfo, troopUin: %s, isSuccess: false", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvn
 * JD-Core Version:    0.7.0.1
 */