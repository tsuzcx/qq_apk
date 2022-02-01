import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import mqq.os.MqqHandler;

public class ajgw
  extends MqqHandler
{
  public ajgw(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (TroopSuspiciousFragment.a(this.a) == null);
      TroopSuspiciousFragment.a(this.a).notifyDataSetChanged();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgw
 * JD-Core Version:    0.7.0.1
 */