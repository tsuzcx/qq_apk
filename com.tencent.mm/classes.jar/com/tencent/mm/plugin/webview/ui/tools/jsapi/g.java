package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiOpenStoreEmoticonDetailPage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  private static final int OOk;
  public static final g Xiq;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297446);
    Xiq = new g();
    OOk = 415;
    idA = "openStoreEmoticonDetailPage";
    AppMethodBeat.o(297446);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297458);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = paramp.params.get("productId");
    Object localObject2;
    int i;
    if ((localObject1 instanceof String))
    {
      localObject1 = (String)localObject1;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label117;
      }
      i = 1;
      label69:
      if (i == 0) {
        break label122;
      }
      paramh = paramh.WDy;
      paramp = paramp.WEH;
      localObject1 = f.Xip;
      paramh.doCallback(paramp, s.X(f.idA, ":fail empty productId"), null);
    }
    for (;;)
    {
      AppMethodBeat.o(297458);
      return true;
      localObject1 = null;
      break;
      label117:
      i = 0;
      break label69;
      label122:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("extra_id", (String)localObject1);
      ((Intent)localObject2).putExtra("preceding_scence", 12);
      ((Intent)localObject2).putExtra("download_entrance_scene", 12);
      c.b(paramh.context, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
      paramh.WDy.doCallback(paramp.WEH, s.X(idA, ":ok"), null);
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */