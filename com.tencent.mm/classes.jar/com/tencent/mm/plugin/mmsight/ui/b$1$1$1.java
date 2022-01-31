package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class b$1$1$1
  implements Runnable
{
  b$1$1$1(b.1.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(55127);
    b.a(this.oOX.oOW.oOV, h.b(b.e(this.oOX.oOW.oOV), b.e(this.oOX.oOW.oOV).getString(2131301572), false, null));
    b.f(this.oOX.oOW.oOV).pause();
    b.a(this.oOX.oOW.oOV, null);
    AppMethodBeat.o(55127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.1.1.1
 * JD-Core Version:    0.7.0.1
 */