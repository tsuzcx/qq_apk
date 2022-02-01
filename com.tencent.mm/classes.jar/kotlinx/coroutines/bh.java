package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
final class bh
  implements bt
{
  final boolean isActive;
  
  public bh(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final cj iRt()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return this.isActive;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117965);
    StringBuilder localStringBuilder = new StringBuilder("Empty{");
    if (this.isActive) {}
    for (String str = "Active";; str = "New")
    {
      str = str + '}';
      AppMethodBeat.o(117965);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.bh
 * JD-Core Version:    0.7.0.1
 */