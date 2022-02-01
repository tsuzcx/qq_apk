package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "e", "", "(Ljava/lang/Throwable;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements f.b
{
  public static final a ajzK;
  public final Throwable e;
  private final f.c<?> key;
  
  static
  {
    AppMethodBeat.i(189216);
    ajzK = new a((byte)0);
    AppMethodBeat.o(189216);
  }
  
  public n(Throwable paramThrowable)
  {
    AppMethodBeat.i(189205);
    this.e = paramThrowable;
    this.key = ((f.c)ajzK);
    AppMethodBeat.o(189205);
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(189239);
    paramR = f.b.a.a(this, paramR, paramm);
    AppMethodBeat.o(189239);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(189234);
    paramc = f.b.a.a(this, paramc);
    AppMethodBeat.o(189234);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    return this.key;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(189242);
    paramc = f.b.a.b(this, paramc);
    AppMethodBeat.o(189242);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(189250);
    paramf = f.b.a.a((f.b)this, paramf);
    AppMethodBeat.o(189250);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.c<n>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.n
 * JD-Core Version:    0.7.0.1
 */