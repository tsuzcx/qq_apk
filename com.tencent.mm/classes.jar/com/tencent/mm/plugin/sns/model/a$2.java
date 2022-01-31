package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class a$2
  extends LinkedHashMap<Long, Integer>
{
  a$2(int paramInt)
  {
    super(paramInt, 0.75F);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<Long, Integer> paramEntry)
  {
    if ((size() > 500) && (paramEntry != null)) {
      y.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + paramEntry.getKey());
    }
    return size() > 500;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.2
 * JD-Core Version:    0.7.0.1
 */