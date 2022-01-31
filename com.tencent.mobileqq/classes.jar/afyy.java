import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.9.1;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class afyy
  extends xax
{
  public afyy(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    while (!paramBoolean) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.9.1(this, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afyy
 * JD-Core Version:    0.7.0.1
 */