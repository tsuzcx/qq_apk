import android.content.Context;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle;
import java.lang.ref.WeakReference;

public final class ablw
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    abrl.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static ablv a(ablu paramablu)
  {
    if ((paramablu == null) || (!paramablu.a()) || (!paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      abrl.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    Object localObject;
    if (paramablu.jdField_a_of_type_Int == 0) {
      if (paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isBannerWithRectangleStyle()) {
        localObject = new GdtBannerViewWithRectangleStyle((Context)paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((ablv)localObject).setSize(paramablu.b, paramablu.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localObject;
      localObject = new GdtBannerViewWithLetterStyle((Context)paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramablu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ablw
 * JD-Core Version:    0.7.0.1
 */