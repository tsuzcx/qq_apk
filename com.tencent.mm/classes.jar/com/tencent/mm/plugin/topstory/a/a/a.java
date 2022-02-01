package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import java.util.ArrayList;

public final class a
{
  public static int ID = 845;
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(91000);
    ArrayList localArrayList;
    IDKey localIDKey;
    if (paramb.yLK > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(0);
      localIDKey.SetValue(paramb.yLK);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.vIY.b(localArrayList, false);
    }
    if (paramb.yLB > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(2);
      localIDKey.SetValue(paramb.yLB);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(3);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.vIY.b(localArrayList, false);
    }
    if (paramb.yLL > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(4);
      localIDKey.SetValue(paramb.yLL);
      localArrayList.add(localIDKey);
      paramb = new IDKey();
      paramb.SetID(ID);
      paramb.SetKey(5);
      paramb.SetValue(1L);
      localArrayList.add(paramb);
      e.vIY.b(localArrayList, false);
    }
    AppMethodBeat.o(91000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.a
 * JD-Core Version:    0.7.0.1
 */