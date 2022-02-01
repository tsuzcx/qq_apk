package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetClipboardData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class j
  extends a
{
  private static final int IIl = 404;
  public static final j Qvc;
  private static final String fXz = "getClipboardData";
  
  static
  {
    AppMethodBeat.i(236309);
    Qvc = new j();
    IIl = 404;
    fXz = "getClipboardData";
    AppMethodBeat.o(236309);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(236304);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    HashMap localHashMap = new HashMap();
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      paramf = new t("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(236304);
      throw paramf;
    }
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
    {
      localObject = ((ClipData)localObject).getItemAt(0);
      p.j(localObject, "item");
      CharSequence localCharSequence = ((ClipData.Item)localObject).getText();
      if (localCharSequence != null) {
        ((Map)localHashMap).put("data", localCharSequence);
      }
      localObject = ((ClipData.Item)localObject).getHtmlText();
      if (localObject != null) {
        ((Map)localHashMap).put("htmlText", localObject);
      }
    }
    Toast.makeText(paramf.context, (CharSequence)paramf.context.getString(c.i.wv_get_clipboard), 0).show();
    paramf.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localHashMap);
    AppMethodBeat.o(236304);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.j
 * JD-Core Version:    0.7.0.1
 */