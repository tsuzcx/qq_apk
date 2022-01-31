import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.Info;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abfp
  extends ArMapObserver
{
  public abfp(ShopScanCheckHandler paramShopScanCheckHandler) {}
  
  public void onQueryPOI(boolean paramBoolean, POIInfo paramPOIInfo, List paramList, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShopScanCheckHandler", 2, "onQueryPOI, success=" + paramBoolean + ", poiInfo=" + paramPOIInfo + ", itemInfos=" + paramList + ", taskStatus=" + paramInt1 + ", loadMapFlag=" + paramInt2 + ", poiId=" + paramLong);
    }
    if ((ShopScanCheckHandler.a(this.a) != null) && (paramLong == ShopScanCheckHandler.a(this.a).a))
    {
      ShopScanCheckHandler.a(this.a).removeObserver(ShopScanCheckHandler.a(this.a));
      if ((paramBoolean) && (paramPOIInfo != null) && (paramList != null) && (paramList.size() > 0))
      {
        ShopScanCheckHandler.a(this.a).j = paramPOIInfo.a;
        ShopScanCheckHandler.a(this.a).k = paramPOIInfo.b;
        ShopScanCheckHandler.a(this.a).f = paramPOIInfo.c;
        ShopScanCheckHandler.a(this.a).g = MD5.toMD5(paramPOIInfo.c);
        ThreadManager.postImmediately(new abfq(this, ShopScanCheckHandler.a(this.a)), null, false);
      }
    }
    else
    {
      return;
    }
    ShopScanCheckHandler.a(this.a, ShopScanCheckHandler.a(this.a), 5, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfp
 * JD-Core Version:    0.7.0.1
 */