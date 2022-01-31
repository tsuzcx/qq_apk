import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.PresenceInterface;
import com.tencent.qphone.base.util.QLog;

public class adzs
  implements View.OnClickListener
{
  public adzs(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if (this.a.a == null) {
      return;
    }
    this.a.a.a(3, paramView);
    QLog.d("HotVideoRelativeLayout", 2, "click mute view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzs
 * JD-Core Version:    0.7.0.1
 */