import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afyi
  implements View.OnClickListener
{
  public afyi(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyi
 * JD-Core Version:    0.7.0.1
 */