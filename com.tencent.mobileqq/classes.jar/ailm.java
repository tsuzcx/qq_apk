import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper.2.1;
import mqq.os.MqqHandler;

public class ailm
  implements bdwd
{
  ailm(ailk paramailk) {}
  
  @UiThread
  private void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.a.c();
      return;
    }
    this.a.b();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, ailk.a(this.a).sessionInfo.curFriendUin)) {
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ailk.a(this.a).post(new StudyRoomTipBarHelper.2.1(this, paramInt));
      return;
    }
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailm
 * JD-Core Version:    0.7.0.1
 */