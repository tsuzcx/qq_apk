import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aarw
  implements View.OnClickListener
{
  public aarw(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(View paramView)
  {
    EditUniqueTitleActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarw
 * JD-Core Version:    0.7.0.1
 */