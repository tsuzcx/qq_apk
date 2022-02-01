package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.util.g;
import java.util.LinkedList;

public class bb
  extends com.tencent.mm.l.a
  implements com.tencent.mm.storagebase.a.a<String>
{
  public cc adir;
  public int adis;
  
  public bb() {}
  
  public bb(String paramString)
  {
    super(paramString);
  }
  
  public final void bG(cc paramcc)
  {
    AppMethodBeat.i(43191);
    setStatus(paramcc.field_status);
    pI(paramcc.field_isSend);
    if (paramcc.dSJ()) {}
    label36:
    label293:
    for (;;)
    {
      long l = paramcc.getCreateTime();
      Object localObject = this;
      ((bb)localObject).gR(l);
      if (paramcc.jbA()) {
        setContent(paramcc.jct());
      }
      for (;;)
      {
        if ((paramcc != null) && ("hidden_conv_parent".equalsIgnoreCase(this.field_parentRef)))
        {
          if ((au.Hh(this.field_username)) && (!au.bwc(this.field_username)))
          {
            BH("appbrandcustomerservicemsg");
            AppMethodBeat.o(43191);
            return;
            if (paramcc.jbQ())
            {
              localObject = g.bDK(this.field_content);
              if (!((ebd)localObject).Ksg.isEmpty())
              {
                l = ((ebe)((ebd)localObject).Ksg.getLast()).createTime;
                localObject = this;
                break label36;
              }
              break;
            }
            if (paramcc.field_status != 1) {
              break label293;
            }
            l = 9223372036854775807L;
            localObject = this;
            break label36;
            setContent(paramcc.field_content);
            continue;
          }
          BH(null);
          localObject = f.Ozc;
          if (paramcc.field_isSend == 1) {}
          for (int i = 3;; i = 6)
          {
            ((f)localObject).b(21170, new Object[] { Integer.valueOf(i), this.field_username, Integer.valueOf(ac.Jj(this.field_username)) });
            AppMethodBeat.o(43191);
            return;
          }
        }
      }
      if ((paramcc != null) && ("message_fold".equalsIgnoreCase(this.field_username)))
      {
        gR(0L);
        super.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(this, 2, 0L));
      }
      AppMethodBeat.o(43191);
      return;
    }
  }
  
  public final void bo(int paramInt, long paramLong)
  {
    AppMethodBeat.i(43193);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43193);
      return;
      pG((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      setStatus((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pI((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      gR(paramLong);
      AppMethodBeat.o(43193);
      return;
      super.gS(paramLong);
      AppMethodBeat.o(43193);
      return;
      pK((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pL((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pM((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pO((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pQ((int)paramLong);
      AppMethodBeat.o(43193);
      return;
      pR((int)paramLong);
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
  
  public final void dY(int paramInt, String paramString)
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
      BE(paramString);
      AppMethodBeat.o(43194);
      return;
      BF(paramString);
      AppMethodBeat.o(43194);
      return;
      BG(paramString);
      AppMethodBeat.o(43194);
      return;
      BI(paramString);
      AppMethodBeat.o(43194);
      return;
      BH(paramString);
    }
  }
  
  public final void gS(long paramLong)
  {
    AppMethodBeat.i(369606);
    super.gS(paramLong);
    AppMethodBeat.o(369606);
  }
  
  public final void iXb() {}
  
  public final void jaJ()
  {
    AppMethodBeat.i(43192);
    setStatus(0);
    pI(0);
    setContent("");
    BE("0");
    pG(0);
    pO(0);
    gT(0L);
    pN(0);
    pN(0);
    super.BF("");
    super.BG("");
    AppMethodBeat.o(43192);
  }
  
  public final void v(int paramInt, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bb
 * JD-Core Version:    0.7.0.1
 */