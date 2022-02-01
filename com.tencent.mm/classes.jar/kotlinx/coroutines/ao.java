package kotlinx.coroutines;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.a;
import kotlin.d.f.c;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends a
  implements cy<String>
{
  public static final a ajvI;
  final long id;
  
  static
  {
    AppMethodBeat.i(118241);
    ajvI = new a((byte)0);
    AppMethodBeat.o(118241);
  }
  
  public ao(long paramLong)
  {
    super((f.c)ajvI);
    AppMethodBeat.i(118240);
    this.id = paramLong;
    AppMethodBeat.o(118240);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ao)) {
        return false;
      }
      paramObject = (ao)paramObject;
    } while (this.id == paramObject.id);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188861);
    int i = q.a..ExternalSyntheticBackport0.m(this.id);
    AppMethodBeat.o(188861);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118237);
    String str = "CoroutineId(" + this.id + ')';
    AppMethodBeat.o(118237);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.c<ao>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ao
 * JD-Core Version:    0.7.0.1
 */