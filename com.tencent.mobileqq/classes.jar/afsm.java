import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

class afsm
  extends TransProcessorHandler
{
  afsm(afsl paramafsl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsm
 * JD-Core Version:    0.7.0.1
 */