package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.ad.a.b.a;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class p$7
  implements b.a
{
  p$7(p paramp, Activity paramActivity) {}
  
  public final void Lv(String paramString)
  {
    m.nHb.wO(m.nGZ);
    if (this.nMw.nMk != null) {
      this.nMw.nMk.byg();
    }
    if ((this.nMw.dnm == null) || (!this.nMw.dnm.isShowing()))
    {
      this.nMw.nMm = false;
      this.nMw.nMl.set(false);
      this.nMw.nMn = false;
      return;
    }
    if (this.nMw.nLB != null) {
      this.nMw.nLB.ix(true);
    }
    this.nMw.dnm.dismiss();
    m.nHb.bcI();
    h.a(this.val$activity, R.l.qrcode_read_file_failed, R.l.app_tip, new p.7.2(this));
    this.nMw.nMl.set(false);
  }
  
  public final void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 1;
    m.nHb.wO(m.nGZ);
    if (this.nMw.nMk != null) {
      this.nMw.nMk.byg();
    }
    if ((this.nMw.dnm == null) || (!this.nMw.dnm.isShowing()))
    {
      this.nMw.nMm = false;
      this.nMw.nMn = false;
      return;
    }
    if (this.nMw.nLB != null) {
      this.nMw.nLB.ix(true);
    }
    this.nMw.dnm.dismiss();
    if (bk.bl(paramString2))
    {
      m.nHb.bcI();
      h.a(this.val$activity, R.l.qrcode_read_file_failed, R.l.app_tip, new p.7.1(this));
      return;
    }
    bt.If().d(10237, new Object[] { Integer.valueOf(1) });
    this.nMw.nLB.bxy();
    int i = j;
    if (paramInt1 != 19) {
      if (paramInt1 != 22) {
        break label230;
      }
    }
    label230:
    for (i = j;; i = 2)
    {
      p.a(this.nMw, i, paramString2, paramArrayOfByte, paramInt1, paramInt2);
      this.nMw.nMn = false;
      this.nMw.nMl.set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.7
 * JD-Core Version:    0.7.0.1
 */