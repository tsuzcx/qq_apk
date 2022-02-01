import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class abfn
  extends WebViewPlugin
{
  public abfn()
  {
    this.mPluginNameSpace = "openToAppDetail";
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.mRuntime.a().getCurrentAccountUin());
    localBundle.putString("sid", this.mRuntime.a().getIntent().getStringExtra("vkey"));
    localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ");
    if ((paramString2 != null) && (paramString2.equals("true"))) {
      localBundle.putBoolean("autoDownload", true);
    }
    if (paramString3 != null) {
      localBundle.putString("packageName", paramString3);
    }
    bjqz.a(this.mRuntime.a(), paramString1, 2470, localBundle);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"openToAppDetail".equals(paramString2)) {}
    do
    {
      do
      {
        return false;
      } while (!"openAppDetailPage".equals(paramString3));
      if (paramVarArgs.length == 2)
      {
        a(paramVarArgs[0], paramVarArgs[1]);
        return true;
      }
    } while (paramVarArgs.length != 3);
    a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfn
 * JD-Core Version:    0.7.0.1
 */