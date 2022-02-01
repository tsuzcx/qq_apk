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
  Map<String, Integer> AeB = new HashMap();
  List<K> AeC = new LinkedList();
  public Vector<p<K>.b> AeD = new Vector();
  List<String> AeE = new LinkedList();
  
  private void ebV()
  {
    int i = 0;
    int j;
    if (i < this.AeD.size()) {
      if (((b)this.AeD.get(i)).AeL != a.AeH)
      {
        Object localObject = a(this.AeD, i);
        if (this.AeB.containsKey(localObject)) {
          break label158;
        }
        localObject = d.aun((String)localObject);
        j = 0;
        label67:
        if (j >= this.AeE.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.AeE.get(j)).contains(localObject[k])) {
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
        a(i, a.AeG);
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
        a(i, a.AeI);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.AeD.get(paramInt)).AeL = parama;
  }
  
  public final void d(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.AeE = paramList;
    this.AeC = paramList2;
    this.AeD.clear();
    this.AeD = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.AeK = localObject;
      if (this.AeC.contains(localObject)) {}
      for (paramList2.AeL = a.AeH;; paramList2.AeL = a.AeG)
      {
        this.AeD.add(paramList2);
        i += 1;
        break;
      }
    }
    this.AeB.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.AeB.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    ebV();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      AeG = new a("DISABLED", 0);
      AeH = new a("CHECKED", 1);
      AeI = new a("UNCHECKED", 2);
      AeJ = new a[] { AeG, AeH, AeI };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K AeK;
    public p.a AeL;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */