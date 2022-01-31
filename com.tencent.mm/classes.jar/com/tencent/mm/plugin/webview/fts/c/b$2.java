package com.tencent.mm.plugin.webview.fts.c;

import android.os.Looper;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
import com.tencent.mm.sdk.platformtools.bf;

final class b$2
  implements FtsWebVideoView.a
{
  b$2(b paramb, int paramInt, a parama) {}
  
  public final void aiZ()
  {
    com.tencent.mm.plugin.webview.fts.ui.b localb = this.rbo.rbl;
    b.5 local5 = new b.5(localb, Boolean.valueOf(false), this.rbp);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ((Boolean)local5.b(null)).booleanValue();
      return;
    }
    ((Boolean)local5.b(localb.mHandler)).booleanValue();
  }
  
  public final boolean isFullScreen()
  {
    return this.rbo.rbl.mi(this.rbp);
  }
  
  public final void lc(boolean paramBoolean)
  {
    com.tencent.mm.plugin.webview.fts.ui.b localb = this.rbo.rbl;
    b.4 local4 = new b.4(localb, Boolean.valueOf(false), this.rbp, this.rbq, paramBoolean);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ((Boolean)local4.b(null)).booleanValue();
      return;
    }
    ((Boolean)local4.b(localb.mHandler)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b.2
 * JD-Core Version:    0.7.0.1
 */