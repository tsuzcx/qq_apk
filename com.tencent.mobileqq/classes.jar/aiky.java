import android.widget.ImageButton;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;

public class aiky
  implements Runnable
{
  public aiky(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void run()
  {
    TroopBarReplyActivity.a(this.a, 3);
    this.a.a.setSelected(false);
    this.a.c.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiky
 * JD-Core Version:    0.7.0.1
 */