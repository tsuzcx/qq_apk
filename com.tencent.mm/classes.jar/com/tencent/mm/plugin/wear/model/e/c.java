package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.edz;
import com.tencent.mm.protocal.protobuf.eef;
import com.tencent.mm.protocal.protobuf.eeg;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.contact.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean WA(int paramInt)
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
    boolean bool = super.WA(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean WB(int paramInt)
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
    boolean bool = super.WB(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> eOv()
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
    edz localedz;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.Wz(6);
      localObject1 = new efc();
      for (;;)
      {
        try
        {
          ((efc)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(u.fMH());
          paramArrayOfByte.addAll(u.fMI());
          bc.aCg();
          paramArrayOfByte = com.tencent.mm.model.c.azL().f(paramArrayOfByte, ((efc)localObject1).GeT, 50);
          if (((efc)localObject1).GeT == 0)
          {
            paramInt = i;
            localObject2 = new efd();
            ((efd)localObject2).GeT = ((efc)localObject1).GeT;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              bc.aCg();
              localObject3 = com.tencent.mm.model.c.azF().BH((String)localObject3);
              ((efd)localObject2).GeT += 1;
              if ((((an)localObject3).fug()) || (((an)localObject3).adv())) {
                continue;
              }
              localedz = new edz();
              localedz.nJO = w.b((an)localObject3);
              localedz.nIJ = ((aw)localObject3).field_username;
              ((efd)localObject2).GQv.add(localedz);
              if (((efd)localObject2).GQv.size() < paramInt) {
                continue;
              }
              ((efd)localObject2).GUq = paramArrayOfByte.moveToNext();
            }
            ae.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((efc)localObject1).GeT), Integer.valueOf(((efd)localObject2).GeT), Integer.valueOf(((efd)localObject2).GQv.size()) });
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
            paramArrayOfByte = ((efd)localObject2).toByteArray();
            AppMethodBeat.o(30072);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(30072);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
          ae.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
      }
    }
    if (paramInt == 11009)
    {
      com.tencent.mm.plugin.wear.model.c.a.Wz(7);
      localObject1 = new eef();
      for (;;)
      {
        try
        {
          ((eef)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new eeg();
          bc.aCg();
          localObject2 = com.tencent.mm.model.c.azF().hO(null);
          paramInt = ((eef)localObject1).GeT;
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
          ae.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
        bc.aCg();
        localObject3 = com.tencent.mm.model.c.azF().BH((String)localObject3);
        localedz = new edz();
        localedz.nJO = w.b((an)localObject3);
        localedz.nIJ = ((aw)localObject3).field_username;
        paramArrayOfByte.GQv.add(localedz);
        if (paramArrayOfByte.GQv.size() >= 5) {
          paramArrayOfByte.GUq = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.GeT = (((eef)localObject1).GeT + paramArrayOfByte.GQv.size());
      try
      {
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        AppMethodBeat.o(30072);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        ae.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
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