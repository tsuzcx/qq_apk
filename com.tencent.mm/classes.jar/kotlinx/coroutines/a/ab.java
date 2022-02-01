package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ab<E>
{
  public abstract boolean Ij();
  
  public abstract Object b(E paramE, d<? super ah> paramd);
  
  public abstract Object iV(E paramE);
  
  public abstract boolean k(Throwable paramThrowable);
  
  public abstract boolean offer(E paramE);
  
  public abstract void p(b<? super Throwable, ah> paramb);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <E> boolean a(ab<? super E> paramab, E paramE)
    {
      AppMethodBeat.i(189356);
      paramab = paramab.iV(paramE);
      if (l.isSuccess-impl(paramab))
      {
        AppMethodBeat.o(189356);
        return true;
      }
      paramab = l.exceptionOrNull-impl(paramab);
      if (paramab == null)
      {
        AppMethodBeat.o(189356);
        return false;
      }
      paramab = kotlinx.coroutines.internal.ab.ab(paramab);
      AppMethodBeat.o(189356);
      throw paramab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.ab
 * JD-Core Version:    0.7.0.1
 */