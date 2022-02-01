package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.util.e;
import java.util.LinkedList;

public final class at
  extends com.tencent.mm.p.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public bu IKk;
  
  public at() {}
  
  public at(String paramString)
  {
    super(paramString);
  }
  
  public final void aL(bu parambu)
  {
    AppMethodBeat.i(43191);
    setStatus(parambu.field_status);
    kr(parambu.field_isSend);
    if (parambu.cxh()) {}
    label132:
    label146:
    for (;;)
    {
      long l = parambu.field_createTime;
      Object localObject = this;
      for (;;)
      {
        ((at)localObject).qu(l);
        if (!parambu.frD()) {
          break label132;
        }
        setContent(parambu.fsp());
        AppMethodBeat.o(43191);
        return;
        if (parambu.frP())
        {
          localObject = e.aXV(this.field_content);
          if (!((cif)localObject).vox.isEmpty())
          {
            l = ((cig)((cif)localObject).vox.getLast()).createTime;
            localObject = this;
            continue;
          }
          break;
        }
        if (parambu.field_status != 1) {
          break label146;
        }
        l = 9223372036854775807L;
        localObject = this;
      }
      setContent(parambu.field_content);
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
      kp((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kr((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      qu(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.qv(paramLong);
      AppMethodBeat.o(43193);
      return;
      kt((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      ku((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kv((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kx((int)paramLong);
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
      tA(paramString);
      AppMethodBeat.o(43194);
      return;
      tB(paramString);
      AppMethodBeat.o(43194);
      return;
      tC(paramString);
      AppMethodBeat.o(43194);
      return;
      tE(paramString);
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
  
  public final void foH() {}
  
  public final void fqK()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    kr(0);
    setContent("");
    tA("0");
    kp(0);
    kx(0);
    qw(0L);
    kw(0);
    kw(0);
    super.tB("");
    super.tC("");
    AppMethodBeat.o(43192);
  }
  
  public final void qv(long paramLong)
  {
    AppMethodBeat.i(160771);
    super.qv(paramLong);
    AppMethodBeat.o(160771);
  }
  
  public final void t(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */