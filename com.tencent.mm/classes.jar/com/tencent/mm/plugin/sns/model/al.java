package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class al<K, O>
{
  private int maxSize;
  Map<K, al<K, O>.b<O>> otf = null;
  private al.a otg = null;
  
  public al(int paramInt, al.a parama)
  {
    this.maxSize = paramInt;
    this.otf = new HashMap();
    this.otg = parama;
  }
  
  public final void bEb()
  {
    Object localObject1;
    int i;
    if (this.otf.size() > this.maxSize)
    {
      localObject1 = new ArrayList(this.otf.entrySet());
      Collections.sort((List)localObject1, new al.1(this));
      i = this.otf.size() - this.maxSize;
      if (i > 0) {
        break label65;
      }
    }
    label148:
    label149:
    for (;;)
    {
      return;
      label65:
      localObject1 = ((ArrayList)localObject1).iterator();
      label70:
      if (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        Object localObject2 = localEntry.getKey();
        if (!this.otg.bB(localObject2)) {
          break label148;
        }
        y.d("MicroMsg.SnsLRUMap", " remove targetKey: " + localEntry.getKey());
        i -= 1;
      }
      for (;;)
      {
        if (i <= 0) {
          break label149;
        }
        break label70;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.al
 * JD-Core Version:    0.7.0.1
 */