package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ad;

public class au
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78610);
    ad.i("MicroMsg.JsApiRecordVideo", "invoke");
    k.a(parama, 1);
    AppMethodBeat.o(78610);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "recordVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.au
 * JD-Core Version:    0.7.0.1
 */