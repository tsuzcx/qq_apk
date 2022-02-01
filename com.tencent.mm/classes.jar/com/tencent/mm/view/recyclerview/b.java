package com.tencent.mm.view.recyclerview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "associatedObject", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)V", "adapterPosition", "", "getAdapterPosition", "()I", "setAdapterPosition", "(I)V", "getAssociatedObject", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "exposeTime", "getExposeTime", "setExposeTime", "startTime", "getStartTime", "setStartTime", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "component1", "copy", "(Lcom/tencent/mm/view/recyclerview/ConvertData;)Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<T extends a>
{
  public long HsA;
  public int afqR;
  public final T agNK;
  public long endTime;
  public long startTime;
  public View view;
  
  public b(T paramT)
  {
    AppMethodBeat.i(234946);
    this.agNK = paramT;
    this.startTime = -1L;
    this.endTime = -1L;
    this.HsA = -1L;
    this.afqR = -1;
    AppMethodBeat.o(234946);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234961);
    if (((paramObject instanceof b)) && ((this == paramObject) || (this.agNK.bZA() == ((b)paramObject).agNK.bZA())))
    {
      AppMethodBeat.o(234961);
      return true;
    }
    AppMethodBeat.o(234961);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(234953);
    int i = (int)this.agNK.bZA();
    AppMethodBeat.o(234953);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234968);
    String str = "\n" + s.X("adapterPosition = ", Integer.valueOf(this.afqR)) + "\n" + s.X("exposeTime = ", Long.valueOf(this.HsA)) + "\n" + s.X("startTime = ", Long.valueOf(this.startTime)) + "\n" + s.X("endTime = ", Long.valueOf(this.endTime)) + "\n";
    s.s(str, "StringBuilder().append(\"…)\n            .toString()");
    AppMethodBeat.o(234968);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */