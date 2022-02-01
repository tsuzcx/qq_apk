package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.r.c;
import com.tencent.mm.protocal.s.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements i
{
  public final void fjV()
  {
    AppMethodBeat.i(149106);
    h.aGY().a(3644, this);
    h.aGY().a(3789, this);
    h.aGY().a(836, this);
    h.aGY().a(3944, this);
    AppMethodBeat.o(149106);
  }
  
  public final void fjW()
  {
    AppMethodBeat.i(149107);
    h.aGY().b(3644, this);
    h.aGY().b(3789, this);
    h.aGY().b(836, this);
    h.aGY().b(3944, this);
    AppMethodBeat.o(149107);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(149108);
    int i;
    if (paramq == null)
    {
      i = -1;
      Log.i("TrustRequestManager", String.format("onSceneEnd: errType = %s errCode = %s errMsg =  %s reqType = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) }));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq.getType() != 3644) && (paramq.getType() != 3789)) {
          break label188;
        }
        paramString = ((s.c)((com.tencent.mm.plugin.normsg.b.b)paramq).getReqResp().getRespObj()).RBR;
        if ((paramString != null) && (paramString.SwU != null))
        {
          paramString = paramString.SwU.toByteArray();
          Log.d("TrustRequestManager", "[debug] onScene end type:[init] dlen:[%d]", new Object[] { Integer.valueOf(paramString.length) });
          d.GxJ.M(paramString, 1, paramInt2);
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        d.GxJ.M(null, 0, paramInt2);
      }
      fjW();
      AppMethodBeat.o(149108);
      return;
      i = paramq.getType();
      break;
      label188:
      if ((paramq.getType() == 836) || (paramq.getType() == 3944))
      {
        paramString = ((r.c)((a)paramq).getReqResp().getRespObj()).RBN;
        if ((paramString != null) && (paramString.SwU != null))
        {
          paramString = paramString.SwU.toByteArray();
          Log.d("TrustRequestManager", "[debug] onScene end type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(paramString.length) });
          d.GxJ.M(paramString, 2, paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.j
 * JD-Core Version:    0.7.0.1
 */