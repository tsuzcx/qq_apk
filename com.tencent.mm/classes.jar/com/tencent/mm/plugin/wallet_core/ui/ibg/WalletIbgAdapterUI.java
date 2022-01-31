package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletIbgAdapterUI
  extends WalletBaseUI
{
  private void QR(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  private void bXe()
  {
    g.DQ();
    g.DP().Dz().c(ac.a.ush, Boolean.valueOf(true));
    h.a(this, false, getString(a.i.webview_tbs_need_download), "", getString(a.i.webview_tbs_download_ok), getString(a.i.webview_tbs_download_cancel), new WalletIbgAdapterUI.1(this), new WalletIbgAdapterUI.2(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof b)))
    {
      paramInt1 = ((b)paramm).qro;
      paramString = ((b)paramm).jumpUrl;
      y.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[] { paramString, Integer.valueOf(paramInt1) });
      if (paramInt1 == 1)
      {
        paramInt1 = v.a.ckI();
        y.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          bXe();
        case 1: 
        case 4: 
          for (paramInt1 = 0;; paramInt1 = 1)
          {
            if (paramInt1 != 0)
            {
              QR(paramString);
              finish();
            }
            return false;
          }
        }
        g.DQ();
        if (((Boolean)g.DP().Dz().get(ac.a.ush, Boolean.valueOf(false))).booleanValue())
        {
          Toast.makeText(this, getString(a.i.webview_tbs_downloading), 1).show();
          v.a.eP(this);
          finish();
        }
        for (;;)
        {
          paramInt1 = 0;
          break;
          bXe();
        }
      }
      QR(paramString);
      finish();
      return false;
    }
    com.tencent.mm.wallet_core.a.b(this, null, 0);
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(4);
    this.wCh.kh(1564);
    a(new b(), true, false);
  }
  
  public void onDestroy()
  {
    this.wCh.ki(1564);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI
 * JD-Core Version:    0.7.0.1
 */