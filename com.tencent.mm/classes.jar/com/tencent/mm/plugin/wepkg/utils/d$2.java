package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$2
  implements Runnable
{
  d$2(long paramLong, a parama, WepkgCrossProcessTask paramWepkgCrossProcessTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(63650);
    ab.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.vHk) });
    if (this.vGw != null) {
      this.vGw.a(this.vGn);
    }
    this.vGn.aBk();
    AppMethodBeat.o(63650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d.2
 * JD-Core Version:    0.7.0.1
 */