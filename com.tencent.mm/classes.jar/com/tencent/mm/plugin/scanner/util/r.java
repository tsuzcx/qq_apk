package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import java.util.HashMap;
import java.util.Map;

public final class r
{
  private g.a fFy;
  private Map<String, r.a> jFd;
  
  public r()
  {
    AppMethodBeat.i(81486);
    this.jFd = new HashMap();
    this.fFy = new r.1(this);
    AppMethodBeat.o(81486);
  }
  
  public static String YO(String paramString)
  {
    AppMethodBeat.i(81487);
    paramString = com.tencent.mm.model.r.Zn() + "_" + paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(81487);
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, r.a parama)
  {
    AppMethodBeat.i(81488);
    g localg = new g();
    localg.edp = this.fFy;
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.field_fileType = paramInt;
    localg.field_priority = a.ecF;
    localg.field_needStorage = false;
    localg.field_needCompressImage = true;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    this.jFd.put(paramString1, parama);
    f.afO().e(localg);
    AppMethodBeat.o(81488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.r
 * JD-Core Version:    0.7.0.1
 */