package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class c
{
  public static boolean d(b paramb)
  {
    AppMethodBeat.i(228532);
    if (paramb == null)
    {
      AppMethodBeat.o(228532);
      return true;
    }
    if (paramb.ahCY == 0)
    {
      AppMethodBeat.o(228532);
      return true;
    }
    if ((g(paramb)) || (f(paramb)))
    {
      AppMethodBeat.o(228532);
      return true;
    }
    AppMethodBeat.o(228532);
    return false;
  }
  
  public static boolean e(b paramb)
  {
    AppMethodBeat.i(228541);
    if (paramb.ahCY == 0)
    {
      AppMethodBeat.o(228541);
      return true;
    }
    boolean bool = f(paramb);
    AppMethodBeat.o(228541);
    return bool;
  }
  
  private static boolean f(b paramb)
  {
    AppMethodBeat.i(228549);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(102, paramb.ahCY, (int)paramb.width, (int)paramb.height, paramb.ahCX, paramb.ahDc);
    AppMethodBeat.o(228549);
    return bool;
  }
  
  private static boolean g(b paramb)
  {
    AppMethodBeat.i(228558);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(101, paramb.ahCY, (int)paramb.width, (int)paramb.height, paramb.ahCX, paramb.ahDc);
    AppMethodBeat.o(228558);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */