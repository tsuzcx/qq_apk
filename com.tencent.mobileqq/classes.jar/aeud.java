import Wallet.AcsMsg;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;

public class aeud
  implements aewm
{
  public aeud(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void a(AcsMsg paramAcsMsg)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("acsMsg", paramAcsMsg);
    localMessage.obj = localBundle;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeud
 * JD-Core Version:    0.7.0.1
 */