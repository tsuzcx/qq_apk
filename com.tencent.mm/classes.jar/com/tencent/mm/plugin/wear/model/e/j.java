package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ggf;
import com.tencent.mm.protocal.protobuf.ggg;
import com.tencent.mm.protocal.protobuf.ggk;
import com.tencent.mm.protocal.protobuf.ggl;
import com.tencent.mm.protocal.protobuf.ggn;
import com.tencent.mm.protocal.protobuf.ggo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String Wjl = "";
  
  protected final boolean asL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean asM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> iob()
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
  
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
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
      Object localObject2 = new ggf();
      try
      {
        ((ggf)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new ggg();
        ((ggg)localObject1).accV = ((ggf)localObject2).accV;
        if (((ggg)localObject1).accV) {
          bh.bCz();
        }
        for (paramArrayOfByte = c.bzD().j(((ggf)localObject2).Username, ((ggf)localObject2).abmO, 11);; paramArrayOfByte = c.bzD().i(((ggf)localObject2).Username, ((ggf)localObject2).abmO, 11))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (cc)paramArrayOfByte.get(paramInt);
            ((ggg)localObject1).aazx.add(h.bv((cc)localObject2));
            paramInt += 1;
          }
          bh.bCz();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((ggg)localObject1).aavs = bool;
          try
          {
            paramArrayOfByte = ((ggg)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.Wjl = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.kK(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.asK(8);
        localObject1 = new ggk();
        try
        {
          ((ggk)localObject1).parseFrom(paramArrayOfByte);
          if (Util.isNullOrNil(((ggk)localObject1).Username))
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
        this.Wjl = ((ggk)localObject1).Username;
        paramArrayOfByte = new ggl();
        bh.bCz();
        localObject1 = c.bzD().i(((ggk)localObject1).Username, ((ggk)localObject1).abmO, 11);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (cc)((List)localObject1).get(paramInt);
          paramArrayOfByte.aazx.add(h.bv((cc)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.aavs = bool;
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
        com.tencent.mm.plugin.wear.model.c.a.kK(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.asK(14);
        localObject1 = new ggn();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((ggn)localObject1).parseFrom(paramArrayOfByte);
          label498:
          bh.bCz();
          paramArrayOfByte = c.bzD().sl(((ggn)localObject1).YKx);
          localObject2 = new ggo();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((ggo)localObject2).acdf = q.l(str, 0, true);
          ((ggo)localObject2).YKx = ((ggn)localObject1).YKx;
          ((ggo)localObject2).YID = new b(y.bi(str, 0, -1));
          s.ay(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((ggo)localObject2).toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */