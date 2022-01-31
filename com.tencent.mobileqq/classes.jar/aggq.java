import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aggq
  extends SosoInterface.OnLocationListener
{
  public aggq(ScanTorchActivity paramScanTorchActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onLocationFinish errCode: " + paramInt + ", info: " + paramSosoLbsInfo);
    }
    if (!NetworkUtil.d(this.a))
    {
      QQToast.a(this.a.getApplicationContext(), 2131437312, 1).b(this.a.getTitleBarHeight());
      ScanTorchActivity.a(this.a, ScanTorchActivity.a(this.a), false);
      return;
    }
    if (paramInt != 0)
    {
      this.a.runOnUiThread(new aggr(this));
      ScanTorchActivity.a(this.a, ScanTorchActivity.a(this.a), false);
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      double d1 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
      double d2 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      paramInt = (int)paramSosoLbsInfo.a.jdField_a_of_type_Float;
      String str1 = paramSosoLbsInfo.a.m;
      String str2 = paramSosoLbsInfo.a.l;
      int i = paramSosoLbsInfo.a.jdField_a_of_type_Int;
      double d3 = paramSosoLbsInfo.a.jdField_a_of_type_Long;
      float f = paramSosoLbsInfo.a.jdField_b_of_type_Float;
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, "onLocationFinish longitude=" + d1 + ", latitude=" + d2 + ", accuracy=" + paramInt + ", verifyKey=" + str2 + ", source=" + str1 + ", fakeReason=" + i + ", speed=" + f + ", locationTime=" + d3);
      }
      paramSosoLbsInfo = (ArMapHandler)this.a.b.getBusinessHandler(2);
      if (paramSosoLbsInfo != null)
      {
        paramSosoLbsInfo.a(str2, d1, d2, d3, paramInt, str1, i);
        paramSosoLbsInfo.a(ScanTorchActivity.a(this.a), d1, d2, 0, 2, 10);
        return;
      }
      ScanTorchActivity.a(this.a, ScanTorchActivity.a(this.a), false);
      return;
    }
    ScanTorchActivity.a(this.a, ScanTorchActivity.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggq
 * JD-Core Version:    0.7.0.1
 */