import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ajjd
  extends aixn
{
  public ajjd(Contacts paramContacts) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onGetAddFriendBlockedRedPoint, success=" + paramBoolean1 + ",blockedUin=" + paramString);
    }
    ((aizi)this.a.a.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjd
 * JD-Core Version:    0.7.0.1
 */