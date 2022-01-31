import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusConfig;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class abwg
  implements Runnable
{
  public abwg(CampusCircleHandler paramCampusCircleHandler, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "campus_circle_config");
    CampusCircleHandler.a(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler).a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwg
 * JD-Core Version:    0.7.0.1
 */