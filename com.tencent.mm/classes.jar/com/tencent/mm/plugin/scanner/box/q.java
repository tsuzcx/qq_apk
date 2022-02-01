package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "closePage", "", "params", "dismissProgressDialog", "doOpenProfilePage", "", "username", "openAdPage", "openProfilePage", "openVideoPage", "openWebView", "release", "setReportData", "data", "Landroid/os/Bundle;", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showShareMenu", "updateShareData", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends a
{
  public static final a ONR;
  private final b vAk;
  
  static
  {
    AppMethodBeat.i(52144);
    ONR = new a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public q(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(52143);
    this.vAk = paramb;
    AppMethodBeat.o(52143);
  }
  
  private static final void a(q paramq)
  {
    AppMethodBeat.i(313747);
    s.u(paramq, "this$0");
    paramq.vAk.dismiss();
    AppMethodBeat.o(313747);
  }
  
  public static void aQ(Bundle paramBundle)
  {
    AppMethodBeat.i(313738);
    s.u(paramBundle, "data");
    n.aQ(paramBundle);
    AppMethodBeat.o(313738);
  }
  
  public static void release()
  {
    AppMethodBeat.i(313742);
    n.gPT();
    AppMethodBeat.o(313742);
  }
  
  @JavascriptInterface
  public final void closePage(String paramString)
  {
    AppMethodBeat.i(313791);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi closePage: %s", new Object[] { paramString });
    h.ahAA.bk(new q..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(313791);
  }
  
  @JavascriptInterface
  public final void openAdPage(String paramString)
  {
    AppMethodBeat.i(313770);
    s.u(paramString, "params");
    Log.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openAdPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("adXml", "");
      localObject = ((JSONObject)localObject).optString("uxinfo", "");
      Log.i("MicroMsg.ScanBoxWebViewJSApi", s.X("openAdPage, adXml=", paramString));
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landing_pages_xml", paramString);
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
      if (this.vAk.getActivityContext() != null)
      {
        c.b(this.vAk.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(313770);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openAdPage exception", new Object[0]);
      AppMethodBeat.o(313770);
    }
  }
  
  @JavascriptInterface
  public final void openProfilePage(String paramString)
  {
    AppMethodBeat.i(313780);
    s.u(paramString, "params");
    Log.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage %s", new Object[] { paramString });
    label281:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("username", "");
        Object localObject = (CharSequence)paramString;
        if (localObject != null)
        {
          if (((CharSequence)localObject).length() == 0)
          {
            break label281;
            if (i != 0)
            {
              Log.e("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage fail, username is null");
              Toast.makeText(this.vAk.getActivityContext(), (CharSequence)this.vAk.getActivityContext().getString(l.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              bool = false;
              Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", new Object[] { Boolean.valueOf(bool) });
              AppMethodBeat.o(313780);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          Log.i("MicroMsg.ScanBoxWebViewJSApi", s.X("doOpenProfilePage success, username is ", paramString));
          localObject = new Intent();
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("Contact_User", paramString);
          ((Intent)localObject).putExtra("Contact_Scene", 300);
          ((Intent)localObject).putExtra("force_get_contact", true);
          ((Intent)localObject).putExtra("key_use_new_contact_profile", true);
          c.b(this.vAk.getActivityContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          boolean bool = true;
          continue;
        }
        int i = 1;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openProfilePage exception", new Object[0]);
        AppMethodBeat.o(313780);
        return;
      }
    }
  }
  
  @JavascriptInterface
  public final void openVideoPage(String paramString)
  {
    AppMethodBeat.i(313786);
    s.u(paramString, "params");
    Log.i("MicroMsg.ScanBoxWebViewJSApi", s.X("openVideoPage param = ", paramString));
    try
    {
      Object localObject = new JSONObject(paramString).optString("videoUrl", "");
      if (Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
        AppMethodBeat.o(313786);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      localObject = this.vAk.getActivityContext();
      if (localObject != null)
      {
        c.b((Context)localObject, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", paramString);
        AppMethodBeat.o(313786);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(313786);
    }
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    s.u(paramString, "params");
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.vAk.getActivityContext();
      if (localObject != null)
      {
        c.b((Context)localObject, "webview", ".ui.tools.WebViewUI", paramString);
        AppMethodBeat.o(52140);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openWebView exception", new Object[0]);
      AppMethodBeat.o(52140);
    }
  }
  
  @JavascriptInterface
  public final void showShareMenu(String paramString)
  {
    AppMethodBeat.i(313805);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi showShareMenu: %s", new Object[] { paramString });
    Context localContext = this.vAk.getActivityContext();
    s.s(localContext, "uiComponent.activityContext");
    n.bJ(localContext, paramString);
    AppMethodBeat.o(313805);
  }
  
  @JavascriptInterface
  public final void updateShareData(String paramString)
  {
    AppMethodBeat.i(313801);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi updateShareData: %s", new Object[] { paramString });
    n.updateShareData(paramString);
    AppMethodBeat.o(313801);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.q
 * JD-Core Version:    0.7.0.1
 */