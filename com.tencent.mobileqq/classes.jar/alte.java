import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.lang.ref.WeakReference;

public class alte
  implements Handler.Callback
{
  private WeakReference<FrameHelperActivity> a;
  
  public alte(FrameHelperActivity paramFrameHelperActivity)
  {
    this.a = new WeakReference(paramFrameHelperActivity);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.a.get();
    if (localFrameHelperActivity != null) {
      localFrameHelperActivity.a(paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alte
 * JD-Core Version:    0.7.0.1
 */