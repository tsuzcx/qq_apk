import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adxh
  implements View.OnClickListener
{
  public adxh(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxh
 * JD-Core Version:    0.7.0.1
 */