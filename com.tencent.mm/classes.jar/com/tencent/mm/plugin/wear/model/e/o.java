package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zd;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends a
{
  private static void TP(int paramInt)
  {
    AppMethodBeat.i(30100);
    zd localzd = new zd();
    localzd.dOk.dkM = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localzd);
    AppMethodBeat.o(30100);
  }
  
  public final List<Integer> eKN()
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
      TP(1);
      continue;
      TP(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.o
 * JD-Core Version:    0.7.0.1
 */