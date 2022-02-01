import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abls
  implements View.OnClickListener
{
  public abls(GdtBannerAd paramGdtBannerAd, ablv paramablv) {}
  
  public void onClick(View paramView)
  {
    abrl.b("GdtBannerAd", "getView().onClick");
    if (!GdtBannerAd.access$200(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd)) {
      abrl.d("GdtBannerAd", "getView().onClick !isValidClick()");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GdtHandler.Params localParams = GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
      ablv localablv = this.jdField_a_of_type_Ablv;
      localParams.a = ablv.a.onClick(paramView);
      if (GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick != null) {
        GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
      }
      GdtHandler.a(GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
      GdtBannerAd.access$400(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abls
 * JD-Core Version:    0.7.0.1
 */