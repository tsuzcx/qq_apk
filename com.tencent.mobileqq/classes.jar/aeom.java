import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeom
  implements View.OnClickListener
{
  public aeom(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeom
 * JD-Core Version:    0.7.0.1
 */