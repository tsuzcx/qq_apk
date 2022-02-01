package d.d.b.a;

import d.d.d;
import d.g.b.k;
import d.g.b.w;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class i
  extends c
  implements d.g.b.i<Object>
{
  private final int arity = 2;
  
  public i(d<Object> paramd)
  {
    super(paramd);
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    if (this.KUl == null)
    {
      String str = w.a((d.g.b.i)this);
      k.g(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.i
 * JD-Core Version:    0.7.0.1
 */