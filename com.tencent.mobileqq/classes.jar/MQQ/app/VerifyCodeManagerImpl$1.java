package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.observer.ServerNotifyObserver;

class VerifyCodeManagerImpl$1
  extends Handler
{
  VerifyCodeManagerImpl$1(VerifyCodeManagerImpl paramVerifyCodeManagerImpl, Looper paramLooper)
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
      ((ServerNotifyObserver)((Object[])(Object[])paramMessage.obj)[0]).onVerifyClose();
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    ((ServerNotifyObserver)paramMessage[0]).onReceiveVerifyCode((String)paramMessage[1], ((Integer)paramMessage[2]).intValue(), (String)paramMessage[3], (byte[])paramMessage[4]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.VerifyCodeManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */