package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.b.k;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper;", "", "()V", "RGB2YUV_HW_ENCODE", "", "RGB2YUV_RENDER", "RGB2YUV_SOFT_ENCODE", "RGB2YUV_TEXTURE_2_BYTE_ARRAY", "RGB2YUV_TRANSFER", "TAG", "", "record", "", "Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "[Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "appendHw", "", "cost", "", "appendSoft", "appendTransfer", "report", "id", "reset", "Record", "plugin-voip_release"})
public final class i
{
  private static final a[] CJM;
  public static final i CJN;
  
  static
  {
    AppMethodBeat.i(210577);
    CJN = new i();
    a[] arrayOfa = new a[5];
    int i = 0;
    while (i < 5)
    {
      arrayOfa[i] = new a();
      i += 1;
    }
    CJM = arrayOfa;
    AppMethodBeat.o(210577);
  }
  
  public static void aJ(int paramInt, long paramLong)
  {
    a locala = CJM[paramInt];
    locala.CJO += 1L;
    locala.CJP += paramLong;
  }
  
  public static void report()
  {
    AppMethodBeat.i(210576);
    if (!h.eDn())
    {
      reset();
      AppMethodBeat.o(210576);
      return;
    }
    k localk;
    if (CJM[0].CJO >= 5L)
    {
      localk = k.CDm;
      k.Cz(CJM[0].eER());
    }
    if (CJM[1].CJO >= 5L)
    {
      localk = k.CDm;
      k.CA(CJM[1].eER());
    }
    if (CJM[2].CJO >= 5L)
    {
      localk = k.CDm;
      k.CB(CJM[2].eER());
    }
    if (CJM[3].CJO >= 5L)
    {
      localk = k.CDm;
      k.CC(CJM[3].eER());
    }
    if (CJM[4].CJO >= 5L)
    {
      localk = k.CDm;
      k.CD(CJM[4].eER());
    }
    reset();
    AppMethodBeat.o(210576);
  }
  
  public static void reset()
  {
    a[] arrayOfa = CJM;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.CJO = 0L;
      locala.CJP = 0L;
      i += 1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "", "times", "", "sum", "(JJ)V", "getSum", "()J", "setSum", "(J)V", "getTimes", "setTimes", "append", "", "cost", "avg", "reset", "plugin-voip_release"})
  public static final class a
  {
    long CJO = 0L;
    long CJP = 0L;
    
    public final long eER()
    {
      long l2 = this.CJP;
      if (this.CJO == 0L) {}
      for (long l1 = 1L;; l1 = this.CJO) {
        return l2 / l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.i
 * JD-Core Version:    0.7.0.1
 */