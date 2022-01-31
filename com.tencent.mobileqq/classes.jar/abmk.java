import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;

public class abmk
  implements Runnable
{
  public abmk(ContactSyncManager paramContactSyncManager, Account[] paramArrayOfAccount) {}
  
  public void run()
  {
    ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager).lock();
    int i = 1;
    try
    {
      while (i < this.jdField_a_of_type_ArrayOfAndroidAccountsAccount.length)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "initSyncAccount | delAccount = " + this.jdField_a_of_type_ArrayOfAndroidAccountsAccount[i]);
        }
        ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager).removeAccount(this.jdField_a_of_type_ArrayOfAndroidAccountsAccount[i], null, null);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abmk
 * JD-Core Version:    0.7.0.1
 */