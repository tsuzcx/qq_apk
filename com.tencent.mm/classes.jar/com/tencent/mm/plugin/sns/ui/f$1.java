package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class f$1
  implements g.a
{
  f$1(f paramf) {}
  
  public final void a(List<bcs> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, fo paramfo)
  {
    AppMethodBeat.i(38081);
    ab.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
    f localf = this.rEl;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(38081);
      return;
    }
    try
    {
      localf.rEk = ((fo)new fo().parseFrom(paramfo.toByteArray()));
      localf.rEj.a(localf.rEk);
      ab.d("MicroMsg.ArtistAdapter", "copy list info");
      j = paramList.size();
      localf.list.clear();
      localf.rEd.clear();
      localf.rEe.clear();
      i = 0;
      while (i < j)
      {
        paramfo = (bcs)paramList.get(i);
        paramfo = e.a(paramfo.Id, paramfo.jKs, paramfo.Url, paramfo.xrS, paramfo.xrR, paramfo.xrT, paramfo.Desc);
        localf.list.add(paramfo);
        i += 1;
      }
    }
    catch (Exception paramfo)
    {
      int j;
      int i;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ArtistAdapter", paramfo, "", new Object[0]);
      }
      paramfo = paramMap1.keySet().iterator();
      while (paramfo.hasNext())
      {
        i = ((Integer)paramfo.next()).intValue();
        j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
        localf.rEd.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      paramfo = paramMap2.keySet().iterator();
      while (paramfo.hasNext())
      {
        i = ((Integer)paramfo.next()).intValue();
        j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
        localf.rEe.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      paramList.clear();
      paramMap1.clear();
      paramMap2.clear();
      localf.rEg = paramInt1;
      localf.rEf = paramInt2;
      ab.d("MicroMsg.ArtistAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2);
      localf.notifyDataSetChanged();
      AppMethodBeat.o(38081);
    }
  }
  
  public final void ctk()
  {
    AppMethodBeat.i(38082);
    f localf = this.rEl;
    if (localf.rEj != null) {
      localf.rEj.ctl();
    }
    AppMethodBeat.o(38082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.1
 * JD-Core Version:    0.7.0.1
 */