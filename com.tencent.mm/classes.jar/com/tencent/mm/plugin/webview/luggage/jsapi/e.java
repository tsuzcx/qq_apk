package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class e
  extends bh<n>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6284);
    ab.i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
    paramContext = b.BJ(paramString);
    if (paramContext == null)
    {
      parama.c("fail", null);
      AppMethodBeat.o(6284);
      return;
    }
    long l = paramContext.optLong("download_id");
    if (l <= 0L)
    {
      ab.e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      parama.c("invalid_downloadid", null);
      AppMethodBeat.o(6284);
      return;
    }
    if (f.bjl().iz(l) > 0)
    {
      parama.c(null, null);
      AppMethodBeat.o(6284);
      return;
    }
    parama.c("fail", null);
    AppMethodBeat.o(6284);
  }
  
  public final void b(a<n>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "cancelDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.e
 * JD-Core Version:    0.7.0.1
 */