package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "()V", "key", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class df
  implements f.b, f.c<df>
{
  public static final df ajwT;
  
  static
  {
    AppMethodBeat.i(188967);
    ajwT = new df();
    AppMethodBeat.o(188967);
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(188987);
    paramR = f.b.a.a(this, paramR, paramm);
    AppMethodBeat.o(188987);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(188981);
    paramc = f.b.a.a(this, paramc);
    AppMethodBeat.o(188981);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    return (f.c)this;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(188992);
    paramc = f.b.a.b(this, paramc);
    AppMethodBeat.o(188992);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(188998);
    paramf = f.b.a.a((f.b)this, paramf);
    AppMethodBeat.o(188998);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.df
 * JD-Core Version:    0.7.0.1
 */