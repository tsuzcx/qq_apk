package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yj;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends a
{
  private static void RX(int paramInt)
  {
    AppMethodBeat.i(30100);
    yj localyj = new yj();
    localyj.dBX.cZu = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localyj);
    AppMethodBeat.o(30100);
  }
  
  public final List<Integer> ewH()
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
      RX(1);
      continue;
      RX(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.o
 * JD-Core Version:    0.7.0.1
 */