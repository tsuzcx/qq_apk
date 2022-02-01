import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adwc
  implements View.OnClickListener
{
  public adwc(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((EditActivity.a(this.a) != null) && (EditActivity.a(this.a).isShowing()) && (EditActivity.a(this.a).getWindow() != null)) {
      EditActivity.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwc
 * JD-Core Version:    0.7.0.1
 */