package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;

final class b$12
  implements e.a
{
  b$12(b paramb) {}
  
  public final void Es()
  {
    AppMethodBeat.i(55160);
    if (b.s(this.oOV) > 0)
    {
      b.f(this.oOV).e(b.s(this.oOV), true);
      AppMethodBeat.o(55160);
      return;
    }
    b.f(this.oOV).e(0.0D, true);
    AppMethodBeat.o(55160);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG() {}
  
  public final void onError(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.12
 * JD-Core Version:    0.7.0.1
 */