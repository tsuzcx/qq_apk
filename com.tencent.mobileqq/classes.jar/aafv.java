import com.tencent.mobileqq.activity.AccountManageActivity;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class aafv
  extends AccountObserver
{
  public aafv(AccountManageActivity paramAccountManageActivity) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    AccountManageActivity.b(this.a);
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    AccountManageActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafv
 * JD-Core Version:    0.7.0.1
 */