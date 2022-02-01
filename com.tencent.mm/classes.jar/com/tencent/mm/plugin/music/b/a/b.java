package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  public static int YR(int paramInt)
  {
    AppMethodBeat.i(62940);
    Log.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(62940);
      return 115;
    case 702: 
      AppMethodBeat.o(62940);
      return 98;
    case 703: 
      AppMethodBeat.o(62940);
      return 99;
    case 704: 
      AppMethodBeat.o(62940);
      return 100;
    case 705: 
      AppMethodBeat.o(62940);
      return 101;
    case 706: 
      AppMethodBeat.o(62940);
      return 102;
    case 707: 
      AppMethodBeat.o(62940);
      return 103;
    case 708: 
      AppMethodBeat.o(62940);
      return 104;
    case 709: 
      AppMethodBeat.o(62940);
      return 105;
    case 710: 
      AppMethodBeat.o(62940);
      return 106;
    case 711: 
      AppMethodBeat.o(62940);
      return 107;
    case 712: 
      AppMethodBeat.o(62940);
      return 108;
    case 713: 
      AppMethodBeat.o(62940);
      return 119;
    case 714: 
      AppMethodBeat.o(62940);
      return 120;
    case 715: 
      AppMethodBeat.o(62940);
      return 109;
    }
    AppMethodBeat.o(62940);
    return 110;
  }
  
  static void e(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(62941);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:688");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    com.tencent.mm.audio.mix.h.b.d("MicroMsg.Audio.AudioPlayIdKeyReport", localStringBuilder.toString());
    AppMethodBeat.o(62941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.b
 * JD-Core Version:    0.7.0.1
 */