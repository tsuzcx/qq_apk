import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class ackb
  implements View.OnClickListener
{
  public ackb(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d == 11) {
      axqy.b(this.a.app, "CliOper", "", "", "0X8006216", "0X8006216", 0, 0, "", "", "", "");
    }
    this.a.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackb
 * JD-Core Version:    0.7.0.1
 */