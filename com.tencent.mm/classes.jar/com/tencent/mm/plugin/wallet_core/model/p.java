package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class p<K>
{
  Map<String, Integer> OQe = new HashMap();
  List<K> OQf = new LinkedList();
  public Vector<p<K>.b> OQg = new Vector();
  List<String> OQh = new LinkedList();
  
  private void gJh()
  {
    int i = 0;
    int j;
    if (i < this.OQg.size()) {
      if (((b)this.OQg.get(i)).OQo != a.OQk)
      {
        Object localObject = a(this.OQg, i);
        if (this.OQe.containsKey(localObject)) {
          break label158;
        }
        localObject = e.bht((String)localObject);
        j = 0;
        label67:
        if (j >= this.OQh.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.OQh.get(j)).contains(localObject[k])) {
          break label139;
        }
      }
    }
    label139:
    label153:
    label158:
    label170:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        j = 1;
        label120:
        if (j != 0) {
          break label158;
        }
        a(i, a.OQj);
      }
      for (;;)
      {
        i += 1;
        break;
        k += 1;
        break label82;
        j += 1;
        break label67;
        j = 0;
        break label120;
        a(i, a.OQl);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.OQg.get(paramInt)).OQo = parama;
  }
  
  public final void f(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.OQh = paramList;
    this.OQf = paramList2;
    this.OQg.clear();
    this.OQg = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.OQn = localObject;
      if (this.OQf.contains(localObject)) {}
      for (paramList2.OQo = a.OQk;; paramList2.OQo = a.OQj)
      {
        this.OQg.add(paramList2);
        i += 1;
        break;
      }
    }
    this.OQe.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.OQe.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    gJh();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      OQj = new a("DISABLED", 0);
      OQk = new a("CHECKED", 1);
      OQl = new a("UNCHECKED", 2);
      OQm = new a[] { OQj, OQk, OQl };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K OQn;
    public p.a OQo;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */