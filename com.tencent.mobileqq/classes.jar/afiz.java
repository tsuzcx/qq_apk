import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afiz
  implements View.OnClickListener
{
  public afiz(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afiz
 * JD-Core Version:    0.7.0.1
 */