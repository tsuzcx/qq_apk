package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class ay$c
{
  private static final HashMap<String, Integer> Rkv;
  
  static
  {
    AppMethodBeat.i(308249);
    Rkv = new HashMap();
    AppMethodBeat.o(308249);
  }
  
  public static int bc(int paramInt, long paramLong)
  {
    AppMethodBeat.i(308244);
    Integer localInteger = (Integer)Rkv.get(paramInt + "_" + paramLong);
    if (localInteger == null)
    {
      AppMethodBeat.o(308244);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(308244);
    return paramInt;
  }
  
  public static void c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(308246);
    Rkv.put(paramInt1 + "_" + paramLong, Integer.valueOf(paramInt2));
    AppMethodBeat.o(308246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay.c
 * JD-Core Version:    0.7.0.1
 */