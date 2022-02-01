package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import java.util.LinkedList;

public final class az
  extends com.tencent.mm.o.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public ca OoM;
  
  public az() {}
  
  public az(String paramString)
  {
    super(paramString);
  }
  
  public final void aT(int paramInt, long paramLong)
  {
    AppMethodBeat.i(43193);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43193);
      return;
      nt((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      nv((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      yA(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.yB(paramLong);
      AppMethodBeat.o(43193);
      return;
      nx((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      ny((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      nz((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      nB((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      nD((int)paramLong);
    }
  }
  
  public final void aX(ca paramca)
  {
    AppMethodBeat.i(43191);
    setStatus(paramca.field_status);
    nv(paramca.field_isSend);
    if (paramca.cWL()) {}
    label256:
    for (;;)
    {
      long l = paramca.field_createTime;
      Object localObject = this;
      label36:
      ((az)localObject).yA(l);
      if (paramca.gDk()) {
        setContent(paramca.gDW());
      }
      for (;;)
      {
        if ((paramca != null) && ("hidden_conv_parent".equalsIgnoreCase(this.field_parentRef)))
        {
          if ((as.HF(this.field_username)) && (!ab.Jf(this.field_username)))
          {
            Co("appbrandcustomerservicemsg");
            AppMethodBeat.o(43191);
            return;
            if (paramca.gDw())
            {
              localObject = com.tencent.mm.util.e.boC(this.field_content);
              if (!((czg)localObject).yVw.isEmpty())
              {
                l = ((czh)((czg)localObject).yVw.getLast()).createTime;
                localObject = this;
                break label36;
              }
              break;
            }
            if (paramca.field_status != 1) {
              break label256;
            }
            l = 9223372036854775807L;
            localObject = this;
            break label36;
            setContent(paramca.field_content);
            continue;
          }
          Co(null);
          localObject = com.tencent.mm.plugin.report.e.Cxv;
          if (paramca.field_isSend != 1) {
            break label250;
          }
        }
      }
      label250:
      for (int i = 3;; i = 6)
      {
        ((com.tencent.mm.plugin.report.e)localObject).a(21170, new Object[] { Integer.valueOf(i), this.field_username, Integer.valueOf(ac.JT(this.field_username)) });
        AppMethodBeat.o(43191);
        return;
      }
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
  
  public final void dh(int paramInt, String paramString)
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
      Cl(paramString);
      AppMethodBeat.o(43194);
      return;
      Cm(paramString);
      AppMethodBeat.o(43194);
      return;
      Cn(paramString);
      AppMethodBeat.o(43194);
      return;
      Cp(paramString);
    }
  }
  
  public final void gCr()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    nv(0);
    setContent("");
    Cl("0");
    nt(0);
    nB(0);
    yC(0L);
    nA(0);
    nA(0);
    super.Cm("");
    super.Cn("");
    AppMethodBeat.o(43192);
  }
  
  public final void gzB() {}
  
  public final void t(int paramInt, byte[] paramArrayOfByte) {}
  
  public final void yB(long paramLong)
  {
    AppMethodBeat.i(160771);
    super.yB(paramLong);
    AppMethodBeat.o(160771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */