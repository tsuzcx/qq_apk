package kotlin.d.b.a;

import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.o;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class k
  extends d
  implements o<Object>
{
  private final int arity;
  
  public k(int paramInt)
  {
    this(paramInt, null);
  }
  
  public k(int paramInt, kotlin.d.d<Object> paramd)
  {
    super(paramd);
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    if (getCompletion() == null)
    {
      String str = ai.a((o)this);
      s.s(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.d.b.a.k
 * JD-Core Version:    0.7.0.1
 */