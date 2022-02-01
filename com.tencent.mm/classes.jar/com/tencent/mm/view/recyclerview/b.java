package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "associatedObject", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)V", "adapterPosition", "", "getAdapterPosition", "()I", "setAdapterPosition", "(I)V", "getAssociatedObject", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "exposeTime", "getExposeTime", "setExposeTime", "startTime", "getStartTime", "setStartTime", "component1", "copy", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class b<T extends a>
{
  public int Qgj;
  public final T RqA;
  public long endTime;
  public long startTime;
  public long wVY;
  
  public b(T paramT)
  {
    AppMethodBeat.i(205033);
    this.RqA = paramT;
    this.startTime = -1L;
    this.endTime = -1L;
    this.wVY = -1L;
    this.Qgj = -1;
    AppMethodBeat.o(205033);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205031);
    if (((paramObject instanceof b)) && (((b)this == paramObject) || (this.RqA.lT() == ((b)paramObject).RqA.lT())))
    {
      AppMethodBeat.o(205031);
      return true;
    }
    AppMethodBeat.o(205031);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205030);
    int i = (int)this.RqA.lT();
    AppMethodBeat.o(205030);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205032);
    String str = "\n" + new StringBuilder("adapterPosition = ").append(this.Qgj).toString() + "\n" + new StringBuilder("exposeTime = ").append(this.wVY).toString() + "\n" + new StringBuilder("startTime = ").append(this.startTime).toString() + "\n" + new StringBuilder("endTime = ").append(this.endTime).toString() + "\n";
    p.g(str, "StringBuilder().append(\"…)\n            .toString()");
    AppMethodBeat.o(205032);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */