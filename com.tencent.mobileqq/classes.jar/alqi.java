import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class alqi
  implements Manager
{
  private bdby jdField_a_of_type_Bdby;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public alqi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bdby a()
  {
    if (this.jdField_a_of_type_Bdby == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bdby == null) {
        this.jdField_a_of_type_Bdby = new bdby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bdby;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bdby != null) {
      this.jdField_a_of_type_Bdby.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alqi
 * JD-Core Version:    0.7.0.1
 */