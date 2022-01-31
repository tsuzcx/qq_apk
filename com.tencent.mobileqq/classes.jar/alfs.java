import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.smtt.sdk.WebView;

public final class alfs
  implements Runnable
{
  public alfs(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new alft(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfs
 * JD-Core Version:    0.7.0.1
 */