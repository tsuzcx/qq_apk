package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class p<E>
  extends a<E>
{
  protected final Object go(E paramE)
  {
    AppMethodBeat.i(204506);
    Object localObject;
    do
    {
      localObject = super.go(paramE);
      if (localObject == b.abyd)
      {
        paramE = b.abyd;
        AppMethodBeat.o(204506);
        return paramE;
      }
      if (localObject != b.abye) {
        break;
      }
      localObject = gp(paramE);
      if (localObject == null)
      {
        paramE = b.abyd;
        AppMethodBeat.o(204506);
        return paramE;
      }
    } while (!(localObject instanceof k));
    AppMethodBeat.o(204506);
    return localObject;
    if ((localObject instanceof k))
    {
      AppMethodBeat.o(204506);
      return localObject;
    }
    paramE = (Throwable)new IllegalStateException("Invalid offerInternal result ".concat(String.valueOf(localObject)).toString());
    AppMethodBeat.o(204506);
    throw paramE;
  }
  
  protected final boolean iSb()
  {
    return true;
  }
  
  protected final boolean iSc()
  {
    return true;
  }
  
  protected final boolean iSh()
  {
    return false;
  }
  
  protected final boolean iSi()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.p
 * JD-Core Version:    0.7.0.1
 */