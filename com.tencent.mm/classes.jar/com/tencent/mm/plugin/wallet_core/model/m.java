package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.plugin.wallet_core.ui.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class m<K>
{
  Map<String, Integer> qvY = new HashMap();
  List<K> qvZ = new LinkedList();
  public Vector<m<K>.b> qwa = new Vector();
  List<String> qwb = new LinkedList();
  
  public abstract String a(Vector<m<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, m.a parama)
  {
    ((m.b)this.qwa.get(paramInt)).qwi = parama;
  }
  
  public final void bVm()
  {
    int i = 0;
    int j;
    if (i < this.qwa.size()) {
      if (((m.b)this.qwa.get(i)).qwi != m.a.qwe)
      {
        Object localObject = a(this.qwa, i);
        if (this.qvY.containsKey(localObject)) {
          break label158;
        }
        localObject = a.QG((String)localObject);
        j = 0;
        label67:
        if (j >= this.qwb.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.qwb.get(j)).contains(localObject[k])) {
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
        a(i, m.a.qwd);
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
        a(i, m.a.qwf);
      }
      return;
    }
  }
  
  public final void c(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.qwb = paramList;
    this.qvZ = paramList2;
    this.qwa.clear();
    this.qwa = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new m.b(this);
      Object localObject = paramList1.get(i);
      paramList2.qwh = localObject;
      if (this.qvZ.contains(localObject)) {}
      for (paramList2.qwi = m.a.qwe;; paramList2.qwi = m.a.qwd)
      {
        this.qwa.add(paramList2);
        i += 1;
        break;
      }
    }
    this.qvY.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.qvY.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    bVm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */