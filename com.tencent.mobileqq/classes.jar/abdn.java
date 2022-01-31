import android.os.Bundle;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;

public class abdn
  extends atzn
{
  public abdn(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.post(new FriendProfileCardActivity.15.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdn
 * JD-Core Version:    0.7.0.1
 */