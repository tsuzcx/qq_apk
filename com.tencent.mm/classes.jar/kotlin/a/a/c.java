package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"arrayOfUninitializedElements", "", "E", "size", "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", "T", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", "offset", "length", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "([Ljava/lang/Object;II)Ljava/lang/String;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class c
{
  public static final <E> E[] aKk(int paramInt)
  {
    AppMethodBeat.i(191034);
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("capacity must be non-negative.".toString());
      AppMethodBeat.o(191034);
      throw ((Throwable)localObject);
    }
    Object localObject = new Object[paramInt];
    AppMethodBeat.o(191034);
    return localObject;
  }
  
  public static final <E> void f(E[] paramArrayOfE, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191064);
    s.u(paramArrayOfE, "$this$resetRange");
    while (paramInt1 < paramInt2)
    {
      o(paramArrayOfE, paramInt1);
      paramInt1 += 1;
    }
    AppMethodBeat.o(191064);
  }
  
  public static final <T> T[] n(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(191039);
    s.u(paramArrayOfT, "$this$copyOfUninitializedElements");
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramInt);
    s.s(paramArrayOfT, "java.util.Arrays.copyOf(this, newSize)");
    if (paramArrayOfT == null)
    {
      paramArrayOfT = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191039);
      throw paramArrayOfT;
    }
    AppMethodBeat.o(191039);
    return paramArrayOfT;
  }
  
  public static final <E> void o(E[] paramArrayOfE, int paramInt)
  {
    AppMethodBeat.i(191053);
    s.u(paramArrayOfE, "$this$resetAt");
    paramArrayOfE[paramInt] = null;
    AppMethodBeat.o(191053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.a.c
 * JD-Core Version:    0.7.0.1
 */