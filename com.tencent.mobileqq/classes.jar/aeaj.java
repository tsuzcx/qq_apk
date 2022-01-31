import android.view.ViewStub;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.leba.LebaWithFeeds;

public class aeaj
  implements Runnable
{
  public aeaj(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void run()
  {
    ViewStub localViewStub = (ViewStub)this.a.a(2131364872);
    ((CommonLoadingView)this.a.a(2131363809)).setVisibility(8);
    localViewStub.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaj
 * JD-Core Version:    0.7.0.1
 */