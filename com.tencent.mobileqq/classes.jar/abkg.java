import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter.Params;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import java.lang.ref.WeakReference;

class abkg
  implements MiniAppLauncher.MiniAppLaunchListener
{
  abkg(abkf paramabkf, AdQQMINIProgramAdapter.Params paramParams, GdtAd paramGdtAd) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    abrl.b("GdtQQMINIProgramAdapter", String.format("onLaunchResult %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    AdReporterForAnalysis.reportForLaunchQQMINIProgramEND((Context)this.jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter$Params.context.get(), this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkg
 * JD-Core Version:    0.7.0.1
 */