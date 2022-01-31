package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;

final class BaseScanUI$16
  extends ak
{
  BaseScanUI$16(BaseScanUI paramBaseScanUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(80928);
    j localj;
    synchronized (BaseScanUI.u(this.qwI))
    {
      localj = BaseScanUI.a(this.qwI);
      if (paramMessage == null)
      {
        ab.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
        AppMethodBeat.o(80928);
        return;
      }
    }
    if (BaseScanUI.G(this.qwI))
    {
      ab.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", new Object[] { Integer.valueOf(paramMessage.what) });
      AppMethodBeat.o(80928);
      return;
    }
    BaseScanUI.e(this.qwI, true);
    if (BaseScanUI.i(this.qwI) != null)
    {
      if (BaseScanUI.j(this.qwI) == paramMessage.what)
      {
        BaseScanUI.e(this.qwI, false);
        AppMethodBeat.o(80928);
        return;
      }
      BaseScanUI.i(this.qwI).onPause();
      if (BaseScanUI.i(this.qwI).cim() != null) {
        BaseScanUI.i(this.qwI).cim().pJ();
      }
      BaseScanUI.i(this.qwI).onDestroy();
      BaseScanUI.a(this.qwI, null);
    }
    if ((!BaseScanUI.b(this.qwI)) || (BaseScanUI.c(this.qwI)) || (BaseScanUI.a(this.qwI, paramMessage.what))) {
      BaseScanUI.a(this.qwI, false);
    }
    while ((BaseScanUI.H(this.qwI)) && (paramMessage.what != 1))
    {
      Toast.makeText(this.qwI, 2131302888, 0).show();
      this.qwI.ab(1, 0L);
      BaseScanUI.e(this.qwI, false);
      AppMethodBeat.o(80928);
      return;
      BaseScanUI.a(this.qwI, true);
    }
    if (this.qwI.isFinishing())
    {
      ab.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler is invoke after ui was destroyed, msg.what=[%s]", new Object[] { Integer.valueOf(paramMessage.what) });
      AppMethodBeat.o(80928);
      return;
    }
    if (localj != null) {
      localj.CQ(paramMessage.what);
    }
    this.qwI.cix();
    BaseScanUI.b(this.qwI, false);
    BaseScanUI.b(this.qwI, paramMessage.what);
    ab.i("MicroMsg.scanner.BaseScanUI", "alvinluo scan changeMode currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.j(this.qwI)) });
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      if ((localj != null) && (localj.isOpen()) && (localj.miS))
      {
        localj.cjC();
        localj.CS(1);
      }
      n.qux.reset();
      if ((BaseScanUI.j(this.qwI) != 3) || (!t.cjO())) {
        BaseScanUI.L(this.qwI);
      }
      if ((!BaseScanUI.c(this.qwI)) && (BaseScanUI.s(this.qwI))) {
        BaseScanUI.M(this.qwI);
      }
      BaseScanUI.e(this.qwI, false);
      AppMethodBeat.o(80928);
      return;
      if (BaseScanUI.I(this.qwI))
      {
        this.qwI.setMMTitle(2131302896);
        BaseScanUI.a(this.qwI, new p(this.qwI, BaseScanUI.B(this.qwI), BaseScanUI.J(this.qwI), 1));
      }
      else
      {
        this.qwI.setMMTitle(2131302897);
        BaseScanUI.a(this.qwI, new p(this.qwI, BaseScanUI.B(this.qwI), BaseScanUI.J(this.qwI), 0));
        continue;
        this.qwI.setMMTitle(2131302897);
        BaseScanUI.a(this.qwI, new p(this.qwI, BaseScanUI.B(this.qwI), BaseScanUI.J(this.qwI), 2));
        continue;
        this.qwI.setMMTitle(2131302896);
        BaseScanUI.a(this.qwI, new p(this.qwI, BaseScanUI.B(this.qwI), BaseScanUI.J(this.qwI), 1));
        continue;
        this.qwI.setMMTitle(t.ge(t.qDP, this.qwI.getString(2131302906)));
        BaseScanUI.a(this.qwI, new k(this.qwI, BaseScanUI.B(this.qwI)));
        continue;
        this.qwI.setMMTitle(2131302894);
        BaseScanUI.a(this.qwI, new o(this.qwI, BaseScanUI.B(this.qwI)));
        if (t.cjO())
        {
          paramMessage = new Intent();
          ??? = d.eI(BaseScanUI.K(this.qwI));
          if (??? != null) {}
          try
          {
            Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
            e.chX();
            d.a((Bitmap)???, 70, localCompressFormat, e.Yw("jpg"), true);
            e.chX();
            paramMessage.putExtra("key_first_background", e.Yw("jpg"));
            paramMessage.setClass(this.qwI, ScanTranslationCaptureUI.class);
            this.qwI.startActivity(paramMessage);
            this.qwI.overridePendingTransition(2131034130, 2131034130);
            BaseScanUI.E(this.qwI);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "get scan ui bg failed!", new Object[0]);
            }
          }
          this.qwI.setMMTitle(2131302898);
          BaseScanUI.a(this.qwI, new q(this.qwI, BaseScanUI.B(this.qwI)));
          BaseScanUI.b(this.qwI, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.16
 * JD-Core Version:    0.7.0.1
 */