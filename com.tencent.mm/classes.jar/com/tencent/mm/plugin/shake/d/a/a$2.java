package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements Runnable
{
  a$2(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.oaG)
    {
      a.a(this.oaF, null, -1L, this.oaH);
      return;
    }
    if (!this.oaF.oau)
    {
      y.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
      return;
    }
    if (this.oaF.bCc != null)
    {
      y.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
      return;
    }
    if (this.oaF.oav != null)
    {
      a locala = this.oaF;
      bly localbly = this.oaF.oav.bAx();
      e locale = this.oaF.oav;
      long l2 = bk.UY();
      long l1 = l2;
      if (locale.oaL > 0L)
      {
        l1 = l2;
        if (locale.oaL < l2) {
          l1 = locale.oaL;
        }
      }
      a.a(locala, localbly, l1, this.oaH);
      return;
    }
    a.a(this.oaF, null, -1L, this.oaH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a.2
 * JD-Core Version:    0.7.0.1
 */