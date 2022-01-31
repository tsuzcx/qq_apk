import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.4;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akwh
  implements aane
{
  public akwh(CmGameBannerAds.4 param4, GdtBannerAd paramGdtBannerAd) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    paramGdtAd = new akwi();
    paramGdtAd.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
    paramGdtAd.b = this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.jdField_a_of_type_Int;
    paramGdtAd.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.b;
    akwg.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.this$0).put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.b), paramGdtAd);
    akwg.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.b, 0, 0);
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, aand paramaand)
  {
    QLog.e("cmgame_process.CmGameBannerAds", 1, "onAdFailedToLoad " + paramaand.a());
    akwg.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.this$0, this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloProcessAdsCmGameBannerAds$4.b, -1, paramaand.a());
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("cmgame_process.CmGameBannerAds", 1, String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwh
 * JD-Core Version:    0.7.0.1
 */