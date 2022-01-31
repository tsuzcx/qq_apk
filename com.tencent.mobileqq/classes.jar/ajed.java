import android.widget.ImageButton;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;

public class ajed
  implements Runnable
{
  public ajed(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void run()
  {
    TroopBarReplyActivity.a(this.a, 2);
    this.a.a.setSelected(true);
    this.a.c.setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajed
 * JD-Core Version:    0.7.0.1
 */