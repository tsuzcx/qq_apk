import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.SubscribeBannerView.BannerAdapter;
import com.tencent.biz.subscribe.widget.SubscribeBannerView.DotsIndicator;
import java.util.ArrayList;

public class aaas
  implements ViewPager.OnPageChangeListener
{
  public aaas(SubscribeBannerView paramSubscribeBannerView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((SubscribeBannerView.a(this.a) != null) && (SubscribeBannerView.a(this.a) != null)) {
      SubscribeBannerView.a(this.a).setDotsSelected(paramInt % SubscribeBannerView.a(this.a).a().size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaas
 * JD-Core Version:    0.7.0.1
 */