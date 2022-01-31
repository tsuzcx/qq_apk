import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;

public final class ahjz
  extends SosoInterface.OnLocationListener
{
  public ahjz(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QZLog.e(QZoneNotifyServlet.a(), "onConsecutiveFailure failCode:" + paramInt1 + ",failCount:" + paramInt2);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      QZoneNotifyServlet.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.a));
      QZLog.i(QZoneNotifyServlet.a(), 1, "onLocationFinish succeed! gps=" + QZoneNotifyServlet.b());
      return;
    }
    QZLog.e(QZoneNotifyServlet.a(), "onLocationFinish failed: error in force gps info update..");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahjz
 * JD-Core Version:    0.7.0.1
 */