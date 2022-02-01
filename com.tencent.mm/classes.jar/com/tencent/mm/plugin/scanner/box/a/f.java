package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.w;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiSend;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "onFailed", "", "onSuccess", "send", "text", "plugin-scan_release"})
public final class f
  extends b
{
  public static final f IIf;
  private static final String fXz = "send";
  
  static
  {
    AppMethodBeat.i(222586);
    IIf = new f();
    fXz = "send";
    AppMethodBeat.o(222586);
  }
  
  private static void a(com.tencent.mm.plugin.webview.d.f paramf)
  {
    AppMethodBeat.i(222579);
    com.tencent.e.h.ZvG.bc((Runnable)new a(paramf));
    AppMethodBeat.o(222579);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(222576);
    p.k(paramf, "env");
    p.k(paramn, "msg");
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
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
        AppMethodBeat.o(222576);
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
            AppMethodBeat.o(222576);
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
  
  public final String fCm()
  {
    return fXz;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.plugin.webview.d.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(217677);
      w.cR(this.IIg.context, this.IIg.context.getString(l.i.app_sent));
      AppMethodBeat.o(217677);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class b
    implements MMActivity.a
  {
    b(com.tencent.mm.plugin.webview.d.f paramf) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      boolean bool = true;
      AppMethodBeat.i(217263);
      if (paramIntent != null) {}
      for (;;)
      {
        Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send requestCode: %s, resultCode: %s, data != null: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        if ((paramInt1 == (f.IIf.hashCode() & 0xFFFF)) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getIntExtra("sendResult", -1) == 0))
        {
          paramIntent = f.IIf;
          f.b(this.IIg);
        }
        AppMethodBeat.o(217263);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.f
 * JD-Core Version:    0.7.0.1
 */