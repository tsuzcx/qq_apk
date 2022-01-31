import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class alfo
  implements alex
{
  alfo(alfn paramalfn) {}
  
  public void a(alfv paramalfv)
  {
    alfn.f(this.a, false);
    if (alfn.a(this.a)) {
      return;
    }
    if (alfn.a(this.a) != null) {
      alfn.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramalfv.jdField_a_of_type_Int + ", imageId = " + paramalfv.jdField_a_of_type_JavaLangString);
    if (alfn.a(this.a) != null)
    {
      algn.a(this.a.a.recognitions, alfn.a(this.a), paramalfv);
      alfn.a(this.a).a(0, alfn.a(this.a));
    }
    alfn.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfo
 * JD-Core Version:    0.7.0.1
 */