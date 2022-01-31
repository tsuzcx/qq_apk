import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class agwv
  extends WtloginObserver
{
  agwv(agwt paramagwt, long paramLong, int[] paramArrayOfInt, DevlockInfo[] paramArrayOfDevlockInfo) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    long l;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      paramWUserSigInfo = new StringBuilder().append("CheckDevLockStatus ret: ").append(paramInt).append(", has devinfo: ");
      if (paramDevlockInfo != null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("C2CMsgRoamProxy", 2, bool + ", cost: " + (l - this.jdField_a_of_type_Long) + "ms");
      this.jdField_a_of_type_ArrayOfInt[0] = paramInt;
      this.jdField_a_of_type_ArrayOfOicqWlogin_sdkDevicelockDevlockInfo[0] = paramDevlockInfo;
      agwt.b(this.jdField_a_of_type_Agwt).b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwv
 * JD-Core Version:    0.7.0.1
 */