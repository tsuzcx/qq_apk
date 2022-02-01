import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiow
  implements View.OnClickListener
{
  public aiow(BlessActivity paramBlessActivity) {}
  
  public void onClick(View paramView)
  {
    bcst.b(this.a.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
    BlessActivity.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */