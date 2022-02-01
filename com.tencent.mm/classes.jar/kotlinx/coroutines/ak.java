package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlinx.coroutines.d.b;
import kotlinx.coroutines.internal.ae;

@Metadata(d1={""}, d2={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withContinuationContext", "T", "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ak
{
  private static final boolean ajvD;
  
  static
  {
    AppMethodBeat.i(118187);
    Object localObject = ae.bJL("kotlinx.coroutines.scheduler");
    if (localObject != null) {
      switch (((String)localObject).hashCode())
      {
      default: 
      case 0: 
        do
        {
          localObject = (Throwable)new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + localObject + '\'').toString());
          AppMethodBeat.o(118187);
          throw ((Throwable)localObject);
        } while (!((String)localObject).equals(""));
      }
    }
    for (;;)
    {
      for (boolean bool = true;; bool = false)
      {
        ajvD = bool;
        AppMethodBeat.o(118187);
        return;
        if (!((String)localObject).equals("off")) {
          break;
        }
      }
      if (!((String)localObject).equals("on")) {
        break;
      }
    }
  }
  
  public static final f a(aq paramaq, f paramf)
  {
    AppMethodBeat.i(118185);
    paramf = paramaq.getCoroutineContext().plus(paramf);
    if (au.DEBUG) {}
    for (paramaq = paramf.plus((f)new ao(au.ajvQ.incrementAndGet())); (paramf != bg.kCg()) && (paramf.get((f.c)kotlin.d.e.aiwc) == null); paramaq = paramf)
    {
      paramaq = paramaq.plus((f)bg.kCg());
      AppMethodBeat.o(118185);
      return paramaq;
    }
    AppMethodBeat.o(118185);
    return paramaq;
  }
  
  public static final de<?> a(d<?> paramd, f paramf, Object paramObject)
  {
    AppMethodBeat.i(188890);
    if (!(paramd instanceof kotlin.d.b.a.e))
    {
      AppMethodBeat.o(188890);
      return null;
    }
    if (paramf.get((f.c)df.ajwT) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(188890);
      return null;
    }
    paramd = (kotlin.d.b.a.e)paramd;
    for (;;)
    {
      if ((paramd instanceof bc)) {
        paramd = null;
      }
      for (;;)
      {
        if (paramd != null)
        {
          paramd.ajwR = paramf;
          paramd.ajwS = paramObject;
        }
        AppMethodBeat.o(188890);
        return paramd;
        paramd = paramd.getCallerFrame();
        if (paramd == null)
        {
          paramd = null;
        }
        else
        {
          if (!(paramd instanceof de)) {
            break;
          }
          paramd = (de)paramd;
        }
      }
    }
  }
  
  public static final String b(f paramf)
  {
    AppMethodBeat.i(118186);
    if (!au.DEBUG)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    ao localao = (ao)paramf.get((f.c)ao.ajvI);
    if (localao == null)
    {
      AppMethodBeat.o(118186);
      return null;
    }
    if ((ap)paramf.get((f.c)ap.ajvJ) == null)
    {
      paramf = "coroutine" + '#' + localao.id;
      AppMethodBeat.o(118186);
      return paramf;
    }
    AppMethodBeat.o(118186);
    throw null;
  }
  
  public static final al kBX()
  {
    if (ajvD) {
      return (al)b.ajBA;
    }
    return (al)y.ajvv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ak
 * JD-Core Version:    0.7.0.1
 */