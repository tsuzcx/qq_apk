import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;

public class ajda
  extends Handler
{
  public ajda(TroopAioNewMessageBar paramTroopAioNewMessageBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == TroopAioNewMessageBar.j) && (TroopAioNewMessageBar.e == this.a.k)) {
      TroopAioNewMessageBar.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */