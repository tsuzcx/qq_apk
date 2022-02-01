import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbq
  implements View.OnClickListener
{
  public afbq(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    TroopAssistantActivity.a(this.a);
    bdla.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_close", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbq
 * JD-Core Version:    0.7.0.1
 */