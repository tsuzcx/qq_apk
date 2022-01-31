import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class akno
  implements Runnable
{
  public akno(WebViewFragment paramWebViewFragment) {}
  
  public void run()
  {
    ThreadManager.postImmediately(new aknp(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akno
 * JD-Core Version:    0.7.0.1
 */