package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.u;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.cg;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class v<T>
  extends kotlin.d.b.a.d
  implements h<T>
{
  public final h<T> ajzQ;
  public final f ajzR;
  public final int ajzS;
  private f ajzT;
  private kotlin.d.d<? super ah> completion;
  
  public v(h<? super T> paramh, f paramf)
  {
    super((kotlin.d.d)s.ajzL, (f)g.aiwf);
    AppMethodBeat.i(189227);
    this.ajzQ = paramh;
    this.ajzR = paramf;
    this.ajzS = ((Number)this.ajzR.fold(Integer.valueOf(0), (m)a.ajzU)).intValue();
    AppMethodBeat.o(189227);
  }
  
  public final Object a(T paramT, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189266);
    f localf1;
    try
    {
      localf1 = paramd.getContext();
      cg.g(localf1);
      f localf2 = this.ajzT;
      if (localf2 == localf1) {
        break label215;
      }
      if ((localf2 instanceof n))
      {
        paramd = (n)localf2;
        paramT = (Throwable)new IllegalStateException(kotlin.n.n.bJB("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + paramd.e + ", but then emission attempt of value '" + paramT + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
        AppMethodBeat.o(189266);
        throw paramT;
      }
    }
    finally
    {
      this.ajzT = ((f)new n(paramT));
      AppMethodBeat.o(189266);
    }
    if (((Number)localf1.fold(Integer.valueOf(0), (m)new x.a(this))).intValue() != this.ajzS)
    {
      paramT = (Throwable)new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.ajzR + ",\n\t\tbut emission happened in " + localf1 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
      AppMethodBeat.o(189266);
      throw paramT;
    }
    this.ajzT = localf1;
    label215:
    this.completion = paramd;
    paramT = w.kDM().invoke(this.ajzQ, paramT, this);
    if (paramT == a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    if (paramT == a.aiwj)
    {
      AppMethodBeat.o(189266);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(189266);
    return paramT;
  }
  
  public final e getCallerFrame()
  {
    kotlin.d.d locald = this.completion;
    if ((locald instanceof e)) {
      return (e)locald;
    }
    return null;
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(189245);
    Object localObject = this.completion;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((kotlin.d.d)localObject).getContext())
    {
      localObject = (f)g.aiwf;
      AppMethodBeat.o(189245);
      return localObject;
    }
    AppMethodBeat.o(189245);
    return localObject;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(189254);
    Object localObject = Result.exceptionOrNull-impl(paramObject);
    if (localObject != null) {
      this.ajzT = ((f)new n((Throwable)localObject));
    }
    localObject = this.completion;
    if (localObject != null) {
      ((kotlin.d.d)localObject).resumeWith(paramObject);
    }
    paramObject = a.aiwj;
    AppMethodBeat.o(189254);
    return paramObject;
  }
  
  public final void releaseIntercepted()
  {
    AppMethodBeat.i(189260);
    super.releaseIntercepted();
    AppMethodBeat.o(189260);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "count", "<anonymous parameter 1>", "Lkotlin/coroutines/CoroutineContext$Element;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Integer, f.b, Integer>
  {
    public static final a ajzU;
    
    static
    {
      AppMethodBeat.i(189167);
      ajzU = new a();
      AppMethodBeat.o(189167);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.v
 * JD-Core Version:    0.7.0.1
 */