import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

class acdr
  extends acko
{
  acdr(acdq paramacdq, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    long l1;
    long l2;
    if ((!this.a.b) && (!acdq.a(this.a)) && (this.a.a))
    {
      l1 = System.currentTimeMillis();
      l2 = acdq.a(this.a);
    }
    try
    {
      paramWebView = new JSONObject();
      paramWebView.put("cost_time", l1 - l2);
      acdq.a(this.a).a(1020031L, paramWebView);
      acdq.a(this.a, true);
      return;
    }
    catch (JSONException paramWebView)
    {
      QLog.e("AbsWebView", 1, "reportWebEndCardLoadingEvent fail :" + paramWebView);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.a.e();
    QLog.i("AbsWebView", 1, "onReceivedError url = " + paramInt + ",description = " + paramString1 + ",failingUrl = " + paramString2);
    this.a.a();
    if ((!acdq.a(this.a)) && (this.a.a))
    {
      acdq.a(this.a).a(1020017L);
      acdq.a(this.a, true);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (acdq.a(this.a, paramWebView, paramString)) {
      return true;
    }
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdr
 * JD-Core Version:    0.7.0.1
 */