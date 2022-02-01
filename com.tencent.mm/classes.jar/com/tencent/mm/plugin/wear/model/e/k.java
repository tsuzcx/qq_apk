package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> eKN()
  {
    AppMethodBeat.i(30089);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11011));
    localArrayList.add(Integer.valueOf(11010));
    AppMethodBeat.o(30089);
    return localArrayList;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30090);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30090);
      return null;
      Object localObject = new edf();
      try
      {
        ((edf)localObject).parseFrom(paramArrayOfByte);
        label50:
        com.tencent.mm.plugin.wear.model.a.eKt().fq(((edf)localObject).Hnp, ((edf)localObject).Hrp);
        AppMethodBeat.o(30090);
        return null;
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf8");
          ba.aBQ();
          localObject = c.azp().Bf(paramArrayOfByte);
          if (w.vF(paramArrayOfByte))
          {
            ba.aBQ();
            localObject = c.azp().Bf(paramArrayOfByte);
            ((am)localObject).ki(0);
            ba.aBQ();
            c.azp().c(paramArrayOfByte, (am)localObject);
            ba.aBQ();
            c.azo().c(new com.tencent.mm.chatroom.f.a(paramArrayOfByte, 0));
            com.tencent.mm.plugin.wear.model.c.a.iP(4, 0);
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte = "";
            continue;
            w.s((am)localObject);
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        break label50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.k
 * JD-Core Version:    0.7.0.1
 */