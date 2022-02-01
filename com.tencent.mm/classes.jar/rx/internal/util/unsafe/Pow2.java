package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Pow2
{
  private Pow2()
  {
    AppMethodBeat.i(90151);
    IllegalStateException localIllegalStateException = new IllegalStateException("No instances!");
    AppMethodBeat.o(90151);
    throw localIllegalStateException;
  }
  
  public static boolean isPowerOfTwo(int paramInt)
  {
    return (paramInt - 1 & paramInt) == 0;
  }
  
  public static int roundToPowerOfTwo(int paramInt)
  {
    AppMethodBeat.i(90152);
    paramInt = Integer.numberOfLeadingZeros(paramInt - 1);
    AppMethodBeat.o(90152);
    return 1 << 32 - paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     rx.internal.util.unsafe.Pow2
 * JD-Core Version:    0.7.0.1
 */