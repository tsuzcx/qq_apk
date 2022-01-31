import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class aajk
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    aanp.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static aajj a(aaji paramaaji)
  {
    if ((paramaaji == null) || (!paramaaji.a()) || (!paramaaji.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      aanp.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    if (paramaaji.jdField_a_of_type_Int == 0) {}
    for (aajn localaajn = new aajn((Context)paramaaji.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaaji.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);; localaajn = null)
    {
      if ((localaajn != null) && (localaajn.a() != null) && (aajj.a != null))
      {
        localaajn.a().setOnTouchListener(new aajl(localaajn));
        localaajn.a().setOnClickListener(new aajm(localaajn, paramaaji));
      }
      if (localaajn != null) {
        localaajn.a(paramaaji.b, paramaaji.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramaaji.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaaji.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localaajn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajk
 * JD-Core Version:    0.7.0.1
 */