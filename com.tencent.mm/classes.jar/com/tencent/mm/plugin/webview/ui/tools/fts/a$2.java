package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class a$2
  implements Runnable
{
  a$2(a parama, View paramView1, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80730);
    this.Jpd.JoV[0] = this.Jpe.getY();
    this.Jpd.JoV[1] = (this.Jpe.getY() - this.Jpc.getY());
    float[] arrayOfFloat = this.Jpd.JoV;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      localStringBuffer.append(String.format("[%d]: %.2f,", new Object[] { Integer.valueOf(i), Float.valueOf(arrayOfFloat[i]) }));
      i += 1;
    }
    Log.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
    AppMethodBeat.o(80730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.2
 * JD-Core Version:    0.7.0.1
 */