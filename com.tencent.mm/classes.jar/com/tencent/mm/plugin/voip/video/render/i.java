package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.b.k;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper;", "", "()V", "RGB2YUV_HW_ENCODE", "", "RGB2YUV_RENDER", "RGB2YUV_SOFT_ENCODE", "RGB2YUV_TEXTURE_2_BYTE_ARRAY", "RGB2YUV_TRANSFER", "TAG", "", "record", "", "Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "[Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "appendHw", "", "cost", "", "appendSoft", "appendTransfer", "report", "id", "reset", "Record", "plugin-voip_release"})
public final class i
{
  private static final a[] Csi;
  public static final i Csj;
  
  static
  {
    AppMethodBeat.i(216156);
    Csj = new i();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a();
      i += 1;
    }
    Csi = arrayOfa;
    AppMethodBeat.o(216156);
  }
  
  public static void aJ(int paramInt, long paramLong)
  {
    a locala = Csi[paramInt];
    locala.Csk += 1L;
    locala.Csl += paramLong;
  }
  
  public static void report()
  {
    AppMethodBeat.i(216155);
    if (!h.ezF())
    {
      reset();
      AppMethodBeat.o(216155);
      return;
    }
    k localk;
    if (Csi[0].Csk >= 5L)
    {
      localk = k.ClI;
      k.Cb(Csi[0].eBj());
    }
    if (Csi[1].Csk >= 5L)
    {
      localk = k.ClI;
      k.Cc(Csi[1].eBj());
    }
    if (Csi[2].Csk >= 5L)
    {
      localk = k.ClI;
      k.Cd(Csi[2].eBj());
    }
    if (Csi[3].Csk >= 5L)
    {
      localk = k.ClI;
      k.Ce(Csi[3].eBj());
    }
    if (Csi[4].Csk >= 5L)
    {
      localk = k.ClI;
      k.Cf(Csi[4].eBj());
    }
    reset();
    AppMethodBeat.o(216155);
  }
  
  public static void reset()
  {
    a[] arrayOfa = Csi;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.Csk = 0L;
      locala.Csl = 0L;
      i += 1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "", "times", "", "sum", "(JJ)V", "getSum", "()J", "setSum", "(J)V", "getTimes", "setTimes", "append", "", "cost", "avg", "reset", "plugin-voip_release"})
  public static final class a
  {
    long Csk = 0L;
    long Csl = 0L;
    
    public final long eBj()
    {
      long l2 = this.Csl;
      if (this.Csk == 0L) {}
      for (long l1 = 1L;; l1 = this.Csk) {
        return l2 / l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.i
 * JD-Core Version:    0.7.0.1
 */