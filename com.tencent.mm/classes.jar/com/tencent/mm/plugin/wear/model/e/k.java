package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26407);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11011));
    localArrayList.add(Integer.valueOf(11010));
    AppMethodBeat.o(26407);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26408);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26408);
      return null;
      Object localObject = new cxk();
      try
      {
        ((cxk)localObject).parseFrom(paramArrayOfByte);
        label50:
        com.tencent.mm.plugin.wear.model.a.cYy().uGE.dH(((cxk)localObject).xlH, ((cxk)localObject).xLK);
        AppMethodBeat.o(26408);
        return null;
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf8");
          aw.aaz();
          localObject = c.YA().arw(paramArrayOfByte);
          if (t.lA(paramArrayOfByte))
          {
            aw.aaz();
            localObject = c.YA().arw(paramArrayOfByte);
            ((ad)localObject).hB(0);
            aw.aaz();
            c.YA().b(paramArrayOfByte, (ad)localObject);
            aw.aaz();
            c.Yz().c(new b(paramArrayOfByte, 0));
            com.tencent.mm.plugin.wear.model.c.a.gD(4, 0);
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte = "";
            continue;
            t.o((ad)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.k
 * JD-Core Version:    0.7.0.1
 */