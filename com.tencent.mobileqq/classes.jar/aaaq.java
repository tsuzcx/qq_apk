import android.os.Handler;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.qphone.base.util.QLog;

public class aaaq
  extends SosoInterface.OnLocationListener
{
  public aaaq(ARCloudControl paramARCloudControl, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ARCloudControl.f(this.a, false);
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).removeMessages(2);
    }
    if (ARCloudControl.a(this.a)) {
      return;
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      paramInt = (int)(paramSosoLbsInfo.jdField_a_of_type_Double * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.jdField_b_of_type_Double * 1000000.0D);
      QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info. Lat_02 = " + paramSosoLbsInfo.jdField_a_of_type_Double + ", Lon_02 = " + paramSosoLbsInfo.jdField_b_of_type_Double + ", latitude = " + paramInt + ", longitude = " + i + ", altitude = " + paramSosoLbsInfo.e + ", accuracy = " + paramSosoLbsInfo.jdField_a_of_type_Float + ", name = " + paramSosoLbsInfo.jdField_a_of_type_JavaLangString + ", address = " + paramSosoLbsInfo.jdField_b_of_type_JavaLangString);
      paramSosoLbsInfo = ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a));
      ARCloudControl.a(this.a, paramSosoLbsInfo, paramInt, i);
      return;
    }
    QLog.i("AREngine_ARCloudControl", 1, "GetLBSLocation. onLocationFinish. gps info failed. errCode = " + paramInt);
    paramSosoLbsInfo = new ARCloudLBSLocationCheckResult();
    paramSosoLbsInfo.a = 2;
    ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a), paramSosoLbsInfo);
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).a(0, ARCloudControl.a(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaaq
 * JD-Core Version:    0.7.0.1
 */