package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ProxyIpManagerImpl$1
  extends Handler
{
  ProxyIpManagerImpl$1(ProxyIpManagerImpl paramProxyIpManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return;
    }
    ProxyIpManagerImpl.access$000(this.this$0).onProxyIpChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.ProxyIpManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */