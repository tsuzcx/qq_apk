import android.os.Bundle;
import android.os.Parcelable;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog.LbsRedBagExtraData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class abgn
  extends LbsPackObserver
{
  public abgn(ARGridMapViewDialog paramARGridMapViewDialog) {}
  
  public void onGetRedPackPage(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null) && (this.a.c == 2))
    {
      long l = paramBundle.getLong("poiId");
      if (QLog.isColorLevel()) {
        QLog.d("ARMapBaseDialog", 2, "ARMapPOIDialog onGetRedPackPage, isSuccess  = " + paramBoolean + " mPoiId=" + l);
      }
      if ((this.a.a instanceof ARGridMapViewDialog.LbsRedBagExtraData))
      {
        ARGridMapViewDialog.LbsRedBagExtraData localLbsRedBagExtraData = (ARGridMapViewDialog.LbsRedBagExtraData)this.a.a;
        if (localLbsRedBagExtraData.a == l)
        {
          Object localObject = paramBundle.getParcelableArrayList("packInfoList");
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Parcelable localParcelable = (Parcelable)((Iterator)localObject).next();
            if ((localParcelable instanceof LbsPackInfo)) {
              localArrayList.add((LbsPackInfo)localParcelable);
            }
          }
          if (localArrayList.size() > 0)
          {
            int i = paramBundle.getInt("packTotalNumber", 0);
            double d1 = paramBundle.getDouble("latitude");
            double d2 = paramBundle.getDouble("longitude");
            int j = paramBundle.getInt("showMapFlag", 0);
            paramBundle = new POIInfo(l, d2, d1);
            paramBundle.a = ((LbsPackInfo)localArrayList.get(0)).d;
            paramBundle.b = ((LbsPackInfo)localArrayList.get(0)).e;
            ThreadManager.getUIHandler().post(new abgo(this, paramBundle, localLbsRedBagExtraData, localArrayList, i, j));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgn
 * JD-Core Version:    0.7.0.1
 */