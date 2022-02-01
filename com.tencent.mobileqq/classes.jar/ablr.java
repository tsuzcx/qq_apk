import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.api.banner.GdtBannerAd;

public class ablr
  implements View.OnTouchListener
{
  public ablr(GdtBannerAd paramGdtBannerAd, ablv paramablv) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ablv localablv = this.jdField_a_of_type_Ablv;
    ablv.a.onTouch(paramView, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      GdtBannerAd.access$002(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd, paramMotionEvent.getX());
      GdtBannerAd.access$102(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd, paramMotionEvent.getY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ablr
 * JD-Core Version:    0.7.0.1
 */