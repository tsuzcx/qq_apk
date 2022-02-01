package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.e;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.vm;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "closePage", "", "params", "dismissProgressDialog", "doOpenProfilePage", "", "username", "openAdPage", "openProfilePage", "openVideoPage", "openWebView", "release", "setReportData", "data", "Landroid/os/Bundle;", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showShareMenu", "updateShareData", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"})
public final class q
  extends a
{
  public static final a IHP;
  private String IHO;
  private s iYE;
  private final b som;
  
  static
  {
    AppMethodBeat.i(52144);
    IHP = new a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public q(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(52143);
    this.som = paramb;
    AppMethodBeat.o(52143);
  }
  
  private final void aQ(Intent paramIntent)
  {
    AppMethodBeat.i(218631);
    c.b(this.som.getActivityContext(), "profile", ".ui.ContactInfoUI", paramIntent);
    AppMethodBeat.o(218631);
  }
  
  public static void ar(Bundle paramBundle)
  {
    AppMethodBeat.i(218623);
    p.k(paramBundle, "data");
    n.ar(paramBundle);
    AppMethodBeat.o(218623);
  }
  
  public static void release()
  {
    AppMethodBeat.i(218624);
    n.fCj();
    AppMethodBeat.o(218624);
  }
  
  @JavascriptInterface
  public final void closePage(String paramString)
  {
    AppMethodBeat.i(218635);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi closePage: %s", new Object[] { paramString });
    com.tencent.e.h.ZvG.bc((Runnable)new b(this));
    AppMethodBeat.o(218635);
  }
  
  @JavascriptInterface
  public final void openAdPage(String paramString)
  {
    AppMethodBeat.i(218627);
    p.k(paramString, "params");
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
      if (this.som.getActivityContext() != null)
      {
        c.b(this.som.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(218627);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openAdPage exception", new Object[0]);
      AppMethodBeat.o(218627);
    }
  }
  
  @JavascriptInterface
  public final void openProfilePage(final String paramString)
  {
    AppMethodBeat.i(218630);
    p.k(paramString, "params");
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
              Toast.makeText(this.som.getActivityContext(), (CharSequence)this.som.getActivityContext().getString(l.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              bool = false;
              Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", new Object[] { Boolean.valueOf(bool) });
              AppMethodBeat.o(218630);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          final aa.f localf = new aa.f();
          paramString = (com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          if (paramString == null) {
            break label625;
          }
          paramString = paramString.bbL();
          if (paramString == null) {
            break label625;
          }
          paramString = paramString.RG((String)localObject);
          localf.aaBC = paramString;
          if (((as)localf.aaBC == null) || (((as)localf.aaBC).ayq() <= 0))
          {
            paramString = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
            p.j(paramString, "MMKernel.service(IMessengerStorage::class.java)");
            localf.aaBC = ((com.tencent.mm.plugin.messenger.foundation.a.n)paramString).bbL().bwe((String)localObject);
          }
          paramString = new Intent();
          if (((as)localf.aaBC != null) && (((as)localf.aaBC).ayq() > 0))
          {
            paramString.addFlags(268435456);
            paramString.putExtra("Contact_User", ((as)localf.aaBC).getUsername());
            if (((as)localf.aaBC).hxX())
            {
              com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, ((as)localf.aaBC).getUsername() + ",300");
              paramString.putExtra("Contact_Scene", 300);
            }
            if (((as)localf.aaBC).axZ())
            {
              localObject = new vm();
              ((vm)localObject).fUF.intent = paramString;
              ((vm)localObject).fUF.username = ((as)localf.aaBC).getUsername();
              EventCenter.instance.publish((IEvent)localObject);
            }
            aQ(paramString);
            bool = true;
            continue;
          }
          CharSequence localCharSequence = (CharSequence)this.IHO;
          if (localCharSequence == null) {
            break label630;
          }
          if (localCharSequence.length() == 0)
          {
            break label630;
            if (i == 0) {
              az.a.ber().Rr(this.IHO);
            }
            this.IHO = ((String)localObject);
            az.a.ber().a((String)localObject, "", (az.b.a)new c(this, localf, paramString));
            paramString = (DialogInterface.OnCancelListener)new d((String)localObject);
            this.iYE = com.tencent.mm.ui.base.h.a(this.som.getActivityContext(), this.som.getActivityContext().getString(l.i.app_waiting), true, paramString);
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
        AppMethodBeat.o(218630);
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
    AppMethodBeat.i(218633);
    p.k(paramString, "params");
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage param = ".concat(String.valueOf(paramString)));
    try
    {
      Object localObject = new JSONObject(paramString).optString("videoUrl", "");
      if (Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
        AppMethodBeat.o(218633);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      localObject = this.som.getActivityContext();
      if (localObject != null)
      {
        c.b((Context)localObject, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", paramString);
        AppMethodBeat.o(218633);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(218633);
    }
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    p.k(paramString, "params");
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.som.getActivityContext();
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
    AppMethodBeat.i(218638);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi showShareMenu: %s", new Object[] { paramString });
    Context localContext = this.som.getActivityContext();
    p.j(localContext, "uiComponent.activityContext");
    n.bH(localContext, paramString);
    AppMethodBeat.o(218638);
  }
  
  @JavascriptInterface
  public final void updateShareData(String paramString)
  {
    AppMethodBeat.i(218637);
    Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi updateShareData: %s", new Object[] { paramString });
    n.updateShareData(paramString);
    AppMethodBeat.o(218637);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(q paramq) {}
    
    public final void run()
    {
      AppMethodBeat.i(222265);
      q.b(this.IHQ).dismiss();
      AppMethodBeat.o(222265);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "userName", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class c
    implements az.b.a
  {
    c(q paramq, aa.f paramf, Intent paramIntent) {}
    
    public final void s(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(216991);
      q.a(this.IHQ);
      if (q.b(this.IHQ).getActivityContext() == null)
      {
        Log.w("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage getNow callback, context is null");
        AppMethodBeat.o(216991);
        return;
      }
      q.c(this.IHQ);
      Object localObject = (com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL();
        if (localObject != null)
        {
          localObject = ((bv)localObject).RG(paramString);
          if (localObject != null)
          {
            as localas = (as)localf.aaBC;
            if (localas == null) {
              p.iCn();
            }
            if (localas.ayq() > 0) {
              break label354;
            }
          }
          localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().bwe(paramString);
        }
      }
      label354:
      for (;;)
      {
        if ((localObject == null) || (((as)localObject).ayq() <= 0)) {
          paramBoolean = false;
        }
        for (;;)
        {
          if (paramBoolean) {
            break label233;
          }
          Toast.makeText(q.b(this.IHQ).getActivityContext(), (CharSequence)q.b(this.IHQ).getActivityContext().getString(l.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(216991);
          return;
          localObject = null;
          break;
          paramString = ((as)localObject).getUsername();
        }
        label233:
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage realUsername: %s", new Object[] { paramString });
        d.aH(paramString, 3);
        com.tencent.mm.am.q.bhR().TB(paramString);
        paramString.addFlags(268435456);
        paramString.putExtra("Contact_User", paramString);
        if (localObject == null) {
          p.iCn();
        }
        if (((as)localObject).hxX())
        {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramString + ",300");
          paramString.putExtra("Contact_Scene", 300);
        }
        q.a(this.IHQ, paramString);
        AppMethodBeat.o(216991);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(String paramString) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(218965);
      Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage user cancel");
      az.a.ber().Rr(this.kyF);
      AppMethodBeat.o(218965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.q
 * JD-Core Version:    0.7.0.1
 */