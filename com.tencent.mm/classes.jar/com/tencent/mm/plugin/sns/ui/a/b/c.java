package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a
{
  public c()
  {
    super(new p());
    AppMethodBeat.i(99844);
    fgY();
    AppMethodBeat.o(99844);
  }
  
  public final String C(long paramLong, String paramString)
  {
    AppMethodBeat.i(179324);
    ad.l("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
    ad.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(af.dtk().dtX()), paramString });
    Object localObject = af.dtu();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = af.dtk().dtX() / 2;
      localObject = com.tencent.mm.plugin.sns.data.q.su(((com.tencent.mm.plugin.sns.storage.q)localObject).f(paramLong, i, false));
      str = dDh();
      if (!str.equals("")) {
        break label141;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = af.dty().apP("@__weixintimtline").dxP();
      if (((afv)localObject).DfN != 0L) {
        break label160;
      }
      AppMethodBeat.o(179324);
      return paramString;
      i = af.dtk().dtX();
      break;
      label141:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label160:
    localObject = com.tencent.mm.plugin.sns.data.q.su(((afv)localObject).DfN);
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
  
  public final String tr(long paramLong)
  {
    AppMethodBeat.i(179325);
    ad.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", new Object[] { Integer.valueOf(af.dtk().dtX()) });
    String str1 = com.tencent.mm.plugin.sns.data.q.su(af.dtu().g(paramLong, af.dtk().dtX(), false));
    String str2 = dDd();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */