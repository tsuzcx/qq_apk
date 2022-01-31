package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends a
{
  public c()
  {
    super(new n());
    AppMethodBeat.i(39954);
    dQd();
    AppMethodBeat.o(39954);
  }
  
  public final String w(long paramLong, String paramString)
  {
    AppMethodBeat.i(39955);
    ab.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(ag.coV().cpD()), paramString });
    Object localObject = ag.cpf();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = ag.coV().cpD() / 2;
      localObject = i.lr(((o)localObject).g(paramLong, i, false));
      str = cwO();
      if (!str.equals("")) {
        break label130;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = ag.cpj().abz("@__weixintimtline").csy();
      if (((abx)localObject).wSq != 0L) {
        break label149;
      }
      AppMethodBeat.o(39955);
      return paramString;
      i = ag.coV().cpD();
      break;
      label130:
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) >= 0) {
        paramString = str;
      }
    }
    label149:
    localObject = i.lr(((abx)localObject).wSq);
    if (paramString.equals(""))
    {
      AppMethodBeat.o(39955);
      return localObject;
    }
    if (((String)localObject).compareTo(paramString) > 0)
    {
      AppMethodBeat.o(39955);
      return localObject;
    }
    AppMethodBeat.o(39955);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */