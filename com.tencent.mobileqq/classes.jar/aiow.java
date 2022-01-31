import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;

public class aiow
  extends Handler
{
  public aiow(TroopAioNewMessageBar paramTroopAioNewMessageBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == TroopAioNewMessageBar.j) && (TroopAioNewMessageBar.e == this.a.k)) {
      TroopAioNewMessageBar.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */