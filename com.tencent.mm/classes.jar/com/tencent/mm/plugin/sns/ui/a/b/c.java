package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a
{
  public c()
  {
    super(new p());
    AppMethodBeat.i(99844);
    fSi();
    AppMethodBeat.o(99844);
  }
  
  public final String AQ(long paramLong)
  {
    AppMethodBeat.i(179325);
    ae.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", new Object[] { Integer.valueOf(ah.dXu().dYi()) });
    String str1 = r.zW(ah.dXE().g(paramLong, ah.dXu().dYi(), false));
    String str2 = ehB();
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
  
  public final String F(long paramLong, String paramString)
  {
    AppMethodBeat.i(179324);
    ae.l("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
    ae.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(ah.dXu().dYi()), paramString });
    Object localObject = ah.dXE();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = ah.dXu().dYi() / 2;
      localObject = r.zW(((q)localObject).f(paramLong, i, false));
      str = ehF();
      if (!str.equals("")) {
        break label141;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = ah.dXI().aBw("@__weixintimtline").ecg();
      if (((aju)localObject).Gzo != 0L) {
        break label160;
      }
      AppMethodBeat.o(179324);
      return paramString;
      i = ah.dXu().dYi();
      break;
      label141:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label160:
    localObject = r.zW(((aju)localObject).Gzo);
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