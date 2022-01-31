package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static boolean Az(int paramInt)
  {
    AppMethodBeat.i(137696);
    switch (paramInt)
    {
    default: 
      a locala = k.bVH().oZe;
      if ((locala != null) && (locala.Af(paramInt)))
      {
        AppMethodBeat.o(137696);
        return true;
      }
      break;
    case 10: 
    case 11: 
      AppMethodBeat.o(137696);
      return true;
    }
    AppMethodBeat.o(137696);
    return false;
  }
  
  public static boolean M(e parame)
  {
    AppMethodBeat.i(137697);
    if (parame == null)
    {
      AppMethodBeat.o(137697);
      return false;
    }
    if (TextUtils.isEmpty(parame.protocol))
    {
      AppMethodBeat.o(137697);
      return false;
    }
    ab.d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", new Object[] { parame.protocol });
    if ("hls".equalsIgnoreCase(parame.protocol))
    {
      AppMethodBeat.o(137697);
      return true;
    }
    AppMethodBeat.o(137697);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.c
 * JD-Core Version:    0.7.0.1
 */