package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.gfm;
import com.tencent.mm.protocal.protobuf.gfs;
import com.tencent.mm.protocal.protobuf.gft;
import com.tencent.mm.protocal.protobuf.ggp;
import com.tencent.mm.protocal.protobuf.ggq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean asL(int paramInt)
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
    boolean bool = super.asL(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean asM(int paramInt)
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
    boolean bool = super.asM(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30071);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11008));
    localArrayList.add(Integer.valueOf(11009));
    AppMethodBeat.o(30071);
    return localArrayList;
  }
  
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 5;
    AppMethodBeat.i(30072);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    gfm localgfm;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.asK(6);
      localObject1 = new ggp();
      for (;;)
      {
        try
        {
          ((ggp)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(w.jyV());
          paramArrayOfByte.addAll(w.jyW());
          bh.bCz();
          paramArrayOfByte = com.tencent.mm.model.c.bzG().p(paramArrayOfByte, ((ggp)localObject1).YYs, 50);
          if (((ggp)localObject1).YYs == 0)
          {
            paramInt = i;
            localObject2 = new ggq();
            ((ggq)localObject2).YYs = ((ggp)localObject1).YYs;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              bh.bCz();
              localObject3 = com.tencent.mm.model.c.bzA().JE((String)localObject3);
              ((ggq)localObject2).YYs += 1;
              if ((((au)localObject3).iZC()) || (((au)localObject3).aSF())) {
                continue;
              }
              localgfm = new gfm();
              localgfm.vhX = aa.b((au)localObject3);
              localgfm.UserName = ((az)localObject3).field_username;
              ((ggq)localObject2).aaqz.add(localgfm);
              if (((ggq)localObject2).aaqz.size() < paramInt) {
                continue;
              }
              ((ggq)localObject2).aavs = paramArrayOfByte.moveToNext();
            }
            Log.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((ggp)localObject1).YYs), Integer.valueOf(((ggq)localObject2).YYs), Integer.valueOf(((ggq)localObject2).aaqz.size()) });
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
            paramArrayOfByte = ((ggq)localObject2).toByteArray();
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
      com.tencent.mm.plugin.wear.model.c.a.asK(7);
      localObject1 = new gfs();
      for (;;)
      {
        try
        {
          ((gfs)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new gft();
          bh.bCz();
          localObject2 = com.tencent.mm.model.c.bzA().mX(null);
          paramInt = ((gfs)localObject1).YYs;
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
        bh.bCz();
        localObject3 = com.tencent.mm.model.c.bzA().JE((String)localObject3);
        localgfm = new gfm();
        localgfm.vhX = aa.b((au)localObject3);
        localgfm.UserName = ((az)localObject3).field_username;
        paramArrayOfByte.aaqz.add(localgfm);
        if (paramArrayOfByte.aaqz.size() >= 5) {
          paramArrayOfByte.aavs = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.YYs = (((gfs)localObject1).YYs + paramArrayOfByte.aaqz.size());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.c
 * JD-Core Version:    0.7.0.1
 */