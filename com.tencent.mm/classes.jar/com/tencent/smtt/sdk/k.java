package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class k
  extends Thread
{
  k(Context paramContext, Handler paramHandler) {}
  
  public final void run()
  {
    AppMethodBeat.i(63988);
    int i = ao.a().a(true, this.a);
    TbsDownloader.setAppContext(this.a);
    TbsLog.i("QbSdk", "QbSdk preinit ver is ".concat(String.valueOf(i)));
    if (i == 0) {
      ao.a().b(this.a, true);
    }
    TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
    o.a(true).a(this.a, false, false, null);
    bz localbz = bz.a();
    localbz.a(this.a, null);
    boolean bool = localbz.b();
    this.b.sendEmptyMessage(3);
    if (!bool)
    {
      this.b.sendEmptyMessage(2);
      AppMethodBeat.o(63988);
      return;
    }
    this.b.sendEmptyMessage(1);
    AppMethodBeat.o(63988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.k
 * JD-Core Version:    0.7.0.1
 */