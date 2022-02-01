package com.tencent.mm.plugin.normsg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.r.c;
import com.tencent.mm.protocal.s.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  implements f
{
  public final void dvu()
  {
    AppMethodBeat.i(149106);
    g.aiU().a(3644, this);
    g.aiU().a(3789, this);
    g.aiU().a(836, this);
    g.aiU().a(3944, this);
    AppMethodBeat.o(149106);
  }
  
  public final void dvv()
  {
    AppMethodBeat.i(149107);
    g.aiU().b(3644, this);
    g.aiU().b(3789, this);
    g.aiU().b(836, this);
    g.aiU().b(3944, this);
    AppMethodBeat.o(149107);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(149108);
    int i;
    if (paramn == null)
    {
      i = -1;
      ad.i("TrustRequestManager", String.format("onSceneEnd: errType = %s errCode = %s errMsg =  %s reqType = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) }));
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn.getType() != 3644) && (paramn.getType() != 3789)) {
          break label188;
        }
        paramString = ((s.c)((com.tencent.mm.plugin.normsg.b.b)paramn).getReqResp().getRespObj()).Fos;
        if ((paramString != null) && (paramString.GfZ != null))
        {
          paramString = paramString.GfZ.toByteArray();
          ad.d("TrustRequestManager", "[debug] onScene end type:[init] dlen:[%d]", new Object[] { Integer.valueOf(paramString.length) });
          com.tencent.mm.plugin.normsg.a.b.wtJ.z(paramString, 1, paramInt2);
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        com.tencent.mm.plugin.normsg.a.b.wtJ.z(null, 0, paramInt2);
      }
      dvv();
      AppMethodBeat.o(149108);
      return;
      i = paramn.getType();
      break;
      label188:
      if ((paramn.getType() == 836) || (paramn.getType() == 3944))
      {
        paramString = ((r.c)((a)paramn).getReqResp().getRespObj()).Foo;
        if ((paramString != null) && (paramString.GfZ != null))
        {
          paramString = paramString.GfZ.toByteArray();
          ad.d("TrustRequestManager", "[debug] onScene end type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(paramString.length) });
          com.tencent.mm.plugin.normsg.a.b.wtJ.z(paramString, 2, paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.i
 * JD-Core Version:    0.7.0.1
 */