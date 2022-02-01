package mqq.os;

import android.util.Log;

class MqqMessageQueue$2
  extends Thread
{
  MqqMessageQueue$2(MqqMessageQueue paramMqqMessageQueue, Throwable paramThrowable) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queueIdle encounter business crash. ");
    localStringBuilder.append(Log.getStackTraceString(this.val$e));
    throw new RuntimeException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.os.MqqMessageQueue.2
 * JD-Core Version:    0.7.0.1
 */