package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.ggj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30089);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11011));
    localArrayList.add(Integer.valueOf(11010));
    AppMethodBeat.o(30089);
    return localArrayList;
  }
  
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30090);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30090);
      return null;
      Object localObject = new ggj();
      try
      {
        ((ggj)localObject).parseFrom(paramArrayOfByte);
        label50:
        com.tencent.mm.plugin.wear.model.a.inG().hI(((ggj)localObject).abvu, ((ggj)localObject).abAu);
        AppMethodBeat.o(30090);
        return null;
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf8");
          bh.bCz();
          localObject = c.bzA().JE(paramArrayOfByte);
          if (au.bwE(paramArrayOfByte))
          {
            bh.bCz();
            localObject = c.bzA().JE(paramArrayOfByte);
            ((au)localObject).pz(0);
            bh.bCz();
            c.bzA().d(paramArrayOfByte, (au)localObject);
            bh.bCz();
            c.bzz().d(new com.tencent.mm.chatroom.f.a(paramArrayOfByte, 0));
            com.tencent.mm.plugin.wear.model.c.a.kK(4, 0);
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte = "";
            continue;
            ab.G((au)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.k
 * JD-Core Version:    0.7.0.1
 */