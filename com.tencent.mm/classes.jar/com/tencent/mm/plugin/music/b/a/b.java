package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  static void r(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(104815);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:688");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    com.tencent.mm.audio.mix.h.b.d("MicroMsg.Audio.AudioPlayIdKeyReport", localStringBuilder.toString());
    AppMethodBeat.o(104815);
  }
  
  public static int zN(int paramInt)
  {
    AppMethodBeat.i(104814);
    ab.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(104814);
      return 115;
    case 702: 
      AppMethodBeat.o(104814);
      return 98;
    case 703: 
      AppMethodBeat.o(104814);
      return 99;
    case 704: 
      AppMethodBeat.o(104814);
      return 100;
    case 705: 
      AppMethodBeat.o(104814);
      return 101;
    case 706: 
      AppMethodBeat.o(104814);
      return 102;
    case 707: 
      AppMethodBeat.o(104814);
      return 103;
    case 708: 
      AppMethodBeat.o(104814);
      return 104;
    case 709: 
      AppMethodBeat.o(104814);
      return 105;
    case 710: 
      AppMethodBeat.o(104814);
      return 106;
    case 711: 
      AppMethodBeat.o(104814);
      return 107;
    case 712: 
      AppMethodBeat.o(104814);
      return 108;
    case 713: 
      AppMethodBeat.o(104814);
      return 119;
    case 714: 
      AppMethodBeat.o(104814);
      return 120;
    case 715: 
      AppMethodBeat.o(104814);
      return 109;
    }
    AppMethodBeat.o(104814);
    return 110;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.b
 * JD-Core Version:    0.7.0.1
 */