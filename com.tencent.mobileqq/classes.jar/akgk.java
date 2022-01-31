import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

public class akgk
  implements View.OnClickListener
{
  public akgk(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(alud.a(2131714237));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
      return;
    }
    SessionClearFragment.a(this.a).setText(alud.a(2131714235));
    SessionClearFragment.a(this.a, 0);
    SessionClearFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgk
 * JD-Core Version:    0.7.0.1
 */