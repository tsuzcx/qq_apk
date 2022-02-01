package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class l
  implements j
{
  public final String U(bl parambl)
  {
    AppMethodBeat.i(94910);
    parambl = p.U(parambl);
    AppMethodBeat.o(94910);
    return parambl;
  }
  
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = p.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, y.b paramb, bl parambl)
  {
    AppMethodBeat.i(94908);
    if (parambl.cxB())
    {
      parambl = k.b.rx(parambl.field_content);
      if ((parambl != null) && (!bt.isNullOrNil(parambl.dxG))) {
        paramb.m(paramString, parambl.dxG);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final void ay(bl parambl)
  {
    AppMethodBeat.i(94909);
    String str = p.U(parambl);
    cxi localcxi;
    if (str != null)
    {
      Object localObject = Base64.decode(str, 0);
      localcxi = new cxi();
      try
      {
        localcxi.parseFrom((byte[])localObject);
        localObject = localcxi.Ept;
        if (localObject == null)
        {
          AppMethodBeat.o(94909);
          return;
        }
      }
      catch (Exception parambl)
      {
        ad.printErrStackTrace("MicroMsg.SnsStatExtUtil", parambl, "", new Object[0]);
        AppMethodBeat.o(94909);
        return;
      }
      if (!parambl.field_talker.endsWith("@chatroom")) {
        break label193;
      }
    }
    label193:
    for (parambl = p.a.hxk.value;; parambl = p.a.hxj.value)
    {
      ad.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { parambl, str, localcxi.Ept.Epw, localcxi.Ept.CoM });
      ((d)g.ab(d.class)).f(13235, new Object[] { parambl, localcxi.Ept.Epw, localcxi.Ept.CoM });
      AppMethodBeat.o(94909);
      return;
    }
  }
  
  public final void b(String paramString, f paramf)
  {
    AppMethodBeat.i(94906);
    p.b(paramString, paramf);
    AppMethodBeat.o(94906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */