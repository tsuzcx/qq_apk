package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.b.y.f;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "closePage", "", "params", "dismissProgressDialog", "doOpenProfilePage", "", "username", "openAdPage", "openProfilePage", "openVideoPage", "openWebView", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"})
public final class i
  extends com.tencent.mm.plugin.box.webview.d
{
  public static final i.a yli;
  private com.tencent.mm.ui.base.p fNb;
  private final com.tencent.mm.plugin.box.c.c nVq;
  private String ylh;
  
  static
  {
    AppMethodBeat.i(52144);
    yli = new i.a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public i(com.tencent.mm.plugin.box.c.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(52143);
    this.nVq = paramc;
    AppMethodBeat.o(52143);
  }
  
  private final void aI(Intent paramIntent)
  {
    AppMethodBeat.i(186254);
    com.tencent.mm.bs.d.b(this.nVq.getActivityContext(), "profile", ".ui.ContactInfoUI", paramIntent);
    AppMethodBeat.o(186254);
  }
  
  @JavascriptInterface
  public final void closePage(String paramString)
  {
    AppMethodBeat.i(186256);
    ad.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi closePage: %s", new Object[] { paramString });
    com.tencent.e.h.LTJ.aP((Runnable)new b(this));
    AppMethodBeat.o(186256);
  }
  
  @JavascriptInterface
  public final void openAdPage(String paramString)
  {
    AppMethodBeat.i(186252);
    d.g.b.p.h(paramString, "params");
    ad.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openAdPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("adXml", "");
      localObject = ((JSONObject)localObject).optString("uxinfo", "");
      ad.i("MicroMsg.ScanBoxWebViewJSApi", "openAdPage, adXml=".concat(String.valueOf(paramString)));
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landing_pages_xml", paramString);
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
      if (this.nVq.getActivityContext() != null)
      {
        com.tencent.mm.bs.d.b(this.nVq.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(186252);
        return;
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openAdPage exception", new Object[0]);
      AppMethodBeat.o(186252);
    }
  }
  
  @JavascriptInterface
  public final void openProfilePage(final String paramString)
  {
    AppMethodBeat.i(186253);
    d.g.b.p.h(paramString, "params");
    ad.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage %s", new Object[] { paramString });
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
            break label619;
            if (i != 0)
            {
              ad.e("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage fail, username is null");
              Toast.makeText(this.nVq.getActivityContext(), (CharSequence)this.nVq.getActivityContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              bool = false;
              ad.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", new Object[] { Boolean.valueOf(bool) });
              AppMethodBeat.o(186253);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          final y.f localf = new y.f();
          paramString = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          if (paramString == null) {
            break label624;
          }
          paramString = paramString.azp();
          if (paramString == null) {
            break label624;
          }
          paramString = paramString.Bf((String)localObject);
          localf.MLV = paramString;
          if (((am)localf.MLV == null) || (((am)localf.MLV).adt() <= 0))
          {
            paramString = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            d.g.b.p.g(paramString, "MMKernel.service(IMessengerStorage::class.java)");
            localf.MLV = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramString).azp().aTh((String)localObject);
          }
          paramString = new Intent();
          if (((am)localf.MLV != null) && (((am)localf.MLV).adt() > 0))
          {
            paramString.addFlags(268435456);
            paramString.putExtra("Contact_User", ((am)localf.MLV).getUsername());
            if (((am)localf.MLV).fqg())
            {
              com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, ((am)localf.MLV).getUsername() + ",300");
              paramString.putExtra("Contact_Scene", 300);
            }
            if (((am)localf.MLV).adh())
            {
              localObject = new tk();
              ((tk)localObject).dHR.intent = paramString;
              ((tk)localObject).dHR.username = ((am)localf.MLV).getUsername();
              a.IbL.l((b)localObject);
            }
            aI(paramString);
            bool = true;
            continue;
          }
          CharSequence localCharSequence = (CharSequence)this.ylh;
          if (localCharSequence == null) {
            break label629;
          }
          if (localCharSequence.length() == 0)
          {
            break label629;
            if (i == 0) {
              as.a.aBA().AJ(this.ylh);
            }
            this.ylh = ((String)localObject);
            as.a.aBA().a((String)localObject, "", (as.b.a)new c(this, localf, paramString));
            paramString = (DialogInterface.OnCancelListener)new d((String)localObject);
            this.fNb = com.tencent.mm.ui.base.h.b(this.nVq.getActivityContext(), this.nVq.getActivityContext().getString(2131755936), true, paramString);
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
        ad.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openProfilePage exception", new Object[0]);
        AppMethodBeat.o(186253);
        return;
      }
      label619:
      continue;
      label624:
      paramString = null;
      continue;
      label629:
      int i = 1;
    }
  }
  
  @JavascriptInterface
  public final void openVideoPage(String paramString)
  {
    AppMethodBeat.i(186255);
    d.g.b.p.h(paramString, "params");
    ad.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage param = ".concat(String.valueOf(paramString)));
    try
    {
      Object localObject = new JSONObject(paramString).optString("videoUrl", "");
      if (bt.isNullOrNil((String)localObject))
      {
        ad.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
        AppMethodBeat.o(186255);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      localObject = this.nVq.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.bs.d.b((Context)localObject, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", paramString);
        AppMethodBeat.o(186255);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(186255);
    }
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    d.g.b.p.h(paramString, "params");
    ad.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.nVq.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.bs.d.b((Context)localObject, "webview", ".ui.tools.WebViewUI", paramString);
        AppMethodBeat.o(52140);
        return;
      }
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openWebView exception", new Object[0]);
      AppMethodBeat.o(52140);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(186249);
      i.b(this.ylj).dismiss();
      AppMethodBeat.o(186249);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "userName", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class c
    implements as.b.a
  {
    c(i parami, y.f paramf, Intent paramIntent) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(186250);
      i.a(this.ylj);
      if (i.b(this.ylj).getActivityContext() == null)
      {
        ad.w("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage getNow callback, context is null");
        AppMethodBeat.o(186250);
        return;
      }
      i.c(this.ylj);
      Object localObject = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp();
        if (localObject != null)
        {
          localObject = ((bp)localObject).Bf(paramString);
          if (localObject != null)
          {
            am localam = (am)localf.MLV;
            if (localam == null) {
              d.g.b.p.gfZ();
            }
            if (localam.adt() > 0) {
              break label353;
            }
          }
          localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().aTh(paramString);
        }
      }
      label353:
      for (;;)
      {
        if ((localObject == null) || (((am)localObject).adt() <= 0)) {
          paramBoolean = false;
        }
        for (;;)
        {
          if (paramBoolean) {
            break label232;
          }
          Toast.makeText(i.b(this.ylj).getActivityContext(), (CharSequence)i.b(this.ylj).getActivityContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(186250);
          return;
          localObject = null;
          break;
          paramString = ((am)localObject).getUsername();
        }
        label232:
        ad.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage realUsername: %s", new Object[] { paramString });
        com.tencent.mm.ak.c.ak(paramString, 3);
        com.tencent.mm.ak.p.aEz().CU(paramString);
        paramString.addFlags(268435456);
        paramString.putExtra("Contact_User", paramString);
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        if (((am)localObject).fqg())
        {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramString + ",300");
          paramString.putExtra("Contact_Scene", 300);
        }
        i.a(this.ylj, paramString);
        AppMethodBeat.o(186250);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(String paramString) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(186251);
      ad.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage user cancel");
      as.a.aBA().AJ(this.gRf);
      AppMethodBeat.o(186251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */