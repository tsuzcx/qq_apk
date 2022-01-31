import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class akvf
  implements Runnable
{
  public akvf(WebViewFragment paramWebViewFragment) {}
  
  public void run()
  {
    ThreadManager.postImmediately(new akvg(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvf
 * JD-Core Version:    0.7.0.1
 */