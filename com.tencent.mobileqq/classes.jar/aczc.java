import android.os.Bundle;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.16.1;
import com.tencent.mobileqq.app.ThreadManager;

public class aczc
  extends avva
{
  public aczc(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.post(new FriendProfileCardActivity.16.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczc
 * JD-Core Version:    0.7.0.1
 */