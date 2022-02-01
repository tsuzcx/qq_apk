import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.Player;
import java.lang.ref.WeakReference;

public final class ahda
  extends AnimationView.Player
{
  public static boolean a;
  
  public ahda(AnimationView paramAnimationView)
  {
    super(paramAnimationView);
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public void a(AnimationView paramAnimationView)
  {
    reset();
    this.playViewRef.clear();
    this.playViewRef = new WeakReference(paramAnimationView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (a)
      {
        paramMessage = this.mHandler.obtainMessage(1);
        this.mHandler.sendMessageDelayed(paramMessage, 500L);
      }
      else
      {
        autoPlay();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahda
 * JD-Core Version:    0.7.0.1
 */