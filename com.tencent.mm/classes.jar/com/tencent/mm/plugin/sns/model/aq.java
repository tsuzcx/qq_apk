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

public final class aq<K, O>
{
  Map<K, aq<K, O>.b<O>> Qwv;
  private a Qww;
  private int maxSize;
  
  public aq(int paramInt, a parama)
  {
    AppMethodBeat.i(95892);
    this.Qwv = null;
    this.Qww = null;
    this.maxSize = paramInt;
    this.Qwv = new HashMap();
    this.Qww = parama;
    AppMethodBeat.o(95892);
  }
  
  public final void hhf()
  {
    AppMethodBeat.i(95893);
    int i;
    if (this.Qwv.size() > this.maxSize)
    {
      Object localObject1 = new ArrayList(this.Qwv.entrySet());
      Collections.sort((List)localObject1, new Comparator() {});
      i = this.Qwv.size() - this.maxSize;
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
        if (!this.Qww.gq(localObject2)) {
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
    public abstract boolean gq(Object paramObject);
  }
  
  public final class b<OO>
  {
    public Long Qwy;
    public OO obj;
    
    public b()
    {
      AppMethodBeat.i(95890);
      Object localObject;
      this.obj = localObject;
      hhg();
      AppMethodBeat.o(95890);
    }
    
    public final void hhg()
    {
      AppMethodBeat.i(95891);
      this.Qwy = Long.valueOf(System.currentTimeMillis());
      AppMethodBeat.o(95891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */