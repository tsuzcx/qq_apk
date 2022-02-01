package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class g
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(78524);
    ac.i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
    paramContext = b.LK(paramString);
    if (paramContext == null)
    {
      parama.f("fail", null);
      AppMethodBeat.o(78524);
      return;
    }
    long l = paramContext.optLong("download_id");
    if (l <= 0L)
    {
      ac.e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      parama.f("invalid_downloadid", null);
      AppMethodBeat.o(78524);
      return;
    }
    if (f.bXJ().rS(l) > 0)
    {
      parama.f(null, null);
      AppMethodBeat.o(78524);
      return;
    }
    parama.f("fail", null);
    AppMethodBeat.o(78524);
  }
  
  public final void b(a<n>.a parama) {}
  
  public final int bYk()
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