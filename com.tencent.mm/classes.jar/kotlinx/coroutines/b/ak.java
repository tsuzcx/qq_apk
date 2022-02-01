package kotlinx.coroutines.b;

import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/ThrowingCollector;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "e", "", "(Ljava/lang/Throwable;)V", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  implements h<Object>
{
  public final Throwable e;
  
  public ak(Throwable paramThrowable)
  {
    this.e = paramThrowable;
  }
  
  public final Object a(Object paramObject, d<? super ah> paramd)
  {
    throw this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.ak
 * JD-Core Version:    0.7.0.1
 */