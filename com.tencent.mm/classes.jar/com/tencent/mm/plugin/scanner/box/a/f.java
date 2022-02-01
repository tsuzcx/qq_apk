package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiSend;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "onFailed", "", "onSuccess", "send", "text", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b
{
  public static final f OOe;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313811);
    OOe = new f();
    idA = "send";
    AppMethodBeat.o(313811);
  }
  
  private static final void a(f paramf, com.tencent.mm.plugin.webview.jsapi.h paramh, int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(313798);
    s.u(paramf, "this$0");
    s.u(paramh, "$env");
    if (paramIntent != null) {}
    for (;;)
    {
      Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send requestCode: %s, resultCode: %s, data != null: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 == (paramf.hashCode() & 0xFFFF)) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getIntExtra("sendResult", -1) == 0)) {
        a(paramh);
      }
      AppMethodBeat.o(313798);
      return;
      bool = false;
    }
  }
  
  private static void a(com.tencent.mm.plugin.webview.jsapi.h paramh)
  {
    AppMethodBeat.i(313788);
    com.tencent.threadpool.h.ahAA.bk(new f..ExternalSyntheticLambda1(paramh));
    AppMethodBeat.o(313788);
  }
  
  private static final void b(com.tencent.mm.plugin.webview.jsapi.h paramh)
  {
    AppMethodBeat.i(313806);
    s.u(paramh, "$env");
    aa.db(paramh.context, paramh.context.getString(l.i.app_sent));
    AppMethodBeat.o(313806);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(313833);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str = (String)paramp.params.get("content");
    int i;
    if (str == null)
    {
      str = "";
      Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send");
      if (((CharSequence)str).length() != 0) {
        break label108;
      }
      i = 1;
      label64:
      if (i == 0) {
        break label113;
      }
      Log.e("MicroMsg.JsApiSend", "ScanJsApi-Call:send text is empty");
    }
    for (;;)
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(313833);
      return true;
      break;
      label108:
      i = 0;
      break label64;
      label113:
      Intent localIntent = new Intent();
      localIntent.putExtra("Retr_Msg_content", str);
      localIntent.putExtra("Retr_Msg_Type", 4);
      localIntent.putExtra("Retr_show_success_tips", false);
      if ((paramh.context instanceof MMActivity))
      {
        i = hashCode();
        c.a((MMActivity)paramh.context, "com.tencent.mm.ui.transmit.MsgRetransmitUI", localIntent, 0xFFFF & i, new f..ExternalSyntheticLambda0(this, paramh));
      }
      else
      {
        c.g(paramh.context, "com.tencent.mm.ui.transmit.MsgRetransmitUI", localIntent);
        a(paramh);
      }
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.f
 * JD-Core Version:    0.7.0.1
 */