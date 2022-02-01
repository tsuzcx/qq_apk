import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adwb
  implements View.OnClickListener
{
  public adwb(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((EditActivity.a(this.a) != null) && (EditActivity.a(this.a).isShowing()) && (EditActivity.a(this.a).getWindow() != null)) {
      EditActivity.a(this.a).dismiss();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwb
 * JD-Core Version:    0.7.0.1
 */