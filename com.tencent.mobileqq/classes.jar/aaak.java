import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudLBSLocationCheckCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.qphone.base.util.QLog;

public class aaak
  implements ARCloudFileUpload.ARCloudLBSLocationCheckCallback
{
  public aaak(ARCloudControl paramARCloudControl) {}
  
  public void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult)
  {
    ARCloudControl.f(this.a, false);
    if (ARCloudControl.a(this.a)) {
      return;
    }
    if (ARCloudControl.a(this.a) != null) {
      ARCloudControl.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramARCloudLBSLocationCheckResult.jdField_a_of_type_Int + ", imageId = " + paramARCloudLBSLocationCheckResult.jdField_a_of_type_JavaLangString);
    if (ARCloudControl.a(this.a) != null)
    {
      ARCloudRecogResult.a(this.a.a.recognitions, ARCloudControl.a(this.a), paramARCloudLBSLocationCheckResult);
      ARCloudControl.a(this.a).a(0, ARCloudControl.a(this.a));
    }
    ARCloudControl.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaak
 * JD-Core Version:    0.7.0.1
 */