package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "", "tag", "", "(Ljava/lang/String;)V", "averageTime", "Lkotlin/Function0;", "", "getAverageTime", "()Lkotlin/jvm/functions/Function0;", "setAverageTime", "(Lkotlin/jvm/functions/Function0;)V", "getTag", "()Ljava/lang/String;", "thisStartTime", "<set-?>", "totalCount", "getTotalCount", "()J", "totalTime", "getTotalTime", "averageRenderCostLog", "end", "", "start", "video_composition_release"})
public final class d
{
  public a<Long> RhY;
  long RhZ;
  public long dtZ;
  public long tTn;
  final String tag;
  
  public d(String paramString)
  {
    AppMethodBeat.i(216847);
    this.tag = paramString;
    this.RhY = ((a)new a(this));
    AppMethodBeat.o(216847);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.d
 * JD-Core Version:    0.7.0.1
 */