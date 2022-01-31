import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;
import com.tencent.mobileqq.widget.AntiphingToast;

public class aksp
  extends Handler
{
  public aksp(AntiphingToast paramAntiphingToast, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - AntiphingToast.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksp
 * JD-Core Version:    0.7.0.1
 */