import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.doutu.DoutuServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class acgi
  implements Runnable
{
  public acgi(DoutuManager paramDoutuManager, DoutuData paramDoutuData, long paramLong, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postReportHotPic!");
    }
    NewIntent localNewIntent = new NewIntent(DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getApp(), DoutuServlet.class);
    localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getCurrentAccountUin()).longValue());
    localNewIntent.putExtra("KEY_CMD", 4);
    localNewIntent.putExtra("KEY_IMAGE_INFO", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData);
    localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
    localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_JavaLangString);
    if (DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager) == null)
    {
      Object localObject = (FriendsManager)DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getManager(50);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).a(DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).getCurrentAccountUin());
        if (localObject != null) {
          DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager, (Card)localObject);
        }
      }
    }
    if (DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager) != null)
    {
      localNewIntent.putExtra("key_gender", DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).shGender);
      localNewIntent.putExtra("KEY_AGE", DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).age);
    }
    DoutuManager.a(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager).startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgi
 * JD-Core Version:    0.7.0.1
 */