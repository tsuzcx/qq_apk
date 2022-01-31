import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class akvk
  implements ThreadExcutor.IThreadListener
{
  public akvk(WebViewPlugin paramWebViewPlugin) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.a.onPostPluginAsyncTask();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvk
 * JD-Core Version:    0.7.0.1
 */