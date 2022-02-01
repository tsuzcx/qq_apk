import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter.Params;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.lang.ref.WeakReference;

public class acjt
  implements AdQQMINIProgramAdapter
{
  public AdError show(AdQQMINIProgramAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      acqy.d("GdtQQMINIProgramAdapter", "show error");
      return new AdError(4);
    }
    GdtAd localGdtAd = (GdtAd)GdtAd.class.cast(paramParams.ad);
    acqy.b("GdtQQMINIProgramAdapter", String.format("show %s", new Object[] { localGdtAd.getUrlForLandingPage() }));
    AdReporterForAnalysis.reportForLaunchQQMINIProgramStart((Context)paramParams.context.get(), localGdtAd);
    MiniAppLauncher.startMiniApp((Context)paramParams.context.get(), localGdtAd.getUrlForLandingPage(), 2054, new acju(this, paramParams, localGdtAd));
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjt
 * JD-Core Version:    0.7.0.1
 */