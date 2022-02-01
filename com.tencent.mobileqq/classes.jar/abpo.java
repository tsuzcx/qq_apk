import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class abpo
  implements AdExposureChecker.ExposureCallback
{
  abpo(abpi paramabpi) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QLog.d("GdtMvViewController", 1, new Object[] { "AdExposureChecker", "onExposure" });
    GdtReporter.doCgiReport(new aboe().a(abpi.a(this.a).a().getUrlForImpression()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpo
 * JD-Core Version:    0.7.0.1
 */