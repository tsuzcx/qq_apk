package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xy;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends a
{
  private static void PO(int paramInt)
  {
    AppMethodBeat.i(30100);
    xy localxy = new xy();
    localxy.dEl.dbV = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localxy);
    AppMethodBeat.o(30100);
  }
  
  public final List<Integer> ehn()
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
      PO(1);
      continue;
      PO(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.o
 * JD-Core Version:    0.7.0.1
 */