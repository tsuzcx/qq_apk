import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class acxs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public acxs(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ForwardRecentActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acxs
 * JD-Core Version:    0.7.0.1
 */