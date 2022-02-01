import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acbi
  implements View.OnClickListener
{
  public acbi(GdtBannerAd paramGdtBannerAd, acbl paramacbl) {}
  
  public void onClick(View paramView)
  {
    acho.b("GdtBannerAd", "getView().onClick");
    if (!GdtBannerAd.access$200(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd)) {
      acho.d("GdtBannerAd", "getView().onClick !isValidClick()");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).a.a = this.jdField_a_of_type_Acbl.a().onClick(paramView);
      GdtHandler.a(GdtBannerAd.access$300(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).a);
      GdtBannerAd.access$400(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbi
 * JD-Core Version:    0.7.0.1
 */