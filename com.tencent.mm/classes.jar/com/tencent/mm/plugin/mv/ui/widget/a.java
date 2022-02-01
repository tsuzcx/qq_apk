package com.tencent.mm.plugin.mv.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "", "()V", "<set-?>", "", "pixelPerMilli", "getPixelPerMilli", "()F", "", "spanIndex", "getSpanIndex", "()I", "", "spanTime", "getSpanTime", "()J", "onScale", "factor", "reset", "", "inputDuration", "Companion", "plugin-mv_release"})
public final class a
{
  static final List<Long> Gqq;
  static final int Gqr;
  static final int Gqs;
  public static final a Gqt;
  public int Gqn;
  public long Gqo;
  public float Gqp;
  
  static
  {
    AppMethodBeat.i(237758);
    Gqt = new a((byte)0);
    Gqq = j.listOf(new Long[] { Long.valueOf(1000L), Long.valueOf(2000L), Long.valueOf(3000L), Long.valueOf(5000L), Long.valueOf(10000L), Long.valueOf(15000L), Long.valueOf(30000L) });
    Gqr = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    Gqs = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 80);
    AppMethodBeat.o(237758);
  }
  
  public a()
  {
    AppMethodBeat.i(237757);
    this.Gqn = 2;
    this.Gqo = a.ZU(this.Gqn);
    this.Gqp = 1.0F;
    AppMethodBeat.o(237757);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper$Companion;", "", "()V", "spanMaxSize", "", "getSpanMaxSize", "()I", "spanMinSize", "getSpanMinSize", "timeSpanList", "", "", "getTimeSpanList", "()Ljava/util/List;", "getDefaultPixelPerMilli", "", "duration", "getDefaultSpan", "getSpanTime", "index", "plugin-mv_release"})
  public static final class a
  {
    public static long ZU(int paramInt)
    {
      AppMethodBeat.i(227512);
      long l = ((Number)a.fif().get(paramInt)).longValue();
      AppMethodBeat.o(227512);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */