package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "", "defaultTime", "", "(J)V", "value", "", "dirty", "setDirty", "(Z)V", "offset", "getOffset", "()J", "setOffset", "refer", "Ljava/util/LinkedList;", "target", "getTarget", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "setTarget", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;)V", "<set-?>", "time", "getTime", "plugin-recordvideo_release"})
public final class c
{
  private c Idm;
  private final LinkedList<c> Idn;
  private boolean dirty;
  public long offset;
  private long time;
  
  private c()
  {
    AppMethodBeat.i(217122);
    this.Idn = new LinkedList();
    this.time = 0L;
    this.dirty = true;
    AppMethodBeat.o(217122);
  }
  
  private final void xa(boolean paramBoolean)
  {
    AppMethodBeat.i(217120);
    if (this.dirty != paramBoolean)
    {
      this.dirty = paramBoolean;
      if (paramBoolean)
      {
        Iterator localIterator = ((Iterable)this.Idn).iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).xa(paramBoolean);
        }
      }
    }
    AppMethodBeat.o(217120);
  }
  
  public final void PF(long paramLong)
  {
    AppMethodBeat.i(217117);
    if (this.offset != paramLong)
    {
      this.offset = paramLong;
      xa(true);
    }
    AppMethodBeat.o(217117);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(217116);
    if ((p.h(this.Idm, paramc) ^ true))
    {
      Object localObject = this.Idm;
      if (localObject != null)
      {
        localObject = ((c)localObject).Idn;
        if (localObject != null) {
          ((LinkedList)localObject).remove(this);
        }
      }
      this.Idm = paramc;
      paramc = this.Idm;
      if (paramc != null)
      {
        paramc = paramc.Idn;
        if (paramc != null) {
          paramc.add(this);
        }
      }
      xa(true);
    }
    AppMethodBeat.o(217116);
  }
  
  public final long getTime()
  {
    AppMethodBeat.i(217119);
    c localc;
    if (this.dirty)
    {
      localc = this.Idm;
      if (localc == null) {
        break label53;
      }
    }
    label53:
    for (long l = localc.getTime();; l = 0L)
    {
      this.time = (l + this.offset);
      xa(false);
      l = this.time;
      AppMethodBeat.o(217119);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c
 * JD-Core Version:    0.7.0.1
 */