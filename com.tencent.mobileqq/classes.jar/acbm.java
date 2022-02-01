import android.content.Context;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle;
import java.lang.ref.WeakReference;

public final class acbm
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    acho.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static acbl a(acbk paramacbk)
  {
    if ((paramacbk == null) || (!paramacbk.a()) || (!paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      acho.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    Object localObject;
    if (paramacbk.jdField_a_of_type_Int == 0) {
      if (paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isBannerWithRectangleStyle()) {
        localObject = new GdtBannerViewWithRectangleStyle((Context)paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((acbl)localObject).setSize(paramacbk.b, paramacbk.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localObject;
      localObject = new GdtBannerViewWithLetterStyle((Context)paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramacbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbm
 * JD-Core Version:    0.7.0.1
 */