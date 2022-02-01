package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class p<K>
{
  Map<String, Integer> CXl = new HashMap();
  List<K> CXm = new LinkedList();
  public Vector<p<K>.b> CXn = new Vector();
  List<String> CXo = new LinkedList();
  
  private void eFr()
  {
    int i = 0;
    int j;
    if (i < this.CXn.size()) {
      if (((b)this.CXn.get(i)).CXv != a.CXr)
      {
        Object localObject = a(this.CXn, i);
        if (this.CXl.containsKey(localObject)) {
          break label158;
        }
        localObject = d.aEP((String)localObject);
        j = 0;
        label67:
        if (j >= this.CXo.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.CXo.get(j)).contains(localObject[k])) {
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
        a(i, a.CXq);
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
        a(i, a.CXs);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.CXn.get(paramInt)).CXv = parama;
  }
  
  public final void e(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.CXo = paramList;
    this.CXm = paramList2;
    this.CXn.clear();
    this.CXn = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.CXu = localObject;
      if (this.CXm.contains(localObject)) {}
      for (paramList2.CXv = a.CXr;; paramList2.CXv = a.CXq)
      {
        this.CXn.add(paramList2);
        i += 1;
        break;
      }
    }
    this.CXl.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.CXl.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    eFr();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      CXq = new a("DISABLED", 0);
      CXr = new a("CHECKED", 1);
      CXs = new a("UNCHECKED", 2);
      CXt = new a[] { CXq, CXr, CXs };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K CXu;
    public p.a CXv;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */