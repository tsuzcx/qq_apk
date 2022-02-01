package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ap<K, O>
{
  Map<K, ap<K, O>.b<O>> DMl;
  private a DMm;
  private int maxSize;
  
  public ap(int paramInt, a parama)
  {
    AppMethodBeat.i(95892);
    this.DMl = null;
    this.DMm = null;
    this.maxSize = paramInt;
    this.DMl = new HashMap();
    this.DMm = parama;
    AppMethodBeat.o(95892);
  }
  
  public final void fbt()
  {
    AppMethodBeat.i(95893);
    int i;
    if (this.DMl.size() > this.maxSize)
    {
      Object localObject1 = new ArrayList(this.DMl.entrySet());
      Collections.sort((List)localObject1, new Comparator() {});
      i = this.DMl.size() - this.maxSize;
      if (i <= 0)
      {
        AppMethodBeat.o(95893);
        return;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        Object localObject2 = localEntry.getKey();
        if (!this.DMm.dQ(localObject2)) {
          break label164;
        }
        Log.d("MicroMsg.SnsLRUMap", " remove targetKey: " + localEntry.getKey());
        i -= 1;
      }
    }
    label164:
    for (;;)
    {
      if (i <= 0)
      {
        AppMethodBeat.o(95893);
        return;
      }
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean dQ(Object paramObject);
  }
  
  public final class b<OO>
  {
    public Long DMo;
    public OO obj;
    
    public b()
    {
      AppMethodBeat.i(95890);
      Object localObject;
      this.obj = localObject;
      fbu();
      AppMethodBeat.o(95890);
    }
    
    public final void fbu()
    {
      AppMethodBeat.i(95891);
      this.DMo = Long.valueOf(System.currentTimeMillis());
      AppMethodBeat.o(95891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */