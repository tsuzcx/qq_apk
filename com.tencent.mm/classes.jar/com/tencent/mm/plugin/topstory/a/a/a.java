package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.topstory.a.b.b;
import java.util.ArrayList;

public final class a
{
  public static int hjP = 845;
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(91000);
    ArrayList localArrayList;
    IDKey localIDKey;
    if (paramb.TIM > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(hjP);
      localIDKey.SetKey(0);
      localIDKey.SetValue(paramb.TIM);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(hjP);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      f.Ozc.b(localArrayList, false);
    }
    if (paramb.TID > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(hjP);
      localIDKey.SetKey(2);
      localIDKey.SetValue(paramb.TID);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(hjP);
      localIDKey.SetKey(3);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      f.Ozc.b(localArrayList, false);
    }
    if (paramb.TIN > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(hjP);
      localIDKey.SetKey(4);
      localIDKey.SetValue(paramb.TIN);
      localArrayList.add(localIDKey);
      paramb = new IDKey();
      paramb.SetID(hjP);
      paramb.SetKey(5);
      paramb.SetValue(1L);
      localArrayList.add(paramb);
      f.Ozc.b(localArrayList, false);
    }
    AppMethodBeat.o(91000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.a
 * JD-Core Version:    0.7.0.1
 */