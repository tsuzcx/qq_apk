import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

public class ahxu
  implements View.OnClickListener
{
  public ahxu(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(ajjy.a(2131648054));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
      return;
    }
    SessionClearFragment.a(this.a).setText(ajjy.a(2131648052));
    SessionClearFragment.a(this.a, 0);
    SessionClearFragment.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahxu
 * JD-Core Version:    0.7.0.1
 */