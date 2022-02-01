import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aecu
  implements View.OnClickListener
{
  public aecu(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity.a(this.a).setVisibility(4);
    EditActivity.a(this.a).setImageResource(2130847887);
    EditActivity.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecu
 * JD-Core Version:    0.7.0.1
 */