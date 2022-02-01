package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
public final class bi
  implements bj
{
  final bx LRN;
  
  public bi(bx parambx)
  {
    AppMethodBeat.i(118136);
    this.LRN = parambx;
    AppMethodBeat.o(118136);
  }
  
  public final bx gdQ()
  {
    return this.LRN;
  }
  
  public final boolean isActive()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118135);
    if (al.getDEBUG())
    {
      str = this.LRN.getString("New");
      AppMethodBeat.o(118135);
      return str;
    }
    String str = super.toString();
    AppMethodBeat.o(118135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bi
 * JD-Core Version:    0.7.0.1
 */