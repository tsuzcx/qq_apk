import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class adxl
  implements View.OnClickListener
{
  public adxl(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    TroopAssistantActivity.a(this.a);
    azmj.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_close", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */