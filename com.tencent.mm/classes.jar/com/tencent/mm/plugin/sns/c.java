package com.tencent.mm.plugin.sns;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.modelstat.o.a;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class c
  implements l
{
  public final String a(String paramString, PString paramPString)
  {
    AppMethodBeat.i(94907);
    paramString = o.a(paramString, paramPString);
    AppMethodBeat.o(94907);
    return paramString;
  }
  
  public final void a(String paramString, ad.b paramb, cc paramcc)
  {
    AppMethodBeat.i(94908);
    if (paramcc.fxR())
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (!Util.isNullOrNil(paramcc.iah))) {
        paramb.q(paramString, paramcc.iah);
      }
    }
    AppMethodBeat.o(94908);
  }
  
  public final String at(cc paramcc)
  {
    AppMethodBeat.i(94910);
    paramcc = o.at(paramcc);
    AppMethodBeat.o(94910);
    return paramcc;
  }
  
  public final void b(String paramString, n paramn)
  {
    AppMethodBeat.i(94906);
    o.b(paramString, paramn);
    AppMethodBeat.o(94906);
  }
  
  public final void bt(cc paramcc)
  {
    AppMethodBeat.i(94909);
    String str = o.at(paramcc);
    Object localObject;
    fhn localfhn;
    if (str != null)
    {
      localObject = Base64.decode(str, 0);
      localfhn = new fhn();
      try
      {
        localfhn.parseFrom((byte[])localObject);
        localObject = localfhn.abIc;
        if (localObject == null)
        {
          AppMethodBeat.o(94909);
          return;
        }
      }
      catch (Exception paramcc)
      {
        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramcc, "", new Object[0]);
        AppMethodBeat.o(94909);
        return;
      }
      if (!paramcc.field_talker.endsWith("@chatroom")) {
        break label263;
      }
      localObject = o.a.oXx.value;
      paramcc = paramcc.field_content;
      if (TextUtils.isEmpty(paramcc)) {
        break label301;
      }
      if (!com.tencent.mm.plugin.sns.ad.d.a.c.aWs(paramcc)) {
        break label286;
      }
      paramcc = "2";
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene=" + (String)localObject + ", adCanvasType=" + paramcc + ", srcSnsId=" + localfhn.abIc.abIf + ", uxinfo=" + localfhn.abIc.Ywb + ", statExtStr=" + str);
      ((d)h.ax(d.class)).b(13235, new Object[] { localObject, localfhn.abIc.abIf, localfhn.abIc.Ywb, "", "", paramcc });
      AppMethodBeat.o(94909);
      return;
      label263:
      localObject = o.a.oXw.value;
      break;
      label286:
      if (paramcc.contains("isInteractiveCanvas")) {
        paramcc = "1";
      } else {
        label301:
        paramcc = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */