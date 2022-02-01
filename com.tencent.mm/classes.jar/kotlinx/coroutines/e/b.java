package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/Empty;", "", "locked", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class b
{
  public final Object ajBT;
  
  public b(Object paramObject)
  {
    this.ajBT = paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188953);
    String str = "Empty[" + this.ajBT + ']';
    AppMethodBeat.o(188953);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.e.b
 * JD-Core Version:    0.7.0.1
 */