package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/report/Kv17523;", "", "()V", "DATA_TYPE_CLICK", "", "DATA_TYPE_SHOW", "TAG", "", "report", "", "actionType", "userName", "enterTimestamp", "", "messageId", "messageIndex", "itemShowType", "position", "publishTime", "enterScene", "reportClick", "reportShow", "app_release"})
public final class d
{
  private static final String TAG = "MicroMsg.Kv17523";
  private static final int uHW = 1;
  public static final int uHX = 2;
  public static final d uHY;
  
  static
  {
    AppMethodBeat.i(39730);
    uHY = new d();
    TAG = "MicroMsg.Kv17523";
    uHW = 1;
    uHX = 2;
    AppMethodBeat.o(39730);
  }
  
  public static void a(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(39728);
    h.vKh.f(17523, new Object[] { Integer.valueOf(paramInt1), paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
    AppMethodBeat.o(39728);
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(39729);
    k.h(paramString, "userName");
    a(uHW, paramString, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(39729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.d
 * JD-Core Version:    0.7.0.1
 */