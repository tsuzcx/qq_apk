import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import mqq.util.WeakReference;

public class alez
  extends Handler
{
  final WeakReference a;
  
  public alez(WebViewProgressBarController paramWebViewProgressBarController)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramWebViewProgressBarController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    WebViewProgressBarController localWebViewProgressBarController = (WebViewProgressBarController)this.a.get();
    if (localWebViewProgressBarController == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localWebViewProgressBarController.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alez
 * JD-Core Version:    0.7.0.1
 */