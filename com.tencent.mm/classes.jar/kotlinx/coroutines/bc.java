package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
final class bc
  implements bm
{
  final boolean isActive;
  
  public bc(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final ca gvq()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bc
 * JD-Core Version:    0.7.0.1
 */