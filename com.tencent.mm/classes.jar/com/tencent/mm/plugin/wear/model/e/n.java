package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends a
{
  public final List<Integer> ewH()
  {
    AppMethodBeat.i(30096);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11033));
    localArrayList.add(Integer.valueOf(11030));
    AppMethodBeat.o(30096);
    return localArrayList;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30097);
    switch (paramInt)
    {
    case 11031: 
    case 11032: 
    default: 
      AppMethodBeat.o(30097);
      return null;
    case 11030: 
      paramArrayOfByte = h.aAj("wechatvoicesilk");
      AppMethodBeat.o(30097);
      return paramArrayOfByte;
    }
    paramArrayOfByte = h.aAj("stlport_shared");
    AppMethodBeat.o(30097);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.n
 * JD-Core Version:    0.7.0.1
 */