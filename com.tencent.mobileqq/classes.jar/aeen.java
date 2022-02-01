import com.tencent.mobileqq.activity.JumpActivity;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aeen
  extends WtloginObserver
{
  public aeen(JumpActivity paramJumpActivity) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (paramDevlockInfo != null) {
      aslf.a().a(paramDevlockInfo.TransferInfo);
    }
    paramWUserSigInfo = this.a;
    if (paramInt == 0) {}
    for (;;)
    {
      aoud.a(paramWUserSigInfo, paramDevlockInfo);
      return;
      paramDevlockInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeen
 * JD-Core Version:    0.7.0.1
 */