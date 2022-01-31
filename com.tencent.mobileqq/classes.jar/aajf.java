import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

public class aajf
  implements View.OnClickListener
{
  public aajf(GdtBannerAd paramGdtBannerAd, aajj paramaajj) {}
  
  public void onClick(View paramView)
  {
    aanp.b("GdtBannerAd", "onClick");
    aajj localaajj = this.jdField_a_of_type_Aajj;
    paramView = aajj.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      aanp.b("GdtBannerAd", "onclick:" + GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    GdtHandler.a(GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
    GdtBannerAd.access$100(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajf
 * JD-Core Version:    0.7.0.1
 */