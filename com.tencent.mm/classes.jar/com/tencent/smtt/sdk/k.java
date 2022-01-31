package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

final class k
  extends Thread
{
  k(Context paramContext, Handler paramHandler) {}
  
  public final void run()
  {
    int i = an.a().a(true, this.a);
    TbsDownloader.setAppContext(this.a);
    TbsLog.i("QbSdk", "QbSdk preinit ver is " + i);
    if (i == 0) {
      an.a().b(this.a, true);
    }
    TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
    o.a(true).a(this.a, false, false, null);
    bv localbv = bv.a();
    localbv.a(this.a, null);
    boolean bool = localbv.b();
    this.b.sendEmptyMessage(3);
    if (!bool)
    {
      this.b.sendEmptyMessage(2);
      return;
    }
    this.b.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.k
 * JD-Core Version:    0.7.0.1
 */