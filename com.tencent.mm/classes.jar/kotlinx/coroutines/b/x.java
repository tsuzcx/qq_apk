package kotlinx.coroutines.b;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface x<T>
  extends af<T>, w<T>
{
  public abstract boolean ad(T paramT1, T paramT2);
  
  public abstract T getValue();
  
  public abstract void setValue(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.x
 * JD-Core Version:    0.7.0.1
 */