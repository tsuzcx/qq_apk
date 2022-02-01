package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eza;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.ezg;
import com.tencent.mm.protocal.protobuf.ezi;
import com.tencent.mm.protocal.protobuf.ezj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String Iyv = "";
  
  protected final boolean afg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean afh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> fWe()
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
      Object localObject2 = new eza();
      try
      {
        ((eza)localObject2).parseFrom(paramArrayOfByte);
        localObject1 = new ezb();
        ((ezb)localObject1).NvC = ((eza)localObject2).NvC;
        if (((ezb)localObject1).NvC) {
          bg.aVF();
        }
        for (paramArrayOfByte = c.aSQ().g(((eza)localObject2).Username, ((eza)localObject2).MKf, 11);; paramArrayOfByte = c.aSQ().f(((eza)localObject2).Username, ((eza)localObject2).MKf, 11))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (ca)paramArrayOfByte.get(paramInt);
            ((ezb)localObject1).Mcg.add(h.aP((ca)localObject2));
            paramInt += 1;
          }
          bg.aVF();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((ezb)localObject1).LYI = bool;
          try
          {
            paramArrayOfByte = ((ezb)localObject1).toByteArray();
            AppMethodBeat.o(30088);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.Iyv = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.jZ(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.aff(8);
        localObject1 = new ezf();
        try
        {
          ((ezf)localObject1).parseFrom(paramArrayOfByte);
          if (Util.isNullOrNil(((ezf)localObject1).Username))
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
        this.Iyv = ((ezf)localObject1).Username;
        paramArrayOfByte = new ezg();
        bg.aVF();
        localObject1 = c.aSQ().f(((ezf)localObject1).Username, ((ezf)localObject1).MKf, 11);
        paramInt = 0;
        while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = (ca)((List)localObject1).get(paramInt);
          paramArrayOfByte.Mcg.add(h.aP((ca)localObject2));
          paramInt += 1;
        }
        if (((List)localObject1).size() > 10) {}
        for (;;)
        {
          paramArrayOfByte.LYI = bool;
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
        com.tencent.mm.plugin.wear.model.c.a.jZ(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.aff(14);
        localObject1 = new ezi();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((ezi)localObject1).parseFrom(paramArrayOfByte);
          label498:
          bg.aVF();
          paramArrayOfByte = c.aSQ().Hb(((ezi)localObject1).KMm);
          localObject2 = new ezj();
          String str = com.tencent.mm.modelvoice.s.getFullPath(paramArrayOfByte.field_imgPath);
          ((ezj)localObject2).NvM = q.g(str, 0, true);
          ((ezj)localObject2).KMm = ((ezi)localObject1).KMm;
          ((ezj)localObject2).KKz = new b(com.tencent.mm.vfs.s.aW(str, 0, -1));
          com.tencent.mm.modelvoice.s.ak(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((ezj)localObject2).toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */