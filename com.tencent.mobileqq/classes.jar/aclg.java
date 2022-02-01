import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdReporterForFeedback;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class aclg
  implements View.OnClickListener
{
  public aclg(GdtBannerAd paramGdtBannerAd, acli paramacli) {}
  
  public void onClick(View paramView)
  {
    acqy.b("GdtBannerAd", "getCloseView().onClick");
    AdReporterForFeedback.reportAsync(new WeakReference(this.jdField_a_of_type_Acli.a().getContext()), this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.getAd(), 2001);
    GdtBannerAd.access$200(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclg
 * JD-Core Version:    0.7.0.1
 */