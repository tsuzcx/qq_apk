package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean IS(int paramInt)
  {
    AppMethodBeat.i(26392);
    if (paramInt == 11008)
    {
      AppMethodBeat.o(26392);
      return true;
    }
    if (paramInt == 11009)
    {
      AppMethodBeat.o(26392);
      return true;
    }
    boolean bool = super.IS(paramInt);
    AppMethodBeat.o(26392);
    return bool;
  }
  
  protected final boolean IT(int paramInt)
  {
    AppMethodBeat.i(26391);
    if (paramInt == 11008)
    {
      AppMethodBeat.o(26391);
      return true;
    }
    if (paramInt == 11009)
    {
      AppMethodBeat.o(26391);
      return true;
    }
    boolean bool = super.IT(paramInt);
    AppMethodBeat.o(26391);
    return bool;
  }
  
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26389);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11008));
    localArrayList.add(Integer.valueOf(11009));
    AppMethodBeat.o(26389);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 5;
    AppMethodBeat.i(26390);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    cwn localcwn;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.IR(6);
      localObject1 = new cxq();
      for (;;)
      {
        try
        {
          ((cxq)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(t.dMg());
          paramArrayOfByte.addAll(t.dMh());
          aw.aaz();
          paramArrayOfByte = com.tencent.mm.model.c.YF().s(paramArrayOfByte, ((cxq)localObject1).wzS);
          if (((cxq)localObject1).wzS == 0)
          {
            paramInt = i;
            localObject2 = new cxr();
            ((cxr)localObject2).wzS = ((cxq)localObject1).wzS;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              aw.aaz();
              localObject3 = com.tencent.mm.model.c.YA().arw((String)localObject3);
              ((cxr)localObject2).wzS += 1;
              if ((((ad)localObject3).dwz()) || (((ad)localObject3).NW())) {
                continue;
              }
              localcwn = new cwn();
              localcwn.jKG = s.c((ad)localObject3);
              localcwn.jJA = ((aq)localObject3).field_username;
              ((cxr)localObject2).xaT.add(localcwn);
              if (((cxr)localObject2).xaT.size() < paramInt) {
                continue;
              }
              ((cxr)localObject2).xKI = paramArrayOfByte.moveToNext();
            }
            ab.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((cxq)localObject1).wzS), Integer.valueOf(((cxr)localObject2).wzS), Integer.valueOf(((cxr)localObject2).xaT.size()) });
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
            paramArrayOfByte = ((cxr)localObject2).toByteArray();
            AppMethodBeat.o(26390);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(26390);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
          ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(26390);
          return null;
        }
      }
    }
    if (paramInt == 11009)
    {
      com.tencent.mm.plugin.wear.model.c.a.IR(7);
      localObject1 = new cwt();
      for (;;)
      {
        try
        {
          ((cwt)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new cwu();
          aw.aaz();
          localObject2 = com.tencent.mm.model.c.YA().eK(null);
          paramInt = ((cwt)localObject1).wzS;
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
          ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(26390);
          return null;
        }
        aw.aaz();
        localObject3 = com.tencent.mm.model.c.YA().arw((String)localObject3);
        localcwn = new cwn();
        localcwn.jKG = s.c((ad)localObject3);
        localcwn.jJA = ((aq)localObject3).field_username;
        paramArrayOfByte.xaT.add(localcwn);
        if (paramArrayOfByte.xaT.size() >= 5) {
          paramArrayOfByte.xKI = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.wzS = (((cwt)localObject1).wzS + paramArrayOfByte.xaT.size());
      try
      {
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        AppMethodBeat.o(26390);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(26390);
        return null;
      }
    }
    AppMethodBeat.o(26390);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.c
 * JD-Core Version:    0.7.0.1
 */