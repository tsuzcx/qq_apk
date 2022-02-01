import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class ajro
  extends WtloginObserver
{
  public ajro(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, long paramLong, boolean paramBoolean) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    int i = 1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      paramWUserSigInfo = new StringBuilder().append("CheckDevLockStatus ret: ").append(paramInt).append(", has devinfo: ");
      if (paramDevlockInfo == null)
      {
        bool = true;
        QLog.d("Q.history.C2CAllFragment", 2, bool + ", cost: " + (l - this.jdField_a_of_type_Long) + "ms");
      }
    }
    else
    {
      paramWUserSigInfo = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.a.obtainMessage(40);
      paramWUserSigInfo.arg1 = paramInt;
      if (!this.jdField_a_of_type_Boolean) {
        break label135;
      }
    }
    label135:
    for (paramInt = i;; paramInt = 0)
    {
      paramWUserSigInfo.arg2 = paramInt;
      paramWUserSigInfo.obj = paramDevlockInfo;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CAllFragment.a.sendMessage(paramWUserSigInfo);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajro
 * JD-Core Version:    0.7.0.1
 */