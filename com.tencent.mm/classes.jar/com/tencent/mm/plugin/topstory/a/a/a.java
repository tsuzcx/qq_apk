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
    if (paramb.zZD > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(0);
      localIDKey.SetValue(paramb.zZD);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.wTc.b(localArrayList, false);
    }
    if (paramb.zZu > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(2);
      localIDKey.SetValue(paramb.zZu);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(3);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.wTc.b(localArrayList, false);
    }
    if (paramb.zZE > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(4);
      localIDKey.SetValue(paramb.zZE);
      localArrayList.add(localIDKey);
      paramb = new IDKey();
      paramb.SetID(ID);
      paramb.SetKey(5);
      paramb.SetValue(1L);
      localArrayList.add(paramb);
      e.wTc.b(localArrayList, false);
    }
    AppMethodBeat.o(91000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.a
 * JD-Core Version:    0.7.0.1
 */