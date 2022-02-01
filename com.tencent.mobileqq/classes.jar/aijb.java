import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

class aijb
  extends aieg
{
  static final String jdField_a_of_type_JavaLangString = aiit.class.getSimpleName();
  WeakReference<aiit> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aijb(aiit paramaiit)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaiit);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress success, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress fail, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress complete, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
    aiit localaiit = (aiit)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaiit == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onCompressComplete, new path:" + paramCompressInfo.e);
    }
    localaiit.g(paramCompressInfo.e);
    aiit.a(localaiit).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijb
 * JD-Core Version:    0.7.0.1
 */