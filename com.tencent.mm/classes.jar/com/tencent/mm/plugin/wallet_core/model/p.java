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
  Map<String, Integer> DoQ = new HashMap();
  List<K> DoR = new LinkedList();
  public Vector<p<K>.b> DoS = new Vector();
  List<String> DoT = new LinkedList();
  
  private void eIY()
  {
    int i = 0;
    int j;
    if (i < this.DoS.size()) {
      if (((b)this.DoS.get(i)).Dpa != a.DoW)
      {
        Object localObject = a(this.DoS, i);
        if (this.DoQ.containsKey(localObject)) {
          break label158;
        }
        localObject = d.aGj((String)localObject);
        j = 0;
        label67:
        if (j >= this.DoT.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.DoT.get(j)).contains(localObject[k])) {
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
        a(i, a.DoV);
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
        a(i, a.DoX);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.DoS.get(paramInt)).Dpa = parama;
  }
  
  public final void e(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.DoT = paramList;
    this.DoR = paramList2;
    this.DoS.clear();
    this.DoS = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.DoZ = localObject;
      if (this.DoR.contains(localObject)) {}
      for (paramList2.Dpa = a.DoW;; paramList2.Dpa = a.DoV)
      {
        this.DoS.add(paramList2);
        i += 1;
        break;
      }
    }
    this.DoQ.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.DoQ.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    eIY();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      DoV = new a("DISABLED", 0);
      DoW = new a("CHECKED", 1);
      DoX = new a("UNCHECKED", 2);
      DoY = new a[] { DoV, DoW, DoX };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K DoZ;
    public p.a Dpa;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */