package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.contact.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  protected final boolean Ub(int paramInt)
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
    boolean bool = super.Ub(paramInt);
    AppMethodBeat.o(30074);
    return bool;
  }
  
  protected final boolean Uc(int paramInt)
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
    boolean bool = super.Uc(paramInt);
    AppMethodBeat.o(30073);
    return bool;
  }
  
  public final List<Integer> ewH()
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
    dwi localdwi;
    if (paramInt == 11008)
    {
      com.tencent.mm.plugin.wear.model.c.a.Ua(6);
      localObject1 = new dxl();
      for (;;)
      {
        try
        {
          ((dxl)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new LinkedList();
          paramArrayOfByte.addAll(u.frC());
          paramArrayOfByte.addAll(u.frD());
          az.ayM();
          paramArrayOfByte = com.tencent.mm.model.c.awG().f(paramArrayOfByte, ((dxl)localObject1).EfV, 50);
          if (((dxl)localObject1).EfV == 0)
          {
            paramInt = i;
            localObject2 = new dxm();
            ((dxm)localObject2).EfV = ((dxl)localObject1).EfV;
            if ((paramArrayOfByte != null) && (paramArrayOfByte.moveToNext()))
            {
              localObject3 = paramArrayOfByte.getString(paramArrayOfByte.getColumnIndex("username"));
              az.ayM();
              localObject3 = com.tencent.mm.model.c.awB().aNt((String)localObject3);
              ((dxm)localObject2).EfV += 1;
              if ((((ai)localObject3).fad()) || (((ai)localObject3).aaH())) {
                continue;
              }
              localdwi = new dwi();
              localdwi.ndW = v.b((ai)localObject3);
              localdwi.ncR = ((av)localObject3).field_username;
              ((dxm)localObject2).ENR.add(localdwi);
              if (((dxm)localObject2).ENR.size() < paramInt) {
                continue;
              }
              ((dxm)localObject2).ERy = paramArrayOfByte.moveToNext();
            }
            ac.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[] { Integer.valueOf(((dxl)localObject1).EfV), Integer.valueOf(((dxm)localObject2).EfV), Integer.valueOf(((dxm)localObject2).ENR.size()) });
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
            paramArrayOfByte = ((dxm)localObject2).toByteArray();
            AppMethodBeat.o(30072);
            return paramArrayOfByte;
          }
          catch (IOException paramArrayOfByte)
          {
            AppMethodBeat.o(30072);
            return null;
          }
          paramArrayOfByte = paramArrayOfByte;
          ac.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
      }
    }
    if (paramInt == 11009)
    {
      com.tencent.mm.plugin.wear.model.c.a.Ua(7);
      localObject1 = new dwo();
      for (;;)
      {
        try
        {
          ((dwo)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = new dwp();
          az.ayM();
          localObject2 = com.tencent.mm.model.c.awB().hs(null);
          paramInt = ((dwo)localObject1).EfV;
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
          ac.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(30072);
          return null;
        }
        az.ayM();
        localObject3 = com.tencent.mm.model.c.awB().aNt((String)localObject3);
        localdwi = new dwi();
        localdwi.ndW = v.b((ai)localObject3);
        localdwi.ncR = ((av)localObject3).field_username;
        paramArrayOfByte.ENR.add(localdwi);
        if (paramArrayOfByte.ENR.size() >= 5) {
          paramArrayOfByte.ERy = ((Cursor)localObject2).moveToNext();
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      paramArrayOfByte.EfV = (((dwo)localObject1).EfV + paramArrayOfByte.ENR.size());
      try
      {
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        AppMethodBeat.o(30072);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        ac.printErrStackTrace("MicroMsg.Wear.HttpContactServer", paramArrayOfByte, "", new Object[0]);
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