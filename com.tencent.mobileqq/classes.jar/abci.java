import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class abci
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public abci(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onGlobalLayout()
  {
    this.a.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ForwardRecentActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abci
 * JD-Core Version:    0.7.0.1
 */