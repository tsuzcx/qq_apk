package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class c
{
  public static boolean d(b paramb)
  {
    AppMethodBeat.i(219743);
    if (paramb == null)
    {
      AppMethodBeat.o(219743);
      return true;
    }
    if (paramb.ZxU == 0)
    {
      AppMethodBeat.o(219743);
      return true;
    }
    if ((g(paramb)) || (f(paramb)))
    {
      AppMethodBeat.o(219743);
      return true;
    }
    AppMethodBeat.o(219743);
    return false;
  }
  
  public static boolean e(b paramb)
  {
    AppMethodBeat.i(219744);
    if (paramb.ZxU == 0)
    {
      AppMethodBeat.o(219744);
      return true;
    }
    boolean bool = f(paramb);
    AppMethodBeat.o(219744);
    return bool;
  }
  
  private static boolean f(b paramb)
  {
    AppMethodBeat.i(219746);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(102, paramb.ZxU, (int)paramb.width, (int)paramb.height, paramb.ZxT, paramb.ZxZ);
    AppMethodBeat.o(219746);
    return bool;
  }
  
  private static boolean g(b paramb)
  {
    AppMethodBeat.i(219748);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(101, paramb.ZxU, (int)paramb.width, (int)paramb.height, paramb.ZxT, paramb.ZxZ);
    AppMethodBeat.o(219748);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */