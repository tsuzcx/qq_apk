import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.POIExtarData;
import java.util.List;
import mqq.os.MqqHandler;

public class aazd
  extends ArMapObserver
{
  public aazd(ARGridMapViewDialog paramARGridMapViewDialog) {}
  
  public void onQueryPOI(boolean paramBoolean, POIInfo paramPOIInfo, List paramList, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.a.a instanceof ARGridMapViewDialog.POIExtarData))
    {
      ARGridMapViewDialog.POIExtarData localPOIExtarData = (ARGridMapViewDialog.POIExtarData)this.a.a;
      if (paramLong == localPOIExtarData.a) {
        ThreadManager.getUIHandler().post(new aaze(this, paramBoolean, paramPOIInfo, paramList, localPOIExtarData, paramInt1, paramInt2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazd
 * JD-Core Version:    0.7.0.1
 */