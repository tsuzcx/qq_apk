import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;

public class ahwl
  extends Handler
{
  public ahwl(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment, Looper paramLooper)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwl
 * JD-Core Version:    0.7.0.1
 */