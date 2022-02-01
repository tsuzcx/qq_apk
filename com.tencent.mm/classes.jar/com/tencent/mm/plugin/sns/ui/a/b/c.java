package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a
{
  public c()
  {
    super(new p());
    AppMethodBeat.i(99844);
    fNN();
    AppMethodBeat.o(99844);
  }
  
  public final String As(long paramLong)
  {
    AppMethodBeat.i(179325);
    ad.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", new Object[] { Integer.valueOf(ag.dTU().dUI()) });
    String str1 = com.tencent.mm.plugin.sns.data.q.zx(ag.dUe().g(paramLong, ag.dTU().dUI(), false));
    String str2 = edU();
    if (str2.equals(""))
    {
      AppMethodBeat.o(179325);
      return str1;
    }
    if (str1.compareTo(str2) <= 0)
    {
      AppMethodBeat.o(179325);
      return str1;
    }
    AppMethodBeat.o(179325);
    return "";
  }
  
  public final String E(long paramLong, String paramString)
  {
    AppMethodBeat.i(179324);
    ad.l("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
    ad.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(ag.dTU().dUI()), paramString });
    Object localObject = ag.dUe();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = ag.dTU().dUI() / 2;
      localObject = com.tencent.mm.plugin.sns.data.q.zx(((com.tencent.mm.plugin.sns.storage.q)localObject).f(paramLong, i, false));
      str = edY();
      if (!str.equals("")) {
        break label141;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = ag.dUi().aAf("@__weixintimtline").dYC();
      if (((ajk)localObject).GgF != 0L) {
        break label160;
      }
      AppMethodBeat.o(179324);
      return paramString;
      i = ag.dTU().dUI();
      break;
      label141:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label160:
    localObject = com.tencent.mm.plugin.sns.data.q.zx(((ajk)localObject).GgF);
    if (paramString.equals(""))
    {
      AppMethodBeat.o(179324);
      return localObject;
    }
    if (((String)localObject).compareTo(paramString) > 0)
    {
      AppMethodBeat.o(179324);
      return localObject;
    }
    AppMethodBeat.o(179324);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */