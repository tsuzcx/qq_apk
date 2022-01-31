package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import java.util.ArrayList;

public final class a
{
  public static int ID = 845;
  
  public static void a(com.tencent.mm.plugin.topstory.a.b.a parama)
  {
    AppMethodBeat.i(96378);
    ArrayList localArrayList;
    IDKey localIDKey;
    if (parama.tfe > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(0);
      localIDKey.SetValue(parama.tfe);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.qrI.b(localArrayList, false);
    }
    if (parama.teV > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(2);
      localIDKey.SetValue(parama.teV);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(3);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      e.qrI.b(localArrayList, false);
    }
    if (parama.tff > 0L)
    {
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(ID);
      localIDKey.SetKey(4);
      localIDKey.SetValue(parama.tff);
      localArrayList.add(localIDKey);
      parama = new IDKey();
      parama.SetID(ID);
      parama.SetKey(5);
      parama.SetValue(1L);
      localArrayList.add(parama);
      e.qrI.b(localArrayList, false);
    }
    AppMethodBeat.o(96378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.a
 * JD-Core Version:    0.7.0.1
 */