import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.OnVidoeControlListener;
import com.tencent.qphone.base.util.QLog;

public class adzr
  implements View.OnClickListener
{
  public adzr(HotVideoMongoliaRelativeLayout paramHotVideoMongoliaRelativeLayout) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.hotpic.HotPicPageView.b = true;
    if (this.a.a == null) {
      return;
    }
    if (HotVideoMongoliaRelativeLayout.a(this.a) != null) {
      HotVideoMongoliaRelativeLayout.a(this.a).b(HotVideoMongoliaRelativeLayout.a(this.a));
    }
    QLog.d("HotVideoRelativeLayout", 2, "click round rect send view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzr
 * JD-Core Version:    0.7.0.1
 */