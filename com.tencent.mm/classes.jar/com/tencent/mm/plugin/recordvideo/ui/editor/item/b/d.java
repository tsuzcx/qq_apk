package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "", "duration", "", "startBase", "", "(JZ)V", "end", "getEnd", "()J", "endPoint", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "getEndPoint", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "start", "getStart", "startPoint", "getStartPoint", "after", "", "target", "align", "alignStart", "alignEnd", "before", "finalize", "isIntersect", "tr", "pivotEnd", "pivotStart", "setDuration", "setEndOffset", "endOffset", "setOffset", "startOffset", "setStartOffset", "setTime", "toString", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a NZK;
  public final c NZL;
  public final c NZM;
  
  static
  {
    AppMethodBeat.i(280239);
    NZK = new d.a((byte)0);
    AppMethodBeat.o(280239);
  }
  
  public d()
  {
    this(0L, false, 3);
  }
  
  private d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(280204);
    this.NZL = new c((byte)0);
    this.NZM = new c((byte)0);
    if (paramBoolean)
    {
      this.NZM.a(this.NZL);
      this.NZM.tF(paramLong);
      AppMethodBeat.o(280204);
      return;
    }
    this.NZL.a(this.NZM);
    this.NZL.tF(-paramLong);
    AppMethodBeat.o(280204);
  }
  
  public final void bb(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(280278);
    c localc = this.NZL;
    localc.tF(localc.offset + (paramLong1 - this.NZL.getTime()));
    localc = this.NZM;
    localc.tF(localc.offset + (paramLong2 - this.NZM.getTime()));
    AppMethodBeat.o(280278);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(280283);
    this.NZL.a(null);
    this.NZM.a(null);
    AppMethodBeat.o(280283);
  }
  
  public final long getEnd()
  {
    AppMethodBeat.i(369759);
    long l = this.NZM.getTime();
    AppMethodBeat.o(369759);
    return l;
  }
  
  public final long getStart()
  {
    AppMethodBeat.i(369758);
    long l = this.NZL.getTime();
    AppMethodBeat.o(369758);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280288);
    String str = "start:" + getStart() + "  end:" + getEnd();
    AppMethodBeat.o(280288);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d
 * JD-Core Version:    0.7.0.1
 */