import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle;
import java.lang.ref.WeakReference;

public final class aclj
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    acqy.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static acli a(aclh paramaclh)
  {
    if ((paramaclh == null) || (!paramaclh.a()) || (!paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      acqy.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    Object localObject;
    if (paramaclh.jdField_a_of_type_Int == 0) {
      if (paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isBannerWithRectangleStyle()) {
        localObject = new GdtBannerViewWithRectangleStyle((Context)paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((acli)localObject).a() != null) && (acli.a != null))
      {
        ((acli)localObject).a().setOnTouchListener(new aclk((acli)localObject));
        ((acli)localObject).a().setOnClickListener(new acll((acli)localObject, paramaclh));
      }
      if (localObject != null) {
        ((acli)localObject).setSize(paramaclh.b, paramaclh.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localObject;
      localObject = new GdtBannerViewWithLetterStyle((Context)paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclj
 * JD-Core Version:    0.7.0.1
 */