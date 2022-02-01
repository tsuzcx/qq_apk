package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.b.a.r;
import kotlinx.coroutines.b.a.r.a;
import kotlinx.coroutines.b.a.t;

@Metadata(d1={"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k=4, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final Object a(g<?> paramg, d<? super ah> paramd)
  {
    AppMethodBeat.i(189109);
    paramd = paramg.a((h)t.ajzM, paramd);
    paramg = paramd;
    if (paramd != a.aiwj) {
      paramg = ah.aiuX;
    }
    AppMethodBeat.o(189109);
    return paramg;
  }
  
  public static final <T> Object a(h<? super T> paramh, x<? extends T> paramx, d<? super ah> paramd)
  {
    AppMethodBeat.i(189097);
    paramx = k.a(paramh, paramx, true, paramd);
    paramh = paramx;
    if (paramx != a.aiwj) {
      paramh = ah.aiuX;
    }
    AppMethodBeat.o(189097);
    return paramh;
  }
  
  public static final <T> g<T> a(g<? extends T> paramg, int paramInt, kotlinx.coroutines.a.g paramg1)
  {
    int j = 0;
    AppMethodBeat.i(189119);
    if ((paramInt >= 0) || (paramInt == -2) || (paramInt == -1)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalArgumentException(s.X("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(paramInt)).toString());
      AppMethodBeat.o(189119);
      throw paramg;
    }
    if ((paramInt != -1) || (paramg1 == kotlinx.coroutines.a.g.ajxx)) {}
    for (i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
      AppMethodBeat.o(189119);
      throw paramg;
    }
    if (paramInt == -1)
    {
      paramg1 = kotlinx.coroutines.a.g.ajxy;
      paramInt = j;
    }
    for (;;)
    {
      if ((paramg instanceof r))
      {
        paramg = r.a.a((r)paramg, null, paramInt, paramg1, 1);
        AppMethodBeat.o(189119);
        return paramg;
      }
      paramg = (g)new kotlinx.coroutines.b.a.i(paramg, null, paramInt, paramg1, 2);
      AppMethodBeat.o(189119);
      return paramg;
    }
  }
  
  public static final void a(h<?> paramh)
  {
    if ((paramh instanceof ak)) {
      throw ((ak)paramh).e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.i
 * JD-Core Version:    0.7.0.1
 */