import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class alfp
  implements aley
{
  alfp(alfo paramalfo) {}
  
  public void a(alfw paramalfw)
  {
    alfo.f(this.a, false);
    if (alfo.a(this.a)) {
      return;
    }
    if (alfo.a(this.a) != null) {
      alfo.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramalfw.jdField_a_of_type_Int + ", imageId = " + paramalfw.jdField_a_of_type_JavaLangString);
    if (alfo.a(this.a) != null)
    {
      algo.a(this.a.a.recognitions, alfo.a(this.a), paramalfw);
      alfo.a(this.a).a(0, alfo.a(this.a));
    }
    alfo.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfp
 * JD-Core Version:    0.7.0.1
 */