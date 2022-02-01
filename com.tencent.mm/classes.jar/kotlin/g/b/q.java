package kotlin.g.b;

import java.io.Serializable;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class q<R>
  implements Serializable, m<R>
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
    String str = aa.a(this);
    p.g(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.q
 * JD-Core Version:    0.7.0.1
 */