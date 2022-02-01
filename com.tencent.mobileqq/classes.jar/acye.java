import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView;
import com.tencent.smtt.sdk.WebView;

public class acye
  extends acyg
{
  public acye(GdtVideoCeilingView paramGdtVideoCeilingView, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    acvc.b("GdtVideoCeilingView", "onPageFinished:" + paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    acvc.b("GdtVideoCeilingView", "onPageStarted:" + paramString);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    acvc.b("GdtVideoCeilingView", "onReceivedTitle: " + paramString);
    GdtVideoCeilingView.a(this.a).setWebBarTitle(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acye
 * JD-Core Version:    0.7.0.1
 */