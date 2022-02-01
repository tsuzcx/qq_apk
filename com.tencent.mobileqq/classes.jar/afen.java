import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afen
  implements View.OnClickListener
{
  public afen(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afen
 * JD-Core Version:    0.7.0.1
 */