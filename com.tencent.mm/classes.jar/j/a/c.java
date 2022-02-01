package j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.x;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonEquals", "", "Lokio/SegmentedByteString;", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "offset", "", "otherOffset", "byteCount", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k=2, mv={1, 4, 1})
public final class c
{
  public static final int a(x paramx, int paramInt)
  {
    AppMethodBeat.i(186388);
    s.u(paramx, "$this$segment");
    paramInt = n(paramx.ajTF, paramInt + 1, ((Object[])paramx.ajTE).length);
    if (paramInt >= 0)
    {
      AppMethodBeat.o(186388);
      return paramInt;
    }
    AppMethodBeat.o(186388);
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private static int n(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186384);
    s.u(paramArrayOfInt, "$this$binarySearch");
    paramInt2 -= 1;
    int i = 0;
    while (i <= paramInt2)
    {
      int j = i + paramInt2 >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt1)
      {
        i = j + 1;
      }
      else if (k > paramInt1)
      {
        paramInt2 = j - 1;
      }
      else
      {
        AppMethodBeat.o(186384);
        return j;
      }
    }
    paramInt1 = -i;
    AppMethodBeat.o(186384);
    return paramInt1 - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     j.a.c
 * JD-Core Version:    0.7.0.1
 */