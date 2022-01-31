import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class allt
  implements Manager
{
  private bcxp jdField_a_of_type_Bcxp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public allt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bcxp a()
  {
    if (this.jdField_a_of_type_Bcxp == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bcxp == null) {
        this.jdField_a_of_type_Bcxp = new bcxp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bcxp;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bcxp != null) {
      this.jdField_a_of_type_Bcxp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     allt
 * JD-Core Version:    0.7.0.1
 */