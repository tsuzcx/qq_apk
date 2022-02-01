package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "", "defaultTime", "", "(J)V", "value", "", "dirty", "setDirty", "(Z)V", "offset", "getOffset", "()J", "setOffset", "refer", "Ljava/util/LinkedList;", "target", "getTarget", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "setTarget", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;)V", "<set-?>", "time", "getTime", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private c NZI;
  private final LinkedList<c> NZJ;
  private boolean dirty;
  public long offset;
  private long time;
  
  private c()
  {
    AppMethodBeat.i(280200);
    this.NZJ = new LinkedList();
    this.time = 0L;
    this.dirty = true;
    AppMethodBeat.o(280200);
  }
  
  private final void au(boolean paramBoolean)
  {
    AppMethodBeat.i(280221);
    if (this.dirty != paramBoolean)
    {
      this.dirty = paramBoolean;
      if (paramBoolean)
      {
        Iterator localIterator = ((Iterable)this.NZJ).iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).au(paramBoolean);
        }
      }
    }
    AppMethodBeat.o(280221);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(280231);
    if (!s.p(this.NZI, paramc))
    {
      c localc = this.NZI;
      if (localc != null) {
        localc.NZJ.remove(this);
      }
      this.NZI = paramc;
      paramc = this.NZI;
      if (paramc != null) {
        paramc.NZJ.add(this);
      }
      au(true);
    }
    AppMethodBeat.o(280231);
  }
  
  public final long getTime()
  {
    AppMethodBeat.i(280247);
    c localc;
    if (this.dirty)
    {
      localc = this.NZI;
      if (localc != null) {
        break label50;
      }
    }
    label50:
    for (long l = 0L;; l = localc.getTime())
    {
      this.time = (l + this.offset);
      au(false);
      l = this.time;
      AppMethodBeat.o(280247);
      return l;
    }
  }
  
  public final void tF(long paramLong)
  {
    AppMethodBeat.i(280240);
    if (this.offset != paramLong)
    {
      this.offset = paramLong;
      au(true);
    }
    AppMethodBeat.o(280240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c
 * JD-Core Version:    0.7.0.1
 */