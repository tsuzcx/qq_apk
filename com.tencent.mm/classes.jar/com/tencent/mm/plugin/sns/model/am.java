package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class am<K, O>
{
  private int maxSize;
  Map<K, am<K, O>.b<O>> zkW;
  private a zkX;
  
  public am(int paramInt, a parama)
  {
    AppMethodBeat.i(95892);
    this.zkW = null;
    this.zkX = null;
    this.maxSize = paramInt;
    this.zkW = new HashMap();
    this.zkX = parama;
    AppMethodBeat.o(95892);
  }
  
  public final void dUF()
  {
    AppMethodBeat.i(95893);
    int i;
    if (this.zkW.size() > this.maxSize)
    {
      Object localObject1 = new ArrayList(this.zkW.entrySet());
      Collections.sort((List)localObject1, new Comparator() {});
      i = this.zkW.size() - this.maxSize;
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
        if (!this.zkX.dG(localObject2)) {
          break label164;
        }
        ad.d("MicroMsg.SnsLRUMap", " remove targetKey: " + localEntry.getKey());
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
    public abstract boolean dG(Object paramObject);
  }
  
  public final class b<OO>
  {
    public OO obj;
    public Long zkZ;
    
    public b()
    {
      AppMethodBeat.i(95890);
      Object localObject;
      this.obj = localObject;
      dUG();
      AppMethodBeat.o(95890);
    }
    
    public final void dUG()
    {
      AppMethodBeat.i(95891);
      this.zkZ = Long.valueOf(System.currentTimeMillis());
      AppMethodBeat.o(95891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */