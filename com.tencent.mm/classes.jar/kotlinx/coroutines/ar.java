package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
final class ar
  implements ay
{
  final boolean isActive;
  
  public ar(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final bk epJ()
  {
    return null;
  }
  
  public final boolean isActive()
  {
    return this.isActive;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118289);
    StringBuilder localStringBuilder = new StringBuilder("Empty{");
    if (this.isActive) {}
    for (String str = "Active";; str = "New")
    {
      str = str + '}';
      AppMethodBeat.o(118289);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.ar
 * JD-Core Version:    0.7.0.1
 */