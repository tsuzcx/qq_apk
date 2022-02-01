package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetClipboardData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final j Xna;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297861);
    Xna = new j();
    OOk = 404;
    idA = "getClipboardData";
    AppMethodBeat.o(297861);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297872);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    HashMap localHashMap = new HashMap();
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(297872);
      throw paramh;
    }
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
    {
      localObject = ((ClipData)localObject).getItemAt(0);
      CharSequence localCharSequence = ((ClipData.Item)localObject).getText();
      if (localCharSequence != null) {
        ((Map)localHashMap).put("data", localCharSequence);
      }
      localObject = ((ClipData.Item)localObject).getHtmlText();
      if (localObject != null) {
        ((Map)localHashMap).put("htmlText", localObject);
      }
    }
    d.uiThread((kotlin.g.a.a)new a(paramh));
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localHashMap);
    AppMethodBeat.o(297872);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.j
 * JD-Core Version:    0.7.0.1
 */