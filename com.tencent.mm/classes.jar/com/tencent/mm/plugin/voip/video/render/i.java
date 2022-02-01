package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.f.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper;", "", "()V", "RGB2YUV_HW_ENCODE", "", "RGB2YUV_RENDER", "RGB2YUV_SOFT_ENCODE", "RGB2YUV_TEXTURE_2_BYTE_ARRAY", "RGB2YUV_TRANSFER", "TAG", "", "record", "", "Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "[Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "appendHw", "", "cost", "", "appendSoft", "appendTransfer", "report", "id", "reset", "Record", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i USW;
  private static final a[] USX;
  
  static
  {
    AppMethodBeat.i(293087);
    USW = new i();
    int i = 0;
    a[] arrayOfa = new a[5];
    while (i < 5)
    {
      arrayOfa[i] = new a();
      i += 1;
    }
    USX = arrayOfa;
    AppMethodBeat.o(293087);
  }
  
  public static void bj(int paramInt, long paramLong)
  {
    a locala = USX[paramInt];
    locala.USY += 1L;
    locala.USZ += paramLong;
  }
  
  public static void report()
  {
    AppMethodBeat.i(293081);
    j localj;
    if (USX[0].USY >= 5L)
    {
      localj = j.UMb;
      j.xs(USX[0].idr());
    }
    if (USX[1].USY >= 5L)
    {
      localj = j.UMb;
      j.xt(USX[1].idr());
    }
    if (USX[2].USY >= 5L)
    {
      localj = j.UMb;
      j.xu(USX[2].idr());
    }
    if (USX[3].USY >= 5L)
    {
      localj = j.UMb;
      j.xv(USX[3].idr());
    }
    if (USX[4].USY >= 5L)
    {
      localj = j.UMb;
      j.xw(USX[4].idr());
    }
    reset();
    AppMethodBeat.o(293081);
  }
  
  public static void reset()
  {
    a[] arrayOfa = USX;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.USY = 0L;
      locala.USZ = 0L;
      i += 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/ProfileHelper$Record;", "", "times", "", "sum", "(JJ)V", "getSum", "()J", "setSum", "(J)V", "getTimes", "setTimes", "append", "", "cost", "avg", "reset", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    long USY = 0L;
    long USZ = 0L;
    
    public final long idr()
    {
      long l2 = this.USZ;
      if (this.USY == 0L) {}
      for (long l1 = 1L;; l1 = this.USY) {
        return l2 / l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.i
 * JD-Core Version:    0.7.0.1
 */