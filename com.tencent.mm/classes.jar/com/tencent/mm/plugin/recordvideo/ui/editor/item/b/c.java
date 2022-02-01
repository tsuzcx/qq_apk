package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "", "defaultTime", "", "(J)V", "value", "", "dirty", "setDirty", "(Z)V", "offset", "getOffset", "()J", "setOffset", "refer", "Ljava/util/LinkedList;", "target", "getTarget", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "setTarget", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;)V", "<set-?>", "time", "getTime", "plugin-recordvideo_release"})
public final class c
{
  private c Cgv;
  private final LinkedList<c> Cgw;
  private boolean dirty;
  public long offset;
  private long time;
  
  private c()
  {
    AppMethodBeat.i(237885);
    this.Cgw = new LinkedList();
    this.time = 0L;
    this.dirty = true;
    AppMethodBeat.o(237885);
  }
  
  private final void tE(boolean paramBoolean)
  {
    AppMethodBeat.i(237884);
    if (this.dirty != paramBoolean)
    {
      this.dirty = paramBoolean;
      if (paramBoolean)
      {
        Iterator localIterator = ((Iterable)this.Cgw).iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).tE(paramBoolean);
        }
      }
    }
    AppMethodBeat.o(237884);
  }
  
  public final void Il(long paramLong)
  {
    AppMethodBeat.i(237882);
    if (this.offset != paramLong)
    {
      this.offset = paramLong;
      tE(true);
    }
    AppMethodBeat.o(237882);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(237881);
    if ((p.j(this.Cgv, paramc) ^ true))
    {
      Object localObject = this.Cgv;
      if (localObject != null)
      {
        localObject = ((c)localObject).Cgw;
        if (localObject != null) {
          ((LinkedList)localObject).remove(this);
        }
      }
      this.Cgv = paramc;
      paramc = this.Cgv;
      if (paramc != null)
      {
        paramc = paramc.Cgw;
        if (paramc != null) {
          paramc.add(this);
        }
      }
      tE(true);
    }
    AppMethodBeat.o(237881);
  }
  
  public final long getTime()
  {
    AppMethodBeat.i(237883);
    c localc;
    if (this.dirty)
    {
      localc = this.Cgv;
      if (localc == null) {
        break label53;
      }
    }
    label53:
    for (long l = localc.getTime();; l = 0L)
    {
      this.time = (l + this.offset);
      tE(false);
      l = this.time;
      AppMethodBeat.o(237883);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c
 * JD-Core Version:    0.7.0.1
 */