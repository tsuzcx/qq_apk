import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.arengine.QRRecognizerController;

public class aapm
  extends Handler
{
  public aapm(QRRecognizerController paramQRRecognizerController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      QRRecognizerController.a(this.a);
      return;
    }
    QRRecognizerController.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapm
 * JD-Core Version:    0.7.0.1
 */