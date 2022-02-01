package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/report/Kv17523;", "", "()V", "DATA_TYPE_CLICK", "", "DATA_TYPE_SHOW", "TAG", "", "report", "", "actionType", "userName", "enterTimestamp", "", "messageId", "messageIndex", "itemShowType", "position", "publishTime", "enterScene", "reportClick", "reportShow", "app_release"})
public final class d
{
  private static final int Hga = 1;
  private static final int Hgb = 2;
  public static final d Hgc;
  private static final String TAG = "MicroMsg.Kv17523";
  
  static
  {
    AppMethodBeat.i(39730);
    Hgc = new d();
    TAG = "MicroMsg.Kv17523";
    Hga = 1;
    Hgb = 2;
    AppMethodBeat.o(39730);
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(280996);
    p.k(paramString, "userName");
    int i = Hgb;
    h.IzE.a(17523, new Object[] { Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    AppMethodBeat.o(280996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.d
 * JD-Core Version:    0.7.0.1
 */