package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

final class a$1
  implements Runnable
{
  a$1(a parama, View paramView) {}
  
  public final void run()
  {
    this.rvA.rvs[0][0] = this.rvz.getY();
    this.rvA.rvs[0][1] = 0;
    this.rvA.rvs[1][0] = this.rvz.getX();
    this.rvA.rvs[1][1] = 0;
    this.rvA.rvs[2][0] = this.rvz.getMeasuredWidth();
    this.rvA.rvs[2][1] = (this.rvz.getMeasuredWidth() + this.rvA.rvg * 2);
    y.i("MicroMsg.FTS.SosAnimatorBaseController", "searchBarData %s", new Object[] { Arrays.toString(this.rvA.rvs) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.1
 * JD-Core Version:    0.7.0.1
 */