package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.b.y.f;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "closePage", "", "params", "dismissProgressDialog", "doOpenProfilePage", "", "username", "openAdPage", "openProfilePage", "openVideoPage", "openWebView", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"})
public final class i
  extends com.tencent.mm.plugin.box.webview.d
{
  public static final i.a yBh;
  private com.tencent.mm.ui.base.p fPj;
  private final com.tencent.mm.plugin.box.c.c oaX;
  private String yBg;
  
  static
  {
    AppMethodBeat.i(52144);
    yBh = new i.a((byte)0);
    AppMethodBeat.o(52144);
  }
  
  public i(com.tencent.mm.plugin.box.c.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(52143);
    this.oaX = paramc;
    AppMethodBeat.o(52143);
  }
  
  private final void aJ(Intent paramIntent)
  {
    AppMethodBeat.i(189536);
    com.tencent.mm.br.d.b(this.oaX.getActivityContext(), "profile", ".ui.ContactInfoUI", paramIntent);
    AppMethodBeat.o(189536);
  }
  
  @JavascriptInterface
  public final void closePage(String paramString)
  {
    AppMethodBeat.i(189538);
    ae.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi closePage: %s", new Object[] { paramString });
    com.tencent.e.h.MqF.aM((Runnable)new b(this));
    AppMethodBeat.o(189538);
  }
  
  @JavascriptInterface
  public final void openAdPage(String paramString)
  {
    AppMethodBeat.i(189534);
    d.g.b.p.h(paramString, "params");
    ae.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openAdPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("adXml", "");
      localObject = ((JSONObject)localObject).optString("uxinfo", "");
      ae.i("MicroMsg.ScanBoxWebViewJSApi", "openAdPage, adXml=".concat(String.valueOf(paramString)));
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landing_pages_xml", paramString);
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
      if (this.oaX.getActivityContext() != null)
      {
        com.tencent.mm.br.d.b(this.oaX.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(189534);
        return;
      }
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openAdPage exception", new Object[0]);
      AppMethodBeat.o(189534);
    }
  }
  
  @JavascriptInterface
  public final void openProfilePage(final String paramString)
  {
    AppMethodBeat.i(189535);
    d.g.b.p.h(paramString, "params");
    ae.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage %s", new Object[] { paramString });
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
              ae.e("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage fail, username is null");
              Toast.makeText(this.oaX.getActivityContext(), (CharSequence)this.oaX.getActivityContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              bool = false;
              ae.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", new Object[] { Boolean.valueOf(bool) });
              AppMethodBeat.o(189535);
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
          paramString = paramString.azF();
          if (paramString == null) {
            break label624;
          }
          paramString = paramString.BH((String)localObject);
          localf.NiY = paramString;
          if (((an)localf.NiY == null) || (((an)localf.NiY).adE() <= 0))
          {
            paramString = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            d.g.b.p.g(paramString, "MMKernel.service(IMessengerStorage::class.java)");
            localf.NiY = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramString).azF().aUI((String)localObject);
          }
          paramString = new Intent();
          if (((an)localf.NiY != null) && (((an)localf.NiY).adE() > 0))
          {
            paramString.addFlags(268435456);
            paramString.putExtra("Contact_User", ((an)localf.NiY).getUsername());
            if (((an)localf.NiY).fug())
            {
              com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, ((an)localf.NiY).getUsername() + ",300");
              paramString.putExtra("Contact_Scene", 300);
            }
            if (((an)localf.NiY).ads())
            {
              localObject = new tl();
              ((tl)localObject).dIV.intent = paramString;
              ((tl)localObject).dIV.username = ((an)localf.NiY).getUsername();
              a.IvT.l((b)localObject);
            }
            aJ(paramString);
            bool = true;
            continue;
          }
          CharSequence localCharSequence = (CharSequence)this.yBg;
          if (localCharSequence == null) {
            break label629;
          }
          if (localCharSequence.length() == 0)
          {
            break label629;
            if (i == 0) {
              au.a.aBQ().Bt(this.yBg);
            }
            this.yBg = ((String)localObject);
            au.a.aBQ().a((String)localObject, "", (au.b.a)new c(this, localf, paramString));
            paramString = (DialogInterface.OnCancelListener)new d((String)localObject);
            this.fPj = com.tencent.mm.ui.base.h.b(this.oaX.getActivityContext(), this.oaX.getActivityContext().getString(2131755936), true, paramString);
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
        ae.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openProfilePage exception", new Object[0]);
        AppMethodBeat.o(189535);
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
    AppMethodBeat.i(189537);
    d.g.b.p.h(paramString, "params");
    ae.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage param = ".concat(String.valueOf(paramString)));
    try
    {
      Object localObject = new JSONObject(paramString).optString("videoUrl", "");
      if (bu.isNullOrNil((String)localObject))
      {
        ae.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
        AppMethodBeat.o(189537);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      localObject = this.oaX.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.br.d.b((Context)localObject, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", paramString);
        AppMethodBeat.o(189537);
        return;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(189537);
    }
  }
  
  @JavascriptInterface
  public final void openWebView(String paramString)
  {
    AppMethodBeat.i(52140);
    d.g.b.p.h(paramString, "params");
    ae.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString).optString("url", "");
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("geta8key_scene", 67);
      localObject = this.oaX.getActivityContext();
      if (localObject != null)
      {
        com.tencent.mm.br.d.b((Context)localObject, "webview", ".ui.tools.WebViewUI", paramString);
        AppMethodBeat.o(52140);
        return;
      }
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", (Throwable)paramString, "alvinluo openWebView exception", new Object[0]);
      AppMethodBeat.o(52140);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(189531);
      i.b(this.yBi).dismiss();
      AppMethodBeat.o(189531);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "userName", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class c
    implements au.b.a
  {
    c(i parami, y.f paramf, Intent paramIntent) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(189532);
      i.a(this.yBi);
      if (i.b(this.yBi).getActivityContext() == null)
      {
        ae.w("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage getNow callback, context is null");
        AppMethodBeat.o(189532);
        return;
      }
      i.c(this.yBi);
      Object localObject = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF();
        if (localObject != null)
        {
          localObject = ((bq)localObject).BH(paramString);
          if (localObject != null)
          {
            an localan = (an)localf.NiY;
            if (localan == null) {
              d.g.b.p.gkB();
            }
            if (localan.adE() > 0) {
              break label353;
            }
          }
          localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().aUI(paramString);
        }
      }
      label353:
      for (;;)
      {
        if ((localObject == null) || (((an)localObject).adE() <= 0)) {
          paramBoolean = false;
        }
        for (;;)
        {
          if (paramBoolean) {
            break label232;
          }
          Toast.makeText(i.b(this.yBi).getActivityContext(), (CharSequence)i.b(this.yBi).getActivityContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(189532);
          return;
          localObject = null;
          break;
          paramString = ((an)localObject).getUsername();
        }
        label232:
        ae.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage realUsername: %s", new Object[] { paramString });
        com.tencent.mm.aj.c.al(paramString, 3);
        com.tencent.mm.aj.p.aEP().Dw(paramString);
        paramString.addFlags(268435456);
        paramString.putExtra("Contact_User", paramString);
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (((an)localObject).fug())
        {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramString + ",300");
          paramString.putExtra("Contact_Scene", 300);
        }
        i.a(this.yBi, paramString);
        AppMethodBeat.o(189532);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(String paramString) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(189533);
      ae.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage user cancel");
      au.a.aBQ().Bt(this.gTN);
      AppMethodBeat.o(189533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */