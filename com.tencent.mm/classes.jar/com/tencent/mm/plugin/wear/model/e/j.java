package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String AEN = "";
  
  protected final boolean RR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean RS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> ehn()
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
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
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
      Object localObject2 = new drk();
      try
      {
        ((drk)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new drl();
        ((drl)localObject1).EGz = ((drk)localObject2).EGz;
        if (((drl)localObject1).EGz) {
          az.arV();
        }
        for (paramArrayOfByte = c.apO().aH(((drk)localObject2).Username, ((drk)localObject2).DYU);; paramArrayOfByte = c.apO().aG(((drk)localObject2).Username, ((drk)localObject2).DYU))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (bl)paramArrayOfByte.get(paramInt);
            ((drl)localObject1).DyV.add(com.tencent.mm.plugin.wear.model.h.az((bl)localObject2));
            paramInt += 1;
          }
          az.arV();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((drl)localObject1).Dwd = bool;
          try
          {
            paramArrayOfByte = ((drl)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.AEN = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.in(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.RQ(8);
        localObject1 = new drp();
        try
        {
          ((drp)localObject1).parseFrom(paramArrayOfByte);
          if (bt.isNullOrNil(((drp)localObject1).Username))
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
        this.AEN = ((drp)localObject1).Username;
        paramArrayOfByte = new drq();
        az.arV();
        localObject1 = c.apO().aG(((drp)localObject1).Username, ((drp)localObject1).DYU);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (bl)((List)localObject1).get(paramInt);
          paramArrayOfByte.DyV.add(com.tencent.mm.plugin.wear.model.h.az((bl)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.Dwd = bool;
          try
          {
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
          bool = false;
        }
        continue;
        com.tencent.mm.plugin.wear.model.c.a.in(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.RQ(14);
        localObject1 = new drs();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((drs)localObject1).parseFrom(paramArrayOfByte);
          label492:
          az.arV();
          paramArrayOfByte = c.apO().rm(((drs)localObject1).CCn);
          localObject2 = new drt();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((drt)localObject2).EGJ = q.f(str, 0, true);
          ((drt)localObject2).CCn = ((drs)localObject1).CCn;
          ((drt)localObject2).CAF = new b(i.aR(str, 0, -1));
          s.Y(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((drt)localObject2).toByteArray();
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
          break label492;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */