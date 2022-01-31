import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;

public class aioq
  extends Handler
{
  public aioq(TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aioq
 * JD-Core Version:    0.7.0.1
 */