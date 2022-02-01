package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends a
{
  private static void acP(int paramInt)
  {
    AppMethodBeat.i(30100);
    aaq localaaq = new aaq();
    localaaq.ehD.dDe = paramInt;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(30100);
  }
  
  public final List<Integer> fWe()
  {
    AppMethodBeat.i(30098);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11028));
    localArrayList.add(Integer.valueOf(11027));
    AppMethodBeat.o(30098);
    return localArrayList;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30099);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30099);
      return null;
      acP(1);
      continue;
      acP(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.o
 * JD-Core Version:    0.7.0.1
 */