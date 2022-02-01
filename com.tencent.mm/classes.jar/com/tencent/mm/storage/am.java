package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.util.d;
import java.util.LinkedList;

public final class am
  extends com.tencent.mm.o.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public bl FxX;
  
  public am() {}
  
  public am(String paramString)
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
      jT((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jV((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kS(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.kT(paramLong);
      AppMethodBeat.o(43193);
      return;
      jX((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jY((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      jZ((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      kb((int)paramLong);
    }
  }
  
  public final void aG(bl parambl)
  {
    AppMethodBeat.i(43191);
    setStatus(parambl.field_status);
    jV(parambl.field_isSend);
    if (parambl.cjO()) {}
    label132:
    label146:
    for (;;)
    {
      long l = parambl.field_createTime;
      Object localObject = this;
      for (;;)
      {
        ((am)localObject).kS(l);
        if (!parambl.eLW()) {
          break label132;
        }
        setContent(parambl.eMD());
        AppMethodBeat.o(43191);
        return;
        if (parambl.eMg())
        {
          localObject = d.aMu(this.field_content);
          if (!((byl)localObject).tdC.isEmpty())
          {
            l = ((bym)((byl)localObject).tdC.getLast()).createTime;
            localObject = this;
            continue;
          }
          break;
        }
        if (parambl.field_status != 1) {
          break label146;
        }
        l = 9223372036854775807L;
        localObject = this;
      }
      setContent(parambl.field_content);
      AppMethodBeat.o(43191);
      return;
    }
  }
  
  public final void cD(int paramInt, String paramString)
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
      nK(paramString);
      AppMethodBeat.o(43194);
      return;
      nL(paramString);
      AppMethodBeat.o(43194);
      return;
      nM(paramString);
      AppMethodBeat.o(43194);
      return;
      nO(paramString);
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
  
  public final void eJA() {}
  
  public final void eLf()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    jV(0);
    setContent("");
    nK("0");
    jT(0);
    kb(0);
    kU(0L);
    ka(0);
    ka(0);
    super.nL("");
    super.nM("");
    AppMethodBeat.o(43192);
  }
  
  public final void kT(long paramLong)
  {
    AppMethodBeat.i(160771);
    super.kT(paramLong);
    AppMethodBeat.o(160771);
  }
  
  public final void t(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.am
 * JD-Core Version:    0.7.0.1
 */