package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, iBN=1)
public class f
{
  public static final void oq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218662);
    if (paramInt1 > paramInt2)
    {
      Throwable localThrowable = (Throwable)new IndexOutOfBoundsException("toIndex (" + paramInt1 + ") is greater than size (" + paramInt2 + ").");
      AppMethodBeat.o(218662);
      throw localThrowable;
    }
    AppMethodBeat.o(218662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.f
 * JD-Core Version:    0.7.0.1
 */