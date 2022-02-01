package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "", "defaultTime", "", "(J)V", "value", "", "dirty", "setDirty", "(Z)V", "offset", "getOffset", "()J", "setOffset", "refer", "Ljava/util/LinkedList;", "target", "getTarget", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "setTarget", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;)V", "<set-?>", "time", "getTime", "plugin-recordvideo_release"})
public final class c
{
  private boolean dirty;
  public long offset;
  private long time;
  private c xPD;
  private final LinkedList<c> xPE;
  
  private c()
  {
    AppMethodBeat.i(200786);
    this.xPE = new LinkedList();
    this.time = 0L;
    this.dirty = true;
    AppMethodBeat.o(200786);
  }
  
  private final void qg(boolean paramBoolean)
  {
    AppMethodBeat.i(200785);
    if (this.dirty != paramBoolean)
    {
      this.dirty = paramBoolean;
      if (paramBoolean)
      {
        Iterator localIterator = ((Iterable)this.xPE).iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).qg(paramBoolean);
        }
      }
    }
    AppMethodBeat.o(200785);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(200782);
    if ((p.i(this.xPD, paramc) ^ true))
    {
      Object localObject = this.xPD;
      if (localObject != null)
      {
        localObject = ((c)localObject).xPE;
        if (localObject != null) {
          ((LinkedList)localObject).remove(this);
        }
      }
      this.xPD = paramc;
      paramc = this.xPD;
      if (paramc != null)
      {
        paramc = paramc.xPE;
        if (paramc != null) {
          paramc.add(this);
        }
      }
      qg(true);
    }
    AppMethodBeat.o(200782);
  }
  
  public final long getTime()
  {
    AppMethodBeat.i(200784);
    c localc;
    if (this.dirty)
    {
      localc = this.xPD;
      if (localc == null) {
        break label53;
      }
    }
    label53:
    for (long l = localc.getTime();; l = 0L)
    {
      this.time = (l + this.offset);
      qg(false);
      l = this.time;
      AppMethodBeat.o(200784);
      return l;
    }
  }
  
  public final void yP(long paramLong)
  {
    AppMethodBeat.i(200783);
    if (this.offset != paramLong)
    {
      this.offset = paramLong;
      qg(true);
    }
    AppMethodBeat.o(200783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c
 * JD-Core Version:    0.7.0.1
 */