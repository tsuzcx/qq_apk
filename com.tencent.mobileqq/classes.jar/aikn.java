import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

public class aikn
  implements View.OnClickListener
{
  public aikn(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(ajyc.a(2131713842));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
      return;
    }
    SessionClearFragment.a(this.a).setText(ajyc.a(2131713840));
    SessionClearFragment.a(this.a, 0);
    SessionClearFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aikn
 * JD-Core Version:    0.7.0.1
 */