package com.tencent.mm.plugin.scanner.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.ph.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.plugin.scanner.view.b;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.scanlib.ui.ScanView;

public final class d
  extends e
  implements f, e.a
{
  private int ypa;
  private boolean ypb;
  private c ypc;
  private a ypd;
  private b ype;
  
  public d(int paramInt1, int paramInt2, ScanView paramScanView, a parama, b paramb)
  {
    AppMethodBeat.i(51660);
    this.mode = paramInt1;
    this.ypa = paramInt2;
    this.ypf = paramScanView;
    this.ypd = parama;
    this.context = paramScanView.getContext();
    this.ype = paramb;
    this.ypb = true;
    g.aiU().a(971, this);
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
    int i = e.d.aLg(str2);
    int j = paramBundle.getInt("result_code_version", 0);
    int k = paramBundle.getInt("qbar_string_scan_source", 0);
    ad.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j) });
    Activity localActivity;
    b localb;
    if (!bt.isNullOrNil(str1))
    {
      paramBundle = new ph();
      paramBundle.dDr.dDt = str2;
      paramBundle.dDr.scanResult = str1;
      paramBundle.dDr.dDp = 1;
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      if (paramBundle.dDs.ret == 1)
      {
        if (this.ypd != null)
        {
          this.ypd.bWi();
          AppMethodBeat.o(51661);
        }
      }
      else
      {
        if (this.ypc != null) {
          this.ypc.dML();
        }
        if (e.d.Ye(i))
        {
          this.ypc = new c();
          this.ypc.a((Activity)this.ypf.getContext(), str1, k, str2, i, j, this, this.ype, null, this.ypa, false, -1, this.ypb);
          AppMethodBeat.o(51661);
          return;
        }
        paramBundle = new com.tencent.mm.plugin.scanner.util.a();
        localActivity = (Activity)this.ypf.getContext();
        localb = this.ype;
        if (k != 1) {
          break label331;
        }
      }
    }
    label331:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.a(localActivity, this, localb, str1, bool, j, str2, null, this.ypa, false, -1, this.ypb);
      AppMethodBeat.o(51661);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(51664);
    g.aiU().b(971, this);
    if (this.ypc != null) {
      this.ypc.dML();
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
      t(0, null);
      AppMethodBeat.o(51662);
      return;
      if (g.aiU().aEO())
      {
        g.aiU().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ae.cP(this.context)) {
          k.hC(this.context);
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
      t(3, null);
    }
    AppMethodBeat.o(51662);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
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
      this.ypf.onResume();
      AppMethodBeat.o(51663);
      return;
      this.ypf.onResume();
      AppMethodBeat.o(51663);
      return;
      if (this.ypd != null)
      {
        this.ypd.bWi();
        AppMethodBeat.o(51663);
        return;
        this.ypf.onPause();
        AppMethodBeat.o(51663);
        return;
        if (this.ypd != null)
        {
          this.ypd.al(paramBundle);
          AppMethodBeat.o(51663);
          return;
          if (this.ypd != null) {
            this.ypd.am(paramBundle);
          }
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void al(Bundle paramBundle);
    
    public abstract void am(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.d
 * JD-Core Version:    0.7.0.1
 */