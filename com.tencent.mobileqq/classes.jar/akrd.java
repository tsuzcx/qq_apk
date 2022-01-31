import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class akrd
  implements akqm
{
  akrd(akrc paramakrc) {}
  
  public void a(akrk paramakrk)
  {
    akrc.f(this.a, false);
    if (akrc.a(this.a)) {
      return;
    }
    if (akrc.a(this.a) != null) {
      akrc.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramakrk.jdField_a_of_type_Int + ", imageId = " + paramakrk.jdField_a_of_type_JavaLangString);
    if (akrc.a(this.a) != null)
    {
      aksc.a(this.a.a.recognitions, akrc.a(this.a), paramakrk);
      akrc.a(this.a).a(0, akrc.a(this.a));
    }
    akrc.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akrd
 * JD-Core Version:    0.7.0.1
 */