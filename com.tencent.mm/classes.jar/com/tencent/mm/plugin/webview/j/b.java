package com.tencent.mm.plugin.webview.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;

public enum b
{
  private int dcS = 0;
  private String extData = "";
  private int scene = 0;
  
  static
  {
    AppMethodBeat.i(82371);
    BwR = new b("INSTANCE");
    BwS = new b[] { BwR };
    AppMethodBeat.o(82371);
  }
  
  private b() {}
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(82369);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(82369);
      return;
    }
    paramLong = System.currentTimeMillis() - paramLong;
    if ((paramLong < 0L) || (paramLong > 3600000L))
    {
      AppMethodBeat.o(82369);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(",");
    localStringBuilder.append(paramInt2).append(",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",").append(paramInt3).append(",").append(paramLong).append(",").append(paramInt4).append(",").append(paramInt5);
    ad.i("MicroMsg.AuthReport", localStringBuilder.toString());
    h.vKh.f(16488, new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(0), Integer.valueOf(paramInt5), Integer.valueOf(this.dcS), this.extData });
    AppMethodBeat.o(82369);
  }
  
  public final void aC(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82370);
    int j = m.Xx();
    int i = j;
    if (j == 100) {
      i = 0;
    }
    if ((paramInt2 < 0) || (paramInt2 > 3600000L))
    {
      AppMethodBeat.o(82370);
      return;
    }
    h.vKh.f(17614, new Object[] { Integer.valueOf(this.dcS), Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(82370);
  }
  
  public final void cy(int paramInt, String paramString)
  {
    AppMethodBeat.i(188751);
    this.dcS = ((int)(System.currentTimeMillis() / 1000L));
    this.scene = paramInt;
    this.extData = x.aCL(paramString);
    AppMethodBeat.o(188751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.b
 * JD-Core Version:    0.7.0.1
 */