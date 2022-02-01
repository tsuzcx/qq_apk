import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationAdapter;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public final class abzq
  implements AdLocationAdapter
{
  public AdLocation getLocationCache()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("gdt_tangram");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      AdLocation localAdLocation = new AdLocation();
      localAdLocation.latitude = localSosoLbsInfo.mLocation.mLat02;
      localAdLocation.longitude = localSosoLbsInfo.mLocation.mLon02;
      localAdLocation.timeMillis = localSosoLbsInfo.mLocation.locationTime;
      return localAdLocation;
    }
    acho.b("GdtLocationAdapter", String.format("getLocationCache %s", new Object[] { null }));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzq
 * JD-Core Version:    0.7.0.1
 */