import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adkz
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  private WeakReference<VerifyDevLockManager.VerifyDevLockObserver> a;
  
  public adkz(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    this.a = new WeakReference(paramVerifyDevLockObserver);
  }
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public int getSeq()
  {
    if (this.a != null)
    {
      VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.a.get();
      if (localVerifyDevLockObserver != null) {
        return localVerifyDevLockObserver.getSeq();
      }
    }
    return super.getSeq();
  }
  
  public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (this.a != null)
    {
      VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.a.get();
      if (localVerifyDevLockObserver != null) {
        localVerifyDevLockObserver.onRecvNotice(paramNotifyType, paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
      }
    }
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a != null)
    {
      VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.a.get();
      if (localVerifyDevLockObserver != null) {
        localVerifyDevLockObserver.onVerifyClose(paramInt1, paramString, paramInt2, paramErrMsg);
      }
    }
  }
  
  public void setSeq(int paramInt)
  {
    if (this.a != null)
    {
      VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)this.a.get();
      if (localVerifyDevLockObserver != null)
      {
        localVerifyDevLockObserver.setSeq(paramInt);
        return;
      }
    }
    super.setSeq(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkz
 * JD-Core Version:    0.7.0.1
 */