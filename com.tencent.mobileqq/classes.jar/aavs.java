import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aavs
  extends akkd
{
  public aavs(Contacts paramContacts) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onGetAddFriendBlockedRedPoint, success=" + paramBoolean1 + ",blockedUin=" + paramString);
    }
    ((akbn)this.a.a.getManager(34)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavs
 * JD-Core Version:    0.7.0.1
 */