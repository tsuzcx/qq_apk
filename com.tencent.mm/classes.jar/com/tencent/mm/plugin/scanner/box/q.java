package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.z.f;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "closePage", "", "params", "dismissProgressDialog", "doOpenProfilePage", "", "username", "openAdPage", "openProfilePage", "openVideoPage", "openWebView", "release", "setReportData", "data", "Landroid/os/Bundle;", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showShareMenu", "updateShareData", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"})
public final class q
  extends a
{
  public static final a CDp;
  private String CDo;
  private com.tencent.mm.ui.base.q gut;
  private final b plU;
  
  static
  {
    AppMethodBeat.i(52144);
    CDp = new a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public q(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(52143);
    this.plU = paramb;
    AppMethodBeat.o(52143);
  }
  
  private final void aR(Intent paramIntent)
  {
    AppMethodBeat.i(240309);
    com.tencent.mm.br.c.b(this.plU.getActivityContext(), "profile", ".ui.ContactInfoUI", paramIntent);
    AppMethodBeat.o(240309);
  }
  
  public static void av(Bundle paramBundle)
  {
    AppMethodBeat.i(240305);
    kotlin.g.b.p.h(paramBundle, "data");
    n.av(paramBundle);
    AppMethodBeat.o(240305);
  }
  
  public static void release()
  {
    AppMethodBeat.i(240306);
    n.ePw();
    AppMethodBeat.o(240306);
  }
  
  @JavascriptInterface
  public final void closePage(String paramString)
  {
    AppMethodBeat.i(240311);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi closePage: %s", new Object[] { paramString });
    com.tencent.f.h.RTc.aV((Runnable)new b(this));
    AppMethodBeat.o(240311);
  }
  
  @JavascriptInterface
  public final void openAdPage(String paramString)
  {
    AppMethodBeat.i(240307);
    kotlin.g.b.p.h(paramString, "params");
    Log.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openAdPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("adXml", "");
      localObject = ((JSONObject)localObject).optString("uxinfo", "");
      Log.i("MicroMsg.ScanBoxWebViewJSApi", "openAdPage, adXml=".concat(String.valueOf(paramString)));
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landing_pages_xml", paramString);
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
      if (this.plU.getActivityContext() != null)
      {
        com.tencent.mm.br.c.b(this.plU.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(240307);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openAdPage exception", new Object[0]);
      AppMethodBeat.o(240307);
    }
  }
  
  @JavascriptInterface
  public final void openProfilePage(final String paramString)
  {
    AppMethodBeat.i(240308);
    kotlin.g.b.p.h(paramString, "params");
    Log.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage %s", new Object[] { paramString });
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
            break label620;
            if (i != 0)
            {
              Log.e("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage fail, username is null");
              Toast.makeText(this.plU.getActivityContext(), (CharSequence)this.plU.getActivityContext().getString(2131760879, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              bool = false;
              Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", new Object[] { Boolean.valueOf(bool) });
              AppMethodBeat.o(240308);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          final z.f localf = new z.f();
          paramString = (com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          if (paramString == null) {
            break label625;
          }
          paramString = paramString.aSN();
          if (paramString == null) {
            break label625;
          }
          paramString = paramString.Kn((String)localObject);
          localf.SYG = paramString;
          if (((as)localf.SYG == null) || (((as)localf.SYG).arH() <= 0))
          {
            paramString = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            kotlin.g.b.p.g(paramString, "MMKernel.service(IMessengerStorage::class.java)");
            localf.SYG = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramString).aSN().bjH((String)localObject);
          }
          paramString = new Intent();
          if (((as)localf.SYG != null) && (((as)localf.SYG).arH() > 0))
          {
            paramString.addFlags(268435456);
            paramString.putExtra("Contact_User", ((as)localf.SYG).getUsername());
            if (((as)localf.SYG).gBM())
            {
              com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, ((as)localf.SYG).getUsername() + ",300");
              paramString.putExtra("Contact_Scene", 300);
            }
            if (((as)localf.SYG).arv())
            {
              localObject = new uj();
              ((uj)localObject).eaI.intent = paramString;
              ((uj)localObject).eaI.username = ((as)localf.SYG).getUsername();
              EventCenter.instance.publish((IEvent)localObject);
            }
            aR(paramString);
            bool = true;
            continue;
          }
          CharSequence localCharSequence = (CharSequence)this.CDo;
          if (localCharSequence == null) {
            break label630;
          }
          if (localCharSequence.length() == 0)
          {
            break label630;
            if (i == 0) {
              ay.a.aVo().JZ(this.CDo);
            }
            this.CDo = ((String)localObject);
            ay.a.aVo().a((String)localObject, "", (ay.b.a)new c(this, localf, paramString));
            paramString = (DialogInterface.OnCancelListener)new d((String)localObject);
            this.gut = com.tencent.mm.ui.base.h.a(this.plU.getActivityContext(), this.plU.getActivityContext().getString(2131756029), true, paramString);
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
        Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openProfilePage exception", new Object[0]);
        AppMethodBeat.o(240308);
        return;
      }
      label620:
      continue;
      label625:
      paramString = null;
      continue;
      label630:
      int i = 1;
    }
  }
  
  @JavascriptInterface
  public final void openVideoPage(String paramString)
  {
    AppMethodBeat.i(240310);
    kotlin.g.b.p.h(paramString, "params");
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage param = ".concat(String.valueOf(paramString)));
    try
    {
      Object localObject = new JSONObject(paramString).optString("videoUrl", "");
      if (Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
        AppMethodBeat.o(240310);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      localObject = this.plU.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.br.c.b((Context)localObject, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", paramString);
        AppMethodBeat.o(240310);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(240310);
    }
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    kotlin.g.b.p.h(paramString, "params");
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.plU.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.br.c.b((Context)localObject, "webview", ".ui.tools.WebViewUI", paramString);
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
    AppMethodBeat.i(240313);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi showShareMenu: %s", new Object[] { paramString });
    Context localContext = this.plU.getActivityContext();
    kotlin.g.b.p.g(localContext, "uiComponent.activityContext");
    n.bu(localContext, paramString);
    AppMethodBeat.o(240313);
  }
  
  @JavascriptInterface
  public final void updateShareData(String paramString)
  {
    AppMethodBeat.i(240312);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi updateShareData: %s", new Object[] { paramString });
    n.updateShareData(paramString);
    AppMethodBeat.o(240312);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(q paramq) {}
    
    public final void run()
    {
      AppMethodBeat.i(240302);
      q.b(this.CDq).dismiss();
      AppMethodBeat.o(240302);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "userName", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class c
    implements ay.b.a
  {
    c(q paramq, z.f paramf, Intent paramIntent) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(240303);
      q.a(this.CDq);
      if (q.b(this.CDq).getActivityContext() == null)
      {
        Log.w("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage getNow callback, context is null");
        AppMethodBeat.o(240303);
        return;
      }
      q.c(this.CDq);
      Object localObject = (com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN();
        if (localObject != null)
        {
          localObject = ((bv)localObject).Kn(paramString);
          if (localObject != null)
          {
            as localas = (as)localf.SYG;
            if (localas == null) {
              kotlin.g.b.p.hyc();
            }
            if (localas.arH() > 0) {
              break label353;
            }
          }
          localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().bjH(paramString);
        }
      }
      label353:
      for (;;)
      {
        if ((localObject == null) || (((as)localObject).arH() <= 0)) {
          paramBoolean = false;
        }
        for (;;)
        {
          if (paramBoolean) {
            break label232;
          }
          Toast.makeText(q.b(this.CDq).getActivityContext(), (CharSequence)q.b(this.CDq).getActivityContext().getString(2131760879, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(240303);
          return;
          localObject = null;
          break;
          paramString = ((as)localObject).getUsername();
        }
        label232:
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage realUsername: %s", new Object[] { paramString });
        com.tencent.mm.aj.c.ap(paramString, 3);
        com.tencent.mm.aj.p.aYD().Mg(paramString);
        paramString.addFlags(268435456);
        paramString.putExtra("Contact_User", paramString);
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        if (((as)localObject).gBM())
        {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramString + ",300");
          paramString.putExtra("Contact_Scene", 300);
        }
        q.a(this.CDq, paramString);
        AppMethodBeat.o(240303);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(String paramString) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(240304);
      Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage user cancel");
      ay.a.aVo().JZ(this.hLl);
      AppMethodBeat.o(240304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.q
 * JD-Core Version:    0.7.0.1
 */