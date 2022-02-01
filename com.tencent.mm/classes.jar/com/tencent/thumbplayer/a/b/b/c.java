package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class c
{
  public static boolean d(b paramb)
  {
    AppMethodBeat.i(189007);
    if (paramb == null)
    {
      AppMethodBeat.o(189007);
      return true;
    }
    if (paramb.RVk == 0)
    {
      AppMethodBeat.o(189007);
      return true;
    }
    if ((g(paramb)) || (f(paramb)))
    {
      AppMethodBeat.o(189007);
      return true;
    }
    AppMethodBeat.o(189007);
    return false;
  }
  
  public static boolean e(b paramb)
  {
    AppMethodBeat.i(189008);
    if (paramb.RVk == 0)
    {
      AppMethodBeat.o(189008);
      return true;
    }
    boolean bool = f(paramb);
    AppMethodBeat.o(189008);
    return bool;
  }
  
  private static boolean f(b paramb)
  {
    AppMethodBeat.i(189009);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(102, paramb.RVk, (int)paramb.width, (int)paramb.height, paramb.RVj, paramb.RVp);
    AppMethodBeat.o(189009);
    return bool;
  }
  
  private static boolean g(b paramb)
  {
    AppMethodBeat.i(189010);
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(101, paramb.RVk, (int)paramb.width, (int)paramb.height, paramb.RVj, paramb.RVp);
    AppMethodBeat.o(189010);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */