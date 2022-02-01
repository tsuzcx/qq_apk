package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class l
  implements j
{
  public final String U(bo parambo)
  {
    AppMethodBeat.i(94910);
    parambo = p.U(parambo);
    AppMethodBeat.o(94910);
    return parambo;
  }
  
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = p.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, y.b paramb, bo parambo)
  {
    AppMethodBeat.i(94908);
    if (parambo.cKN())
    {
      parambo = k.b.vA(parambo.field_content);
      if ((parambo != null) && (!bs.isNullOrNil(parambo.dvs))) {
        paramb.l(paramString, parambo.dvs);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final void aA(bo parambo)
  {
    AppMethodBeat.i(94909);
    String str = p.U(parambo);
    dcu localdcu;
    if (str != null)
    {
      Object localObject = Base64.decode(str, 0);
      localdcu = new dcu();
      try
      {
        localdcu.parseFrom((byte[])localObject);
        localObject = localdcu.FMs;
        if (localObject == null)
        {
          AppMethodBeat.o(94909);
          return;
        }
      }
      catch (Exception parambo)
      {
        ac.printErrStackTrace("MicroMsg.SnsStatExtUtil", parambo, "", new Object[0]);
        AppMethodBeat.o(94909);
        return;
      }
      if (!parambo.field_talker.endsWith("@chatroom")) {
        break label193;
      }
    }
    label193:
    for (parambo = p.a.hXL.value;; parambo = p.a.hXK.value)
    {
      ac.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { parambo, str, localdcu.FMs.FMv, localdcu.FMs.DHe });
      ((d)g.ab(d.class)).f(13235, new Object[] { parambo, localdcu.FMs.FMv, localdcu.FMs.DHe });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */