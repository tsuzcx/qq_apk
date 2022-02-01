package mqq.os;

import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

public class MqqMessage
{
  static boolean DEBUG_MESSAGE = true;
  private static final int MAX_POOL_SIZE = 10;
  private static AtomicInteger sIndex = new AtomicInteger(0);
  private static MqqMessage sPool;
  private static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private int index;
  MqqMessage next;
  IMqqMessageCallback target;
  long when;
  Message wrappedMsg;
  
  static
  {
    sPoolSize = 0;
  }
  
  private MqqMessage()
  {
    if (DEBUG_MESSAGE) {
      this.index = sIndex.incrementAndGet();
    }
  }
  
  public static MqqMessage obtain()
  {
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        MqqMessage localMqqMessage = sPool;
        sPool = localMqqMessage.next;
        localMqqMessage.next = null;
        if (DEBUG_MESSAGE) {
          localMqqMessage.index = sIndex.incrementAndGet();
        }
        sPoolSize -= 1;
        return localMqqMessage;
      }
      return new MqqMessage();
    }
  }
  
  public static MqqMessage obtain(Message paramMessage)
  {
    MqqMessage localMqqMessage = obtain();
    localMqqMessage.wrappedMsg = paramMessage;
    return localMqqMessage;
  }
  
  public void recycle()
  {
    ??? = this.wrappedMsg;
    if (??? != null) {
      ((Message)???).recycle();
    }
    this.when = 0L;
    this.wrappedMsg = null;
    this.target = null;
    synchronized (sPoolSync)
    {
      if (sPoolSize < 10)
      {
        this.next = sPool;
        sPool = this;
        sPoolSize += 1;
      }
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MqqMessage@");
    localStringBuilder.append(this.index);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.os.MqqMessage
 * JD-Core Version:    0.7.0.1
 */