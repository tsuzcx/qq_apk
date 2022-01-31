package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.bv.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cjt;
import com.tencent.mm.protocal.c.cju;
import com.tencent.mm.protocal.c.cjy;
import com.tencent.mm.protocal.c.cjz;
import com.tencent.mm.protocal.c.ckb;
import com.tencent.mm.protocal.c.ckc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  public String qSB = "";
  
  protected final boolean Bg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected final boolean Bh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11019));
    localArrayList.add(Integer.valueOf(11020));
    localArrayList.add(Integer.valueOf(11021));
    localArrayList.add(Integer.valueOf(11031));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      Object localObject2 = new cjt();
      try
      {
        ((cjt)localObject2).aH(paramArrayOfByte);
        localObject1 = new cju();
        ((cju)localObject1).tXy = ((cjt)localObject2).tXy;
        if (((cju)localObject1).tXy) {
          au.Hx();
        }
        for (paramArrayOfByte = c.Fy().S(((cjt)localObject2).sxM, ((cjt)localObject2).tAB);; paramArrayOfByte = c.Fy().R(((cjt)localObject2).sxM, ((cjt)localObject2).tAB))
        {
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < paramArrayOfByte.size()))
          {
            localObject2 = (bi)paramArrayOfByte.get(paramInt);
            ((cju)localObject1).thk.add(h.aa((bi)localObject2));
            paramInt += 1;
          }
          au.Hx();
        }
        if (paramArrayOfByte.size() > 10) {}
        for (bool = true;; bool = false)
        {
          ((cju)localObject1).tXg = bool;
          try
          {
            paramArrayOfByte = ((cju)localObject1).toByteArray();
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            y.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
        }
        continue;
        this.qSB = "";
        continue;
        com.tencent.mm.plugin.wear.model.c.a.ez(9, 0);
        com.tencent.mm.plugin.wear.model.c.a.Bf(8);
        localObject1 = new cjy();
        try
        {
          ((cjy)localObject1).aH(paramArrayOfByte);
          this.qSB = ((cjy)localObject1).sxM;
          paramArrayOfByte = new cjz();
          au.Hx();
          localObject1 = c.Fy().R(((cjy)localObject1).sxM, ((cjy)localObject1).tAB);
          paramInt = 0;
          while ((paramInt < 10) && (paramInt < ((List)localObject1).size()))
          {
            localObject2 = (bi)((List)localObject1).get(paramInt);
            paramArrayOfByte.thk.add(h.aa((bi)localObject2));
            paramInt += 1;
          }
          if (((List)localObject1).size() <= 10) {}
        }
        catch (IOException paramArrayOfByte)
        {
          return null;
        }
        for (;;)
        {
          paramArrayOfByte.tXg = bool;
          try
          {
            paramArrayOfByte = paramArrayOfByte.toByteArray();
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            y.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", paramArrayOfByte, "", new Object[0]);
          }
          bool = false;
        }
        continue;
        com.tencent.mm.plugin.wear.model.c.a.ez(12, 0);
        com.tencent.mm.plugin.wear.model.c.a.Bf(14);
        localObject1 = new ckb();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          Object localObject1;
          ((ckb)localObject1).aH(paramArrayOfByte);
          label441:
          au.Hx();
          paramArrayOfByte = c.Fy().fd(((ckb)localObject1).tXq);
          localObject2 = new ckc();
          String str = q.getFullPath(paramArrayOfByte.field_imgPath);
          ((ckc)localObject2).tXJ = o.g(str, 0, true);
          ((ckc)localObject2).tXq = ((ckb)localObject1).tXq;
          ((ckc)localObject2).sxO = new b(e.c(str, 0, -1));
          q.H(paramArrayOfByte);
          try
          {
            paramArrayOfByte = ((ckc)localObject2).toByteArray();
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
        }
        catch (IOException paramArrayOfByte)
        {
          break label441;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.j
 * JD-Core Version:    0.7.0.1
 */