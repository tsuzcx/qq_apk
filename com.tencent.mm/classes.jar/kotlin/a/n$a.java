package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class n$a
  extends b<Integer>
  implements RandomAccess
{
  n$a(int[] paramArrayOfInt) {}
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(129237);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(129237);
      return false;
    }
    int i = ((Number)paramObject).intValue();
    boolean bool = k.contains(this.aivp, i);
    AppMethodBeat.o(129237);
    return bool;
  }
  
  public final int getSize()
  {
    return this.aivp.length;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(129239);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(129239);
      return -1;
    }
    int i = ((Number)paramObject).intValue();
    i = k.B(this.aivp, i);
    AppMethodBeat.o(129239);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.aivp.length == 0;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(129240);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(129240);
      return -1;
    }
    int j = ((Number)paramObject).intValue();
    paramObject = this.aivp;
    s.u(paramObject, "$this$lastIndexOf");
    int i = paramObject.length - 1;
    while (i >= 0)
    {
      if (j == paramObject[i])
      {
        AppMethodBeat.o(129240);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(129240);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.n.a
 * JD-Core Version:    0.7.0.1
 */