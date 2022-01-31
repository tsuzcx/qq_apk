import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;

public class ajsk
  extends Handler
{
  public ajsk(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 10) {
      postDelayed(QzoneSlideShowPreparingFragment.a(this.a), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsk
 * JD-Core Version:    0.7.0.1
 */