package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class b
{
  public static void fxU()
  {
    AppMethodBeat.i(91001);
    try
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(990);
      localIDKey1.SetValue(1L);
      localIDKey1.SetKey(0);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(990);
      localIDKey2.SetValue(1L);
      localIDKey2.SetKey(1);
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.CyF.b(localArrayList, false);
      AppMethodBeat.o(91001);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(91001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.a.b
 * JD-Core Version:    0.7.0.1
 */