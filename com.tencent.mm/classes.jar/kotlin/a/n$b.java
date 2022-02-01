package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Float;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class n$b
  extends b<Float>
  implements RandomAccess
{
  n$b(float[] paramArrayOfFloat) {}
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(191141);
    if (!(paramObject instanceof Float))
    {
      AppMethodBeat.o(191141);
      return false;
    }
    float f = ((Number)paramObject).floatValue();
    paramObject = this.aivq;
    int k = paramObject.length;
    int i = 0;
    while (i < k)
    {
      if (Float.floatToIntBits(paramObject[i]) == Float.floatToIntBits(f)) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(191141);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(191141);
    return false;
  }
  
  public final int getSize()
  {
    return this.aivq.length;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(191151);
    if (!(paramObject instanceof Float))
    {
      AppMethodBeat.o(191151);
      return -1;
    }
    float f = ((Number)paramObject).floatValue();
    paramObject = this.aivq;
    int k = paramObject.length;
    int i = 0;
    while (i < k)
    {
      if (Float.floatToIntBits(paramObject[i]) == Float.floatToIntBits(f)) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(191151);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191151);
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return this.aivq.length == 0;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(191156);
    if (!(paramObject instanceof Float))
    {
      AppMethodBeat.o(191156);
      return -1;
    }
    float f = ((Number)paramObject).floatValue();
    paramObject = this.aivq;
    int i = paramObject.length - 1;
    while (i >= 0)
    {
      if (Float.floatToIntBits(paramObject[i]) == Float.floatToIntBits(f)) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(191156);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(191156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.n.b
 * JD-Core Version:    0.7.0.1
 */