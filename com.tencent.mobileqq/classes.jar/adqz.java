import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class adqz
  extends AccountObserver
{
  public adqz(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onDeleteAccount isSuccess " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqz
 * JD-Core Version:    0.7.0.1
 */