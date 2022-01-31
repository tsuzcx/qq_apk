import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.qphone.base.util.QLog;

public class abme
  extends SosoInterface.OnLocationListener
{
  public abme(ARMapConfigManager paramARMapConfigManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {}
    for (;;)
    {
      try
      {
        l = Long.valueOf(paramSosoLbsInfo.a.f).longValue();
        ARMapConfigManager.a(this.a, paramSosoLbsInfo.a.b);
        ARMapConfigManager.b(this.a, paramSosoLbsInfo.a.a);
        this.a.a(l, true);
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, String.format("onLocationFinish errCode=%s adCode=%s mLongitude=%s mLatitude=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), Double.valueOf(ARMapConfigManager.a(this.a)), Double.valueOf(ARMapConfigManager.b(this.a)) }));
        }
        return;
      }
      catch (Exception paramSosoLbsInfo)
      {
        ARMapConfigManager.a(this.a, 0.0D);
        ARMapConfigManager.b(this.a, 0.0D);
      }
      long l = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abme
 * JD-Core Version:    0.7.0.1
 */