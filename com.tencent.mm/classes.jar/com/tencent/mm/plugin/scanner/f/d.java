package com.tencent.mm.plugin.scanner.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.qa.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.scanlib.ui.ScanView;

public final class d
  extends e
  implements i, e.a
{
  private int CIR;
  private boolean CIS;
  private com.tencent.mm.plugin.scanner.util.c CIT;
  private a CIU;
  private com.tencent.mm.plugin.scanner.view.c CIV;
  
  public d(int paramInt1, int paramInt2, ScanView paramScanView, a parama, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51660);
    this.mode = paramInt1;
    this.CIR = paramInt2;
    this.CIW = paramScanView;
    this.CIU = parama;
    this.context = paramScanView.getContext();
    this.CIV = paramc;
    this.CIS = true;
    g.azz().a(971, this);
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
    int i = e.d.bcV(str2);
    int j = paramBundle.getInt("result_code_version", 0);
    int k = paramBundle.getInt("qbar_string_scan_source", 0);
    Log.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j) });
    Activity localActivity;
    com.tencent.mm.plugin.scanner.view.c localc;
    if (!Util.isNullOrNil(str1))
    {
      paramBundle = new qa();
      paramBundle.dWj.dWl = str2;
      paramBundle.dWj.scanResult = str1;
      paramBundle.dWj.cSx = 1;
      EventCenter.instance.publish(paramBundle);
      if (paramBundle.dWk.ret == 1)
      {
        if (this.CIU != null)
        {
          this.CIU.cvn();
          AppMethodBeat.o(51661);
        }
      }
      else
      {
        if (this.CIT != null) {
          this.CIT.eRR();
        }
        if (e.d.ahw(i))
        {
          this.CIT = new com.tencent.mm.plugin.scanner.util.c();
          this.CIT.a((Activity)this.CIW.getContext(), str1, k, str2, i, j, this, this.CIV, null, this.CIR, false, -1, this.CIS);
          AppMethodBeat.o(51661);
          return;
        }
        if (k != 1) {
          break label342;
        }
        i = 1;
        paramBundle = new a();
        localActivity = (Activity)this.CIW.getContext();
        localc = this.CIV;
        if (k != 1) {
          break label348;
        }
      }
    }
    label342:
    label348:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.a(localActivity, this, localc, str1, bool, j, str2, null, this.CIR, false, -1, this.CIS, i);
      AppMethodBeat.o(51661);
      return;
      i = 0;
      break;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(51664);
    g.azz().b(971, this);
    if (this.CIT != null) {
      this.CIT.eRR();
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
      r(0, null);
      AppMethodBeat.o(51662);
      return;
      if (g.azz().aYT())
      {
        g.azz().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ag.dm(this.context)) {
          m.iC(this.context);
        } else {
          Toast.makeText(this.context, this.context.getString(2131760825, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.context, this.context.getString(2131760826), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      h.n(this.context, 2131764139, 2131755998);
      AppMethodBeat.o(51662);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.context, this.context.getString(2131760877, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(51662);
      return;
    }
    if (paramq.getType() == 971) {
      r(3, null);
    }
    AppMethodBeat.o(51662);
  }
  
  public final void r(int paramInt, Bundle paramBundle)
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
      this.CIW.onResume();
      AppMethodBeat.o(51663);
      return;
      this.CIW.onResume();
      AppMethodBeat.o(51663);
      return;
      if (this.CIU != null)
      {
        this.CIU.cvn();
        AppMethodBeat.o(51663);
        return;
        this.CIW.onPause();
        AppMethodBeat.o(51663);
        return;
        if (this.CIU != null)
        {
          this.CIU.s(1, paramBundle);
          AppMethodBeat.o(51663);
          return;
          if (this.CIU != null)
          {
            this.CIU.s(2, paramBundle);
            AppMethodBeat.o(51663);
            return;
            if (this.CIU != null) {
              this.CIU.s(3, paramBundle);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
    extends e.b
  {
    public abstract void s(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.d
 * JD-Core Version:    0.7.0.1
 */