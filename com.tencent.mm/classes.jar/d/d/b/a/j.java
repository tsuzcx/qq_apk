package d.d.b.a;

import d.g.b.m;
import d.g.b.p;
import d.g.b.z;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class j
  extends d
  implements m<Object>
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
    if (this.MLk == null)
    {
      String str = z.a((m)this);
      p.g(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.j
 * JD-Core Version:    0.7.0.1
 */