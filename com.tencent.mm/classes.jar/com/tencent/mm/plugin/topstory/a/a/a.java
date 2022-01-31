package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.f;
import java.util.ArrayList;

public final class a
{
  public static int bxH = 845;
  
  public static void a(com.tencent.mm.plugin.topstory.a.b.a parama)
  {
    ArrayList localArrayList;
    IDKey localIDKey;
    if (parama.pDp > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(bxH);
      localIDKey.SetKey(0);
      localIDKey.SetValue(parama.pDp);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(bxH);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      f.nEG.b(localArrayList, false);
    }
    if (parama.pDg > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(bxH);
      localIDKey.SetKey(2);
      localIDKey.SetValue(parama.pDg);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(bxH);
      localIDKey.SetKey(3);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      f.nEG.b(localArrayList, false);
    }
    if (parama.pDq > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(bxH);
      localIDKey.SetKey(4);
      localIDKey.SetValue(parama.pDq);
      localArrayList.add(localIDKey);
      parama = new IDKey();
      parama.SetID(bxH);
      parama.SetKey(5);
      parama.SetValue(1L);
      localArrayList.add(parama);
      f.nEG.b(localArrayList, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.a
 * JD-Core Version:    0.7.0.1
 */