package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;

final class b$11
  implements c.b
{
  b$11(b paramb) {}
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55157);
    if (b.f(this.oOV) == null)
    {
      AppMethodBeat.o(55157);
      return;
    }
    int i = b.d(this.oOV);
    b.a(this.oOV, Math.round(i * paramFloat1));
    b.b(this.oOV, Math.round(i * paramFloat2));
    ab.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", new Object[] { Integer.valueOf(b.s(this.oOV)), Integer.valueOf(b.c(this.oOV)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    b.f(this.oOV).e(b.s(this.oOV), true);
    AppMethodBeat.o(55157);
  }
  
  public final void W(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140587);
    if (b.f(this.oOV) == null)
    {
      AppMethodBeat.o(140587);
      return;
    }
    b.f(this.oOV).pause();
    AppMethodBeat.o(140587);
  }
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55159);
    if (b.f(this.oOV) == null)
    {
      AppMethodBeat.o(55159);
      return;
    }
    int i = b.d(this.oOV);
    b.a(this.oOV, Math.round(i * paramFloat1));
    b.b(this.oOV, Math.round(i * paramFloat2));
    if (b.c(this.oOV) <= 0) {
      b.b(this.oOV, 1000);
    }
    b.f(this.oOV).e(b.s(this.oOV), true);
    ab.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", new Object[] { Integer.valueOf(b.s(this.oOV)), Integer.valueOf(b.c(this.oOV)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    AppMethodBeat.o(55159);
  }
  
  public final void Y(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.11
 * JD-Core Version:    0.7.0.1
 */