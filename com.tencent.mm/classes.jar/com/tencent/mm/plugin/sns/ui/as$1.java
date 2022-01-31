package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class as$1
  implements at.b
{
  as$1(as paramas, as.c paramc) {}
  
  public final void a(List<n> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
    as localas = this.pbW;
    y.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    y.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    localas.list.clear();
    localas.oMs.clear();
    localas.oMt.clear();
    localas.pbK.clear();
    int i = 0;
    while (i < j)
    {
      n localn = n.A((n)paramList.get(i));
      localas.list.add(localn);
      i += 1;
    }
    paramList = paramMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
      localas.oMs.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      localas.oMt.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      localas.pbK.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (localas.bMo)
    {
      if (localas.list.size() <= 1) {}
      for (i = 2147483647;; i = ((n)localas.list.get(1)).field_head)
      {
        localas.pbP = 0;
        j = 0;
        while (j < localas.list.size())
        {
          if ((!localas.bMo) || (j != 0))
          {
            if (i != ((n)localas.list.get(j)).field_head) {
              break;
            }
            localas.pbP = Math.max(localas.pbP, ((n)localas.list.get(j)).field_createTime);
          }
          j += 1;
        }
      }
    }
    if (localas.list.isEmpty()) {}
    for (i = 2147483647;; i = ((n)localas.list.get(0)).field_head) {
      break;
    }
    if ((localas.list.isEmpty()) || ((localas.bMo) && (localas.list.size() == 1))) {
      localas.pbP = 2147483647;
    }
    if (localas.list.isEmpty()) {}
    for (i = 0;; i = ((n)localas.list.get(localas.list.size() - 1)).field_head)
    {
      localas.pbQ = 2147483647;
      j = localas.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((n)localas.list.get(j)).field_head))
      {
        localas.pbQ = Math.min(localas.pbQ, ((n)localas.list.get(j)).field_createTime);
        j -= 1;
      }
    }
    if (localas.list.isEmpty()) {
      localas.pbQ = 0;
    }
    localas.oMv = paramInt1;
    localas.oMu = paramInt2;
    y.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + localas.pbP + " edTIme " + localas.pbQ);
    localas.notifyDataSetChanged();
  }
  
  public final void bJk()
  {
    this.pbW.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.1
 * JD-Core Version:    0.7.0.1
 */