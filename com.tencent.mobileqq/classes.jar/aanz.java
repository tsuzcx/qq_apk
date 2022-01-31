import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class aanz
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    aase.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static aany a(aanx paramaanx)
  {
    if ((paramaanx == null) || (!paramaanx.a()) || (!paramaanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      aase.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    if (paramaanx.jdField_a_of_type_Int == 0) {}
    for (aaoc localaaoc = new aaoc((Context)paramaanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);; localaaoc = null)
    {
      if ((localaaoc != null) && (localaaoc.a() != null) && (aany.a != null))
      {
        localaaoc.a().setOnTouchListener(new aaoa(localaaoc));
        localaaoc.a().setOnClickListener(new aaob(localaaoc, paramaanx));
      }
      if (localaaoc != null) {
        localaaoc.a(paramaanx.b, paramaanx.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramaanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramaanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localaaoc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanz
 * JD-Core Version:    0.7.0.1
 */