import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

public class akbv
  implements View.OnClickListener
{
  public akbv(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(alpo.a(2131714225));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
      return;
    }
    SessionClearFragment.a(this.a).setText(alpo.a(2131714223));
    SessionClearFragment.a(this.a, 0);
    SessionClearFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbv
 * JD-Core Version:    0.7.0.1
 */