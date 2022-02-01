import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.InputOnGlobalLayoutListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

public class aiqu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private aiqu(TroopChatPie paramTroopChatPie) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      if (!this.a.aa)
      {
        this.a.aa = true;
        ThreadManager.getSubThreadHandler().postDelayed(new TroopChatPie.InputOnGlobalLayoutListener.1(this), 1500L);
      }
      return;
      this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqu
 * JD-Core Version:    0.7.0.1
 */