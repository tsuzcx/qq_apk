import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

class aeob
  extends aeji
{
  final String jdField_a_of_type_JavaLangString = aent.class.getSimpleName();
  WeakReference<aent> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aeob(aent paramaent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaent);
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
    aent localaent = (aent)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCompressComplete, new path:" + paramCompressInfo.e);
    }
    localaent.f(paramCompressInfo.e);
    aent.a(localaent).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeob
 * JD-Core Version:    0.7.0.1
 */