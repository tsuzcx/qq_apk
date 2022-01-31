import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class adad
  extends amcd
{
  public adad(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
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
          bdgm.a(this.a, 232, null, alud.a(2131705282), null, alud.a(2131705290), new adae(this), null).show();
        }
        this.a.removeObserver(FriendProfileCardActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adad
 * JD-Core Version:    0.7.0.1
 */