import android.widget.ImageButton;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;

public class aizc
  implements Runnable
{
  public aizc(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void run()
  {
    TroopBarReplyActivity.a(this.a, 3);
    this.a.a.setSelected(false);
    this.a.c.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizc
 * JD-Core Version:    0.7.0.1
 */