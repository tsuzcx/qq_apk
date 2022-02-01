package com.tencent.mm.plugin.mv.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "", "()V", "<set-?>", "", "pixelPerMilli", "getPixelPerMilli", "()F", "", "spanIndex", "getSpanIndex", "()I", "", "spanTime", "getSpanTime", "()J", "onScale", "factor", "reset", "", "inputDuration", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Mkp;
  static final List<Long> Mkt;
  static final int Mku;
  static final int Mkv;
  int Mkq;
  long Mkr;
  float Mks;
  
  static
  {
    AppMethodBeat.i(286673);
    Mkp = new a((byte)0);
    Mkt = p.listOf(new Long[] { Long.valueOf(1000L), Long.valueOf(2000L), Long.valueOf(3000L), Long.valueOf(5000L), Long.valueOf(10000L), Long.valueOf(15000L), Long.valueOf(30000L) });
    Mku = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    Mkv = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 80);
    AppMethodBeat.o(286673);
  }
  
  public a()
  {
    AppMethodBeat.i(286657);
    this.Mkq = 2;
    this.Mkr = a.aen(this.Mkq);
    this.Mks = 1.0F;
    AppMethodBeat.o(286657);
  }
  
  public final void reset(long paramLong)
  {
    AppMethodBeat.i(286680);
    this.Mkq = a.sO(paramLong);
    this.Mkr = a.aen(this.Mkq);
    this.Mks = a.sP(paramLong);
    AppMethodBeat.o(286680);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper$Companion;", "", "()V", "spanMaxSize", "", "getSpanMaxSize", "()I", "spanMinSize", "getSpanMinSize", "timeSpanList", "", "", "getTimeSpanList", "()Ljava/util/List;", "getDefaultPixelPerMilli", "", "duration", "getDefaultSpan", "getSpanTime", "index", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long aen(int paramInt)
    {
      AppMethodBeat.i(286653);
      long l = ((Number)a.gsg().get(paramInt)).longValue();
      AppMethodBeat.o(286653);
      return l;
    }
    
    public static int sO(long paramLong)
    {
      if (paramLong < 120000L) {
        return 2;
      }
      return 3;
    }
    
    public static float sP(long paramLong)
    {
      AppMethodBeat.i(286660);
      int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      if (paramLong < 120000L)
      {
        f = i * 2.0F / 1000.0F;
        AppMethodBeat.o(286660);
        return f;
      }
      if (paramLong < 240000L)
      {
        f = i * 1.5F / 1000.0F;
        AppMethodBeat.o(286660);
        return f;
      }
      float f = i * 1.0F / 1000.0F;
      AppMethodBeat.o(286660);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */