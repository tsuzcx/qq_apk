import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.qphone.base.util.QLog;

public class abpg
  extends SosoInterface.OnLocationListener
{
  public abpg(ARMapLoadingActivity paramARMapLoadingActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ARMapLoadingActivity.a(this.a).d = System.currentTimeMillis();
    ARMapLoadingActivity.a(this.a).removeMessages(106);
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("onLocationFinish mLocationTimeout=%s errCode=%s info=%s", new Object[] { Boolean.valueOf(ARMapLoadingActivity.b(this.a)), Integer.valueOf(paramInt), paramSosoLbsInfo }));
    }
    if (!ARMapLoadingActivity.b(this.a))
    {
      localObject = null;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label229;
      }
    }
    for (;;)
    {
      try
      {
        ARMapLoadingActivity.a(this.a, Long.parseLong(paramSosoLbsInfo.a.f));
        ARMapLoadingActivity.a(this.a, paramSosoLbsInfo.a.b);
        ARMapLoadingActivity.b(this.a, paramSosoLbsInfo.a.a);
        paramSosoLbsInfo = paramSosoLbsInfo.a.f;
        if (ARMapLoadingActivity.a(this.a) <= 0L) {
          break;
        }
        ARMapLoadingActivity.a(this.a).sendEmptyMessage(101);
        return;
      }
      catch (Exception paramSosoLbsInfo)
      {
        QLog.e("ARMapLoadingActivity", 1, String.format("onLocationFinish parse fail! cityCode=%s", new Object[] { null }));
        ARMapLoadingActivity.a(this.a, -1L);
        ARMapLoadingActivity.a(this.a, 0.0D);
        ARMapLoadingActivity.b(this.a, 0.0D);
        paramSosoLbsInfo = (SosoInterface.SosoLbsInfo)localObject;
        continue;
      }
      label229:
      ARMapLoadingActivity.a(this.a, -1L);
      ARMapLoadingActivity.a(this.a, 0.0D);
      ARMapLoadingActivity.b(this.a, 0.0D);
      paramSosoLbsInfo = (SosoInterface.SosoLbsInfo)localObject;
    }
    Object localObject = String.format("errCode=%s|cityCode=%s", new Object[] { Integer.valueOf(paramInt), paramSosoLbsInfo });
    paramSosoLbsInfo = new Bundle();
    paramSosoLbsInfo.putString("failInfo", (String)localObject);
    localObject = ARMapLoadingActivity.a(this.a).obtainMessage(104);
    ((Message)localObject).arg1 = 1;
    ((Message)localObject).setData(paramSosoLbsInfo);
    ARMapLoadingActivity.a(this.a).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpg
 * JD-Core Version:    0.7.0.1
 */