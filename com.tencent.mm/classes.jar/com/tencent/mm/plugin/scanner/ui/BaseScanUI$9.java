package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class BaseScanUI$9
  extends ah
{
  BaseScanUI$9(BaseScanUI paramBaseScanUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    h localh;
    synchronized (BaseScanUI.s(this.nJg))
    {
      localh = BaseScanUI.g(this.nJg);
      if (paramMessage == null)
      {
        y.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
        return;
      }
    }
    if (BaseScanUI.C(this.nJg))
    {
      y.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", new Object[] { Integer.valueOf(paramMessage.what) });
      return;
    }
    BaseScanUI.e(this.nJg, true);
    if (BaseScanUI.i(this.nJg) != null)
    {
      if (BaseScanUI.j(this.nJg) == paramMessage.what)
      {
        BaseScanUI.e(this.nJg, false);
        return;
      }
      BaseScanUI.i(this.nJg).onPause();
      if (BaseScanUI.i(this.nJg).bxp() != null) {
        BaseScanUI.i(this.nJg).bxp().nm();
      }
      BaseScanUI.i(this.nJg).onDestroy();
      BaseScanUI.a(this.nJg, null);
    }
    if ((!BaseScanUI.a(this.nJg)) || (BaseScanUI.b(this.nJg))) {
      BaseScanUI.b(this.nJg, false);
    }
    while ((BaseScanUI.D(this.nJg)) && (paramMessage.what != 1))
    {
      Toast.makeText(this.nJg, R.l.scan_device_not_support, 0).show();
      this.nJg.L(1, 0L);
      BaseScanUI.e(this.nJg, false);
      return;
      BaseScanUI.b(this.nJg, true);
    }
    if (this.nJg.isFinishing())
    {
      y.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler is invoke after ui was destroyed, msg.what=[%s]", new Object[] { Integer.valueOf(paramMessage.what) });
      return;
    }
    if (localh != null) {
      localh.wV(paramMessage.what);
    }
    this.nJg.bxx();
    BaseScanUI.a(this.nJg, paramMessage.what);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      if ((localh != null) && (localh.isOpen()) && (localh.jOC))
      {
        localh.bys();
        localh.wX(1);
      }
      m.nHb.reset();
      if ((BaseScanUI.j(this.nJg) != 3) || (!r.byE())) {
        BaseScanUI.H(this.nJg);
      }
      BaseScanUI.e(this.nJg, false);
      return;
      if (BaseScanUI.E(this.nJg))
      {
        this.nJg.setMMTitle(R.l.scan_entry_qrcode);
        BaseScanUI.a(this.nJg, new p(this.nJg, BaseScanUI.y(this.nJg), BaseScanUI.F(this.nJg), 1));
      }
      else
      {
        this.nJg.setMMTitle(R.l.scan_entry_qrcode_zbar);
        BaseScanUI.a(this.nJg, new p(this.nJg, BaseScanUI.y(this.nJg), BaseScanUI.F(this.nJg), 0));
        continue;
        this.nJg.setMMTitle(R.l.scan_entry_qrcode_zbar);
        BaseScanUI.a(this.nJg, new p(this.nJg, BaseScanUI.y(this.nJg), BaseScanUI.F(this.nJg), 2));
        continue;
        this.nJg.setMMTitle(R.l.scan_entry_qrcode);
        BaseScanUI.a(this.nJg, new p(this.nJg, BaseScanUI.y(this.nJg), BaseScanUI.F(this.nJg), 1));
        continue;
        this.nJg.setMMTitle(r.eD(r.nPW, this.nJg.getString(R.l.scan_img_title)));
        BaseScanUI.a(this.nJg, new k(this.nJg, BaseScanUI.y(this.nJg)));
        continue;
        this.nJg.setMMTitle(R.l.scan_entry_ocr);
        BaseScanUI.a(this.nJg, new o(this.nJg, BaseScanUI.y(this.nJg)));
        if (r.byE())
        {
          paramMessage = new Intent();
          ??? = c.dA(BaseScanUI.G(this.nJg));
          if (??? != null) {}
          try
          {
            c.a((Bitmap)???, 70, Bitmap.CompressFormat.JPEG, r.Mn("jpg"), true);
            paramMessage.putExtra("key_first_background", r.Mn("jpg"));
            paramMessage.setClass(this.nJg, ScanTranslationCaptureUI.class);
            this.nJg.startActivity(paramMessage);
            this.nJg.overridePendingTransition(R.a.anim_not_change, R.a.anim_not_change);
            BaseScanUI.A(this.nJg);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "get scan ui bg failed!", new Object[0]);
            }
          }
          this.nJg.setMMTitle(R.l.scan_entry_street);
          BaseScanUI.a(this.nJg, new q(this.nJg, BaseScanUI.y(this.nJg)));
          y.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[] { Boolean.valueOf(a.a(this.nJg, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)), bk.csb() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.9
 * JD-Core Version:    0.7.0.1
 */