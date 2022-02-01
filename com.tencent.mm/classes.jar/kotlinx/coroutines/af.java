package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public final b<Throwable, ah> ajvz;
  public final Object result;
  
  public af(Object paramObject, b<? super Throwable, ah> paramb)
  {
    this.result = paramObject;
    this.ajvz = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188885);
    if (this == paramObject)
    {
      AppMethodBeat.o(188885);
      return true;
    }
    if (!(paramObject instanceof af))
    {
      AppMethodBeat.o(188885);
      return false;
    }
    paramObject = (af)paramObject;
    if (!s.p(this.result, paramObject.result))
    {
      AppMethodBeat.o(188885);
      return false;
    }
    if (!s.p(this.ajvz, paramObject.ajvz))
    {
      AppMethodBeat.o(188885);
      return false;
    }
    AppMethodBeat.o(188885);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188876);
    if (this.result == null) {}
    for (int i = 0;; i = this.result.hashCode())
    {
      int j = this.ajvz.hashCode();
      AppMethodBeat.o(188876);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188870);
    String str = "CompletedWithCancellation(result=" + this.result + ", onCancellation=" + this.ajvz + ')';
    AppMethodBeat.o(188870);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.af
 * JD-Core Version:    0.7.0.1
 */