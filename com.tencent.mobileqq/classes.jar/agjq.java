import Wallet.IdiomRedPackMatchRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class agjq
  implements BusinessObserver
{
  agjq(agjp paramagjp) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 26)
    {
      paramBundle = (IdiomRedPackMatchRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "openSolitaireRedBagByIdiom reportObserver:" + paramBoolean + "|" + paramBundle);
      }
      if ((paramBoolean) && (paramBundle != null))
      {
        if (paramBundle.status != 0) {
          break label104;
        }
        this.a.jdField_a_of_type_Agjk.a(this.a.jdField_a_of_type_Agjj.jdField_a_of_type_JavaLangString, paramBundle.hbIdiom, paramBundle.hbIdiomLastPY, paramBundle.idiomSeq);
      }
    }
    label104:
    do
    {
      return;
      if (paramBundle.status == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PasswdRedBagManager", 2, "sessionInfo.curType: " + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
          this.a.jdField_a_of_type_Agjk.a(this.a.jdField_a_of_type_Agjj.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        paramBundle = new Bundle();
        paramBundle.putString("answer", this.a.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_Agjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_Agjj, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_Int, paramBundle);
        return;
      }
    } while (paramBundle.status != 2);
    long l = NetConnInfoCenter.getServerTime();
    agkn.a(agjk.a(this.a.jdField_a_of_type_Agjk).getCurrentAccountUin(), "idiom_match_in_phone", l + paramBundle.timeInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agjq
 * JD-Core Version:    0.7.0.1
 */