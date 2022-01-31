import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class abny
  extends ArMapObserver
{
  public abny(ARMapPOIStarDialog paramARMapPOIStarDialog) {}
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapPOIStarDialog", 2, "onOpenPOI : isSuc:" + paramBoolean1 + " itemInfo:" + paramItemInfo + "\nholder:" + paramBoolean2 + "\nbussiType:" + paramInt2 + "\bmode:" + paramInt3 + ", isServerSuccess:" + paramBoolean3);
    }
    ThreadManager.getUIHandler().post(new abnz(this, paramItemInfo, paramInt1));
  }
  
  public void onQueryPOI(boolean paramBoolean, POIInfo paramPOIInfo, List paramList, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapPOIStarDialog", 2, "onQueryPOI : isSuc:" + paramBoolean + " poiInfo:[" + paramPOIInfo + "] itemInfos:" + paramList + " taskStatus:" + paramInt1 + " loadMapFlag:" + paramInt2);
    }
    ThreadManager.getUIHandler().post(new aboa(this, paramPOIInfo, paramList, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abny
 * JD-Core Version:    0.7.0.1
 */