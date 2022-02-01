package com.tencent.mm.plugin.scanner.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oy.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.plugin.scanner.view.b;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.scanlib.ui.ScanView;

public final class d
  extends e
  implements com.tencent.mm.ak.g, e.a
{
  private int xbb;
  private boolean xbc;
  private c xbd;
  private a xbe;
  private b xbf;
  
  public d(int paramInt1, int paramInt2, ScanView paramScanView, a parama, b paramb)
  {
    AppMethodBeat.i(51660);
    this.mode = paramInt1;
    this.xbb = paramInt2;
    this.xbg = paramScanView;
    this.xbe = parama;
    this.context = paramScanView.getContext();
    this.xbf = paramb;
    this.xbc = true;
    com.tencent.mm.kernel.g.agi().a(971, this);
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
    int i = d.d.aFG(str2);
    int j = paramBundle.getInt("result_code_version", 0);
    int k = paramBundle.getInt("qbar_string_scan_source", 0);
    ac.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j) });
    Activity localActivity;
    b localb;
    if (!bs.isNullOrNil(str1))
    {
      paramBundle = new oy();
      paramBundle.drz.drB = str2;
      paramBundle.drz.scanResult = str1;
      paramBundle.drz.drx = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      if (paramBundle.drA.ret == 1)
      {
        if (this.xbe != null)
        {
          this.xbe.bRD();
          AppMethodBeat.o(51661);
        }
      }
      else
      {
        if (this.xbd != null) {
          this.xbd.dBn();
        }
        if (d.d.Wn(i))
        {
          this.xbd = new c();
          this.xbd.a((Activity)this.xbg.getContext(), str1, k, str2, i, j, this, this.xbf, null, this.xbb, false, -1, this.xbc);
          AppMethodBeat.o(51661);
          return;
        }
        paramBundle = new com.tencent.mm.plugin.scanner.util.a();
        localActivity = (Activity)this.xbg.getContext();
        localb = this.xbf;
        if (k != 1) {
          break label331;
        }
      }
    }
    label331:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.a(localActivity, this, localb, str1, bool, j, str2, null, this.xbb, false, -1, this.xbc);
      AppMethodBeat.o(51661);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(51664);
    com.tencent.mm.kernel.g.agi().b(971, this);
    if (this.xbd != null) {
      this.xbd.dBn();
    }
    AppMethodBeat.o(51664);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(51662);
    ac.i("MicroMsg.QRCodeHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    while (i != 0)
    {
      s(0, null);
      AppMethodBeat.o(51662);
      return;
      if (com.tencent.mm.kernel.g.agi().aBL())
      {
        com.tencent.mm.kernel.g.agi().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ae.cS(this.context)) {
          k.hx(this.context);
        } else {
          Toast.makeText(this.context, this.context.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.context, this.context.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      h.l(this.context, 2131762118, 2131755906);
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
      s(3, null);
    }
    AppMethodBeat.o(51662);
  }
  
  public final void s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(51663);
    ac.i("MicroMsg.QRCodeHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51663);
      return;
      AppMethodBeat.o(51663);
      return;
      this.xbg.onResume();
      AppMethodBeat.o(51663);
      return;
      this.xbg.onResume();
      AppMethodBeat.o(51663);
      return;
      if (this.xbe != null)
      {
        this.xbe.bRD();
        AppMethodBeat.o(51663);
        return;
        this.xbg.onPause();
        AppMethodBeat.o(51663);
        return;
        if (this.xbe != null)
        {
          this.xbe.dzQ();
          AppMethodBeat.o(51663);
          return;
          if (this.xbe != null) {
            this.xbe.dzR();
          }
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void dzQ();
    
    public abstract void dzR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.d
 * JD-Core Version:    0.7.0.1
 */