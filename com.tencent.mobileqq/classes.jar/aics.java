import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;

public final class aics
  extends SosoInterface.OnLocationListener
{
  public aics(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "onConsecutiveFailure failCode:" + paramInt1 + ",failCount:" + paramInt2);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      QZoneNotifyServlet.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.a));
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onLocationFinish succeed! gps=" + QZoneNotifyServlet.b());
      return;
    }
    QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "onLocationFinish failed: error in force gps info update..");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aics
 * JD-Core Version:    0.7.0.1
 */