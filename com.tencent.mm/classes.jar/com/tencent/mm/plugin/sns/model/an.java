package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class an<K, O>
{
  private int maxSize;
  Map<K, an<K, O>.b<O>> zCl;
  private a zCm;
  
  public an(int paramInt, a parama)
  {
    AppMethodBeat.i(95892);
    this.zCl = null;
    this.zCm = null;
    this.maxSize = paramInt;
    this.zCl = new HashMap();
    this.zCm = parama;
    AppMethodBeat.o(95892);
  }
  
  public final void dYf()
  {
    AppMethodBeat.i(95893);
    int i;
    if (this.zCl.size() > this.maxSize)
    {
      Object localObject1 = new ArrayList(this.zCl.entrySet());
      Collections.sort((List)localObject1, new Comparator() {});
      i = this.zCl.size() - this.maxSize;
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
        if (!this.zCm.dH(localObject2)) {
          break label164;
        }
        ae.d("MicroMsg.SnsLRUMap", " remove targetKey: " + localEntry.getKey());
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
    public abstract boolean dH(Object paramObject);
  }
  
  public final class b<OO>
  {
    public OO obj;
    public Long zCo;
    
    public b()
    {
      AppMethodBeat.i(95890);
      Object localObject;
      this.obj = localObject;
      dYg();
      AppMethodBeat.o(95890);
    }
    
    public final void dYg()
    {
      AppMethodBeat.i(95891);
      this.zCo = Long.valueOf(System.currentTimeMillis());
      AppMethodBeat.o(95891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.an
 * JD-Core Version:    0.7.0.1
 */