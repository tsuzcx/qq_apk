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
    if (paramb.Brp > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(0);
      localIDKey.SetValue(paramb.Brp);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.ygI.b(localArrayList, false);
    }
    if (paramb.Brg > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(2);
      localIDKey.SetValue(paramb.Brg);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(3);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.ygI.b(localArrayList, false);
    }
    if (paramb.Brq > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(4);
      localIDKey.SetValue(paramb.Brq);
      localArrayList.add(localIDKey);
      paramb = new IDKey();
      paramb.SetID(ID);
      paramb.SetKey(5);
      paramb.SetValue(1L);
      localArrayList.add(paramb);
      e.ygI.b(localArrayList, false);
    }
    AppMethodBeat.o(91000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.a
 * JD-Core Version:    0.7.0.1
 */