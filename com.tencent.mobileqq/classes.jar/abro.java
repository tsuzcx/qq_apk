import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.lang.ref.WeakReference;

public final class abro
{
  @Deprecated
  public static int[] a(Context paramContext)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("gdt_tangram");
    boolean bool;
    AdAnalysis localAdAnalysis;
    WeakReference localWeakReference;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      bool = true;
      localAdAnalysis = AdAnalysis.INSTANCE;
      localWeakReference = new WeakReference(paramContext);
      if (!bool) {
        break label87;
      }
    }
    label87:
    for (long l = System.currentTimeMillis() - localSosoLbsInfo.mLocation.locationTime;; l = -2147483648L)
    {
      localAdAnalysis.handleAsync(localWeakReference, AdReporterForAnalysis.createEventForLocation(paramContext, bool, l));
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
        break label94;
      }
      return null;
      bool = false;
      break;
    }
    label94:
    return new int[] { (int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abro
 * JD-Core Version:    0.7.0.1
 */