package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.util.e;
import java.util.LinkedList;

public final class au
  extends com.tencent.mm.o.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public bv JeR;
  
  public au() {}
  
  public au(String paramString)
  {
    super(paramString);
  }
  
  public final void aK(bv parambv)
  {
    AppMethodBeat.i(43191);
    setStatus(parambv.field_status);
    kt(parambv.field_isSend);
    if (parambv.cyI()) {}
    label132:
    label146:
    for (;;)
    {
      long l = parambv.field_createTime;
      Object localObject = this;
      for (;;)
      {
        ((au)localObject).qH(l);
        if (!parambv.fvD()) {
          break label132;
        }
        setContent(parambv.fwq());
        AppMethodBeat.o(43191);
        return;
        if (parambv.fvP())
        {
          localObject = e.aZx(this.field_content);
          if (!((ciz)localObject).vAC.isEmpty())
          {
            l = ((cja)((ciz)localObject).vAC.getLast()).createTime;
            localObject = this;
            continue;
          }
          break;
        }
        if (parambv.field_status != 1) {
          break label146;
        }
        l = 9223372036854775807L;
        localObject = this;
      }
      setContent(parambv.field_content);
      AppMethodBeat.o(43191);
      return;
    }
  }
  
  public final void aO(int paramInt, long paramLong)
  {
    AppMethodBeat.i(43193);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43193);
      return;
      kr((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kt((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      qH(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.qI(paramLong);
      AppMethodBeat.o(43193);
      return;
      kv((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kw((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kx((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kz((int)paramLong);
    }
  }
  
  public final void cN(int paramInt, String paramString)
  {
    AppMethodBeat.i(43194);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43194);
      return;
      setUsername(paramString);
      AppMethodBeat.o(43194);
      return;
      setContent(paramString);
      AppMethodBeat.o(43194);
      return;
      tV(paramString);
      AppMethodBeat.o(43194);
      return;
      tW(paramString);
      AppMethodBeat.o(43194);
      return;
      tX(paramString);
      AppMethodBeat.o(43194);
      return;
      tZ(paramString);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(160773);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(160773);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(160772);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(160772);
    return localContentValues;
  }
  
  public final void fsA() {}
  
  public final void fuK()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    kt(0);
    setContent("");
    tV("0");
    kr(0);
    kz(0);
    qJ(0L);
    ky(0);
    ky(0);
    super.tW("");
    super.tX("");
    AppMethodBeat.o(43192);
  }
  
  public final void qI(long paramLong)
  {
    AppMethodBeat.i(160771);
    super.qI(paramLong);
    AppMethodBeat.o(160771);
  }
  
  public final void t(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.au
 * JD-Core Version:    0.7.0.1
 */