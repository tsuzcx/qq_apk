package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static boolean LD(int paramInt)
  {
    AppMethodBeat.i(137449);
    switch (paramInt)
    {
    default: 
      a locala = k.dta().wkp;
      if ((locala != null) && (locala.Lk(paramInt)))
      {
        AppMethodBeat.o(137449);
        return true;
      }
      break;
    case 10: 
    case 11: 
      AppMethodBeat.o(137449);
      return true;
    }
    AppMethodBeat.o(137449);
    return false;
  }
  
  public static boolean Q(f paramf)
  {
    AppMethodBeat.i(137450);
    if (paramf == null)
    {
      AppMethodBeat.o(137450);
      return false;
    }
    if (TextUtils.isEmpty(paramf.protocol))
    {
      AppMethodBeat.o(137450);
      return false;
    }
    ad.d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", new Object[] { paramf.protocol });
    if ("hls".equalsIgnoreCase(paramf.protocol))
    {
      AppMethodBeat.o(137450);
      return true;
    }
    AppMethodBeat.o(137450);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.c
 * JD-Core Version:    0.7.0.1
 */