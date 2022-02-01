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
  Map<String, Integer> HYe = new HashMap();
  List<K> HYf = new LinkedList();
  public Vector<p<K>.b> HYg = new Vector();
  List<String> HYh = new LinkedList();
  
  private void fQB()
  {
    int i = 0;
    int j;
    if (i < this.HYg.size()) {
      if (((b)this.HYg.get(i)).HYo != a.HYk)
      {
        Object localObject = a(this.HYg, i);
        if (this.HYe.containsKey(localObject)) {
          break label158;
        }
        localObject = d.aVK((String)localObject);
        j = 0;
        label67:
        if (j >= this.HYh.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.HYh.get(j)).contains(localObject[k])) {
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
        a(i, a.HYj);
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
        a(i, a.HYl);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.HYg.get(paramInt)).HYo = parama;
  }
  
  public final void f(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.HYh = paramList;
    this.HYf = paramList2;
    this.HYg.clear();
    this.HYg = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.HYn = localObject;
      if (this.HYf.contains(localObject)) {}
      for (paramList2.HYo = a.HYk;; paramList2.HYo = a.HYj)
      {
        this.HYg.add(paramList2);
        i += 1;
        break;
      }
    }
    this.HYe.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.HYe.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    fQB();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      HYj = new a("DISABLED", 0);
      HYk = new a("CHECKED", 1);
      HYl = new a("UNCHECKED", 2);
      HYm = new a[] { HYj, HYk, HYl };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K HYn;
    public p.a HYo;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */