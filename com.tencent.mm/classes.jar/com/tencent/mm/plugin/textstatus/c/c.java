package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusImgDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "()V", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.c.b<b>
{
  public final void a(a<b> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(289649);
    s.u(parama, "url");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    try
    {
      paramg = Util.httpGet(((b)parama.bmg()).toString());
      if (paramg == null)
      {
        Log.e("MicroMsg.TextStatus.TextStatusLoader", s.X("loadDataImp() data == null url = ", parama.bmg()));
        paramb.atR();
        AppMethodBeat.o(289649);
        return;
      }
      Log.i("MicroMsg.TextStatus.TextStatusLoader", s.X("loadDataImp() finished with: url = ", parama.bmg()));
      parama = com.tencent.mm.loader.g.b.d(paramg, "");
      s.s(parama, "create(data,\"\")");
      paramb.a((f)parama);
      AppMethodBeat.o(289649);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusLoader", parama, "loadDataImp err", new Object[0]);
      paramb.atR();
      AppMethodBeat.o(289649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.c
 * JD-Core Version:    0.7.0.1
 */