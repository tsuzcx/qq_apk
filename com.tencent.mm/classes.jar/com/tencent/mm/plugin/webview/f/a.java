package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public enum a
{
  private int cnU = 0;
  private int scene = 0;
  
  static
  {
    AppMethodBeat.i(10131);
    vtM = new a("INSTANCE");
    vtN = new a[] { vtM };
    AppMethodBeat.o(10131);
  }
  
  private a() {}
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(10130);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(10130);
      return;
    }
    paramLong = System.currentTimeMillis() - paramLong;
    if ((paramLong < 0L) || (paramLong > 3600000L))
    {
      AppMethodBeat.o(10130);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(",");
    localStringBuilder.append(paramInt2).append(",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",").append(paramInt3).append(",").append(paramLong).append(",").append(paramInt4).append(",").append(paramInt5);
    ab.i("MicroMsg.AuthReport", localStringBuilder.toString());
    h.qsU.e(16488, new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4), Integer.valueOf(0), Integer.valueOf(paramInt5), Integer.valueOf(this.cnU) });
    AppMethodBeat.o(10130);
  }
  
  public final void ap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154627);
    int j = l.LZ();
    int i = j;
    if (j == 100) {
      i = 0;
    }
    if ((paramInt2 < 0) || (paramInt2 > 3600000L))
    {
      AppMethodBeat.o(154627);
      return;
    }
    h.qsU.e(17614, new Object[] { Integer.valueOf(this.cnU), Integer.valueOf(this.scene), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(154627);
  }
  
  public final void reset(int paramInt)
  {
    AppMethodBeat.i(154626);
    this.cnU = ((int)(System.currentTimeMillis() / 1000L));
    this.scene = paramInt;
    AppMethodBeat.o(154626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.a
 * JD-Core Version:    0.7.0.1
 */