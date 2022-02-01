package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.eze;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends a
{
  public final List<Integer> fWe()
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
      Object localObject = new eze();
      try
      {
        ((eze)localObject).parseFrom(paramArrayOfByte);
        label50:
        com.tencent.mm.plugin.wear.model.a.fVK().gc(((eze)localObject).MRZ, ((eze)localObject).MWA);
        AppMethodBeat.o(30090);
        return null;
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf8");
          bg.aVF();
          localObject = c.aSN().Kn(paramArrayOfByte);
          if (ab.Eq(paramArrayOfByte))
          {
            bg.aVF();
            localObject = c.aSN().Kn(paramArrayOfByte);
            ((as)localObject).nm(0);
            bg.aVF();
            c.aSN().c(paramArrayOfByte, (as)localObject);
            bg.aVF();
            c.aSM().d(new com.tencent.mm.chatroom.f.a(paramArrayOfByte, 0));
            com.tencent.mm.plugin.wear.model.c.a.jZ(4, 0);
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte = "";
            continue;
            ab.z((as)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.k
 * JD-Core Version:    0.7.0.1
 */