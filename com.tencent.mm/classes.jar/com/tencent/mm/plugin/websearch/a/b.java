package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kt;
import com.tencent.mm.g.b.a.lk;
import com.tencent.mm.plugin.websearch.api.ar;

public final class b
{
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong)
  {
    AppMethodBeat.i(198078);
    kt localkt = new kt();
    localkt.eXk = paramInt1;
    localkt.eXl = paramInt2;
    paramString1 = localkt.yh(paramString1).yi(paramString2);
    paramString1.eXn = paramInt3;
    paramString1 = paramString1.yj(paramString3).yk(paramString4);
    paramString1.ejA = paramInt4;
    paramString1 = paramString1.yl(paramString5);
    paramString1.eua = paramLong;
    paramString1.bfK();
    ar.a(localkt);
    AppMethodBeat.o(198078);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(198077);
    lk locallk = new lk();
    locallk.etp = paramInt1;
    locallk.eYE = locallk.x("EnterSceneId", paramString1, true);
    locallk.eno = locallk.x("RequestId", paramString2, true);
    locallk.enl = paramInt2;
    locallk.eXp = locallk.x("QueryKey", paramString3, true);
    locallk.eiB = locallk.x("SessionId", paramString4, true);
    locallk.eYF = paramInt3;
    locallk.eYG = paramLong;
    locallk.bfK();
    ar.a(locallk);
    AppMethodBeat.o(198077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.b
 * JD-Core Version:    0.7.0.1
 */