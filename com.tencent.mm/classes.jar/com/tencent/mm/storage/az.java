package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.util.g;
import java.util.LinkedList;

public class az
  extends com.tencent.mm.o.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public ca VEF;
  
  public az() {}
  
  public az(String paramString)
  {
    super(paramString);
  }
  
  public final void EC(long paramLong)
  {
    AppMethodBeat.i(160771);
    super.EC(paramLong);
    AppMethodBeat.o(160771);
  }
  
  public final void bf(int paramInt, long paramLong)
  {
    AppMethodBeat.i(43193);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43193);
      return;
      pH((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pJ((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      EB(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.EC(paramLong);
      AppMethodBeat.o(43193);
      return;
      pL((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pM((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pN((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pP((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pR((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pS((int)paramLong);
    }
  }
  
  public final void bq(ca paramca)
  {
    AppMethodBeat.i(43191);
    setStatus(paramca.field_status);
    pJ(paramca.field_isSend);
    if (paramca.dlT()) {}
    label256:
    for (;;)
    {
      long l = paramca.field_createTime;
      Object localObject = this;
      label36:
      ((az)localObject).EB(l);
      if (paramca.hzx()) {
        setContent(paramca.hAm());
      }
      for (;;)
      {
        if ((paramca != null) && ("hidden_conv_parent".equalsIgnoreCase(this.field_parentRef)))
        {
          if ((as.OS(this.field_username)) && (!ab.Qy(this.field_username)))
          {
            Jc("appbrandcustomerservicemsg");
            AppMethodBeat.o(43191);
            return;
            if (paramca.hzL())
            {
              localObject = g.bBr(this.field_content);
              if (!((dit)localObject).Ezu.isEmpty())
              {
                l = ((diu)((dit)localObject).Ezu.getLast()).createTime;
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
          Jc(null);
          localObject = f.Iyx;
          if (paramca.field_isSend != 1) {
            break label250;
          }
        }
      }
      label250:
      for (int i = 3;; i = 6)
      {
        ((f)localObject).a(21170, new Object[] { Integer.valueOf(i), this.field_username, Integer.valueOf(ac.Rl(this.field_username)) });
        AppMethodBeat.o(43191);
        return;
      }
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(160773);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(160773);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(160772);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(160772);
    return localContentValues;
  }
  
  public final void dg(int paramInt, String paramString)
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
      IZ(paramString);
      AppMethodBeat.o(43194);
      return;
      Ja(paramString);
      AppMethodBeat.o(43194);
      return;
      Jb(paramString);
      AppMethodBeat.o(43194);
      return;
      Jd(paramString);
    }
  }
  
  public final void hvB() {}
  
  public final void hyE()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    pJ(0);
    setContent("");
    IZ("0");
    pH(0);
    pP(0);
    ED(0L);
    pO(0);
    pO(0);
    super.Ja("");
    super.Jb("");
    AppMethodBeat.o(43192);
  }
  
  public final void u(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */