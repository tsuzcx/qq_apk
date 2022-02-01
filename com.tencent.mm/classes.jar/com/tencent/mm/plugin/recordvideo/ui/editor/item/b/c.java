package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "", "defaultTime", "", "(J)V", "value", "", "dirty", "setDirty", "(Z)V", "offset", "getOffset", "()J", "setOffset", "refer", "Ljava/util/LinkedList;", "target", "getTarget", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "setTarget", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;)V", "<set-?>", "time", "getTime", "plugin-recordvideo_release"})
public final class c
{
  private boolean dirty;
  public long offset;
  private long time;
  private c yfw;
  private final LinkedList<c> yfx;
  
  private c()
  {
    AppMethodBeat.i(207044);
    this.yfx = new LinkedList();
    this.time = 0L;
    this.dirty = true;
    AppMethodBeat.o(207044);
  }
  
  private final void qn(boolean paramBoolean)
  {
    AppMethodBeat.i(207043);
    if (this.dirty != paramBoolean)
    {
      this.dirty = paramBoolean;
      if (paramBoolean)
      {
        Iterator localIterator = ((Iterable)this.yfx).iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).qn(paramBoolean);
        }
      }
    }
    AppMethodBeat.o(207043);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(207040);
    if ((p.i(this.yfw, paramc) ^ true))
    {
      Object localObject = this.yfw;
      if (localObject != null)
      {
        localObject = ((c)localObject).yfx;
        if (localObject != null) {
          ((LinkedList)localObject).remove(this);
        }
      }
      this.yfw = paramc;
      paramc = this.yfw;
      if (paramc != null)
      {
        paramc = paramc.yfx;
        if (paramc != null) {
          paramc.add(this);
        }
      }
      qn(true);
    }
    AppMethodBeat.o(207040);
  }
  
  public final long getTime()
  {
    AppMethodBeat.i(207042);
    c localc;
    if (this.dirty)
    {
      localc = this.yfw;
      if (localc == null) {
        break label53;
      }
    }
    label53:
    for (long l = localc.getTime();; l = 0L)
    {
      this.time = (l + this.offset);
      qn(false);
      l = this.time;
      AppMethodBeat.o(207042);
      return l;
    }
  }
  
  public final void zn(long paramLong)
  {
    AppMethodBeat.i(207041);
    if (this.offset != paramLong)
    {
      this.offset = paramLong;
      qn(true);
    }
    AppMethodBeat.o(207041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c
 * JD-Core Version:    0.7.0.1
 */