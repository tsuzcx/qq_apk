import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.view.TribeEditVideoButton;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class aifb
  implements View.OnClickListener
{
  public aifb(TribeEditVideoButton paramTribeEditVideoButton) {}
  
  public void onClick(View paramView)
  {
    if (TribeEditVideoButton.a(this.a) == -1) {
      if (!"barindex".equals(TribeEditVideoButton.a(this.a))) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_add_topic", i, 0, "", "", "", "");
      TroopBarPublishUtils.a((Activity)this.a.a(), 1001, TribeEditVideoButton.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aifb
 * JD-Core Version:    0.7.0.1
 */