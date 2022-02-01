package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.logic.a;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean aa(f paramf)
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
    Log.d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", new Object[] { paramf.protocol });
    if ("hls".equalsIgnoreCase(paramf.protocol))
    {
      AppMethodBeat.o(137450);
      return true;
    }
    AppMethodBeat.o(137450);
    return false;
  }
  
  public static boolean adO(int paramInt)
  {
    AppMethodBeat.i(137449);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    case 13: 
    default: 
      a locala = j.gnw().LLw;
      if ((locala != null) && (locala.gnh()))
      {
        AppMethodBeat.o(137449);
        return true;
      }
      break;
    case 0: 
    case 1: 
    case 4: 
    case 5: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 14: 
      AppMethodBeat.o(137449);
      return true;
    }
    AppMethodBeat.o(137449);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.c
 * JD-Core Version:    0.7.0.1
 */