import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class ajug
  implements Manager
{
  private bayv jdField_a_of_type_Bayv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public ajug(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bayv a()
  {
    if (this.jdField_a_of_type_Bayv == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bayv == null) {
        this.jdField_a_of_type_Bayv = new bayv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bayv;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bayv != null) {
      this.jdField_a_of_type_Bayv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajug
 * JD-Core Version:    0.7.0.1
 */