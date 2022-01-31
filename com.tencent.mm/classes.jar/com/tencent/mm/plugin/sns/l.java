package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class l
  implements i
{
  public final String I(bi parambi)
  {
    AppMethodBeat.i(35632);
    parambi = p.I(parambi);
    AppMethodBeat.o(35632);
    return parambi;
  }
  
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(35629);
    paramString = p.a(paramString, paramPString);
    AppMethodBeat.o(35629);
    return paramString;
  }
  
  public final void a(String paramString, v.b paramb, bi parambi)
  {
    AppMethodBeat.i(35630);
    if (parambi.bCn())
    {
      parambi = j.b.mY(parambi.field_content);
      if ((parambi != null) && (!bo.isNullOrNil(parambi.cGU))) {
        paramb.i(paramString, parambi.cGU);
      }
    }
    AppMethodBeat.o(35630);
  }
  
  public final void ai(bi parambi)
  {
    AppMethodBeat.i(35631);
    String str = p.I(parambi);
    cgh localcgh;
    if (str != null)
    {
      Object localObject = Base64.decode(str, 0);
      localcgh = new cgh();
      try
      {
        localcgh.parseFrom((byte[])localObject);
        localObject = localcgh.xQY;
        if (localObject == null)
        {
          AppMethodBeat.o(35631);
          return;
        }
      }
      catch (Exception parambi)
      {
        ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", parambi, "", new Object[0]);
        AppMethodBeat.o(35631);
        return;
      }
      if (!parambi.field_talker.endsWith("@chatroom")) {
        break label193;
      }
    }
    label193:
    for (parambi = p.a.fUB.value;; parambi = p.a.fUA.value)
    {
      ab.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { parambi, str, localcgh.xQY.xRb, localcgh.xQY.xRc });
      ((c)g.E(c.class)).e(13235, new Object[] { parambi, localcgh.xQY.xRb, localcgh.xQY.xRc });
      AppMethodBeat.o(35631);
      return;
    }
  }
  
  public final void b(String paramString, d paramd)
  {
    AppMethodBeat.i(35628);
    p.b(paramString, paramd);
    AppMethodBeat.o(35628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */