import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class acvo
  extends alxo
{
  public acvo(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.a.app != null) && (VipUtils.b(this.a.app)))
    {
      this.a.a(0L, null, null, false);
      if (FriendProfileCardActivity.b(this.a).compareAndSet(true, false))
      {
        if (FriendProfileCardActivity.a(this.a).get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "onVipStatusChanged: showDialog");
          }
          bdcd.a(this.a, 232, null, alpo.a(2131705270), null, alpo.a(2131705278), new acvp(this), null).show();
        }
        this.a.removeObserver(FriendProfileCardActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvo
 * JD-Core Version:    0.7.0.1
 */