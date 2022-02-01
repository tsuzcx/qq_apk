package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;

final class a$b$3
  implements Runnable
{
  a$b$3(a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(202090);
    try
    {
      Object localObject = this.DxC.DxB;
      if ((localObject != null) && (((q)localObject).isShowing())) {
        ((q)localObject).dismiss();
      }
      localObject = this.DxC.oXS;
      if ((localObject != null) && (((e)localObject).isShowing())) {
        ((e)localObject).bMo();
      }
      AppMethodBeat.o(202090);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202090);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a.b.3
 * JD-Core Version:    0.7.0.1
 */