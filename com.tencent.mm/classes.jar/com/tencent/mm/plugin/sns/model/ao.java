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

public final class ao<K, O>
{
  Map<K, ao<K, O>.b<O>> JZn;
  private a JZo;
  private int maxSize;
  
  public ao(int paramInt, a parama)
  {
    AppMethodBeat.i(95892);
    this.JZn = null;
    this.JZo = null;
    this.maxSize = paramInt;
    this.JZn = new HashMap();
    this.JZo = parama;
    AppMethodBeat.o(95892);
  }
  
  public final void fPm()
  {
    AppMethodBeat.i(95893);
    int i;
    if (this.JZn.size() > this.maxSize)
    {
      Object localObject1 = new ArrayList(this.JZn.entrySet());
      Collections.sort((List)localObject1, new Comparator() {});
      i = this.JZn.size() - this.maxSize;
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
        if (!this.JZo.dT(localObject2)) {
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
    public abstract boolean dT(Object paramObject);
  }
  
  public final class b<OO>
  {
    public Long JZq;
    public OO obj;
    
    public b()
    {
      AppMethodBeat.i(95890);
      Object localObject;
      this.obj = localObject;
      fPn();
      AppMethodBeat.o(95890);
    }
    
    public final void fPn()
    {
      AppMethodBeat.i(95891);
      this.JZq = Long.valueOf(System.currentTimeMillis());
      AppMethodBeat.o(95891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */