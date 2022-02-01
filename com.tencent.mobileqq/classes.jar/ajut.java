import android.os.Handler;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.qphone.base.util.QLog;

public class ajut
  extends bgkn
{
  public ajut(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onGetGiftMemberList error");
    }
    ChatHistoryTroopMemberFragment.a(this.a, true);
    if (ChatHistoryTroopMemberFragment.b(this.a))
    {
      paramString = this.a.b.obtainMessage(12, null);
      this.a.b.sendMessage(paramString);
    }
  }
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onGetGiftMemberList");
    }
    ChatHistoryTroopMemberFragment.a(this.a, paramArrayOfLong1);
    ChatHistoryTroopMemberFragment.b(this.a, paramArrayOfLong2);
    ChatHistoryTroopMemberFragment.c(this.a, paramArrayOfLong3);
    ChatHistoryTroopMemberFragment.a(this.a, true);
    if (ChatHistoryTroopMemberFragment.b(this.a))
    {
      paramArrayOfLong1 = this.a.b.obtainMessage(12, null);
      this.a.b.sendMessage(paramArrayOfLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajut
 * JD-Core Version:    0.7.0.1
 */