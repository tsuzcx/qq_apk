package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "", "duration", "", "startBase", "", "(JZ)V", "end", "getEnd", "()J", "endPoint", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "getEndPoint", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "start", "getStart", "startPoint", "getStartPoint", "after", "", "target", "align", "alignStart", "alignEnd", "before", "finalize", "isIntersect", "tr", "pivotEnd", "pivotStart", "setDuration", "setEndOffset", "endOffset", "setOffset", "startOffset", "setStartOffset", "setTime", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class d
{
  public static final d.a xPH;
  public final c xPF;
  public final c xPG;
  
  static
  {
    AppMethodBeat.i(200795);
    xPH = new d.a((byte)0);
    AppMethodBeat.o(200795);
  }
  
  public d()
  {
    this(0L, false, 3);
  }
  
  private d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(200793);
    this.xPF = new c((byte)0);
    this.xPG = new c((byte)0);
    if (paramBoolean)
    {
      this.xPG.a(this.xPF);
      this.xPG.yP(paramLong);
      AppMethodBeat.o(200793);
      return;
    }
    this.xPF.a(this.xPG);
    this.xPF.yP(-paramLong);
    AppMethodBeat.o(200793);
  }
  
  public final void af(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(200790);
    c localc = this.xPF;
    localc.yP(localc.offset + (paramLong1 - this.xPF.getTime()));
    localc = this.xPG;
    localc.yP(localc.offset + (paramLong2 - this.xPG.getTime()));
    AppMethodBeat.o(200790);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(200791);
    this.xPF.a(null);
    this.xPG.a(null);
    AppMethodBeat.o(200791);
  }
  
  public final long getEnd()
  {
    AppMethodBeat.i(221443);
    long l = this.xPG.getTime();
    AppMethodBeat.o(221443);
    return l;
  }
  
  public final long getStart()
  {
    AppMethodBeat.i(221442);
    long l = this.xPF.getTime();
    AppMethodBeat.o(221442);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200792);
    String str = "start:" + getStart() + "  end:" + getEnd();
    AppMethodBeat.o(200792);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d
 * JD-Core Version:    0.7.0.1
 */