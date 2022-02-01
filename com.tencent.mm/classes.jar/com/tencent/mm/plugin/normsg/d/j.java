package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.r.c;
import com.tencent.mm.protocal.s.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements com.tencent.mm.am.h
{
  public final void gun()
  {
    AppMethodBeat.i(149106);
    com.tencent.mm.kernel.h.aZW().a(3644, this);
    com.tencent.mm.kernel.h.aZW().a(3789, this);
    com.tencent.mm.kernel.h.aZW().a(836, this);
    com.tencent.mm.kernel.h.aZW().a(3944, this);
    AppMethodBeat.o(149106);
  }
  
  public final void guo()
  {
    AppMethodBeat.i(149107);
    com.tencent.mm.kernel.h.aZW().b(3644, this);
    com.tencent.mm.kernel.h.aZW().b(3789, this);
    com.tencent.mm.kernel.h.aZW().b(836, this);
    com.tencent.mm.kernel.h.aZW().b(3944, this);
    AppMethodBeat.o(149107);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = -1;
    AppMethodBeat.i(149108);
    int j;
    if (paramp == null)
    {
      j = -1;
      Log.i("TrustRequestManager", String.format("onSceneEnd: errType = %s errCode = %s errMsg =  %s reqType = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(j) }));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramp.getType() != 3644) && (paramp.getType() != 3789)) {
          break label199;
        }
        paramString = ((s.c)((com.tencent.mm.plugin.normsg.b.b)paramp).getReqResp().getRespObj()).Yyu;
        if ((paramString != null) && (paramString.ZxE != null))
        {
          paramString = paramString.ZxE.toByteArray();
          if (paramString != null) {
            break label192;
          }
          label129:
          Log.d("TrustRequestManager", "[debug] onScene end type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
          d.MtP.K(paramString, 1, paramInt2);
        }
      }
    }
    label192:
    label199:
    do
    {
      do
      {
        if (paramInt2 != 0) {
          d.MtP.K(null, 0, paramInt2);
        }
        guo();
        AppMethodBeat.o(149108);
        return;
        j = paramp.getType();
        break;
        i = paramString.length;
        break label129;
      } while ((paramp.getType() != 836) && (paramp.getType() != 3944));
      paramString = ((r.c)((a)paramp).getReqResp().getRespObj()).Yyq;
    } while ((paramString == null) || (paramString.ZxE == null));
    paramString = paramString.ZxE.toByteArray();
    if (paramString == null) {}
    for (;;)
    {
      Log.d("TrustRequestManager", "[debug] onScene end type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
      d.MtP.K(paramString, 2, paramInt2);
      break;
      i = paramString.length;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.j
 * JD-Core Version:    0.7.0.1
 */