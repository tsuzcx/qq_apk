package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.plugin.wallet_core.ui.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class r<K>
{
  List<String> uiA = new LinkedList();
  Map<String, Integer> uix = new HashMap();
  List<K> uiy = new LinkedList();
  public Vector<r<K>.b> uiz = new Vector();
  
  private void cTH()
  {
    int i = 0;
    int j;
    if (i < this.uiz.size()) {
      if (((r.b)this.uiz.get(i)).uiH != r.a.uiD)
      {
        Object localObject = a(this.uiz, i);
        if (this.uix.containsKey(localObject)) {
          break label158;
        }
        localObject = b.afE((String)localObject);
        j = 0;
        label67:
        if (j >= this.uiA.size()) {
          break label153;
        }
        k = 0;
        label82:
        if (k >= localObject.length) {
          break label170;
        }
        if (((String)this.uiA.get(j)).contains(localObject[k])) {
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
        a(i, r.a.uiC);
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
        a(i, r.a.uiE);
      }
      return;
    }
  }
  
  public abstract String a(Vector<r<K>.b> paramVector, int paramInt);
  
  public final void a(int paramInt, r.a parama)
  {
    ((r.b)this.uiz.get(paramInt)).uiH = parama;
  }
  
  public final void d(List<K> paramList1, List<K> paramList2, List<String> paramList)
  {
    this.uiA = paramList;
    this.uiy = paramList2;
    this.uiz.clear();
    this.uiz = new Vector(paramList1.size());
    int i = 0;
    if (i < paramList1.size())
    {
      paramList2 = new r.b(this);
      Object localObject = paramList1.get(i);
      paramList2.uiG = localObject;
      if (this.uiy.contains(localObject)) {}
      for (paramList2.uiH = r.a.uiD;; paramList2.uiH = r.a.uiC)
      {
        this.uiz.add(paramList2);
        i += 1;
        break;
      }
    }
    this.uix.clear();
    i = 0;
    while (i < paramList.size())
    {
      this.uix.put(paramList.get(i), Integer.valueOf(0));
      i += 1;
    }
    cTH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */