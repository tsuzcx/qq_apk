import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.api.banner.GdtBannerAd;

public class acbh
  implements View.OnTouchListener
{
  public acbh(GdtBannerAd paramGdtBannerAd, acbl paramacbl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Acbl.a().onTouch(paramView, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      GdtBannerAd.access$002(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd, paramMotionEvent.getX());
      GdtBannerAd.access$102(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd, paramMotionEvent.getY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbh
 * JD-Core Version:    0.7.0.1
 */