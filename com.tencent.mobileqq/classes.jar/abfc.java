import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.qphone.base.util.QLog;

public class abfc
  extends SosoInterface.OnLocationListener
{
  public abfc(ARMapConfigManager paramARMapConfigManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramSosoLbsInfo != null)
    {
      l1 = l2;
      if (paramSosoLbsInfo.a == null) {}
    }
    try
    {
      l1 = Long.valueOf(paramSosoLbsInfo.a.f).longValue();
      ARMapConfigManager.a(this.a, paramSosoLbsInfo.a.b);
      ARMapConfigManager.b(this.a, paramSosoLbsInfo.a.a);
      this.a.e = l1;
      if (l1 > 0L) {
        ARMapConfigManager.a(this.a, 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, String.format("onFirstLocationFinish errCode=%s adCode=%s mLongitude=%s mLatitude=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l1), Double.valueOf(ARMapConfigManager.a(this.a)), Double.valueOf(ARMapConfigManager.b(this.a)) }));
      }
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      for (;;)
      {
        l1 = -1L;
        ARMapConfigManager.a(this.a, 0.0D);
        ARMapConfigManager.b(this.a, 0.0D);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfc
 * JD-Core Version:    0.7.0.1
 */