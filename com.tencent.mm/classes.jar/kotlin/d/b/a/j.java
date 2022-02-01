package kotlin.d.b.a;

import kotlin.g.b.ab;
import kotlin.g.b.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class j
  extends d
  implements m<Object>
{
  private final int arity;
  
  public j(int paramInt)
  {
    this(paramInt, null);
  }
  
  public j(int paramInt, kotlin.d.d<Object> paramd)
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
      String str = ab.a((m)this);
      p.j(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.d.b.a.j
 * JD-Core Version:    0.7.0.1
 */