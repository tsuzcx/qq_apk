package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String uHI = "";
  
  protected final boolean IS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean IT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26405);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11019));
    localArrayList.add(Integer.valueOf(11020));
    localArrayList.add(Integer.valueOf(11021));
    localArrayList.add(Integer.valueOf(11031));
    AppMethodBeat.o(26405);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(26406);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26406);
      return null;
      Object localObject2 = new cxg();
      try
      {
        ((cxg)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new cxh();
        ((cxh)localObject1).yeP = ((cxg)localObject2).yeP;
        if (((cxh)localObject1).yeP) {
          aw.aaz();
        }
        for (paramArrayOfByte = c.YC().ak(((cxg)localObject2).Username, ((cxg)localObject2).xCj);; paramArrayOfByte = c.YC().aj(((cxg)localObject2).Username, ((cxg)localObject2).xCj))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (bi)paramArrayOfByte.get(paramInt);
            ((cxh)localObject1).xfZ.add(com.tencent.mm.plugin.wear.model.h.aj((bi)localObject2));
            paramInt += 1;
          }
          aw.aaz();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((cxh)localObject1).xKI = bool;
          try
          {
            paramArrayOfByte = ((cxh)localObject1).toByteArray();
            AppMethodBeat.o(26406);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ab.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.uHI = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.gD(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.IR(8);
        localObject1 = new cxl();
        try
        {
          ((cxl)localObject1).parseFrom(paramArrayOfByte);
          this.uHI = ((cxl)localObject1).Username;
          paramArrayOfByte = new cxm();
          aw.aaz();
          localObject1 = c.YC().aj(((cxl)localObject1).Username, ((cxl)localObject1).xCj);
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
          {
            localObject2 = (bi)((List)localObject1).get(paramInt);
            paramArrayOfByte.xfZ.add(com.tencent.mm.plugin.wear.model.h.aj((bi)localObject2));
            paramInt += 1;
          }
          if (((List)localObject1).size() <= 10) {}
        }
        catch (IOException paramArrayOfByte)
        {
          AppMethodBeat.o(26406);
          return null;
        }
        for (;;)
        {
          paramArrayOfByte.xKI = bool;
          try
          {
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            AppMethodBeat.o(26406);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ab.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
          bool = false;
        }
        continue;
        com.tencent.mm.plugin.wear.model.c.a.gD(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.IR(14);
        localObject1 = new cxo();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((cxo)localObject1).parseFrom(paramArrayOfByte);
          label473:
          aw.aaz();
          paramArrayOfByte = c.YC().kB(((cxo)localObject1).wsz);
          localObject2 = new cxp();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((cxp)localObject2).yeZ = q.g(str, 0, true);
          ((cxp)localObject2).wsz = ((cxo)localObject1).wsz;
          ((cxp)localObject2).wrr = new b(e.i(str, 0, -1));
          s.M(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((cxp)localObject2).toByteArray();
            AppMethodBeat.o(26406);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(26406);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
        }
        catch (IOException paramArrayOfByte)
        {
          break label473;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */