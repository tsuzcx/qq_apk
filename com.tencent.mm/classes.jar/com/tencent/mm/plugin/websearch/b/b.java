package com.tencent.mm.plugin.websearch.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rh;
import com.tencent.mm.autogen.mmdata.rpt.rz;
import com.tencent.mm.plugin.websearch.api.as;

public final class b
{
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong)
  {
    AppMethodBeat.i(315392);
    rh localrh = new rh();
    localrh.jvB = paramInt1;
    localrh.jvC = paramInt2;
    paramString1 = localrh.yh(paramString1).yi(paramString2);
    paramString1.jgk = paramInt3;
    paramString1 = paramString1.yj(paramString3).yk(paramString4);
    paramString1.ikE = paramInt4;
    paramString1 = paramString1.yl(paramString5);
    paramString1.izR = paramLong;
    paramString1.bMH();
    as.a(localrh);
    AppMethodBeat.o(315392);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(315386);
    rz localrz = new rz();
    localrz.izg = paramInt1;
    localrz.jwY = localrz.F("EnterSceneId", paramString1, true);
    localrz.ioY = localrz.F("RequestId", paramString2, true);
    localrz.ioV = paramInt2;
    localrz.jvE = localrz.F("QueryKey", paramString3, true);
    localrz.ijk = localrz.F("SessionId", paramString4, true);
    localrz.jwZ = paramInt3;
    localrz.jxa = paramLong;
    localrz.bMH();
    as.a(localrz);
    AppMethodBeat.o(315386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.b
 * JD-Core Version:    0.7.0.1
 */