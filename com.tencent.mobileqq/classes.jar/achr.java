import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.lang.ref.WeakReference;

public final class achr
{
  @Deprecated
  public static int[] a(Context paramContext)
  {
    long l2 = System.currentTimeMillis();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("gdt_tangram");
    boolean bool;
    AdAnalysis localAdAnalysis;
    WeakReference localWeakReference;
    long l3;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      bool = true;
      localAdAnalysis = AdAnalysis.INSTANCE;
      localWeakReference = new WeakReference(paramContext);
      l3 = System.currentTimeMillis();
      if (!bool) {
        break label104;
      }
    }
    label104:
    for (long l1 = System.currentTimeMillis() - localSosoLbsInfo.mLocation.locationTime;; l1 = -2147483648L)
    {
      localAdAnalysis.handleAsync(localWeakReference, AdReporterForAnalysis.createEventForLocation(paramContext, bool, l3 - l2, l1));
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
        break label111;
      }
      return null;
      bool = false;
      break;
    }
    label111:
    return new int[] { (int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achr
 * JD-Core Version:    0.7.0.1
 */