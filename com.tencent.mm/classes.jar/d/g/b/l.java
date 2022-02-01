package d.g.b;

import java.io.Serializable;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
public abstract class l<R>
  implements i<R>, Serializable
{
  private final int arity;
  
  public l(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    String str = w.a(this);
    k.g(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.l
 * JD-Core Version:    0.7.0.1
 */