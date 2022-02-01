package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiOpenStoreEmoticonDetailPage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class g
  extends a
{
  private static final int IIl = 415;
  public static final g Qqd;
  private static final String fXz = "openStoreEmoticonDetailPage";
  
  static
  {
    AppMethodBeat.i(216862);
    Qqd = new g();
    IIl = 415;
    fXz = "openStoreEmoticonDetailPage";
    AppMethodBeat.o(216862);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(216860);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject2 = paramn.params.get("productId");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label138;
      }
      paramf = paramf.PNo;
      paramn = paramn.POu;
      localObject1 = new StringBuilder();
      localObject2 = f.Qqb;
      paramf.h(paramn, f.fXz + ":fail empty productId", null);
    }
    for (;;)
    {
      AppMethodBeat.o(216860);
      return true;
      i = 0;
      break;
      label138:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("extra_id", (String)localObject1);
      ((Intent)localObject2).putExtra("preceding_scence", 12);
      ((Intent)localObject2).putExtra("download_entrance_scene", 12);
      c.b(paramf.context, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
      paramf.PNo.h(paramn.POu, fXz + ":ok", null);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g
 * JD-Core Version:    0.7.0.1
 */