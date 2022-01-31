import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.now.enter.NowFestivalEnterFragment;
import com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment;

public class ageo
  implements Runnable
{
  public ageo(NowFestivalEnterFragment paramNowFestivalEnterFragment) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", NowFestivalEnterFragment.a(this.a));
    localIntent.setClass(NowFestivalEnterFragment.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("fragment_class", NowFestivalWebViewFragment.class.getCanonicalName());
    NowFestivalEnterFragment.a(this.a).startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ageo
 * JD-Core Version:    0.7.0.1
 */