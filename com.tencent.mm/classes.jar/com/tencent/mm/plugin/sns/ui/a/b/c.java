package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  public c()
  {
    super(new SnsInfo());
    AppMethodBeat.i(99844);
    hdm();
    AppMethodBeat.o(99844);
  }
  
  public final String JV(long paramLong)
  {
    AppMethodBeat.i(179325);
    Log.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", new Object[] { Integer.valueOf(aj.faE().fbw()) });
    String str1 = r.Jc(aj.faO().h(paramLong, aj.faE().fbw(), false));
    String str2 = fkd();
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
  
  public final String L(long paramLong, String paramString)
  {
    AppMethodBeat.i(179324);
    Log.printDebugStack("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
    Log.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(aj.faE().fbw()), paramString });
    Object localObject = aj.faO();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = aj.faE().fbw() / 2;
      localObject = r.Jc(((n)localObject).g(paramLong, i, false));
      str = fkh();
      if (!str.equals("")) {
        break label141;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = aj.faS().aQr("@__weixintimtline").feM();
      if (((ami)localObject).Lvc != 0L) {
        break label160;
      }
      AppMethodBeat.o(179324);
      return paramString;
      i = aj.faE().fbw();
      break;
      label141:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label160:
    localObject = r.Jc(((ami)localObject).Lvc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */