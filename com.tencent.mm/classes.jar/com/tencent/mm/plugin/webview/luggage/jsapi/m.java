package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;

public class m
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78545);
    ac.i("MicroMsg.JsApiCloseWindow", "invokeInOwn");
    ((f)parama.bWR).eAx();
    parama.a("", null);
    AppMethodBeat.o(78545);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "closeWindow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.m
 * JD-Core Version:    0.7.0.1
 */