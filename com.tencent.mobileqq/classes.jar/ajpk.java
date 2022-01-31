import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag;
import com.tencent.qphone.base.util.QLog;

public final class ajpk
  extends TroopObserver
{
  public ajpk(long paramLong, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    paramTroopInfo = new StringBuilder().append("onOIDB0X88D_0_Ret[").append(this.jdField_a_of_type_JavaLangString).append("], troopuin[").append(paramLong).append("], nFlag[").append(paramInt1).append("], isMyFlag[");
    if ((paramInt1 & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("QAVGroupConfig", 1, bool + "], isSuccess[" + paramBoolean + "], result[" + paramInt2 + "], strErrorMsg[" + paramString + "]");
      if (paramInt1 != 480) {
        break;
      }
      if (paramBoolean) {
        QAVGroupConfig.GroupInviteFlag.a(this.jdField_a_of_type_JavaLangString + ".onOIDB0X88D_0_Ret", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajpk
 * JD-Core Version:    0.7.0.1
 */