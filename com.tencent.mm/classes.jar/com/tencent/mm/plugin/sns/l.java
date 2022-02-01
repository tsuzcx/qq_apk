package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class l
  implements j
{
  public final String X(bu parambu)
  {
    AppMethodBeat.i(94910);
    parambu = p.X(parambu);
    AppMethodBeat.o(94910);
    return parambu;
  }
  
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = p.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, y.b paramb, bu parambu)
  {
    AppMethodBeat.i(94908);
    if (parambu.cTc())
    {
      parambu = k.b.yr(parambu.field_content);
      if ((parambu != null) && (!bt.isNullOrNil(parambu.dHv))) {
        paramb.k(paramString, parambu.dHv);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final void aD(bu parambu)
  {
    AppMethodBeat.i(94909);
    String str = p.X(parambu);
    dih localdih;
    if (str != null)
    {
      Object localObject = Base64.decode(str, 0);
      localdih = new dih();
      try
      {
        localdih.parseFrom((byte[])localObject);
        localObject = localdih.Hxa;
        if (localObject == null)
        {
          AppMethodBeat.o(94909);
          return;
        }
      }
      catch (Exception parambu)
      {
        ad.printErrStackTrace("MicroMsg.SnsStatExtUtil", parambu, "", new Object[0]);
        AppMethodBeat.o(94909);
        return;
      }
      if (!parambu.field_talker.endsWith("@chatroom")) {
        break label193;
      }
    }
    label193:
    for (parambu = p.a.irg.value;; parambu = p.a.irf.value)
    {
      ad.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { parambu, str, localdih.Hxa.Hxd, localdih.Hxa.Fml });
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(13235, new Object[] { parambu, localdih.Hxa.Hxd, localdih.Hxa.Fml });
      AppMethodBeat.o(94909);
      return;
    }
  }
  
  public final void b(String paramString, com.tencent.mm.modelsns.g paramg)
  {
    AppMethodBeat.i(94906);
    p.b(paramString, paramg);
    AppMethodBeat.o(94906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */