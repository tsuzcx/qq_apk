package com.tencent.mm.plugin.music.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static int Am(int paramInt)
  {
    AppMethodBeat.i(151914);
    ab.i("MicroMsg.Music.ExoPlayIdkeyReport", "getExoMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 5: 
    default: 
      AppMethodBeat.o(151914);
      return 59;
    case 0: 
      AppMethodBeat.o(151914);
      return 50;
    case 1: 
      AppMethodBeat.o(151914);
      return 51;
    case 4: 
      AppMethodBeat.o(151914);
      return 52;
    case 6: 
      AppMethodBeat.o(151914);
      return 53;
    case 7: 
      AppMethodBeat.o(151914);
      return 54;
    case 8: 
      AppMethodBeat.o(151914);
      return 55;
    case 9: 
      AppMethodBeat.o(151914);
      return 56;
    case 10: 
      AppMethodBeat.o(151914);
      return 57;
    }
    AppMethodBeat.o(151914);
    return 58;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.b
 * JD-Core Version:    0.7.0.1
 */