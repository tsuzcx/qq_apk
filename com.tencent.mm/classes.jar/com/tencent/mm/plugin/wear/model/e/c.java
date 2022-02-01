package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.fiy;
import com.tencent.mm.protocal.protobuf.fje;
import com.tencent.mm.protocal.protobuf.fjf;
import com.tencent.mm.protocal.protobuf.fkb;
import com.tencent.mm.protocal.protobuf.fkc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean amU(int paramInt)
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
    boolean bool = super.amU(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean amV(int paramInt)
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
    boolean bool = super.amV(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> gON()
  {
    AppMethodBeat.i(30071);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11008));
    localArrayList.add(Integer.valueOf(11009));
    AppMethodBeat.o(30071);
    return localArrayList;
  }
  
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 5;
    AppMethodBeat.i(30072);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    fiy localfiy;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.amT(6);
      localObject1 = new fkb();
      for (;;)
      {
        try
        {
          ((fkb)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(w.hVh());
          paramArrayOfByte.addAll(w.hVi());
          bh.beI();
          paramArrayOfByte = com.tencent.mm.model.c.bbR().h(paramArrayOfByte, ((fkb)localObject1).Sat, 50);
          if (((fkb)localObject1).Sat == 0)
          {
            paramInt = i;
            localObject2 = new fkc();
            ((fkc)localObject2).Sat = ((fkb)localObject1).Sat;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              bh.beI();
              localObject3 = com.tencent.mm.model.c.bbL().RG((String)localObject3);
              ((fkc)localObject2).Sat += 1;
              if ((((as)localObject3).hxX()) || (((as)localObject3).ayc())) {
                continue;
              }
              localfiy = new fiy();
              localfiy.rWI = aa.b((as)localObject3);
              localfiy.UserName = ((ax)localObject3).field_username;
              ((fkc)localObject2).Tdk.add(localfiy);
              if (((fkc)localObject2).Tdk.size() < paramInt) {
                continue;
              }
              ((fkc)localObject2).Tic = paramArrayOfByte.moveToNext();
            }
            Log.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((fkb)localObject1).Sat), Integer.valueOf(((fkc)localObject2).Sat), Integer.valueOf(((fkc)localObject2).Tdk.size()) });
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
            paramArrayOfByte = ((fkc)localObject2).toByteArray();
            AppMethodBeat.o(30072);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(30072);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
          Log.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
      }
    }
    if (paramInt == 11009)
    {
      com.tencent.mm.plugin.wear.model.c.a.amT(7);
      localObject1 = new fje();
      for (;;)
      {
        try
        {
          ((fje)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new fjf();
          bh.beI();
          localObject2 = com.tencent.mm.model.c.bbL().jK(null);
          paramInt = ((fje)localObject1).Sat;
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
          Log.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
        bh.beI();
        localObject3 = com.tencent.mm.model.c.bbL().RG((String)localObject3);
        localfiy = new fiy();
        localfiy.rWI = aa.b((as)localObject3);
        localfiy.UserName = ((ax)localObject3).field_username;
        paramArrayOfByte.Tdk.add(localfiy);
        if (paramArrayOfByte.Tdk.size() >= 5) {
          paramArrayOfByte.Tic = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.Sat = (((fje)localObject1).Sat + paramArrayOfByte.Tdk.size());
      try
      {
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        AppMethodBeat.o(30072);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
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