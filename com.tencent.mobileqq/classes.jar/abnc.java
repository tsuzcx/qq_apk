import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingDialog$initWeb$1", "Lcom/tencent/gdtad/views/videoceiling/GdtWebViewBuilder;", "onReceivedError", "", "view", "Lcom/tencent/smtt/sdk/WebView;", "errorCode", "", "description", "", "failingUrl", "shouldOverrideUrlLoading", "", "webview", "url", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abnc
  extends abup
{
  abnc(AppInterface paramAppInterface1, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface2)
  {
    super(paramActivity, paramIntent, paramAppInterface2, localAppInterface);
  }
  
  public void onReceivedError(@NotNull WebView paramWebView, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    Intrinsics.checkParameterIsNotNull(paramString1, "description");
    Intrinsics.checkParameterIsNotNull(paramString2, "failingUrl");
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    QLog.i("AbsWebView", 1, "onReceivedError url = " + paramInt + ",description = " + paramString1 + ",failingUrl = " + paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramWebView, "webview");
    QLog.i("AbsWebView", 1, "shouldOverrideUrlLoading " + paramString);
    if (paramString != null)
    {
      if (!abmw.a(this.jdField_a_of_type_Abmw).a(paramString, abmw.a(this.jdField_a_of_type_Abmw))) {
        bool = a(paramWebView, paramString);
      }
    }
    else {
      return bool;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abnc
 * JD-Core Version:    0.7.0.1
 */