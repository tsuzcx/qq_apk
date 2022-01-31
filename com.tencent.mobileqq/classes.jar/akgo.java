import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

public class akgo
  implements View.OnClickListener
{
  public akgo(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    SessionClearFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgo
 * JD-Core Version:    0.7.0.1
 */