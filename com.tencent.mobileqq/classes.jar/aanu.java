import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aanu
  implements View.OnClickListener
{
  public aanu(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(View paramView)
  {
    EditUniqueTitleActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanu
 * JD-Core Version:    0.7.0.1
 */