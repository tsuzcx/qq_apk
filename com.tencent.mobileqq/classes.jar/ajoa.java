import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ajoa
  implements Runnable
{
  public ajoa(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Int;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StatisticConstants.a(new String[] { str }, i, false, true, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajoa
 * JD-Core Version:    0.7.0.1
 */