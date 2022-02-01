package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;

public class aw
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78610);
    Log.i("MicroMsg.JsApiRecordVideo", "invoke");
    k.a(paramb, 1);
    AppMethodBeat.o(78610);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "recordVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aw
 * JD-Core Version:    0.7.0.1
 */