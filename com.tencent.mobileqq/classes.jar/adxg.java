import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.AccountDetail;

public class adxg
  extends bfrc
{
  public adxg(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 16;
      Bundle localBundle = new Bundle();
      localBundle.putString("uinname", paramAccountDetail.name);
      localBundle.putString("extra_type", paramAccountDetail.summary);
      localBundle.putLong("uin", paramLong);
      localMessage.setData(localBundle);
      this.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxg
 * JD-Core Version:    0.7.0.1
 */