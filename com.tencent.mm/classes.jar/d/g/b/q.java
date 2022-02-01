package d.g.b;

import d.l;
import java.io.Serializable;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class q<R>
  implements m<R>, Serializable
{
  private final int arity;
  
  public q(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    String str = z.a(this);
    p.g(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.q
 * JD-Core Version:    0.7.0.1
 */