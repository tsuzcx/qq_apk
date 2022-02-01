package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
public final class bd
  implements be
{
  final bs Ken;
  
  public bd(bs parambs)
  {
    AppMethodBeat.i(118136);
    this.Ken = parambs;
    AppMethodBeat.o(118136);
  }
  
  public final bs fLh()
  {
    return this.Ken;
  }
  
  public final boolean isActive()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118135);
    if (ah.getDEBUG())
    {
      str = this.Ken.getString("New");
      AppMethodBeat.o(118135);
      return str;
    }
    String str = super.toString();
    AppMethodBeat.o(118135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */