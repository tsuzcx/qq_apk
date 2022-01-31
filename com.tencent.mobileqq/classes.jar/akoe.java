import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class akoe
  implements bkgo
{
  akoe(aknx paramaknx) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "onGetAdvs isSucc:", Boolean.valueOf(paramBoolean) });
    }
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {
      return;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null)
    {
      QLog.w("ApolloManager", 1, "rspEntries == null");
      return;
    }
    HashMap localHashMap = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localRspEntry != null) && (localRspEntry.key.has())) {
        localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
      }
    }
    aknx.a(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(364)));
    aknx.b(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(367)));
    aknx.c(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(366)));
    aknx.d(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(365)));
    aknx.e(this.a, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(393)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoe
 * JD-Core Version:    0.7.0.1
 */