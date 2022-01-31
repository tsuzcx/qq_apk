package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  static void r(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(104813);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:971");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    b.d("MicroMsg.Audio.AudioMixReport", localStringBuilder.toString());
    AppMethodBeat.o(104813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.a
 * JD-Core Version:    0.7.0.1
 */