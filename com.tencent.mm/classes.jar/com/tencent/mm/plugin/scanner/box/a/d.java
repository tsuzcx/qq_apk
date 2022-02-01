package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.u;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiSend;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "onFailed", "", "onSuccess", "send", "text", "plugin-scan_release"})
public final class d
  extends b
{
  public static final d CDD;
  private static final String edq = "send";
  
  static
  {
    AppMethodBeat.i(240351);
    CDD = new d();
    edq = "send";
    AppMethodBeat.o(240351);
  }
  
  private static void a(f paramf)
  {
    AppMethodBeat.i(240350);
    com.tencent.f.h.RTc.aV((Runnable)new a(paramf));
    AppMethodBeat.o(240350);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(240349);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject = (String)paramn.params.get("content");
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send");
      int i;
      if (((CharSequence)localObject).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label121;
        }
        Log.e("MicroMsg.JsApiSend", "ScanJsApi-Call:send text is empty");
      }
      for (;;)
      {
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
        AppMethodBeat.o(240349);
        return true;
        i = 0;
        break;
        label121:
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_Msg_content", (String)localObject);
        localIntent.putExtra("Retr_Msg_Type", 4);
        localIntent.putExtra("Retr_show_success_tips", false);
        if ((paramf.context instanceof MMActivity))
        {
          i = hashCode();
          localObject = paramf.context;
          if (localObject == null)
          {
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(240349);
            throw paramf;
          }
          c.a((MMActivity)localObject, "com.tencent.mm.ui.transmit.MsgRetransmitUI", localIntent, i & 0xFFFF, (MMActivity.a)new b(paramf));
        }
        else
        {
          c.f(paramf.context, "com.tencent.mm.ui.transmit.MsgRetransmitUI", localIntent);
          a(paramf);
        }
      }
    }
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(240347);
      u.cG(this.CDE.context, this.CDE.context.getString(2131755979));
      AppMethodBeat.o(240347);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class b
    implements MMActivity.a
  {
    b(f paramf) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      boolean bool = true;
      AppMethodBeat.i(240348);
      if (paramIntent != null) {}
      for (;;)
      {
        Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send requestCode: %s, resultCode: %s, data != null: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        if ((paramInt1 == (d.CDD.hashCode() & 0xFFFF)) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getIntExtra("sendResult", -1) == 0))
        {
          paramIntent = d.CDD;
          d.b(this.CDE);
        }
        AppMethodBeat.o(240348);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.d
 * JD-Core Version:    0.7.0.1
 */