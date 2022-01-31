import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aaux
  extends ajrp
{
  public aaux(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.a.app != null) && (bajr.b(this.a.app)))
    {
      this.a.a(0L, null, null, false);
      if (FriendProfileCardActivity.b(this.a).compareAndSet(true, false))
      {
        if (FriendProfileCardActivity.a(this.a).get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "onVipStatusChanged: showDialog");
          }
          babr.a(this.a, 232, null, ajjy.a(2131639102), null, ajjy.a(2131639110), new aauy(this), null).show();
        }
        this.a.removeObserver(FriendProfileCardActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaux
 * JD-Core Version:    0.7.0.1
 */