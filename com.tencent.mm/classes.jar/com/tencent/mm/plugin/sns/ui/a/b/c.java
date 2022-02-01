package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  public c()
  {
    super(new SnsInfo());
    AppMethodBeat.i(99844);
    jJA();
    AppMethodBeat.o(99844);
  }
  
  public final String ai(long paramLong, String paramString)
  {
    AppMethodBeat.i(179324);
    Log.printDebugStack("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
    Log.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(al.hgr().hhi()), paramString });
    Object localObject = al.hgB();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = al.hgr().hhi() / 2;
      localObject = t.uB(((w)localObject).h(paramLong, i, false));
      str = hqO();
      if (!str.equals("")) {
        break label141;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = al.hgF().aZW("@__weixintimtline").hkS();
      if (((arc)localObject).Zyu != 0L) {
        break label160;
      }
      AppMethodBeat.o(179324);
      return paramString;
      i = al.hgr().hhi();
      break;
      label141:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label160:
    localObject = t.uB(((arc)localObject).Zyu);
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
  
  public final String vy(long paramLong)
  {
    AppMethodBeat.i(179325);
    Log.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", new Object[] { Integer.valueOf(al.hgr().hhi()) });
    String str1 = t.uB(al.hgB().i(paramLong, al.hgr().hhi(), false));
    String str2 = hqK();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */