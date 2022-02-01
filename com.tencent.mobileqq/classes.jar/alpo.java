import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class alpo
  extends SosoInterface.OnLocationListener
{
  public alpo(FlowCameraActivity2 paramFlowCameraActivity2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.a.a = paramSosoLbsInfo.mLocation.mLat02;
      this.a.b = paramSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "onLocationUpdate() latitude=" + this.a.a + " longitude=" + this.a.b);
      }
      if (FlowCameraActivity2.a(this.a) != null) {
        FlowCameraActivity2.a(this.a);
      }
    }
    do
    {
      return;
      this.a.a = 0.0D;
      this.a.b = 0.0D;
    } while (!QLog.isColorLevel());
    QLog.d("FlowCameraActivity", 2, "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpo
 * JD-Core Version:    0.7.0.1
 */