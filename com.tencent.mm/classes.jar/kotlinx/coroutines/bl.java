package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
public final class bl
  implements bm
{
  final ca OfP;
  
  public bl(ca paramca)
  {
    AppMethodBeat.i(118136);
    this.OfP = paramca;
    AppMethodBeat.o(118136);
  }
  
  public final ca gzS()
  {
    return this.OfP;
  }
  
  public final boolean isActive()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118135);
    if (am.getDEBUG())
    {
      str = this.OfP.getString("New");
      AppMethodBeat.o(118135);
      return str;
    }
    String str = super.toString();
    AppMethodBeat.o(118135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bl
 * JD-Core Version:    0.7.0.1
 */