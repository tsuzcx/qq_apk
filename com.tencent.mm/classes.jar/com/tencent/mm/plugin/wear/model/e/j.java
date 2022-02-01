package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.fjr;
import com.tencent.mm.protocal.protobuf.fjs;
import com.tencent.mm.protocal.protobuf.fjw;
import com.tencent.mm.protocal.protobuf.fjx;
import com.tencent.mm.protocal.protobuf.fjz;
import com.tencent.mm.protocal.protobuf.fka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String Psy = "";
  
  protected final boolean amU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean amV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> gON()
  {
    AppMethodBeat.i(30087);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11019));
    localArrayList.add(Integer.valueOf(11020));
    localArrayList.add(Integer.valueOf(11021));
    localArrayList.add(Integer.valueOf(11031));
    AppMethodBeat.o(30087);
    return localArrayList;
  }
  
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(30088);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30088);
      return null;
      Object localObject2 = new fjr();
      try
      {
        ((fjr)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new fjs();
        ((fjs)localObject1).UIN = ((fjr)localObject2).UIN;
        if (((fjs)localObject1).UIN) {
          bh.beI();
        }
        for (paramArrayOfByte = c.bbO().h(((fjr)localObject2).Username, ((fjr)localObject2).TVZ, 11);; paramArrayOfByte = c.bbO().g(((fjr)localObject2).Username, ((fjr)localObject2).TVZ, 11))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (ca)paramArrayOfByte.get(paramInt);
            ((fjs)localObject1).TlE.add(h.bd((ca)localObject2));
            paramInt += 1;
          }
          bh.beI();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((fjs)localObject1).Tic = bool;
          try
          {
            paramArrayOfByte = ((fjs)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.Psy = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.lp(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.amT(8);
        localObject1 = new fjw();
        try
        {
          ((fjw)localObject1).parseFrom(paramArrayOfByte);
          if (Util.isNullOrNil(((fjw)localObject1).Username))
          {
            AppMethodBeat.o(30088);
            return null;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          AppMethodBeat.o(30088);
          return null;
        }
        this.Psy = ((fjw)localObject1).Username;
        paramArrayOfByte = new fjx();
        bh.beI();
        localObject1 = c.bbO().g(((fjw)localObject1).Username, ((fjw)localObject1).TVZ, 11);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (ca)((List)localObject1).get(paramInt);
          paramArrayOfByte.TlE.add(h.bd((ca)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.Tic = bool;
          try
          {
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
          bool = false;
        }
        continue;
        com.tencent.mm.plugin.wear.model.c.a.lp(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.amT(14);
        localObject1 = new fjz();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((fjz)localObject1).parseFrom(paramArrayOfByte);
          label498:
          bh.beI();
          paramArrayOfByte = c.bbO().Oq(((fjz)localObject1).RNj);
          localObject2 = new fka();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((fka)localObject2).UIX = q.k(str, 0, true);
          ((fka)localObject2).RNj = ((fjz)localObject1).RNj;
          ((fka)localObject2).RLr = new b(u.aY(str, 0, -1));
          s.as(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((fka)localObject2).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(30088);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
        }
        catch (IOException paramArrayOfByte)
        {
          break label498;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */