package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String BXh = "";
  
  protected final boolean Ub(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean Uc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> ewH()
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
      Object localObject2 = new dxb();
      try
      {
        ((dxb)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new dxc();
        ((dxc)localObject1).GdL = ((dxb)localObject2).GdL;
        if (((dxc)localObject1).GdL) {
          az.ayM();
        }
        for (paramArrayOfByte = c.awD().aJ(((dxb)localObject2).Username, ((dxb)localObject2).FvQ);; paramArrayOfByte = c.awD().aI(((dxb)localObject2).Username, ((dxb)localObject2).FvQ))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (bo)paramArrayOfByte.get(paramInt);
            ((dxc)localObject1).EUr.add(com.tencent.mm.plugin.wear.model.h.aB((bo)localObject2));
            paramInt += 1;
          }
          az.ayM();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((dxc)localObject1).ERy = bool;
          try
          {
            paramArrayOfByte = ((dxc)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ac.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.BXh = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.iC(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.Ua(8);
        localObject1 = new dxg();
        try
        {
          ((dxg)localObject1).parseFrom(paramArrayOfByte);
          if (bs.isNullOrNil(((dxg)localObject1).Username))
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
        this.BXh = ((dxg)localObject1).Username;
        paramArrayOfByte = new dxh();
        az.ayM();
        localObject1 = c.awD().aI(((dxg)localObject1).Username, ((dxg)localObject1).FvQ);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (bo)((List)localObject1).get(paramInt);
          paramArrayOfByte.EUr.add(com.tencent.mm.plugin.wear.model.h.aB((bo)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.ERy = bool;
          try
          {
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            ac.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
          bool = false;
        }
        continue;
        com.tencent.mm.plugin.wear.model.c.a.iC(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.Ua(14);
        localObject1 = new dxj();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((dxj)localObject1).parseFrom(paramArrayOfByte);
          label492:
          az.ayM();
          paramArrayOfByte = c.awD().vP(((dxj)localObject1).DUK);
          localObject2 = new dxk();
          String str = s.getFullPath(paramArrayOfByte.field_imgPath);
          ((dxk)localObject2).GdV = q.f(str, 0, true);
          ((dxk)localObject2).DUK = ((dxj)localObject1).DUK;
          ((dxk)localObject2).DTb = new b(i.aU(str, 0, -1));
          s.Y(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((dxk)localObject2).toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */