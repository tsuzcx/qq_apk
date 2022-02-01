package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class bl
  implements bw
{
  final boolean isActive;
  
  public bl(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final boolean isActive()
  {
    return this.isActive;
  }
  
  public final cn kCj()
  {
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bl
 * JD-Core Version:    0.7.0.1
 */