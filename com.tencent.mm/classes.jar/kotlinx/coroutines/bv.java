package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class bv
  implements bw
{
  final cn ajwp;
  
  public bv(cn paramcn)
  {
    AppMethodBeat.i(118136);
    this.ajwp = paramcn;
    AppMethodBeat.o(118136);
  }
  
  public final boolean isActive()
  {
    return false;
  }
  
  public final cn kCj()
  {
    return this.ajwp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118135);
    if (au.DEBUG)
    {
      str = this.ajwp.getString("New");
      AppMethodBeat.o(118135);
      return str;
    }
    String str = super.toString();
    AppMethodBeat.o(118135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bv
 * JD-Core Version:    0.7.0.1
 */