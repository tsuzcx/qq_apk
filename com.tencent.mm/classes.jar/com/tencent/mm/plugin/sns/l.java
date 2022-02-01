package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class l
  implements j
{
  public final String W(bv parambv)
  {
    AppMethodBeat.i(94910);
    parambv = p.W(parambv);
    AppMethodBeat.o(94910);
    return parambv;
  }
  
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = p.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, z.b paramb, bv parambv)
  {
    AppMethodBeat.i(94908);
    if (parambv.cVH())
    {
      parambv = k.b.zb(parambv.field_content);
      if ((parambv != null) && (!bu.isNullOrNil(parambv.dIA))) {
        paramb.k(paramString, parambv.dIA);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final void aC(bv parambv)
  {
    AppMethodBeat.i(94909);
    String str = p.W(parambv);
    djc localdjc;
    if (str != null)
    {
      Object localObject = Base64.decode(str, 0);
      localdjc = new djc();
      try
      {
        localdjc.parseFrom((byte[])localObject);
        localObject = localdjc.HQJ;
        if (localObject == null)
        {
          AppMethodBeat.o(94909);
          return;
        }
      }
      catch (Exception parambv)
      {
        ae.printErrStackTrace("MicroMsg.SnsStatExtUtil", parambv, "", new Object[0]);
        AppMethodBeat.o(94909);
        return;
      }
      if (!parambv.field_talker.endsWith("@chatroom")) {
        break label193;
      }
    }
    label193:
    for (parambv = p.a.iub.value;; parambv = p.a.iua.value)
    {
      ae.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { parambv, str, localdjc.HQJ.HQM, localdjc.HQJ.FEJ });
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(13235, new Object[] { parambv, localdjc.HQJ.HQM, localdjc.HQJ.FEJ });
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