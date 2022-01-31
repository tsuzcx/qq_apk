import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class ajui
  implements Manager
{
  private bayh jdField_a_of_type_Bayh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public ajui(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bayh a()
  {
    if (this.jdField_a_of_type_Bayh == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bayh == null) {
        this.jdField_a_of_type_Bayh = new bayh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bayh;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bayh != null) {
      this.jdField_a_of_type_Bayh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajui
 * JD-Core Version:    0.7.0.1
 */