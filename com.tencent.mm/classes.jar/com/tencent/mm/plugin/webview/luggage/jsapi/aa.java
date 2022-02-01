package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;

public class aa
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78562);
    Log.i("MicroMsg.JsApiHideOptionMenu", "invoke");
    m localm = ((g)paramb.crg).gUx();
    if (localm == null)
    {
      Log.e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
      paramb.a("fail", null);
      AppMethodBeat.o(78562);
      return;
    }
    localm.gUT();
    paramb.a("", null);
    AppMethodBeat.o(78562);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "hideOptionMenu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */