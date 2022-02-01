package mqq.manager;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class VerifyDevLockManager$VerifyDevLockObserver
{
  private int mSeq;
  
  public int getSeq()
  {
    return this.mSeq;
  }
  
  public void onReceive(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void onRecvNotice(int paramInt1, int paramInt2, String paramString, int paramInt3, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo) {}
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onVerifySuccess(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void setSeq(int paramInt)
  {
    this.mSeq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.manager.VerifyDevLockManager.VerifyDevLockObserver
 * JD-Core Version:    0.7.0.1
 */