package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n
  extends a
{
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26414);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11033));
    localArrayList.add(Integer.valueOf(11030));
    AppMethodBeat.o(26414);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26415);
    switch (paramInt)
    {
    case 11031: 
    case 11032: 
    default: 
      AppMethodBeat.o(26415);
      return null;
    case 11030: 
      if (new String(paramArrayOfByte).equals("arm_v7"))
      {
        paramArrayOfByte = h.agh("wechatvoicesilk_v7a");
        AppMethodBeat.o(26415);
        return paramArrayOfByte;
      }
      paramArrayOfByte = h.agh("wechatvoicesilk");
      AppMethodBeat.o(26415);
      return paramArrayOfByte;
    }
    paramArrayOfByte = h.agh("stlport_shared");
    AppMethodBeat.o(26415);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.n
 * JD-Core Version:    0.7.0.1
 */