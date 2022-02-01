package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.g.b.v.f;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissProgressDialog", "", "doOpenProfilePage", "", "username", "openAdPage", "params", "openProfilePage", "openVideoPage", "openWebView", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"})
public final class i
  extends com.tencent.mm.plugin.box.webview.d
{
  public static final i.a wXx;
  private com.tencent.mm.ui.base.p fua;
  private final com.tencent.mm.plugin.box.c.c nua;
  private String wXw;
  
  static
  {
    AppMethodBeat.i(52144);
    wXx = new i.a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public i(com.tencent.mm.plugin.box.c.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(52143);
    this.nua = paramc;
    AppMethodBeat.o(52143);
  }
  
  private final void aD(Intent paramIntent)
  {
    AppMethodBeat.i(199576);
    com.tencent.mm.br.d.b(this.nua.getActivityContext(), "profile", ".ui.ContactInfoUI", paramIntent);
    AppMethodBeat.o(199576);
  }
  
  @JavascriptInterface
  public final void openAdPage(String paramString)
  {
    AppMethodBeat.i(199574);
    d.g.b.k.h(paramString, "params");
    ac.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openAdPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("adXml", "");
      localObject = ((JSONObject)localObject).optString("uxinfo", "");
      ac.i("MicroMsg.ScanBoxWebViewJSApi", "openAdPage, adXml=".concat(String.valueOf(paramString)));
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landing_pages_xml", paramString);
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
      if (this.nua.getActivityContext() != null)
      {
        com.tencent.mm.br.d.b(this.nua.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(199574);
        return;
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openAdPage exception", new Object[0]);
      AppMethodBeat.o(199574);
    }
  }
  
  @JavascriptInterface
  public final void openProfilePage(final String paramString)
  {
    AppMethodBeat.i(199575);
    d.g.b.k.h(paramString, "params");
    ac.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString).optString("username", "");
        paramString = (CharSequence)localObject;
        if (paramString != null)
        {
          boolean bool;
          if (paramString.length() == 0)
          {
            break label616;
            if (i != 0)
            {
              ac.e("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage fail, username is null");
              Toast.makeText(this.nua.getActivityContext(), (CharSequence)this.nua.getActivityContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              bool = false;
              ac.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", new Object[] { Boolean.valueOf(bool) });
              AppMethodBeat.o(199575);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          final v.f localf = new v.f();
          paramString = (com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          if (paramString == null) {
            break label621;
          }
          paramString = paramString.awB();
          if (paramString == null) {
            break label621;
          }
          paramString = paramString.aNt((String)localObject);
          localf.KUQ = paramString;
          if (((ai)localf.KUQ == null) || (((ai)localf.KUQ).aaQ() <= 0))
          {
            paramString = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
            d.g.b.k.g(paramString, "MMKernel.service(IMessengerStorage::class.java)");
            localf.KUQ = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramString).awB().aNp((String)localObject);
          }
          paramString = new Intent();
          if (((ai)localf.KUQ != null) && (((ai)localf.KUQ).aaQ() > 0))
          {
            paramString.addFlags(268435456);
            paramString.putExtra("Contact_User", ((ai)localf.KUQ).getUsername());
            if (((ai)localf.KUQ).fad())
            {
              com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, ((ai)localf.KUQ).getUsername() + ",300");
              paramString.putExtra("Contact_Scene", 300);
            }
            if (((ai)localf.KUQ).aaE())
            {
              localObject = new st();
              ((st)localObject).dvI.intent = paramString;
              ((st)localObject).dvI.username = ((ai)localf.KUQ).getUsername();
              a.GpY.l((b)localObject);
            }
            aD(paramString);
            bool = true;
            continue;
          }
          CharSequence localCharSequence = (CharSequence)this.wXw;
          if (localCharSequence == null) {
            break label626;
          }
          if (localCharSequence.length() == 0)
          {
            break label626;
            if (i == 0) {
              ar.a.ayw().yd(this.wXw);
            }
            this.wXw = ((String)localObject);
            ar.a.ayw().a((String)localObject, "", (ar.b.a)new b(this, localf, paramString));
            paramString = (DialogInterface.OnCancelListener)new c((String)localObject);
            this.fua = com.tencent.mm.ui.base.h.b(this.nua.getActivityContext(), this.nua.getActivityContext().getString(2131755936), true, paramString);
            bool = true;
            continue;
          }
          i = 0;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openProfilePage exception", new Object[0]);
        AppMethodBeat.o(199575);
        return;
      }
      label616:
      continue;
      label621:
      paramString = null;
      continue;
      label626:
      int i = 1;
    }
  }
  
  @JavascriptInterface
  public final void openVideoPage(String paramString)
  {
    AppMethodBeat.i(199577);
    d.g.b.k.h(paramString, "params");
    ac.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage param = ".concat(String.valueOf(paramString)));
    try
    {
      Object localObject = new JSONObject(paramString).optString("videoUrl", "");
      if (bs.isNullOrNil((String)localObject))
      {
        ac.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
        AppMethodBeat.o(199577);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      localObject = this.nua.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.br.d.b((Context)localObject, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", paramString);
        AppMethodBeat.o(199577);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(199577);
    }
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    d.g.b.k.h(paramString, "params");
    ac.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.nua.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.br.d.b((Context)localObject, "webview", ".ui.tools.WebViewUI", paramString);
        AppMethodBeat.o(52140);
        return;
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openWebView exception", new Object[0]);
      AppMethodBeat.o(52140);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "userName", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class b
    implements ar.b.a
  {
    b(i parami, v.f paramf, Intent paramIntent) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(199572);
      i.a(this.wXy);
      if (i.b(this.wXy).getActivityContext() == null)
      {
        ac.w("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage getNow callback, context is null");
        AppMethodBeat.o(199572);
        return;
      }
      i.c(this.wXy);
      Object localObject = (com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB();
        if (localObject != null)
        {
          localObject = ((bj)localObject).aNt(paramString);
          if (localObject != null)
          {
            ai localai = (ai)localf.KUQ;
            if (localai == null) {
              d.g.b.k.fOy();
            }
            if (localai.aaQ() > 0) {
              break label353;
            }
          }
          localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNp(paramString);
        }
      }
      label353:
      for (;;)
      {
        if ((localObject == null) || (((ai)localObject).aaQ() <= 0)) {
          paramBoolean = false;
        }
        for (;;)
        {
          if (paramBoolean) {
            break label232;
          }
          Toast.makeText(i.b(this.wXy).getActivityContext(), (CharSequence)i.b(this.wXy).getActivityContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(199572);
          return;
          localObject = null;
          break;
          paramString = ((ai)localObject).getUsername();
        }
        label232:
        ac.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage realUsername: %s", new Object[] { paramString });
        com.tencent.mm.aj.c.ag(paramString, 3);
        com.tencent.mm.aj.p.aBy().zV(paramString);
        paramString.addFlags(268435456);
        paramString.putExtra("Contact_User", paramString);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if (((ai)localObject).fad())
        {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramString + ",300");
          paramString.putExtra("Contact_Scene", 300);
        }
        i.a(this.wXy, paramString);
        AppMethodBeat.o(199572);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class c
    implements DialogInterface.OnCancelListener
  {
    c(String paramString) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(199573);
      ac.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage user cancel");
      ar.a.ayw().yd(this.gxu);
      AppMethodBeat.o(199573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */