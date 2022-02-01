package kotlin.g.b;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class u<R>
  implements Serializable, o<R>
{
  private final int arity;
  
  public u(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    String str = ai.a(this);
    s.s(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.g.b.u
 * JD-Core Version:    0.7.0.1
 */