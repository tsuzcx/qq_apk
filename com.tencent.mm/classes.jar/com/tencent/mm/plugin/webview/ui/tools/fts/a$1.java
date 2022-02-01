package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements Runnable
{
  a$1(a parama, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(80729);
    this.Jpd.JoU[0][0] = this.Jpc.getY();
    this.Jpd.JoU[0][1] = 0;
    this.Jpd.JoU[1][0] = this.Jpc.getX();
    this.Jpd.JoU[1][1] = 0;
    this.Jpd.JoU[2][0] = this.Jpc.getMeasuredWidth();
    this.Jpd.JoU[2][1] = (this.Jpc.getMeasuredWidth() + this.Jpd.zSm * 2);
    float[][] arrayOfFloat = this.Jpd.JoU;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      int j = 0;
      while (j < arrayOfFloat[i].length)
      {
        localStringBuffer.append(String.format("[%d,%d]: %.2f,", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(arrayOfFloat[i][j]) }));
        j += 1;
      }
      i += 1;
    }
    Log.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
    AppMethodBeat.o(80729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.1
 * JD-Core Version:    0.7.0.1
 */