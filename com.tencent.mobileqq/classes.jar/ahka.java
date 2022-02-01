import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class ahka
  extends SosoInterface.OnLocationListener
{
  ahka(ahiu paramahiu, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (paramSosoLbsInfo.mLocation.address != null))
    {
      str = paramSosoLbsInfo.mLocation.address;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.mLocation == null)) {
        break label211;
      }
    }
    label211:
    for (double d1 = paramSosoLbsInfo.mLocation.mLat02;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.mLocation != null) {
          d2 = paramSosoLbsInfo.mLocation.mLon02;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2 + ", address=" + str);
      }
      if (this.a.a == null) {
        this.a.a = ((PublicAccountHandler)this.a.app.getBusinessHandler(11));
      }
      if (this.a.a != null) {
        this.a.a.a(this.a.sessionInfo.curFriendUin, d1, d2, str);
      }
      return;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahka
 * JD-Core Version:    0.7.0.1
 */