import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afwa
  implements View.OnClickListener
{
  public afwa(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0, this.a.getIntent());
    this.a.finish();
    if (this.a.d == 11) {
      bdll.b(this.a.app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwa
 * JD-Core Version:    0.7.0.1
 */