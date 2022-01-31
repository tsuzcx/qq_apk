import android.os.Handler;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class aber
  extends aoez
{
  public aber(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, got extend info");
    }
    if (FriendProfileCardActivity.a(this.a) != null) {
      FriendProfileCardActivity.a(this.a).dismiss();
    }
    if (FriendProfileCardActivity.a(this.a) != null)
    {
      FriendProfileCardActivity.a(this.a).removeCallbacksAndMessages(null);
      FriendProfileCardActivity.a(this.a, null);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, start add friend :" + FriendProfileCardActivity.d(this.a));
      }
      if (!FriendProfileCardActivity.d(this.a))
      {
        FriendProfileCardActivity.a(this.a, true);
        FriendProfileCardActivity.b(this.a);
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aber
 * JD-Core Version:    0.7.0.1
 */