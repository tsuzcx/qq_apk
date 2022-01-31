package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$4
  implements Runnable
{
  u$4(boolean paramBoolean, u.b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80460);
    if (this.wgg)
    {
      this.wgf.amY("javascript:document.getElementById('_edw_iframe_').src = '" + this.wgh + "' + " + this.vdV);
      AppMethodBeat.o(80460);
      return;
    }
    this.wgf.amY("javascript:console.log('" + this.wgh + "' + " + this.vdV + ")");
    AppMethodBeat.o(80460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u.4
 * JD-Core Version:    0.7.0.1
 */