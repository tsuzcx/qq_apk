import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class ackq
  implements View.OnClickListener
{
  public ackq(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0, this.a.getIntent());
    this.a.finish();
    if (this.a.d == 11) {
      axqy.b(this.a.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ackq
 * JD-Core Version:    0.7.0.1
 */