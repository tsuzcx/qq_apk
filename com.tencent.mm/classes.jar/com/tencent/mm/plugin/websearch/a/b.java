package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.np;
import com.tencent.mm.f.b.a.oh;
import com.tencent.mm.plugin.websearch.api.ar;

public final class b
{
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong)
  {
    AppMethodBeat.i(198016);
    np localnp = new np();
    localnp.gZP = paramInt1;
    localnp.gZQ = paramInt2;
    paramString1 = localnp.Ez(paramString1).EA(paramString2);
    paramString1.gZS = paramInt3;
    paramString1 = paramString1.EB(paramString3).EC(paramString4);
    paramString1.gef = paramInt4;
    paramString1 = paramString1.ED(paramString5);
    paramString1.gqh = paramLong;
    paramString1.bpa();
    ar.a(localnp);
    AppMethodBeat.o(198016);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(198006);
    oh localoh = new oh();
    localoh.gpu = paramInt1;
    localoh.hbo = localoh.z("EnterSceneId", paramString1, true);
    localoh.git = localoh.z("RequestId", paramString2, true);
    localoh.giq = paramInt2;
    localoh.gZU = localoh.z("QueryKey", paramString3, true);
    localoh.gcU = localoh.z("SessionId", paramString4, true);
    localoh.hbp = paramInt3;
    localoh.hbq = paramLong;
    localoh.bpa();
    ar.a(localoh);
    AppMethodBeat.o(198006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.b
 * JD-Core Version:    0.7.0.1
 */