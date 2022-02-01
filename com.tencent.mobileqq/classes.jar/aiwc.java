import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper.2.1;
import mqq.os.MqqHandler;

public class aiwc
  implements bdvn
{
  aiwc(aiwa paramaiwa) {}
  
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
    if (!TextUtils.equals(paramString, aiwa.a(this.a).a.a)) {
      return;
    }
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      aiwa.a(this.a).post(new StudyRoomTipBarHelper.2.1(this, paramInt));
      return;
    }
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwc
 * JD-Core Version:    0.7.0.1
 */