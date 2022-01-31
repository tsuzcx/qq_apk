package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
public final class ax
  implements ay
{
  final bk CIg;
  
  public ax(bk parambk)
  {
    AppMethodBeat.i(118453);
    this.CIg = parambk;
    AppMethodBeat.o(118453);
  }
  
  public final bk epJ()
  {
    return this.CIg;
  }
  
  public final boolean isActive()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118452);
    String str = this.CIg.getString("New");
    AppMethodBeat.o(118452);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.ax
 * JD-Core Version:    0.7.0.1
 */