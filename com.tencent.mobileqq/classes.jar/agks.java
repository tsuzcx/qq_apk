import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

class agks
  extends agga
{
  final String jdField_a_of_type_JavaLangString = agkk.class.getSimpleName();
  WeakReference<agkk> jdField_a_of_type_JavaLangRefWeakReference;
  
  public agks(agkk paramagkk)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagkk);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress success, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress fail, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress complete, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
    agkk localagkk = (agkk)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localagkk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCompressComplete, new path:" + paramCompressInfo.e);
    }
    localagkk.f(paramCompressInfo.e);
    agkk.a(localagkk).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agks
 * JD-Core Version:    0.7.0.1
 */