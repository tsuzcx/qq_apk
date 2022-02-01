import androidx.annotation.CallSuper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class ajib
{
  public QQAppInterface a;
  protected final String a;
  
  public ajib(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract void a();
  
  @CallSuper
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clearAllMsgCache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajib
 * JD-Core Version:    0.7.0.1
 */