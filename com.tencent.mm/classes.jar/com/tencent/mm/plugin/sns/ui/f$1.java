package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class f$1
  implements g.a
{
  f$1(f paramf) {}
  
  public final void a(List<awd> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, el paramel)
  {
    y.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
    f localf = this.oMA;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    try
    {
      localf.oMz = ((el)new el().aH(paramel.toByteArray()));
      localf.oMy.a(localf.oMz);
      y.d("MicroMsg.ArtistAdapter", "copy list info");
      j = paramList.size();
      localf.list.clear();
      localf.oMs.clear();
      localf.oMt.clear();
      i = 0;
      while (i < j)
      {
        paramel = (awd)paramList.get(i);
        paramel = e.a(paramel.lsK, paramel.hQR, paramel.kSC, paramel.trP, paramel.trO, paramel.trQ, paramel.kRN);
        localf.list.add(paramel);
        i += 1;
      }
    }
    catch (Exception paramel)
    {
      int j;
      int i;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ArtistAdapter", paramel, "", new Object[0]);
      }
      paramel = paramMap1.keySet().iterator();
      while (paramel.hasNext())
      {
        i = ((Integer)paramel.next()).intValue();
        j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
        localf.oMs.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      paramel = paramMap2.keySet().iterator();
      while (paramel.hasNext())
      {
        i = ((Integer)paramel.next()).intValue();
        j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
        localf.oMt.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      paramList.clear();
      paramMap1.clear();
      paramMap2.clear();
      localf.oMv = paramInt1;
      localf.oMu = paramInt2;
      y.d("MicroMsg.ArtistAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2);
      localf.notifyDataSetChanged();
    }
  }
  
  public final void bHg()
  {
    f localf = this.oMA;
    if (localf.oMy != null) {
      localf.oMy.bHh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.1
 * JD-Core Version:    0.7.0.1
 */