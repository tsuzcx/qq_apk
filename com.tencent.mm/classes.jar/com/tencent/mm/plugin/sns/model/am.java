package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class am<K, O>
{
  private int maxSize;
  Map<K, am<K, O>.b<O>> rhX;
  private am.a rhY;
  
  public am(int paramInt, am.a parama)
  {
    AppMethodBeat.i(36569);
    this.rhX = null;
    this.rhY = null;
    this.maxSize = paramInt;
    this.rhX = new HashMap();
    this.rhY = parama;
    AppMethodBeat.o(36569);
  }
  
  public final void cpA()
  {
    AppMethodBeat.i(36570);
    int i;
    if (this.rhX.size() > this.maxSize)
    {
      Object localObject1 = new ArrayList(this.rhX.entrySet());
      Collections.sort((List)localObject1, new am.1(this));
      i = this.rhX.size() - this.maxSize;
      if (i <= 0)
      {
        AppMethodBeat.o(36570);
        return;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        Object localObject2 = localEntry.getKey();
        if (!this.rhY.cg(localObject2)) {
          break label164;
        }
        ab.d("MicroMsg.SnsLRUMap", " remove targetKey: " + localEntry.getKey());
        i -= 1;
      }
    }
    label164:
    for (;;)
    {
      if (i <= 0)
      {
        AppMethodBeat.o(36570);
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */