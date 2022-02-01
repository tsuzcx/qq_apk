package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class g
  extends bv<s>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(78524);
    Log.i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
    paramContext = c.ZL(paramString);
    if (paramContext == null)
    {
      parama.j("fail", null);
      AppMethodBeat.o(78524);
      return;
    }
    long l = paramContext.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      parama.j("invalid_downloadid", null);
      AppMethodBeat.o(78524);
      return;
    }
    if (f.duv().kR(l) > 0)
    {
      parama.j(null, null);
      AppMethodBeat.o(78524);
      return;
    }
    parama.j("fail", null);
    AppMethodBeat.o(78524);
  }
  
  public final void b(b<s>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "cancelDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.g
 * JD-Core Version:    0.7.0.1
 */