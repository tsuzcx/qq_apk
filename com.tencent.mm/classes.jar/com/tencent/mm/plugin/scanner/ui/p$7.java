package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.u.a.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class p$7
  implements b.a
{
  p$7(p paramp, Activity paramActivity) {}
  
  public final void XF(String paramString)
  {
    AppMethodBeat.i(81210);
    n.qux.CE(n.quv);
    if (this.qAf.qzR != null) {
      this.qAf.qzR.restartDecoder();
    }
    if ((this.qAf.eeN == null) || (!this.qAf.eeN.isShowing()))
    {
      this.qAf.qzT = false;
      this.qAf.qzS.set(false);
      this.qAf.qzU = false;
      AppMethodBeat.o(81210);
      return;
    }
    if (this.qAf.qzg != null) {
      this.qAf.qzg.kA(true);
    }
    this.qAf.eeN.dismiss();
    n.qux.bJP();
    h.a(this.val$activity, 2131302248, 2131297087, new p.7.2(this));
    this.qAf.qzS.set(false);
    AppMethodBeat.o(81210);
  }
  
  public final void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString3)
  {
    int j = 1;
    AppMethodBeat.i(151681);
    n.qux.CE(n.quv);
    if (this.qAf.qzR != null) {
      this.qAf.qzR.restartDecoder();
    }
    if ((this.qAf.eeN == null) || (!this.qAf.eeN.isShowing()))
    {
      this.qAf.qzT = false;
      this.qAf.qzU = false;
      AppMethodBeat.o(151681);
      return;
    }
    if (this.qAf.qzg != null) {
      this.qAf.qzg.kA(true);
    }
    this.qAf.eeN.dismiss();
    if (bo.isNullOrNil(paramString2))
    {
      n.qux.bJP();
      h.a(this.val$activity, 2131302248, 2131297087, new p.7.1(this));
      AppMethodBeat.o(151681);
      return;
    }
    bv.abc().c(10237, new Object[] { Integer.valueOf(1) });
    this.qAf.qzg.ciy();
    int i = j;
    if (paramInt1 != 19) {
      if (paramInt1 != 22) {
        break label250;
      }
    }
    label250:
    for (i = j;; i = 2)
    {
      p.a(this.qAf, i, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramString3);
      this.qAf.qzU = false;
      this.qAf.qzS.set(false);
      AppMethodBeat.o(151681);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.7
 * JD-Core Version:    0.7.0.1
 */