package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;

final class a$a
  implements h.a
{
  private a$a(a parama) {}
  
  public final void a(final String paramString, final int paramInt, d paramd)
  {
    AppMethodBeat.i(37499);
    if ((this.ryN.ibL != null) && (this.ryN.qAL.equals(paramString))) {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37495);
          h.qsU.cT(955, 31);
          a.a.this.ryN.ibL.ad(paramString, paramInt);
          AppMethodBeat.o(37495);
        }
      });
    }
    AppMethodBeat.o(37499);
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37496);
    if ((this.ryN.ibL != null) && (this.ryN.qAL.equals(paramString))) {
      al.d(new a.a.1(this, paramString, paramInt1, paramInt2));
    }
    AppMethodBeat.o(37496);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37497);
    if ((this.ryN.ibL != null) && (this.ryN.qAL.equals(paramString))) {
      al.d(new a.a.2(this, paramString, paramInt1, paramInt2));
    }
    AppMethodBeat.o(37497);
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37498);
    if ((this.ryN.ibL != null) && (this.ryN.qAL.equals(paramString))) {
      al.d(new a.a.3(this, paramString, paramInt1, paramInt2));
    }
    AppMethodBeat.o(37498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a
 * JD-Core Version:    0.7.0.1
 */