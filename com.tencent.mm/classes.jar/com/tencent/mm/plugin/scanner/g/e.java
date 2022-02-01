package com.tencent.mm.plugin.scanner.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.sn;
import com.tencent.mm.autogen.a.sn.b;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.qbar.ScanIdentifyReportInfo;
import com.tencent.scanlib.ui.ScanView;
import java.util.ArrayList;

public final class e
  extends f<Bundle>
  implements com.tencent.mm.am.h, f.a
{
  private int OVt;
  private boolean OVu;
  private com.tencent.mm.plugin.scanner.util.c OVv;
  private a OVw;
  private com.tencent.mm.plugin.scanner.view.c OVx;
  
  public e(int paramInt1, int paramInt2, ScanView paramScanView, a parama, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51660);
    this.mode = paramInt1;
    this.OVt = paramInt2;
    this.OVy = paramScanView;
    this.OVw = parama;
    this.context = paramScanView.getContext();
    this.OVx = paramc;
    this.OVu = true;
    com.tencent.mm.kernel.h.aZW().a(971, this);
    AppMethodBeat.o(51660);
  }
  
  public final void aS(Bundle paramBundle)
  {
    AppMethodBeat.i(313562);
    if (paramBundle == null)
    {
      AppMethodBeat.o(313562);
      return;
    }
    String str1 = paramBundle.getString("result_content", "");
    String str2 = paramBundle.getString("result_code_name", "");
    int i = e.e.boP(str2);
    int j = paramBundle.getInt("result_code_version", 0);
    int k = paramBundle.getInt("qbar_string_scan_source", 0);
    boolean bool2 = paramBundle.getBoolean("key_disable_bar_code_jump_scan_goods", false);
    ArrayList localArrayList = paramBundle.getIntegerArrayList("key_scan_tab_bar_type_list");
    paramBundle = (ScanIdentifyReportInfo)paramBundle.getParcelable("ScanIdentifyReportInfo.DecodeKey");
    Log.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d, disableJumpScanGoods: %s", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j), Boolean.valueOf(bool2) });
    Object localObject;
    com.tencent.mm.plugin.scanner.view.c localc;
    if (!Util.isNullOrNil(str1))
    {
      localObject = new sn();
      ((sn)localObject).hVJ.hVL = str2;
      ((sn)localObject).hVJ.scanResult = str1;
      ((sn)localObject).hVJ.eQp = 1;
      ((sn)localObject).publish();
      if (((sn)localObject).hVK.ret == 1)
      {
        if (this.OVw != null)
        {
          this.OVw.dmh();
          AppMethodBeat.o(313562);
        }
      }
      else
      {
        if (this.OVv != null) {
          this.OVv.gTL();
        }
        if (e.e.avx(i))
        {
          this.OVv = new com.tencent.mm.plugin.scanner.util.c();
          this.OVv.a((Activity)this.OVy.getContext(), str1, k, str2, i, j, this, this.OVx, null, this.OVt, false, -1, this.OVu, paramBundle);
          AppMethodBeat.o(313562);
          return;
        }
        if (k != 1) {
          break label375;
        }
        i = 1;
        paramBundle = new a();
        localObject = (Activity)this.OVy.getContext();
        localc = this.OVx;
        if (k != 1) {
          break label380;
        }
      }
    }
    label375:
    label380:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBundle.a((Activity)localObject, this, localc, str1, bool1, j, str2, null, this.OVt, false, -1, this.OVu, bool2, i, localArrayList);
      AppMethodBeat.o(313562);
      return;
      i = 0;
      break;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(51664);
    com.tencent.mm.kernel.h.aZW().b(971, this);
    if (this.OVv != null) {
      this.OVv.gTL();
    }
    AppMethodBeat.o(51664);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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
      w(0, null);
      AppMethodBeat.o(51662);
      return;
      if (com.tencent.mm.kernel.h.aZW().bFR())
      {
        com.tencent.mm.kernel.h.aZW().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ah.eb(this.context)) {
          m.lE(this.context);
        } else {
          Toast.makeText(this.context, this.context.getString(l.i.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.context, this.context.getString(l.i.fmt_iap_err), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      k.s(this.context, l.i.qrcode_ban_by_expose, l.i.app_tip);
      AppMethodBeat.o(51662);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.context, this.context.getString(l.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(51662);
      return;
    }
    if (paramp.getType() == 971) {
      w(3, null);
    }
    AppMethodBeat.o(51662);
  }
  
  public final void w(int paramInt, Bundle paramBundle)
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
      this.OVy.onResume();
      AppMethodBeat.o(51663);
      return;
      this.OVy.onResume();
      AppMethodBeat.o(51663);
      return;
      if (this.OVw != null)
      {
        this.OVw.dmh();
        AppMethodBeat.o(51663);
        return;
        this.OVy.onPause();
        AppMethodBeat.o(51663);
        return;
        if (this.OVw != null)
        {
          this.OVw.x(1, paramBundle);
          AppMethodBeat.o(51663);
          return;
          if (this.OVw != null)
          {
            this.OVw.x(2, paramBundle);
            AppMethodBeat.o(51663);
            return;
            if (this.OVw != null)
            {
              this.OVw.x(3, paramBundle);
              AppMethodBeat.o(51663);
              return;
              if (this.OVw != null) {
                this.OVw.x(4, paramBundle);
              }
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
    extends f.b
  {
    public abstract void x(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.e
 * JD-Core Version:    0.7.0.1
 */