package com.tencent.mm.wallet_core.ui;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.n;

public final class f
{
  private static String ghs = null;
  private static int jsT;
  private static int jtf = 0;
  
  static
  {
    jsT = 0;
  }
  
  public static void a(WalletBaseUI paramWalletBaseUI, int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm, boolean paramBoolean)
  {
    int j = 1;
    String str = paramString;
    if (bk.bl(paramString)) {
      str = paramWalletBaseUI.getString(a.i.wallet_unknown_err);
    }
    if ((paramm instanceof o)) {}
    for (boolean bool = ((o)paramm).bqd();; bool = true)
    {
      if ((paramm instanceof l)) {
        bool = ((l)paramm).bZB;
      }
      label640:
      label672:
      for (;;)
      {
        y.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool), paramm });
        Bundle localBundle;
        if ((!(paramm instanceof n)) && (!(paramm instanceof b)))
        {
          if (!(paramm instanceof o)) {
            break label553;
          }
          paramString = (o)paramm;
          if (!paramString.cMw()) {
            break label453;
          }
          y.d("MicroMsg.WalletDispatcher", "order pay end!!!");
          localBundle = paramWalletBaseUI.BX;
          localBundle.putInt("intent_pay_end_errcode", paramInt2);
          localBundle.putString("intent_pay_app_url", paramString.wAB);
          localBundle.putString("intent_wap_pay_jump_url", paramString.wAC);
          localBundle.putBoolean("intent_pay_end", true);
          a.k(paramWalletBaseUI, localBundle);
          break label452;
          if ((!bool) || (!com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramm, paramInt1, paramInt2, str)) || (paramString.bUL())) {
            break label685;
          }
        }
        label553:
        label685:
        for (int i = 0;; i = 1)
        {
          if (i != 0) {
            if (((paramWalletBaseUI.cNj() == null) || (!paramWalletBaseUI.cNk().c(paramInt1, paramInt2, str, paramm))) && (!paramWalletBaseUI.c(paramInt1, paramInt2, str, (o)paramm)) && (bool))
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                jtf = paramInt1;
                jsT = paramInt2;
                ghs = str;
                y.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
              }
            }
            else {
              label301:
              if (paramBoolean)
              {
                y.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[] { Boolean.valueOf(bool) });
                if (jsT == 0) {
                  break label672;
                }
                y.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + jsT);
                if (!(paramm instanceof o)) {
                  break label635;
                }
                paramString = ((o)paramm).cMx();
                if (bk.bl(paramString)) {
                  break label635;
                }
                y.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                com.tencent.mm.ui.base.h.a(paramWalletBaseUI.mController.uMN, ghs, null, paramWalletBaseUI.getResources().getString(a.i.wallet_err_alert_btn_err_detail_text), paramWalletBaseUI.getResources().getString(a.i.app_ok), true, new f.2(paramWalletBaseUI, paramString), new f.3(paramWalletBaseUI));
                cNh();
                e.Jc(4);
              }
            }
          }
          label452:
          label453:
          label635:
          for (paramInt1 = j;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label640;
            }
            return;
            if ((!(paramm instanceof com.tencent.mm.wallet_core.tenpay.model.m)) || (!((com.tencent.mm.wallet_core.tenpay.model.m)paramm).qno)) {
              break;
            }
            y.i("MicroMsg.WalletDispatcher", "delay order pay end");
            localBundle = paramWalletBaseUI.BX;
            localBundle.putInt("intent_pay_end_errcode", paramInt2);
            localBundle.putString("intent_pay_app_url", paramString.wAB);
            localBundle.putString("intent_wap_pay_jump_url", paramString.wAC);
            localBundle.putBoolean("intent_pay_end", true);
            a.k(paramWalletBaseUI, localBundle);
            break;
            y.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
            break label301;
            y.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
            break label301;
            if (((paramWalletBaseUI.cNj() != null) && (paramWalletBaseUI.cNk().c(paramInt1, paramInt2, str, paramm))) || (paramWalletBaseUI.c(paramInt1, paramInt2, str, paramm)) || (!bool)) {
              break label301;
            }
            if ((paramInt1 != 0) || (paramInt2 != 0))
            {
              jtf = paramInt1;
              jsT = paramInt2;
              ghs = str;
              y.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
              break label301;
            }
            y.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
            break label301;
          }
          y.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI.mController.uMN, ghs, null, false, new f.1(paramWalletBaseUI));
          return;
          if (paramWalletBaseUI.aSl()) {
            break;
          }
          paramWalletBaseUI.vN(0);
          return;
        }
      }
    }
  }
  
  public static void cNh()
  {
    jtf = 0;
    jsT = 0;
    ghs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */