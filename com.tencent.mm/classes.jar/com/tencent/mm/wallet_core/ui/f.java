package com.tencent.mm.wallet_core.ui;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.p;

public final class f
{
  private static String hyJ = null;
  private static int lCE = 0;
  private static int lCs = 0;
  
  public static void a(WalletBaseUI paramWalletBaseUI, int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(49332);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = paramWalletBaseUI.getString(2131305682);
    }
    boolean bool = true;
    if ((paramm instanceof com.tencent.mm.wallet_core.c.q)) {
      bool = ((com.tencent.mm.wallet_core.c.q)paramm).isBlock();
    }
    if ((paramm instanceof n)) {
      bool = ((n)paramm).isBlock();
    }
    label556:
    for (;;)
    {
      ab.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool), paramm });
      Bundle localBundle;
      if ((!(paramm instanceof com.tencent.mm.wallet_core.tenpay.model.q)) && (!(paramm instanceof b)))
      {
        if (!(paramm instanceof com.tencent.mm.wallet_core.c.q)) {
          break label556;
        }
        paramString = (com.tencent.mm.wallet_core.c.q)paramm;
        if (!paramString.isPayEnd()) {
          break label456;
        }
        ab.d("MicroMsg.WalletDispatcher", "order pay end!!!");
        localBundle = paramWalletBaseUI.getInput();
        localBundle.putInt("intent_pay_end_errcode", paramInt2);
        localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
        localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
        localBundle.putBoolean("intent_pay_end", true);
        a.k(paramWalletBaseUI, localBundle);
        if ((!bool) || (!com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramm, paramInt1, paramInt2, str)) || (paramString.callbackUIWhenWalletError())) {
          break label697;
        }
      }
      label305:
      label691:
      label697:
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          if (((paramWalletBaseUI.getProcess() == null) || (!paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramm))) && (!paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, (com.tencent.mm.wallet_core.c.q)paramm)) && (bool))
          {
            if ((paramInt1 != 0) || (paramInt2 != 0))
            {
              lCE = paramInt1;
              lCs = paramInt2;
              hyJ = str;
              ab.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            }
          }
          else
          {
            if (!paramBoolean) {
              break label691;
            }
            ab.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[] { Boolean.valueOf(bool) });
            if (lCs == 0) {
              break label679;
            }
            ab.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + lCs);
            if (!(paramm instanceof com.tencent.mm.wallet_core.c.q)) {
              break label638;
            }
            paramString = ((com.tencent.mm.wallet_core.c.q)paramm).getErrDetailUrl();
            if (bo.isNullOrNil(paramString)) {
              break label638;
            }
            ab.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), hyJ, null, paramWalletBaseUI.getResources().getString(2131305057), paramWalletBaseUI.getResources().getString(2131297018), true, new f.2(paramWalletBaseUI, paramString), new f.3(paramWalletBaseUI));
            clearErr();
            e.RX(4);
          }
        }
        label456:
        label638:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label643;
          }
          AppMethodBeat.o(49332);
          return;
          if ((!(paramm instanceof p)) || (!((p)paramm).checkPaySuccess())) {
            break;
          }
          ab.i("MicroMsg.WalletDispatcher", "delay order pay end");
          localBundle = paramWalletBaseUI.getInput();
          localBundle.putInt("intent_pay_end_errcode", paramInt2);
          localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
          localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
          localBundle.putBoolean("intent_pay_end", true);
          a.k(paramWalletBaseUI, localBundle);
          break;
          ab.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
          break label305;
          ab.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
          break label305;
          if (((paramWalletBaseUI.getProcess() != null) && (paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramm))) || (paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, paramm)) || (!bool)) {
            break label305;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            lCE = paramInt1;
            lCs = paramInt2;
            hyJ = str;
            ab.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            break label305;
          }
          ab.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
          break label305;
        }
        ab.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), hyJ, null, false, new f.1(paramWalletBaseUI, paramm));
        AppMethodBeat.o(49332);
        return;
        if (!paramWalletBaseUI.onProgressFinish()) {
          paramWalletBaseUI.setContentViewVisibility(0);
        }
        AppMethodBeat.o(49332);
        return;
      }
    }
  }
  
  public static void clearErr()
  {
    lCE = 0;
    lCs = 0;
    hyJ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */