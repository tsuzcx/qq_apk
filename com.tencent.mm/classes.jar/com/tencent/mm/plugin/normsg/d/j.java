package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.r.c;
import com.tencent.mm.protocal.s.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements i
{
  public final void eyq()
  {
    AppMethodBeat.i(149106);
    g.azz().a(3644, this);
    g.azz().a(3789, this);
    g.azz().a(836, this);
    g.azz().a(3944, this);
    AppMethodBeat.o(149106);
  }
  
  public final void eyr()
  {
    AppMethodBeat.i(149107);
    g.azz().b(3644, this);
    g.azz().b(3789, this);
    g.azz().b(836, this);
    g.azz().b(3944, this);
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
        paramString = ((s.c)((com.tencent.mm.plugin.normsg.b.b)paramq).getReqResp().getRespObj()).KAb;
        if ((paramString != null) && (paramString.Luw != null))
        {
          paramString = paramString.Luw.toByteArray();
          Log.d("TrustRequestManager", "[debug] onScene end type:[init] dlen:[%d]", new Object[] { Integer.valueOf(paramString.length) });
          d.AEF.K(paramString, 1, paramInt2);
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        d.AEF.K(null, 0, paramInt2);
      }
      eyr();
      AppMethodBeat.o(149108);
      return;
      i = paramq.getType();
      break;
      label188:
      if ((paramq.getType() == 836) || (paramq.getType() == 3944))
      {
        paramString = ((r.c)((a)paramq).getReqResp().getRespObj()).KzX;
        if ((paramString != null) && (paramString.Luw != null))
        {
          paramString = paramString.Luw.toByteArray();
          Log.d("TrustRequestManager", "[debug] onScene end type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(paramString.length) });
          d.AEF.K(paramString, 2, paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.j
 * JD-Core Version:    0.7.0.1
 */