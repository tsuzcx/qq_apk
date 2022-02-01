package mqq.app;

import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.observer.ServerNotifyObserver;

class VerifyCodeManagerImpl$VerifyCodeWrapper
{
  HashMap attr;
  int seq;
  ServerNotifyObserver serverNotifyObserver;
  ToServiceMsg srcTo;
  VerifyCodeInfo verifyCodeInfo;
  
  public VerifyCodeManagerImpl$VerifyCodeWrapper(VerifyCodeManagerImpl paramVerifyCodeManagerImpl, int paramInt)
  {
    this.seq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.VerifyCodeManagerImpl.VerifyCodeWrapper
 * JD-Core Version:    0.7.0.1
 */