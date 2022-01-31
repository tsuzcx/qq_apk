import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class akvg
  implements Manager
{
  private final QQAppInterface a;
  
  public akvg(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static akvg a(QQAppInterface paramQQAppInterface)
  {
    return (akvg)paramQQAppInterface.getManager(189);
  }
  
  public boolean a()
  {
    if (akva.a().a() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "hasNewApkDownloaded: invoked. ", " hasDl: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = bbjn.aN(this.a.getApp(), this.a.c());
      j = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.c;
      k = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.d;
      l1 = bbjn.k(this.a.getApp(), this.a.c());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowDownloadDialog: invoked. ", " downloadDialogMaxTimes: ", Integer.valueOf(j), " downloadDialogShownTimes: ", Integer.valueOf(i), " downloadDialogDayRate: ", Integer.valueOf(k), " downloadDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public boolean b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return false;
      i = bbjn.aO(this.a.getApp(), this.a.c());
      j = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.e;
      k = paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.f;
      l1 = bbjn.l(this.a.getApp(), this.a.c());
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeManager", 2, new Object[] { "needShowInstallDialog: invoked. ", " installDialogMaxTimes: ", Integer.valueOf(j), " installDialogShownTimes: ", Integer.valueOf(i), " installDialogDayRate: ", Integer.valueOf(k), " installDialogShownTimestamp: ", Long.valueOf(l1), " now: ", Long.valueOf(l2) });
      }
    } while ((i >= j) || (l2 - l1 < k * 86400000L));
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akvg
 * JD-Core Version:    0.7.0.1
 */