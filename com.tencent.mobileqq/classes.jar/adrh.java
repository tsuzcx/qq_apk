import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adrh
  implements View.OnClickListener
{
  public adrh(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(View paramView)
  {
    MoveToGroupActivity.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrh
 * JD-Core Version:    0.7.0.1
 */