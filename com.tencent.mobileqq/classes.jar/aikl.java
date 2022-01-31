import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

public class aikl
  implements View.OnClickListener
{
  public aikl(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(ajya.a(2131713853));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
      return;
    }
    SessionClearFragment.a(this.a).setText(ajya.a(2131713851));
    SessionClearFragment.a(this.a, 0);
    SessionClearFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aikl
 * JD-Core Version:    0.7.0.1
 */