package d.d.b.a;

import d.g.b.i;
import d.g.b.k;
import d.g.b.w;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class j
  extends d
  implements i<Object>
{
  private final int arity = 2;
  
  public j(d.d.d<Object> paramd)
  {
    super(paramd);
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    if (this.JgR == null)
    {
      String str = w.a((i)this);
      k.g(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.d.b.a.j
 * JD-Core Version:    0.7.0.1
 */