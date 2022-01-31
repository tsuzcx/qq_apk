import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.smtt.sdk.WebView;

public final class akqc
  implements Runnable
{
  public akqc(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new akqd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akqc
 * JD-Core Version:    0.7.0.1
 */