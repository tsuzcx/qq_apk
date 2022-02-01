package com.tencent.mm.plugin.scanner.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.f.a.qy.b;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.a.j;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.scanlib.ui.ScanView;

public final class d
  extends e
  implements i, e.a
{
  private int IOr;
  private boolean IOs;
  private com.tencent.mm.plugin.scanner.util.c IOt;
  private a IOu;
  private com.tencent.mm.plugin.scanner.view.c IOv;
  
  public d(int paramInt1, int paramInt2, ScanView paramScanView, a parama, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51660);
    this.mode = paramInt1;
    this.IOr = paramInt2;
    this.IOw = paramScanView;
    this.IOu = parama;
    this.context = paramScanView.getContext();
    this.IOv = paramc;
    this.IOs = true;
    com.tencent.mm.kernel.h.aGY().a(971, this);
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
    int i = e.d.boV(str2);
    int j = paramBundle.getInt("result_code_version", 0);
    int k = paramBundle.getInt("qbar_string_scan_source", 0);
    Object localObject1 = null;
    Object localObject2;
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vOk, 0) != 0)
    {
      localObject2 = paramBundle.getByteArray("decode_success_jpeg_data");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramBundle = paramBundle.getString("decode_original_image_path");
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramBundle)) {
          localObject1 = j.aXF(paramBundle);
        }
      }
    }
    Log.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j) });
    if (!Util.isNullOrNil(str1))
    {
      paramBundle = new qy();
      paramBundle.fPO.fPQ = str2;
      paramBundle.fPO.scanResult = str1;
      paramBundle.fPO.cUP = 1;
      EventCenter.instance.publish(paramBundle);
      if (paramBundle.fPP.ret == 1)
      {
        if (this.IOu != null)
        {
          this.IOu.cIP();
          AppMethodBeat.o(51661);
        }
      }
      else
      {
        if (this.IOt != null) {
          this.IOt.fEQ();
        }
        if (e.d.apt(i))
        {
          this.IOt = new com.tencent.mm.plugin.scanner.util.c();
          this.IOt.a((Activity)this.IOw.getContext(), str1, k, str2, i, j, this, this.IOv, null, this.IOr, false, -1, this.IOs, (byte[])localObject1);
          AppMethodBeat.o(51661);
          return;
        }
        if (k != 1) {
          break label408;
        }
        i = 1;
        paramBundle = new a();
        localObject1 = (Activity)this.IOw.getContext();
        localObject2 = this.IOv;
        if (k != 1) {
          break label414;
        }
      }
    }
    label408:
    label414:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.a((Activity)localObject1, this, (com.tencent.mm.plugin.scanner.view.c)localObject2, str1, bool, j, str2, null, this.IOr, false, -1, this.IOs, i);
      AppMethodBeat.o(51661);
      return;
      i = 0;
      break;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(51664);
    com.tencent.mm.kernel.h.aGY().b(971, this);
    if (this.IOt != null) {
      this.IOt.fEQ();
    }
    AppMethodBeat.o(51664);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(51662);
    Log.i("MicroMsg.QRCodeHandler", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
      if (com.tencent.mm.kernel.h.aGY().bii())
      {
        com.tencent.mm.kernel.h.aGY().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ag.dj(this.context)) {
          n.jF(this.context);
        } else {
          Toast.makeText(this.context, this.context.getString(l.i.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.context, this.context.getString(l.i.fmt_iap_err), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.p(this.context, l.i.qrcode_ban_by_expose, l.i.app_tip);
      AppMethodBeat.o(51662);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.context, this.context.getString(l.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(51662);
      return;
    }
    if (paramq.getType() == 971) {
      t(3, null);
    }
    AppMethodBeat.o(51662);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(51663);
    Log.i("MicroMsg.QRCodeHandler", "notify Event: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51663);
      return;
      AppMethodBeat.o(51663);
      return;
      this.IOw.onResume();
      AppMethodBeat.o(51663);
      return;
      this.IOw.onResume();
      AppMethodBeat.o(51663);
      return;
      if (this.IOu != null)
      {
        this.IOu.cIP();
        AppMethodBeat.o(51663);
        return;
        this.IOw.onPause();
        AppMethodBeat.o(51663);
        return;
        if (this.IOu != null)
        {
          this.IOu.u(1, paramBundle);
          AppMethodBeat.o(51663);
          return;
          if (this.IOu != null)
          {
            this.IOu.u(2, paramBundle);
            AppMethodBeat.o(51663);
            return;
            if (this.IOu != null) {
              this.IOu.u(3, paramBundle);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void u(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.d
 * JD-Core Version:    0.7.0.1
 */