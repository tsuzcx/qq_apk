package com.tencent.mm.plugin.sns;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.modelstat.o.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class l
  implements k
{
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = o.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, ad.b paramb, ca paramca)
  {
    AppMethodBeat.i(94908);
    if (paramca.erk())
    {
      paramca = k.b.OQ(paramca.field_content);
      if ((paramca != null) && (!Util.isNullOrNil(paramca.fUk))) {
        paramb.k(paramString, paramca.fUk);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final String ao(ca paramca)
  {
    AppMethodBeat.i(94910);
    paramca = o.ao(paramca);
    AppMethodBeat.o(94910);
    return paramca;
  }
  
  public final void b(String paramString, n paramn)
  {
    AppMethodBeat.i(94906);
    o.b(paramString, paramn);
    AppMethodBeat.o(94906);
  }
  
  public final void bc(ca paramca)
  {
    AppMethodBeat.i(94909);
    String str = o.ao(paramca);
    Object localObject;
    emp localemp;
    if (str != null)
    {
      localObject = Base64.decode(str, 0);
      localemp = new emp();
      try
      {
        localemp.parseFrom((byte[])localObject);
        localObject = localemp.Upe;
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
        break label265;
      }
      localObject = o.a.meF.value;
      paramca = paramca.field_content;
      if ((TextUtils.isEmpty(paramca)) || (!paramca.contains("isInteractiveCanvas"))) {
        break label288;
      }
    }
    label265:
    label288:
    for (paramca = "1";; paramca = "0")
    {
      Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene=" + (String)localObject + ", adCanvasType=" + paramca + ", srcSnsId=" + localemp.Upe.Uph + ", uxinfo=" + localemp.Upe.RzC + ", statExtStr=" + str);
      ((d)h.ae(d.class)).a(13235, new Object[] { localObject, localemp.Upe.Uph, localemp.Upe.RzC, "", "", paramca });
      AppMethodBeat.o(94909);
      return;
      localObject = o.a.meE.value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l
 * JD-Core Version:    0.7.0.1
 */