package com.tencent.mm.videocomposition.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "", "tag", "", "(Ljava/lang/String;)V", "averageTime", "Lkotlin/Function0;", "", "getAverageTime", "()Lkotlin/jvm/functions/Function0;", "setAverageTime", "(Lkotlin/jvm/functions/Function0;)V", "getTag", "()Ljava/lang/String;", "thisStartTime", "<set-?>", "totalCount", "getTotalCount", "()J", "totalTime", "getTotalTime", "averageRenderCostLog", "end", "", "start", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class d
{
  public long Bbb;
  public a<Long> agFy;
  long agFz;
  public long hqS;
  final String tag;
  
  public d(String paramString)
  {
    AppMethodBeat.i(233515);
    this.tag = paramString;
    this.agFy = ((a)new a(this));
    AppMethodBeat.o(233515);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class a
    extends u
    implements a<Long>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.d
 * JD-Core Version:    0.7.0.1
 */