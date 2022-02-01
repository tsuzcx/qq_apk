package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper;", "", "()V", "RGB2YUV_HW_ENCODE", "", "RGB2YUV_RENDER", "RGB2YUV_SOFT_ENCODE", "RGB2YUV_TEXTURE_2_BYTE_ARRAY", "RGB2YUV_TRANSFER", "TAG", "", "record", "", "Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "[Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "appendHw", "", "cost", "", "appendSoft", "appendTransfer", "report", "id", "reset", "Record", "plugin-voip_release"})
public final class j
{
  private static final a[] OeK;
  public static final j OeL;
  
  static
  {
    AppMethodBeat.i(244385);
    OeL = new j();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a();
      i += 1;
    }
    OeK = arrayOfa;
    AppMethodBeat.o(244385);
  }
  
  public static void ba(int paramInt, long paramLong)
  {
    a locala = OeK[paramInt];
    locala.OeM += 1L;
    locala.OeN += paramLong;
  }
  
  public static void report()
  {
    AppMethodBeat.i(244382);
    if (!g.gCD())
    {
      reset();
      AppMethodBeat.o(244382);
      return;
    }
    com.tencent.mm.plugin.voip.c.j localj;
    if (OeK[0].OeM >= 5L)
    {
      localj = com.tencent.mm.plugin.voip.c.j.NYe;
      com.tencent.mm.plugin.voip.c.j.Tk(OeK[0].gEv());
    }
    if (OeK[1].OeM >= 5L)
    {
      localj = com.tencent.mm.plugin.voip.c.j.NYe;
      com.tencent.mm.plugin.voip.c.j.Tl(OeK[1].gEv());
    }
    if (OeK[2].OeM >= 5L)
    {
      localj = com.tencent.mm.plugin.voip.c.j.NYe;
      com.tencent.mm.plugin.voip.c.j.Tm(OeK[2].gEv());
    }
    if (OeK[3].OeM >= 5L)
    {
      localj = com.tencent.mm.plugin.voip.c.j.NYe;
      com.tencent.mm.plugin.voip.c.j.Tn(OeK[3].gEv());
    }
    if (OeK[4].OeM >= 5L)
    {
      localj = com.tencent.mm.plugin.voip.c.j.NYe;
      com.tencent.mm.plugin.voip.c.j.To(OeK[4].gEv());
    }
    reset();
    AppMethodBeat.o(244382);
  }
  
  public static void reset()
  {
    a[] arrayOfa = OeK;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.OeM = 0L;
      locala.OeN = 0L;
      i += 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "", "times", "", "sum", "(JJ)V", "getSum", "()J", "setSum", "(J)V", "getTimes", "setTimes", "append", "", "cost", "avg", "reset", "plugin-voip_release"})
  public static final class a
  {
    long OeM = 0L;
    long OeN = 0L;
    
    public final long gEv()
    {
      long l2 = this.OeN;
      if (this.OeM == 0L) {}
      for (long l1 = 1L;; l1 = this.OeM) {
        return l2 / l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.j
 * JD-Core Version:    0.7.0.1
 */