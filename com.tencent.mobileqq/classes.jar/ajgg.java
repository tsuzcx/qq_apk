import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class ajgg
  implements Manager
{
  private azxd jdField_a_of_type_Azxd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public ajgg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public azxd a()
  {
    if (this.jdField_a_of_type_Azxd == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Azxd == null) {
        this.jdField_a_of_type_Azxd = new azxd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Azxd;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Azxd != null) {
      this.jdField_a_of_type_Azxd.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajgg
 * JD-Core Version:    0.7.0.1
 */