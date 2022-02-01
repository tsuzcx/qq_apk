package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "associatedObject", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)V", "adapterPosition", "", "getAdapterPosition", "()I", "setAdapterPosition", "(I)V", "getAssociatedObject", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "exposeTime", "getExposeTime", "setExposeTime", "startTime", "getStartTime", "setStartTime", "component1", "copy", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class b<T extends a>
{
  public long BHT;
  public int XDo;
  public final T YRY;
  public long endTime;
  public long startTime;
  
  public b(T paramT)
  {
    AppMethodBeat.i(203394);
    this.YRY = paramT;
    this.startTime = -1L;
    this.endTime = -1L;
    this.BHT = -1L;
    this.XDo = -1;
    AppMethodBeat.o(203394);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203388);
    if (((paramObject instanceof b)) && (((b)this == paramObject) || (this.YRY.mf() == ((b)paramObject).YRY.mf())))
    {
      AppMethodBeat.o(203388);
      return true;
    }
    AppMethodBeat.o(203388);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203387);
    int i = (int)this.YRY.mf();
    AppMethodBeat.o(203387);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203392);
    String str = "\n" + new StringBuilder("adapterPosition = ").append(this.XDo).toString() + "\n" + new StringBuilder("exposeTime = ").append(this.BHT).toString() + "\n" + new StringBuilder("startTime = ").append(this.startTime).toString() + "\n" + new StringBuilder("endTime = ").append(this.endTime).toString() + "\n";
    p.j(str, "StringBuilder().append(\"…)\n            .toString()");
    AppMethodBeat.o(203392);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */