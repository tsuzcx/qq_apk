import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class abth
  extends ContactBindObserver
{
  public abth(ContactSyncManager paramContactSyncManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.a.getManager(10);
    int i = localPhoneContactManager.c();
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + ContactSyncManager.b(str2) + " | currentUin = " + ContactSyncManager.b(str1));
    }
    if (localPhoneContactManager.c()) {
      if (TextUtils.isEmpty(str2)) {
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
        ContactSyncManager.a(this.a).sendEmptyMessage(2);
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localPhoneContactManager.a() == null) || (localPhoneContactManager.a().lastUsedFlag != 3L)) && ((i != 7) || (localPhoneContactManager.a() == null) || (!localPhoneContactManager.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ContactSyncManager.a(this.a);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.getCurrentAccountUin())));
    ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
    ContactSyncManager.a(this.a).sendEmptyMessage(2);
  }
  
  protected void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abth
 * JD-Core Version:    0.7.0.1
 */