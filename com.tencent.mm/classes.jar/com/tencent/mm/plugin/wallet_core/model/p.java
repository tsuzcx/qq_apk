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
  Map<String, Integer> BwV = new HashMap();
  List<K> BwW = new LinkedList();
  public Vector<p<K>.b> BwX = new Vector();
  List<String> BwY = new LinkedList();
  
  private void err()
  {
    int i = 0;
    int j;
    if (i < this.BwX.size()) {
      if (((b)this.BwX.get(i)).Bxf != a.Bxb)
      {
        Object localObject = a(this.BwX, i);
        if (this.BwV.containsKey(localObject)) {
          break label158;
        }
        localObject = d.azF((String)localObject);
        j = 0;
        label67:
        if (j >= this.BwY.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.BwY.get(j)).contains(localObject[k])) {
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
        a(i, a.Bxa);
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
        a(i, a.Bxc);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.BwX.get(paramInt)).Bxf = parama;
  }
  
  public final void d(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.BwY = paramList;
    this.BwW = paramList2;
    this.BwX.clear();
    this.BwX = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.Bxe = localObject;
      if (this.BwW.contains(localObject)) {}
      for (paramList2.Bxf = a.Bxb;; paramList2.Bxf = a.Bxa)
      {
        this.BwX.add(paramList2);
        i += 1;
        break;
      }
    }
    this.BwV.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.BwV.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    err();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      Bxa = new a("DISABLED", 0);
      Bxb = new a("CHECKED", 1);
      Bxc = new a("UNCHECKED", 2);
      Bxd = new a[] { Bxa, Bxb, Bxc };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K Bxe;
    public p.a Bxf;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */