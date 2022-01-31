import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import mqq.os.MqqHandler;

public class afoe
  extends MqqHandler
{
  public afoe(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afoe
 * JD-Core Version:    0.7.0.1
 */