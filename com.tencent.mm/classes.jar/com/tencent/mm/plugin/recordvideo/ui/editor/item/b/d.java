package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "", "duration", "", "startBase", "", "(JZ)V", "end", "getEnd", "()J", "endPoint", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "getEndPoint", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "start", "getStart", "startPoint", "getStartPoint", "after", "", "target", "align", "alignStart", "alignEnd", "before", "finalize", "isIntersect", "tr", "pivotEnd", "pivotStart", "setDuration", "setEndOffset", "endOffset", "setOffset", "startOffset", "setStartOffset", "setTime", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class d
{
  public static final a Idq;
  public final c Ido;
  public final c Idp;
  
  static
  {
    AppMethodBeat.i(224421);
    Idq = new a((byte)0);
    AppMethodBeat.o(224421);
  }
  
  public d()
  {
    this(0L, false, 3);
  }
  
  private d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(224416);
    this.Ido = new c((byte)0);
    this.Idp = new c((byte)0);
    if (paramBoolean)
    {
      this.Idp.a(this.Ido);
      this.Idp.PF(paramLong);
      AppMethodBeat.o(224416);
      return;
    }
    this.Ido.a(this.Idp);
    this.Ido.PF(-paramLong);
    AppMethodBeat.o(224416);
  }
  
  public final void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(224407);
    c localc = this.Ido;
    localc.PF(localc.offset + (paramLong1 - this.Ido.getTime()));
    localc = this.Idp;
    localc.PF(localc.offset + (paramLong2 - this.Idp.getTime()));
    AppMethodBeat.o(224407);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(224409);
    this.Ido.a(null);
    this.Idp.a(null);
    AppMethodBeat.o(224409);
  }
  
  public final long getEnd()
  {
    AppMethodBeat.i(292863);
    long l = this.Idp.getTime();
    AppMethodBeat.o(292863);
    return l;
  }
  
  public final long getStart()
  {
    AppMethodBeat.i(292862);
    long l = this.Ido.getTime();
    AppMethodBeat.o(292862);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224410);
    String str = "start:" + getStart() + "  end:" + getEnd();
    AppMethodBeat.o(224410);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange$Companion;", "", "()V", "chain", "", "ranges", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "chainWithOffset", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d
 * JD-Core Version:    0.7.0.1
 */