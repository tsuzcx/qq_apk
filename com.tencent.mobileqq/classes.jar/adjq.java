import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adjq
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  private WeakReference<VerifyDevLockManager.VerifyDevLockObserver> a;
  
  public adjq(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    this.a = new WeakReference(paramVerifyDevLockObserver);
  }
  
  public void onReceive(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt, Object paramObject)
  {
    if (this.a.get() == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "VerifyObserverWrapper onReceive mObserver.get() is null");
      return;
    }
    ((VerifyDevLockManager.VerifyDevLockObserver)this.a.get()).onReceive(paramNotifyType, paramInt, paramObject);
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a.get() == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "VerifyObserverWrapper onVerifyClose mObserver.get() is null");
      return;
    }
    ((VerifyDevLockManager.VerifyDevLockObserver)this.a.get()).onVerifyClose(paramInt1, paramString, paramInt2, paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjq
 * JD-Core Version:    0.7.0.1
 */