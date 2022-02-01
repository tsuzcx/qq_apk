package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.edb;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.protocal.protobuf.edj;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String DxA = "";
  
  protected final boolean VT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean VU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> eKN()
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
      Object localObject2 = new edb();
      try
      {
        ((edb)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new edc();
        ((edc)localObject1).HOR = ((edb)localObject2).HOR;
        if (((edc)localObject1).HOR) {
          ba.aBQ();
        }
        for (paramArrayOfByte = c.azs().g(((edb)localObject2).Username, ((edb)localObject2).HfW, 11);; paramArrayOfByte = c.azs().f(((edb)localObject2).Username, ((edb)localObject2).HfW, 11))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (bu)paramArrayOfByte.get(paramInt);
            ((edc)localObject1).GDO.add(h.aE((bu)localObject2));
            paramInt += 1;
          }
          ba.aBQ();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((edc)localObject1).GAQ = bool;
          try
          {
            paramArrayOfByte = ((edc)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.DxA = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.iP(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.VS(8);
        localObject1 = new edg();
        try
        {
          ((edg)localObject1).parseFrom(paramArrayOfByte);
          if (bt.isNullOrNil(((edg)localObject1).Username))
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
        this.DxA = ((edg)localObject1).Username;
        paramArrayOfByte = new edh();
        ba.aBQ();
        localObject1 = c.azs().f(((edg)localObject1).Username, ((edg)localObject1).HfW, 11);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (bu)((List)localObject1).get(paramInt);
          paramArrayOfByte.GDO.add(h.aE((bu)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.GAQ = bool;
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
        com.tencent.mm.plugin.wear.model.c.a.iP(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.VS(14);
        localObject1 = new edj();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((edj)localObject1).parseFrom(paramArrayOfByte);
          label498:
          ba.aBQ();
          paramArrayOfByte = c.azs().xY(((edj)localObject1).FAf);
          localObject2 = new edk();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((edk)localObject2).HPb = q.f(str, 0, true);
          ((edk)localObject2).FAf = ((edj)localObject1).FAf;
          ((edk)localObject2).Fyu = new b(com.tencent.mm.vfs.i.aY(str, 0, -1));
          s.ab(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((edk)localObject2).toByteArray();
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