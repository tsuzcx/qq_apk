package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusImgDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "()V", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-textstatus_release"})
public final class c
  extends com.tencent.mm.loader.d.b<b>
{
  public final void a(a<b> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(232834);
    p.k(parama, "url");
    p.k(paramg, "fileNameCreator");
    p.k(paramb, "callback");
    try
    {
      paramg = Util.httpGet(((b)parama.aSr()).toString());
      if (paramg == null)
      {
        Log.e("TextStatusLoader", "loadDataImp() data == null url = " + (b)parama.aSr());
        paramb.onError();
        AppMethodBeat.o(232834);
        return;
      }
      Log.i("TextStatusLoader", "loadDataImp() finished with: url = " + (b)parama.aSr());
      parama = com.tencent.mm.loader.h.b.d(paramg, "");
      p.j(parama, "HttpResponse.create(data,\"\")");
      paramb.a((f)parama);
      AppMethodBeat.o(232834);
      return;
    }
    catch (Throwable parama)
    {
      Log.printErrStackTrace("TextStatusLoader", parama, "loadDataImp err", new Object[0]);
      paramb.onError();
      AppMethodBeat.o(232834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.c
 * JD-Core Version:    0.7.0.1
 */