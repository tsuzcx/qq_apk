import android.content.ContentResolver;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public final class ahjq
  implements Runnable
{
  public ahjq(QQAppInterface paramQQAppInterface, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      } while ((localObject == null) || (!(localObject instanceof QZoneManagerImp)));
      localObject = (QZoneManagerImp)localObject;
      if (((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList == null) {
        ((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        QZConfigProviderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList);
      }
    } while (QZoneUnreadServletLogic.a(this.jdField_a_of_type_JavaUtilArrayList, ((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList));
    ((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList.clear();
    ((QZoneManagerImp)localObject).jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.g, null, null);
      QZConfigProviderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(QZoneUnreadServletLogic.a(), 2, "getNavigatorConfigs error:" + localException.getMessage(), localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahjq
 * JD-Core Version:    0.7.0.1
 */