import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.armap.test.ARWebTestActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class abot
  implements Runnable
{
  public abot(ARWebTestActivity paramARWebTestActivity) {}
  
  public void run()
  {
    if (ARWebTestActivity.a(this.a) != null) {
      ARWebTestActivity.a(this.a).a();
    }
    ARWebTestActivity.a(this.a).setVisibility(8);
    if (ARWebTestActivity.a(this.a) == null)
    {
      ARWebTestActivity.a(this.a, new AlphaAnimation(1.0F, 0.0F));
      ARWebTestActivity.a(this.a).setDuration(1000L);
      ARWebTestActivity.a(this.a).setAnimationListener(this.a);
    }
    ARWebTestActivity.a(this.a).startAnimation(ARWebTestActivity.a(this.a));
    if (ARWebTestActivity.b(this.a) == null)
    {
      ARWebTestActivity.b(this.a, new AlphaAnimation(0.0F, 1.0F));
      ARWebTestActivity.b(this.a).setDuration(1000L);
      ARWebTestActivity.b(this.a).setAnimationListener(this.a);
    }
    ARWebTestActivity.a(this.a).startAnimation(ARWebTestActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abot
 * JD-Core Version:    0.7.0.1
 */