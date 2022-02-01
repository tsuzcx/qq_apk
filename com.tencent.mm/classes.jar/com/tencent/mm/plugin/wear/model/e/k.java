package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.f.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> ehn()
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
      Object localObject = new dro();
      try
      {
        ((dro)localObject).parseFrom(paramArrayOfByte);
        label50:
        com.tencent.mm.plugin.wear.model.a.egT().eP(((dro)localObject).Egc, ((dro)localObject).EjI);
        AppMethodBeat.o(30090);
        return null;
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf8");
          az.arV();
          localObject = c.apM().aHY(paramArrayOfByte);
          if (w.pF(paramArrayOfByte))
          {
            az.arV();
            localObject = c.apM().aHY(paramArrayOfByte);
            ((af)localObject).jM(0);
            az.arV();
            c.apM().c(paramArrayOfByte, (af)localObject);
            az.arV();
            c.apL().c(new b(paramArrayOfByte, 0));
            com.tencent.mm.plugin.wear.model.c.a.in(4, 0);
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte = "";
            continue;
            w.s((af)localObject);
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