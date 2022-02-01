package com.tencent.mm.plugin.scanner.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.op.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.plugin.scanner.view.b;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.scanlib.ui.ScanView;

public final class d
  extends e
  implements com.tencent.mm.al.g, e.a
{
  private int vQu;
  private boolean vQv;
  private c vQw;
  private a vQx;
  private b vQy;
  
  public d(int paramInt1, int paramInt2, ScanView paramScanView, a parama, b paramb)
  {
    AppMethodBeat.i(51660);
    this.mode = paramInt1;
    this.vQu = paramInt2;
    this.vQz = paramScanView;
    this.vQx = parama;
    this.context = paramScanView.getContext();
    this.vQy = paramb;
    this.vQv = true;
    com.tencent.mm.kernel.g.aeS().a(971, this);
    AppMethodBeat.o(51660);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(51661);
    if (paramBundle == null)
    {
      AppMethodBeat.o(51661);
      return;
    }
    String str1 = paramBundle.getString("result_content", "");
    String str2 = paramBundle.getString("result_code_name", "");
    int j = d.d.aAo(str2);
    int k = paramBundle.getInt("result_code_version", 0);
    int m = paramBundle.getInt("qbar_string_scan_source", 0);
    ad.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d", new Object[] { str1, Integer.valueOf(j), str2, Integer.valueOf(k) });
    Activity localActivity;
    b localb;
    if (!bt.isNullOrNil(str1))
    {
      paramBundle = new op();
      paramBundle.dtO.dtQ = str2;
      paramBundle.dtO.scanResult = str1;
      paramBundle.dtO.dtM = 1;
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      if (paramBundle.dtP.ret == 1)
      {
        if (this.vQx != null)
        {
          this.vQx.bKq();
          AppMethodBeat.o(51661);
        }
      }
      else
      {
        if (this.vQw != null) {
          this.vQw.dnf();
        }
        if ((j == 19) || (j == 22)) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.vQw = new c();
          this.vQw.a((Activity)this.vQz.getContext(), str1, m, str2, j, k, this, this.vQy, null, this.vQu, false, -1, this.vQv);
          AppMethodBeat.o(51661);
          return;
        }
        paramBundle = new com.tencent.mm.plugin.scanner.util.a();
        localActivity = (Activity)this.vQz.getContext();
        localb = this.vQy;
        if (m != 1) {
          break label351;
        }
      }
    }
    label351:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.a(localActivity, this, localb, str1, bool, k, str2, null, this.vQu, false, -1, this.vQv);
      AppMethodBeat.o(51661);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(51664);
    com.tencent.mm.kernel.g.aeS().b(971, this);
    if (this.vQw != null) {
      this.vQw.dnf();
    }
    AppMethodBeat.o(51664);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(51662);
    ad.i("MicroMsg.QRCodeHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    while (i != 0)
    {
      r(0, null);
      AppMethodBeat.o(51662);
      return;
      if (com.tencent.mm.kernel.g.aeS().auS())
      {
        com.tencent.mm.kernel.g.aeS().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ae.cJ(this.context)) {
          k.hm(this.context);
        } else {
          Toast.makeText(this.context, this.context.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.context, this.context.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      h.j(this.context, 2131762118, 2131755906);
      AppMethodBeat.o(51662);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.context, this.context.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(51662);
      return;
    }
    if (paramn.getType() == 971) {
      r(3, null);
    }
    AppMethodBeat.o(51662);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(51663);
    ad.i("MicroMsg.QRCodeHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51663);
      return;
      AppMethodBeat.o(51663);
      return;
      this.vQz.onResume();
      AppMethodBeat.o(51663);
      return;
      this.vQz.onResume();
      AppMethodBeat.o(51663);
      return;
      if (this.vQx != null)
      {
        this.vQx.bKq();
        AppMethodBeat.o(51663);
        return;
        this.vQz.onPause();
        AppMethodBeat.o(51663);
        return;
        if (this.vQx != null)
        {
          this.vQx.dlK();
          AppMethodBeat.o(51663);
          return;
          if (this.vQx != null) {
            this.vQx.dlL();
          }
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void dlK();
    
    public abstract void dlL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.d
 * JD-Core Version:    0.7.0.1
 */