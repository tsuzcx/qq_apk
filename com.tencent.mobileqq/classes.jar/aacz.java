import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class aacz
  implements Runnable
{
  public aacz(UpgradeController paramUpgradeController, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if ((UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController) == null) || (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {}
    Object localObject;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.e.equals("1")) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("UpgradeConfigManager", 2, "config do not allow to tip");
                return;
                if (MessageCache.a() >= UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.b / 1000L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("UpgradeConfigManager", 2, "want to tip but is not time to show");
              return;
              localObject = (QQAppInterface)UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).getRuntime();
            } while (localObject == null);
            if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.a() != 4) || (!this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.b())) {
              break;
            }
          } while ((UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController) == null) || (TextUtils.isEmpty(UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).k)));
          UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController, true);
          localObject = new File(UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).k);
        } while (!((File)localObject).exists());
        ((File)localObject).delete();
      } while (!QLog.isColorLevel());
      QLog.d("UpgradeConfigManager", 2, "the jacked apk has been removed.");
      return;
      localSharedPreferences = ((QQAppInterface)localObject).getPreferences();
      if (!ConfigHandler.b((QQAppInterface)localObject))
      {
        if ((localSharedPreferences.getLong("upgrade_tip_time", 0L) == 0L) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.a((QQAppInterface)localObject, false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.a((QQAppInterface)localObject);
        return;
      }
    } while ((UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1));
    if (localSharedPreferences.getLong("upgrade_tip_time", 0L) == 0L) {
      i = 1;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.a((QQAppInterface)localObject, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.a((QQAppInterface)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aacz
 * JD-Core Version:    0.7.0.1
 */