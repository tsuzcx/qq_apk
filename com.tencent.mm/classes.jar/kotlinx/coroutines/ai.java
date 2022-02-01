package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"})
public final class ai
  extends a
  implements cu<String>
{
  public static final a abwy;
  final long id;
  
  static
  {
    AppMethodBeat.i(118241);
    abwy = new a((byte)0);
    AppMethodBeat.o(118241);
  }
  
  public ai(long paramLong)
  {
    super((f.c)abwy);
    AppMethodBeat.i(118240);
    this.id = paramLong;
    AppMethodBeat.o(118240);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ai))
      {
        paramObject = (ai)paramObject;
        if (this.id != paramObject.id) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118242);
    paramR = f.b.a.a((f.b)this, paramR, paramm);
    AppMethodBeat.o(118242);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(118243);
    paramc = f.b.a.a((f.b)this, paramc);
    AppMethodBeat.o(118243);
    return paramc;
  }
  
  public final int hashCode()
  {
    long l = this.id;
    return (int)(l ^ l >>> 32);
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(118244);
    paramc = f.b.a.b((f.b)this, paramc);
    AppMethodBeat.o(118244);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(118245);
    paramf = f.b.a.a((f.b)this, paramf);
    AppMethodBeat.o(118245);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118237);
    String str = "CoroutineId(" + this.id + ')';
    AppMethodBeat.o(118237);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    implements f.c<ai>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ai
 * JD-Core Version:    0.7.0.1
 */