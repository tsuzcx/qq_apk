import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

public class aanu
  implements View.OnClickListener
{
  public aanu(GdtBannerAd paramGdtBannerAd, aany paramaany) {}
  
  public void onClick(View paramView)
  {
    aase.b("GdtBannerAd", "onClick");
    aany localaany = this.jdField_a_of_type_Aany;
    paramView = aany.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      aase.b("GdtBannerAd", "onclick:" + GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    GdtHandler.a(GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
    GdtBannerAd.access$100(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanu
 * JD-Core Version:    0.7.0.1
 */