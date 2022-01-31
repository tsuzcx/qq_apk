package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.al;

final class ad$1
  implements h.a
{
  ad$1(ad paramad) {}
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(145256);
    if ((this.rgb.ibL != null) && (this.rgb.qAL.equals(paramString))) {
      al.d(new ad.1.4(this, paramString, paramInt));
    }
    AppMethodBeat.o(145256);
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145253);
    if ((this.rgb.ibL != null) && (this.rgb.qAL.equals(paramString))) {
      al.d(new ad.1.1(this, paramString, paramInt1, paramInt2));
    }
    AppMethodBeat.o(145253);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145254);
    if ((this.rgb.ibL != null) && (this.rgb.qAL.equals(paramString))) {
      al.d(new ad.1.2(this, paramString, paramInt1, paramInt2));
    }
    AppMethodBeat.o(145254);
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145255);
    if ((this.rgb.ibL != null) && (this.rgb.qAL.equals(paramString))) {
      al.d(new ad.1.3(this, paramString, paramInt1, paramInt2));
    }
    AppMethodBeat.o(145255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad.1
 * JD-Core Version:    0.7.0.1
 */