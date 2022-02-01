package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.eew;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> eOv()
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
      Object localObject = new eew();
      try
      {
        ((eew)localObject).parseFrom(paramArrayOfByte);
        label50:
        com.tencent.mm.plugin.wear.model.a.eOb().fz(((eew)localObject).HGP, ((eew)localObject).HKR);
        AppMethodBeat.o(30090);
        return null;
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf8");
          bc.aCg();
          localObject = c.azF().BH(paramArrayOfByte);
          if (x.wb(paramArrayOfByte))
          {
            bc.aCg();
            localObject = c.azF().BH(paramArrayOfByte);
            ((an)localObject).kk(0);
            bc.aCg();
            c.azF().c(paramArrayOfByte, (an)localObject);
            bc.aCg();
            c.azE().d(new com.tencent.mm.chatroom.f.a(paramArrayOfByte, 0));
            com.tencent.mm.plugin.wear.model.c.a.iT(4, 0);
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte = "";
            continue;
            x.z((an)localObject);
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