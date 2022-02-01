package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends a
{
  public c()
  {
    super(new p());
    AppMethodBeat.i(99844);
    fxa();
    AppMethodBeat.o(99844);
  }
  
  public final String A(long paramLong, String paramString)
  {
    AppMethodBeat.i(179324);
    ac.l("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
    ac.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(af.dHH().dIv()), paramString });
    Object localObject = af.dHR();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = af.dHH().dIv() / 2;
      localObject = com.tencent.mm.plugin.sns.data.q.wX(((com.tencent.mm.plugin.sns.storage.q)localObject).f(paramLong, i, false));
      str = dRE();
      if (!str.equals("")) {
        break label141;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = af.dHV().auY("@__weixintimtline").dMm();
      if (((agu)localObject).EyT != 0L) {
        break label160;
      }
      AppMethodBeat.o(179324);
      return paramString;
      i = af.dHH().dIv();
      break;
      label141:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label160:
    localObject = com.tencent.mm.plugin.sns.data.q.wX(((agu)localObject).EyT);
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
  
  public final String xU(long paramLong)
  {
    AppMethodBeat.i(179325);
    ac.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", new Object[] { Integer.valueOf(af.dHH().dIv()) });
    String str1 = com.tencent.mm.plugin.sns.data.q.wX(af.dHR().g(paramLong, af.dHH().dIv(), false));
    String str2 = dRA();
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