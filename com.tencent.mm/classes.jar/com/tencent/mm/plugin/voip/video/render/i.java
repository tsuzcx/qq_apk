package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper;", "", "()V", "RGB2YUV_HW_ENCODE", "", "RGB2YUV_RENDER", "RGB2YUV_SOFT_ENCODE", "RGB2YUV_TEXTURE_2_BYTE_ARRAY", "RGB2YUV_TRANSFER", "TAG", "", "record", "", "Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "[Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "appendHw", "", "cost", "", "appendSoft", "appendTransfer", "report", "id", "reset", "Record", "plugin-voip_release"})
public final class i
{
  private static final a[] HnQ;
  public static final i HnR;
  
  static
  {
    AppMethodBeat.i(236253);
    HnR = new i();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a();
      i += 1;
    }
    HnQ = arrayOfa;
    AppMethodBeat.o(236253);
  }
  
  public static void aO(int paramInt, long paramLong)
  {
    a locala = HnQ[paramInt];
    locala.HnS += 1L;
    locala.HnT += paramLong;
  }
  
  public static void report()
  {
    AppMethodBeat.i(236252);
    if (!g.fKe())
    {
      reset();
      AppMethodBeat.o(236252);
      return;
    }
    j localj;
    if (HnQ[0].HnS >= 5L)
    {
      localj = j.Hhp;
      j.LM(HnQ[0].fLU());
    }
    if (HnQ[1].HnS >= 5L)
    {
      localj = j.Hhp;
      j.LN(HnQ[1].fLU());
    }
    if (HnQ[2].HnS >= 5L)
    {
      localj = j.Hhp;
      j.LO(HnQ[2].fLU());
    }
    if (HnQ[3].HnS >= 5L)
    {
      localj = j.Hhp;
      j.LP(HnQ[3].fLU());
    }
    if (HnQ[4].HnS >= 5L)
    {
      localj = j.Hhp;
      j.LQ(HnQ[4].fLU());
    }
    reset();
    AppMethodBeat.o(236252);
  }
  
  public static void reset()
  {
    a[] arrayOfa = HnQ;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.HnS = 0L;
      locala.HnT = 0L;
      i += 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "", "times", "", "sum", "(JJ)V", "getSum", "()J", "setSum", "(J)V", "getTimes", "setTimes", "append", "", "cost", "avg", "reset", "plugin-voip_release"})
  public static final class a
  {
    long HnS = 0L;
    long HnT = 0L;
    
    public final long fLU()
    {
      long l2 = this.HnT;
      if (this.HnS == 0L) {}
      for (long l1 = 1L;; l1 = this.HnS) {
        return l2 / l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.i
 * JD-Core Version:    0.7.0.1
 */