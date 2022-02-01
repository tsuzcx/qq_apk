package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "", "duration", "", "startBase", "", "(JZ)V", "end", "getEnd", "()J", "endPoint", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "getEndPoint", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "start", "getStart", "startPoint", "getStartPoint", "after", "", "target", "align", "alignStart", "alignEnd", "before", "finalize", "isIntersect", "tr", "pivotEnd", "pivotStart", "setDuration", "setEndOffset", "endOffset", "setOffset", "startOffset", "setStartOffset", "setTime", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class d
{
  public static final d.a yfA;
  public final c yfy;
  public final c yfz;
  
  static
  {
    AppMethodBeat.i(207053);
    yfA = new d.a((byte)0);
    AppMethodBeat.o(207053);
  }
  
  public d()
  {
    this(0L, false, 3);
  }
  
  private d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(207051);
    this.yfy = new c((byte)0);
    this.yfz = new c((byte)0);
    if (paramBoolean)
    {
      this.yfz.a(this.yfy);
      this.yfz.zn(paramLong);
      AppMethodBeat.o(207051);
      return;
    }
    this.yfy.a(this.yfz);
    this.yfy.zn(-paramLong);
    AppMethodBeat.o(207051);
  }
  
  public final void ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(207048);
    c localc = this.yfy;
    localc.zn(localc.offset + (paramLong1 - this.yfy.getTime()));
    localc = this.yfz;
    localc.zn(localc.offset + (paramLong2 - this.yfz.getTime()));
    AppMethodBeat.o(207048);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(207049);
    this.yfy.a(null);
    this.yfz.a(null);
    AppMethodBeat.o(207049);
  }
  
  public final long getEnd()
  {
    AppMethodBeat.i(224255);
    long l = this.yfz.getTime();
    AppMethodBeat.o(224255);
    return l;
  }
  
  public final long getStart()
  {
    AppMethodBeat.i(224254);
    long l = this.yfy.getTime();
    AppMethodBeat.o(224254);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207050);
    String str = "start:" + getStart() + "  end:" + getEnd();
    AppMethodBeat.o(207050);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d
 * JD-Core Version:    0.7.0.1
 */