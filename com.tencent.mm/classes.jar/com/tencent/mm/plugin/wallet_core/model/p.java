package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class p<K>
{
  Map<String, Integer> VFY = new HashMap();
  List<K> VFZ = new LinkedList();
  public Vector<p<K>.b> VGa = new Vector();
  List<String> VGb = new LinkedList();
  
  private void iiv()
  {
    int i = 0;
    int j;
    if (i < this.VGa.size()) {
      if (((b)this.VGa.get(i)).VGi != a.VGe)
      {
        Object localObject = a(this.VGa, i);
        if (this.VFY.containsKey(localObject)) {
          break label158;
        }
        localObject = f.bhc((String)localObject);
        j = 0;
        label67:
        if (j >= this.VGb.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.VGb.get(j)).contains(localObject[k])) {
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
        a(i, a.VGd);
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
        a(i, a.VGf);
      }
      return;
    }
  }
  
  public abstract String a(Vector<p<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, a parama)
  {
    ((b)this.VGa.get(paramInt)).VGi = parama;
  }
  
  public final void f(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.VGb = paramList;
    this.VFZ = paramList2;
    this.VGa.clear();
    this.VGa = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new b();
      Object localObject = paramList1.get(i);
      paramList2.VGh = localObject;
      if (this.VFZ.contains(localObject)) {}
      for (paramList2.VGi = a.VGe;; paramList2.VGi = a.VGd)
      {
        this.VGa.add(paramList2);
        i += 1;
        break;
      }
    }
    this.VFY.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.VFY.put((String)paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    iiv();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(70308);
      VGd = new a("DISABLED", 0);
      VGe = new a("CHECKED", 1);
      VGf = new a("UNCHECKED", 2);
      VGg = new a[] { VGd, VGe, VGf };
      AppMethodBeat.o(70308);
    }
    
    private a() {}
  }
  
  public final class b
  {
    public K VGh;
    public p.a VGi;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.p
 * JD-Core Version:    0.7.0.1
 */