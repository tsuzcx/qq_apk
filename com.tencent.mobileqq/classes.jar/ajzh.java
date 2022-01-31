import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class ajzh
  implements Runnable
{
  public ajzh(WebViewFragment paramWebViewFragment) {}
  
  public void run()
  {
    ThreadManager.postImmediately(new ajzi(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajzh
 * JD-Core Version:    0.7.0.1
 */