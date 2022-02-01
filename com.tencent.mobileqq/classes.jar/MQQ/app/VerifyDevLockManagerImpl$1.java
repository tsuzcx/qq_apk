package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class VerifyDevLockManagerImpl$1
  extends Handler
{
  VerifyDevLockManagerImpl$1(VerifyDevLockManagerImpl paramVerifyDevLockManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramMessage = (Object[])paramMessage.obj;
      ((VerifyDevLockManager.VerifyDevLockObserver)paramMessage[0]).onVerifyClose(((Integer)paramMessage[1]).intValue(), (String)paramMessage[2], ((Integer)paramMessage[3]).intValue(), (ErrMsg)paramMessage[4]);
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)paramMessage[0];
    localVerifyDevLockObserver.onRecvNotice(((Integer)paramMessage[1]).intValue(), ((Integer)paramMessage[2]).intValue(), (String)paramMessage[3], ((Integer)paramMessage[4]).intValue(), (ErrMsg)paramMessage[5], (DevlockInfo)paramMessage[6]);
    localVerifyDevLockObserver.onReceive(((Integer)paramMessage[1]).intValue(), ((Integer)paramMessage[4]).intValue(), paramMessage[7]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.VerifyDevLockManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */