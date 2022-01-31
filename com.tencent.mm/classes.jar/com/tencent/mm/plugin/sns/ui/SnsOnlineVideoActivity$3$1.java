package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.e.b;

final class SnsOnlineVideoActivity$3$1
  implements e.b
{
  SnsOnlineVideoActivity$3$1(SnsOnlineVideoActivity.3 param3) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(39144);
    if (SnsOnlineVideoActivity.q(this.rUg.rUf) != null)
    {
      if (SnsOnlineVideoActivity.r(this.rUg.rUf))
      {
        SnsOnlineVideoActivity.q(this.rUg.rUf).ctY();
        AppMethodBeat.o(39144);
        return;
      }
      SnsOnlineVideoActivity.q(this.rUg.rUf).onResume();
    }
    AppMethodBeat.o(39144);
  }
  
  public final void onAnimationStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.3.1
 * JD-Core Version:    0.7.0.1
 */