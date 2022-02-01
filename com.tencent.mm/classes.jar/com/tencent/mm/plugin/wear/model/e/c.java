package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.eyh;
import com.tencent.mm.protocal.protobuf.eyn;
import com.tencent.mm.protocal.protobuf.eyo;
import com.tencent.mm.protocal.protobuf.ezk;
import com.tencent.mm.protocal.protobuf.ezl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean afg(int paramInt)
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
    boolean bool = super.afg(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean afh(int paramInt)
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
    boolean bool = super.afh(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> fWe()
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
    eyh localeyh;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.aff(6);
      localObject1 = new ezk();
      for (;;)
      {
        try
        {
          ((ezk)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(u.gVb());
          paramArrayOfByte.addAll(u.gVc());
          bg.aVF();
          paramArrayOfByte = com.tencent.mm.model.c.aST().f(paramArrayOfByte, ((ezk)localObject1).KZk, 50);
          if (((ezk)localObject1).KZk == 0)
          {
            paramInt = i;
            localObject2 = new ezl();
            ((ezl)localObject2).KZk = ((ezk)localObject1).KZk;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              bg.aVF();
              localObject3 = com.tencent.mm.model.c.aSN().Kn((String)localObject3);
              ((ezl)localObject2).KZk += 1;
              if ((((as)localObject3).gBM()) || (((as)localObject3).ary())) {
                continue;
              }
              localeyh = new eyh();
              localeyh.oUJ = aa.b((as)localObject3);
              localeyh.UserName = ((ax)localObject3).field_username;
              ((ezl)localObject2).LUC.add(localeyh);
              if (((ezl)localObject2).LUC.size() < paramInt) {
                continue;
              }
              ((ezl)localObject2).LYI = paramArrayOfByte.moveToNext();
            }
            Log.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((ezk)localObject1).KZk), Integer.valueOf(((ezl)localObject2).KZk), Integer.valueOf(((ezl)localObject2).LUC.size()) });
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
            paramArrayOfByte = ((ezl)localObject2).toByteArray();
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
      com.tencent.mm.plugin.wear.model.c.a.aff(7);
      localObject1 = new eyn();
      for (;;)
      {
        try
        {
          ((eyn)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new eyo();
          bg.aVF();
          localObject2 = com.tencent.mm.model.c.aSN().iS(null);
          paramInt = ((eyn)localObject1).KZk;
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
        bg.aVF();
        localObject3 = com.tencent.mm.model.c.aSN().Kn((String)localObject3);
        localeyh = new eyh();
        localeyh.oUJ = aa.b((as)localObject3);
        localeyh.UserName = ((ax)localObject3).field_username;
        paramArrayOfByte.LUC.add(localeyh);
        if (paramArrayOfByte.LUC.size() >= 5) {
          paramArrayOfByte.LYI = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.KZk = (((eyn)localObject1).KZk + paramArrayOfByte.LUC.size());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.c
 * JD-Core Version:    0.7.0.1
 */