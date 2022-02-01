import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdReporterForFeedback;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class ablt
  implements View.OnClickListener
{
  public ablt(GdtBannerAd paramGdtBannerAd, ablv paramablv) {}
  
  public void onClick(View paramView)
  {
    abrl.b("GdtBannerAd", "getCloseView().onClick");
    AdReporterForFeedback.reportAsync(new WeakReference(this.jdField_a_of_type_Ablv.a().getContext()), this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.getAd(), 2001);
    GdtBannerAd.access$500(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ablt
 * JD-Core Version:    0.7.0.1
 */