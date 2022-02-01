package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ees;
import com.tencent.mm.protocal.protobuf.eet;
import com.tencent.mm.protocal.protobuf.eex;
import com.tencent.mm.protocal.protobuf.eey;
import com.tencent.mm.protocal.protobuf.efa;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String DPf = "";
  
  protected final boolean WA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean WB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> eOv()
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
      Object localObject2 = new ees();
      try
      {
        ((ees)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new eet();
        ((eet)localObject1).IiY = ((ees)localObject2).IiY;
        if (((eet)localObject1).IiY) {
          bc.aCg();
        }
        for (paramArrayOfByte = c.azI().g(((ees)localObject2).Username, ((ees)localObject2).Hzw, 11);; paramArrayOfByte = c.azI().f(((ees)localObject2).Username, ((ees)localObject2).Hzw, 11))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (bv)paramArrayOfByte.get(paramInt);
            ((eet)localObject1).GXr.add(h.aD((bv)localObject2));
            paramInt += 1;
          }
          bc.aCg();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((eet)localObject1).GUq = bool;
          try
          {
            paramArrayOfByte = ((eet)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.DPf = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.iT(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.Wz(8);
        localObject1 = new eex();
        try
        {
          ((eex)localObject1).parseFrom(paramArrayOfByte);
          if (bu.isNullOrNil(((eex)localObject1).Username))
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
        this.DPf = ((eex)localObject1).Username;
        paramArrayOfByte = new eey();
        bc.aCg();
        localObject1 = c.azI().f(((eex)localObject1).Username, ((eex)localObject1).Hzw, 11);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (bv)((List)localObject1).get(paramInt);
          paramArrayOfByte.GXr.add(h.aD((bv)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.GUq = bool;
          try
          {
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
          bool = false;
        }
        continue;
        com.tencent.mm.plugin.wear.model.c.a.iT(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.Wz(14);
        localObject1 = new efa();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((efa)localObject1).parseFrom(paramArrayOfByte);
          label498:
          bc.aCg();
          paramArrayOfByte = c.azI().ys(((efa)localObject1).FSD);
          localObject2 = new efb();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((efb)localObject2).Iji = q.f(str, 0, true);
          ((efb)localObject2).FSD = ((efa)localObject1).FSD;
          ((efb)localObject2).FQS = new b(o.bb(str, 0, -1));
          s.aa(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((efb)localObject2).toByteArray();
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