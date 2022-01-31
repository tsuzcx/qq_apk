import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.grayversion.ShareAppLogActivity;

public class aaev
  implements View.OnClickListener
{
  public aaev(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(ShareAppLogActivity.buildIntent(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaev
 * JD-Core Version:    0.7.0.1
 */