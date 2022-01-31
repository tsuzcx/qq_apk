import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;

public class ajud
  implements TouchWebView.OnScrollChangedListener
{
  public ajud(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.a.a != null) {
      this.a.a.scrollBy(0, paramInt2 - paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajud
 * JD-Core Version:    0.7.0.1
 */