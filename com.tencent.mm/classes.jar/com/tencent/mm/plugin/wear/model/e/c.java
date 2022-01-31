package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.c.cja;
import com.tencent.mm.protocal.c.cjg;
import com.tencent.mm.protocal.c.cjh;
import com.tencent.mm.protocal.c.ckd;
import com.tencent.mm.protocal.c.cke;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean Bg(int paramInt)
  {
    if (paramInt == 11008) {}
    while (paramInt == 11009) {
      return true;
    }
    return super.Bg(paramInt);
  }
  
  protected final boolean Bh(int paramInt)
  {
    if (paramInt == 11008) {}
    while (paramInt == 11009) {
      return true;
    }
    return super.Bh(paramInt);
  }
  
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11008));
    localArrayList.add(Integer.valueOf(11009));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 5;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    cja localcja;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.Bf(6);
      localObject1 = new ckd();
      for (;;)
      {
        try
        {
          ((ckd)localObject1).aH(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(s.cHO());
          paramArrayOfByte.addAll(s.cHP());
          au.Hx();
          paramArrayOfByte = com.tencent.mm.model.c.FB().l(paramArrayOfByte, ((ckd)localObject1).sDT);
          if (((ckd)localObject1).sDT == 0)
          {
            paramInt = i;
            localObject2 = new cke();
            ((cke)localObject2).sDT = ((ckd)localObject1).sDT;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              au.Hx();
              localObject3 = com.tencent.mm.model.c.Fw().abl((String)localObject3);
              ((cke)localObject2).sDT += 1;
              if ((((ad)localObject3).cua()) || (((ad)localObject3).Bg())) {
                continue;
              }
              localcja = new cja();
              localcja.hRf = r.c((ad)localObject3);
              localcja.hPY = ((ao)localObject3).field_username;
              ((cke)localObject2).tcB.add(localcja);
              if (((cke)localObject2).tcB.size() < paramInt) {
                continue;
              }
              ((cke)localObject2).tXg = paramArrayOfByte.moveToNext();
            }
            y.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((ckd)localObject1).sDT), Integer.valueOf(((cke)localObject2).sDT), Integer.valueOf(((cke)localObject2).tcB.size()) });
            if (paramArrayOfByte != null) {
              paramArrayOfByte.close();
            }
          }
          paramInt = 20;
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            paramArrayOfByte = ((cke)localObject2).toByteArray();
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
          y.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          return null;
        }
      }
    }
    if (paramInt == 11009)
    {
      com.tencent.mm.plugin.wear.model.c.a.Bf(7);
      localObject1 = new cjg();
      for (;;)
      {
        try
        {
          ((cjg)localObject1).aH(paramArrayOfByte);
          paramArrayOfByte = new cjh();
          au.Hx();
          localObject2 = com.tencent.mm.model.c.Fw().dB(null);
          paramInt = ((cjg)localObject1).sDT;
          if ((localObject2 == null) || (!((Cursor)localObject2).moveToNext())) {
            break;
          }
          if (paramInt > 0)
          {
            paramInt -= 1;
            continue;
          }
          localObject3 = ((Cursor)localObject2).getString(0);
        }
        catch (IOException paramArrayOfByte)
        {
          y.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          return null;
        }
        au.Hx();
        localObject3 = com.tencent.mm.model.c.Fw().abl((String)localObject3);
        localcja = new cja();
        localcja.hRf = r.c((ad)localObject3);
        localcja.hPY = ((ao)localObject3).field_username;
        paramArrayOfByte.tcB.add(localcja);
        if (paramArrayOfByte.tcB.size() >= 5) {
          paramArrayOfByte.tXg = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.sDT = (((cjg)localObject1).sDT + paramArrayOfByte.tcB.size());
      try
      {
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.c
 * JD-Core Version:    0.7.0.1
 */