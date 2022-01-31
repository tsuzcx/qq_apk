import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;

public class abml
  implements AccountManagerCallback
{
  public abml(ContactSyncManager paramContactSyncManager) {}
  
  public void run(AccountManagerFuture paramAccountManagerFuture)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "removeSyncAccount | is done = " + paramAccountManagerFuture.isDone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abml
 * JD-Core Version:    0.7.0.1
 */