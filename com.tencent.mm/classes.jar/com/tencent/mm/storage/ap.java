package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.util.d;
import java.util.LinkedList;

public final class ap
  extends com.tencent.mm.o.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public bo GWX;
  
  public ap() {}
  
  public ap(String paramString)
  {
    super(paramString);
  }
  
  public final void aE(int paramInt, long paramLong)
  {
    AppMethodBeat.i(43193);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43193);
      return;
      jR((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jT((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      ou(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.ov(paramLong);
      AppMethodBeat.o(43193);
      return;
      jV((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jW((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jX((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jZ((int)paramLong);
    }
  }
  
  public final void aI(bo parambo)
  {
    AppMethodBeat.i(43191);
    setStatus(parambo.field_status);
    jT(parambo.field_isSend);
    if (parambo.crv()) {}
    label132:
    label146:
    for (;;)
    {
      long l = parambo.field_createTime;
      Object localObject = this;
      for (;;)
      {
        ((ap)localObject).ou(l);
        if (!parambo.fbA()) {
          break label132;
        }
        setContent(parambo.fci());
        AppMethodBeat.o(43191);
        return;
        if (parambo.fbL())
        {
          localObject = d.aRW(this.field_content);
          if (!((cdh)localObject).ulR.isEmpty())
          {
            l = ((cdi)((cdh)localObject).ulR.getLast()).createTime;
            localObject = this;
            continue;
          }
          break;
        }
        if (parambo.field_status != 1) {
          break label146;
        }
        l = 9223372036854775807L;
        localObject = this;
      }
      setContent(parambo.field_content);
      AppMethodBeat.o(43191);
      return;
    }
  }
  
  public final void cG(int paramInt, String paramString)
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
      qQ(paramString);
      AppMethodBeat.o(43194);
      return;
      qR(paramString);
      AppMethodBeat.o(43194);
      return;
      qS(paramString);
      AppMethodBeat.o(43194);
      return;
      qU(paramString);
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
  
  public final void eYX() {}
  
  public final void faH()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    jT(0);
    setContent("");
    qQ("0");
    jR(0);
    jZ(0);
    ow(0L);
    jY(0);
    jY(0);
    super.qR("");
    super.qS("");
    AppMethodBeat.o(43192);
  }
  
  public final void ov(long paramLong)
  {
    AppMethodBeat.i(160771);
    super.ov(paramLong);
    AppMethodBeat.o(160771);
  }
  
  public final void t(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ap
 * JD-Core Version:    0.7.0.1
 */