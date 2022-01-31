package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class at$1
  implements au.b
{
  at$1(at paramat, at.c paramc) {}
  
  public final void a(List<n> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39200);
    ab.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
    at localat = this.rUG;
    ab.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(39200);
      return;
    }
    ab.d("MicroMsg.SnsphotoAdapter", "copy list info");
    int j = paramList.size();
    localat.list.clear();
    localat.rEd.clear();
    localat.rEe.clear();
    localat.rUu.clear();
    int i = 0;
    while (i < j)
    {
      n localn = n.z((n)paramList.get(i));
      localat.list.add(localn);
      i += 1;
    }
    paramList = paramMap1.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap1.get(Integer.valueOf(i))).intValue();
      localat.rEd.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap2.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap2.get(Integer.valueOf(i))).intValue();
      localat.rEe.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramList = paramMap3.keySet().iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      j = ((Integer)paramMap3.get(Integer.valueOf(i))).intValue();
      localat.rUu.put(Integer.valueOf(i), Integer.valueOf(j));
    }
    paramMap1.clear();
    paramMap2.clear();
    if (localat.ctJ)
    {
      if (localat.list.size() <= 1) {}
      for (i = 2147483647;; i = ((n)localat.list.get(1)).field_head)
      {
        localat.rUz = 0;
        j = 0;
        while (j < localat.list.size())
        {
          if ((!localat.ctJ) || (j != 0))
          {
            if (i != ((n)localat.list.get(j)).field_head) {
              break;
            }
            localat.rUz = Math.max(localat.rUz, ((n)localat.list.get(j)).field_createTime);
          }
          j += 1;
        }
      }
    }
    if (localat.list.isEmpty()) {}
    for (i = 2147483647;; i = ((n)localat.list.get(0)).field_head) {
      break;
    }
    if ((localat.list.isEmpty()) || ((localat.ctJ) && (localat.list.size() == 1))) {
      localat.rUz = 2147483647;
    }
    if (localat.list.isEmpty()) {}
    for (i = 0;; i = ((n)localat.list.get(localat.list.size() - 1)).field_head)
    {
      localat.rUA = 2147483647;
      j = localat.list.size() - 1;
      while ((j >= 0) && (i != 0) && (i == ((n)localat.list.get(j)).field_head))
      {
        localat.rUA = Math.min(localat.rUA, ((n)localat.list.get(j)).field_createTime);
        j -= 1;
      }
    }
    if (localat.list.isEmpty()) {
      localat.rUA = 0;
    }
    localat.rEg = paramInt1;
    localat.rEf = paramInt2;
    ab.d("MicroMsg.SnsphotoAdapter", "reallyCount " + paramInt1 + " icount " + paramInt2 + " stTime " + localat.rUz + " edTIme " + localat.rUA);
    localat.notifyDataSetChanged();
    AppMethodBeat.o(39200);
  }
  
  public final void cvM()
  {
    AppMethodBeat.i(39201);
    this.rUG.notifyDataSetChanged();
    AppMethodBeat.o(39201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.1
 * JD-Core Version:    0.7.0.1
 */