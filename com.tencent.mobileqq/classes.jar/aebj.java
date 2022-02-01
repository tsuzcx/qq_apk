import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class aebj
  implements View.OnClickListener
{
  public aebj(Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    this.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebj
 * JD-Core Version:    0.7.0.1
 */