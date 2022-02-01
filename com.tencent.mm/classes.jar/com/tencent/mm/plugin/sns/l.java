package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class l
  implements j
{
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = p.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, ad.b paramb, ca paramca)
  {
    AppMethodBeat.i(94908);
    if (paramca.dOQ())
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (!Util.isNullOrNil(paramca.ean))) {
        paramb.l(paramString, paramca.ean);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final void aO(ca paramca)
  {
    AppMethodBeat.i(94909);
    String str = p.ag(paramca);
    eco localeco;
    if (str != null)
    {
      Object localObject = Base64.decode(str, 0);
      localeco = new eco();
      try
      {
        localeco.parseFrom((byte[])localObject);
        localObject = localeco.NcH;
        if (localObject == null)
        {
          AppMethodBeat.o(94909);
          return;
        }
      }
      catch (Exception paramca)
      {
        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramca, "", new Object[0]);
        AppMethodBeat.o(94909);
        return;
      }
      if (!paramca.field_talker.endsWith("@chatroom")) {
        break label193;
      }
    }
    label193:
    for (paramca = p.a.jpn.value;; paramca = p.a.jpm.value)
    {
      Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { paramca, str, localeco.NcH.NcK, localeco.NcH.KxO });
      ((d)g.af(d.class)).a(13235, new Object[] { paramca, localeco.NcH.NcK, localeco.NcH.KxO });
      AppMethodBeat.o(94909);
      return;
    }
  }
  
  public final String ag(ca paramca)
  {
    AppMethodBeat.i(94910);
    paramca = p.ag(paramca);
    AppMethodBeat.o(94910);
    return paramca;
  }
  
  public final void b(String paramString, m paramm)
  {
    AppMethodBeat.i(94906);
    p.b(paramString, paramm);
    AppMethodBeat.o(94906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */