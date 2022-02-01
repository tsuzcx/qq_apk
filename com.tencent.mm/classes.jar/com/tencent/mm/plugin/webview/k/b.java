package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;

public enum b
{
  private String extData = "";
  private int fwM = 0;
  private int scene = 0;
  
  static
  {
    AppMethodBeat.i(82371);
    QzJ = new b("INSTANCE");
    QzK = new b[] { QzJ };
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
    Log.i("MicroMsg.AuthReport", localStringBuilder.toString());
    h.IzE.a(16488, new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(0), Integer.valueOf(paramInt5), Integer.valueOf(this.fwM), this.extData });
    AppMethodBeat.o(82369);
  }
  
  public final void aS(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82370);
    int j = m.avq();
    int i = j;
    if (j == 100) {
      i = 0;
    }
    if ((paramInt2 < 0) || (paramInt2 > 3600000L))
    {
      AppMethodBeat.o(82370);
      return;
    }
    h.IzE.a(17614, new Object[] { Integer.valueOf(this.fwM), Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(82370);
  }
  
  public final void da(int paramInt, String paramString)
  {
    AppMethodBeat.i(227222);
    this.fwM = ((int)(System.currentTimeMillis() / 1000L));
    this.scene = paramInt;
    this.extData = ab.aXb(paramString);
    AppMethodBeat.o(227222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.b
 * JD-Core Version:    0.7.0.1
 */