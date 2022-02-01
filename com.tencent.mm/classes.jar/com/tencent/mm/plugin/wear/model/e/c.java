package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.contact.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean RR(int paramInt)
  {
    AppMethodBeat.i(30074);
    if (paramInt == 11008)
    {
      AppMethodBeat.o(30074);
      return true;
    }
    if (paramInt == 11009)
    {
      AppMethodBeat.o(30074);
      return true;
    }
    boolean bool = super.RR(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean RS(int paramInt)
  {
    AppMethodBeat.i(30073);
    if (paramInt == 11008)
    {
      AppMethodBeat.o(30073);
      return true;
    }
    if (paramInt == 11009)
    {
      AppMethodBeat.o(30073);
      return true;
    }
    boolean bool = super.RS(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> ehn()
  {
    AppMethodBeat.i(30071);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11008));
    localArrayList.add(Integer.valueOf(11009));
    AppMethodBeat.o(30071);
    return localArrayList;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 5;
    AppMethodBeat.i(30072);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    dqr localdqr;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.RQ(6);
      localObject1 = new dru();
      for (;;)
      {
        try
        {
          ((dru)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(u.fbL());
          paramArrayOfByte.addAll(u.fbM());
          az.arV();
          paramArrayOfByte = com.tencent.mm.model.c.apR().f(paramArrayOfByte, ((dru)localObject1).CNt, 50);
          if (((dru)localObject1).CNt == 0)
          {
            paramInt = i;
            localObject2 = new drv();
            ((drv)localObject2).CNt = ((dru)localObject1).CNt;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              az.arV();
              localObject3 = com.tencent.mm.model.c.apM().aHY((String)localObject3);
              ((drv)localObject2).CNt += 1;
              if ((((af)localObject3).eKB()) || (((af)localObject3).ZM())) {
                continue;
              }
              localdqr = new dqr();
              localdqr.mBV = v.b((af)localObject3);
              localdqr.mAQ = ((au)localObject3).field_username;
              ((drv)localObject2).DsN.add(localdqr);
              if (((drv)localObject2).DsN.size() < paramInt) {
                continue;
              }
              ((drv)localObject2).Dwd = paramArrayOfByte.moveToNext();
            }
            ad.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((dru)localObject1).CNt), Integer.valueOf(((drv)localObject2).CNt), Integer.valueOf(((drv)localObject2).DsN.size()) });
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
            paramArrayOfByte = ((drv)localObject2).toByteArray();
            AppMethodBeat.o(30072);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(30072);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
          ad.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
      }
    }
    if (paramInt == 11009)
    {
      com.tencent.mm.plugin.wear.model.c.a.RQ(7);
      localObject1 = new dqx();
      for (;;)
      {
        try
        {
          ((dqx)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new dqy();
          az.arV();
          localObject2 = com.tencent.mm.model.c.apM().hf(null);
          paramInt = ((dqx)localObject1).CNt;
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
          ad.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
        az.arV();
        localObject3 = com.tencent.mm.model.c.apM().aHY((String)localObject3);
        localdqr = new dqr();
        localdqr.mBV = v.b((af)localObject3);
        localdqr.mAQ = ((au)localObject3).field_username;
        paramArrayOfByte.DsN.add(localdqr);
        if (paramArrayOfByte.DsN.size() >= 5) {
          paramArrayOfByte.Dwd = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.CNt = (((dqx)localObject1).CNt + paramArrayOfByte.DsN.size());
      try
      {
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        AppMethodBeat.o(30072);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(30072);
        return null;
      }
    }
    AppMethodBeat.o(30072);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.c
 * JD-Core Version:    0.7.0.1
 */