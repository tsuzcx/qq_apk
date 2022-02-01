package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetClipboardData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class y
  extends a
{
  private static final int IIl = 403;
  public static final y QvK;
  private static final String fXz = "setClipboardData";
  
  static
  {
    AppMethodBeat.i(223523);
    QvK = new y();
    IIl = 403;
    fXz = "setClipboardData";
    AppMethodBeat.o(223523);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(223519);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject2 = paramn.params.get("data");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject3 = paramn.params.get("htmlText");
      localObject2 = localObject3;
      if (!(localObject3 instanceof String)) {
        localObject2 = null;
      }
      localObject2 = (String)localObject2;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        ClipboardHelper.setText(paramf.context, (CharSequence)"text", (CharSequence)localObject1, (String)localObject2);
        Toast.makeText(paramf.context, (CharSequence)paramf.context.getString(c.i.wv_set_clipboard), 0).show();
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
        AppMethodBeat.o(223519);
        return true;
      }
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.y
 * JD-Core Version:    0.7.0.1
 */