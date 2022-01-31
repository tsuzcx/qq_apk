package com.tinkerboots.sdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class d
{
  private static String BLP;
  private static HashSet<String> BLQ;
  
  static
  {
    AppMethodBeat.i(65559);
    BLQ = new HashSet();
    AppMethodBeat.o(65559);
  }
  
  public static String eaM()
  {
    if (BLP == null) {
      return "";
    }
    return BLP;
  }
  
  public static boolean eaN()
  {
    AppMethodBeat.i(65558);
    if (BLP == null)
    {
      AppMethodBeat.o(65558);
      return false;
    }
    boolean bool = BLQ.contains(BLP);
    AppMethodBeat.o(65558);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tinkerboots.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */