package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/ArraysKt")
class l
{
  public static final void qm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191113);
    if (paramInt1 > paramInt2)
    {
      Throwable localThrowable = (Throwable)new IndexOutOfBoundsException("toIndex (" + paramInt1 + ") is greater than size (" + paramInt2 + ").");
      AppMethodBeat.o(191113);
      throw localThrowable;
    }
    AppMethodBeat.o(191113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.l
 * JD-Core Version:    0.7.0.1
 */