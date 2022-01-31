package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements Runnable
{
  d$2(long paramLong, a parama, WepkgCrossProcessTask paramWepkgCrossProcessTask) {}
  
  public final void run()
  {
    y.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.rQs) });
    if (this.rPE != null) {
      this.rPE.a(this.rPw);
    }
    this.rPw.ahD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d.2
 * JD-Core Version:    0.7.0.1
 */