package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.internal.v;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class s<E>
  extends a<E>
{
  public s(kotlin.g.a.b<? super E, ah> paramb)
  {
    super(null);
  }
  
  protected final void a(Object paramObject, n<?> paramn)
  {
    kotlin.g.a.b localb = null;
    AppMethodBeat.i(189309);
    Object localObject = localb;
    if (paramObject != null)
    {
      if ((paramObject instanceof ArrayList)) {
        break label90;
      }
      paramObject = (aa)paramObject;
      if (!(paramObject instanceof c.a)) {
        break label78;
      }
      paramn = this.ajxf;
      if (paramn != null) {
        break label62;
      }
      paramObject = null;
      localObject = paramObject;
    }
    label62:
    label78:
    label90:
    ArrayList localArrayList;
    int i;
    for (;;)
    {
      if (localObject != null)
      {
        AppMethodBeat.o(189309);
        throw ((Throwable)localObject);
        paramObject = v.a(paramn, ((c.a)paramObject).aqH, null);
        break;
        paramObject.d(paramn);
        localObject = localb;
        continue;
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
          AppMethodBeat.o(189309);
          throw paramObject;
        }
        localArrayList = (ArrayList)paramObject;
        i = localArrayList.size() - 1;
        localObject = localb;
        if (i >= 0) {
          paramObject = null;
        }
      }
    }
    for (;;)
    {
      int j = i - 1;
      localObject = (aa)localArrayList.get(i);
      if ((localObject instanceof c.a))
      {
        localb = this.ajxf;
        if (localb == null) {
          paramObject = null;
        }
      }
      for (;;)
      {
        if (j < 0)
        {
          localObject = paramObject;
          break;
          paramObject = v.a(localb, ((c.a)localObject).aqH, paramObject);
          continue;
          ((aa)localObject).d(paramn);
          continue;
          AppMethodBeat.o(189309);
          return;
        }
      }
      i = j;
    }
  }
  
  protected final Object iT(E paramE)
  {
    AppMethodBeat.i(189301);
    Object localObject;
    do
    {
      localObject = super.iT(paramE);
      if (localObject == b.ajxk)
      {
        paramE = b.ajxk;
        AppMethodBeat.o(189301);
        return paramE;
      }
      if (localObject != b.ajxl) {
        break;
      }
      localObject = iU(paramE);
      if (localObject == null)
      {
        paramE = b.ajxk;
        AppMethodBeat.o(189301);
        return paramE;
      }
    } while (!(localObject instanceof n));
    AppMethodBeat.o(189301);
    return localObject;
    if ((localObject instanceof n))
    {
      AppMethodBeat.o(189301);
      return localObject;
    }
    paramE = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Invalid offerInternal result ", localObject).toString());
    AppMethodBeat.o(189301);
    throw paramE;
  }
  
  protected final boolean kCR()
  {
    return true;
  }
  
  protected final boolean kCS()
  {
    return true;
  }
  
  protected final boolean kCZ()
  {
    return false;
  }
  
  protected final boolean kDa()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.s
 * JD-Core Version:    0.7.0.1
 */