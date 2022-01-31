package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class a$5
  extends LinkedHashMap<Long, Integer>
{
  a$5(int paramInt)
  {
    super(paramInt, 0.75F);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<Long, Integer> paramEntry)
  {
    AppMethodBeat.i(36065);
    if ((size() > 500) && (paramEntry != null)) {
      ab.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + paramEntry.getKey());
    }
    if (size() > 500)
    {
      AppMethodBeat.o(36065);
      return true;
    }
    AppMethodBeat.o(36065);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.5
 * JD-Core Version:    0.7.0.1
 */