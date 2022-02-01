package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "", "duration", "", "startBase", "", "(JZ)V", "end", "getEnd", "()J", "endPoint", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "getEndPoint", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "start", "getStart", "startPoint", "getStartPoint", "after", "", "target", "align", "alignStart", "alignEnd", "before", "finalize", "isIntersect", "tr", "pivotEnd", "pivotStart", "setDuration", "setEndOffset", "endOffset", "setOffset", "startOffset", "setStartOffset", "setTime", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class d
{
  public static final d.a Cgz;
  public final c Cgx;
  public final c Cgy;
  
  static
  {
    AppMethodBeat.i(237894);
    Cgz = new d.a((byte)0);
    AppMethodBeat.o(237894);
  }
  
  public d()
  {
    this(0L, false, 3);
  }
  
  private d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(237892);
    this.Cgx = new c((byte)0);
    this.Cgy = new c((byte)0);
    if (paramBoolean)
    {
      this.Cgy.a(this.Cgx);
      this.Cgy.Il(paramLong);
      AppMethodBeat.o(237892);
      return;
    }
    this.Cgx.a(this.Cgy);
    this.Cgx.Il(-paramLong);
    AppMethodBeat.o(237892);
  }
  
  public final void ai(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(237889);
    c localc = this.Cgx;
    localc.Il(localc.offset + (paramLong1 - this.Cgx.getTime()));
    localc = this.Cgy;
    localc.Il(localc.offset + (paramLong2 - this.Cgy.getTime()));
    AppMethodBeat.o(237889);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(237890);
    this.Cgx.a(null);
    this.Cgy.a(null);
    AppMethodBeat.o(237890);
  }
  
  public final long getEnd()
  {
    AppMethodBeat.i(258733);
    long l = this.Cgy.getTime();
    AppMethodBeat.o(258733);
    return l;
  }
  
  public final long getStart()
  {
    AppMethodBeat.i(258732);
    long l = this.Cgx.getTime();
    AppMethodBeat.o(258732);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237891);
    String str = "start:" + getStart() + "  end:" + getEnd();
    AppMethodBeat.o(237891);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d
 * JD-Core Version:    0.7.0.1
 */