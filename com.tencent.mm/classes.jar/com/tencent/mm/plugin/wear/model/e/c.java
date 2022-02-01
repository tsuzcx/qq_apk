package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.protocal.protobuf.edl;
import com.tencent.mm.protocal.protobuf.edm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean VT(int paramInt)
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
    boolean bool = super.VT(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean VU(int paramInt)
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
    boolean bool = super.VU(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> eKN()
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
    eci localeci;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.VS(6);
      localObject1 = new edl();
      for (;;)
      {
        try
        {
          ((edl)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(u.fIp());
          paramArrayOfByte.addAll(u.fIq());
          ba.aBQ();
          paramArrayOfByte = com.tencent.mm.model.c.azv().f(paramArrayOfByte, ((edl)localObject1).FMu, 50);
          if (((edl)localObject1).FMu == 0)
          {
            paramInt = i;
            localObject2 = new edm();
            ((edm)localObject2).FMu = ((edl)localObject1).FMu;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              ba.aBQ();
              localObject3 = com.tencent.mm.model.c.azp().Bf((String)localObject3);
              ((edm)localObject2).FMu += 1;
              if ((((am)localObject3).fqg()) || (((am)localObject3).adk())) {
                continue;
              }
              localeci = new eci();
              localeci.nEt = v.b((am)localObject3);
              localeci.nDo = ((aw)localObject3).field_username;
              ((edm)localObject2).GwV.add(localeci);
              if (((edm)localObject2).GwV.size() < paramInt) {
                continue;
              }
              ((edm)localObject2).GAQ = paramArrayOfByte.moveToNext();
            }
            ad.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((edl)localObject1).FMu), Integer.valueOf(((edm)localObject2).FMu), Integer.valueOf(((edm)localObject2).GwV.size()) });
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
            paramArrayOfByte = ((edm)localObject2).toByteArray();
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
      com.tencent.mm.plugin.wear.model.c.a.VS(7);
      localObject1 = new eco();
      for (;;)
      {
        try
        {
          ((eco)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new ecp();
          ba.aBQ();
          localObject2 = com.tencent.mm.model.c.azp().hE(null);
          paramInt = ((eco)localObject1).FMu;
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
        ba.aBQ();
        localObject3 = com.tencent.mm.model.c.azp().Bf((String)localObject3);
        localeci = new eci();
        localeci.nEt = v.b((am)localObject3);
        localeci.nDo = ((aw)localObject3).field_username;
        paramArrayOfByte.GwV.add(localeci);
        if (paramArrayOfByte.GwV.size() >= 5) {
          paramArrayOfByte.GAQ = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.FMu = (((eco)localObject1).FMu + paramArrayOfByte.GwV.size());
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