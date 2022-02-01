package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.e.a.b;

public final class g
{
  private static String lAr = null;
  private static int rxH = 0;
  private static int rxv = 0;
  
  public static void a(WalletBaseUI paramWalletBaseUI, int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(73058);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = paramWalletBaseUI.getString(2131768354);
    }
    boolean bool = true;
    if ((paramq instanceof com.tencent.mm.wallet_core.c.s)) {
      bool = ((com.tencent.mm.wallet_core.c.s)paramq).isBlock();
    }
    if ((paramq instanceof com.tencent.mm.wallet_core.c.p)) {
      bool = ((com.tencent.mm.wallet_core.c.p)paramq).isBlock();
    }
    label556:
    label688:
    for (;;)
    {
      Log.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool), paramq });
      Bundle localBundle;
      if ((!(paramq instanceof com.tencent.mm.wallet_core.tenpay.model.q)) && (!(paramq instanceof b)))
      {
        if (!(paramq instanceof com.tencent.mm.wallet_core.c.s)) {
          break label556;
        }
        paramString = (com.tencent.mm.wallet_core.c.s)paramq;
        if (!paramString.isPayEnd()) {
          break label456;
        }
        Log.d("MicroMsg.WalletDispatcher", "order pay end!!!");
        localBundle = paramWalletBaseUI.getInput();
        localBundle.putInt("intent_pay_end_errcode", paramInt2);
        localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
        localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
        localBundle.putBoolean("intent_pay_end", true);
        a.m(paramWalletBaseUI, localBundle);
        if ((!bool) || (!com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramq, paramInt1, paramInt2, str)) || (paramString.callbackUIWhenWalletError())) {
          break label706;
        }
      }
      label305:
      label700:
      label706:
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          if (((paramWalletBaseUI.getProcess() == null) || (!paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramq))) && (!paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, (com.tencent.mm.wallet_core.c.s)paramq)) && (bool))
          {
            if ((paramInt1 != 0) || (paramInt2 != 0))
            {
              rxH = paramInt1;
              rxv = paramInt2;
              lAr = str;
              Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            }
          }
          else
          {
            if (!paramBoolean) {
              break label700;
            }
            Log.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[] { Boolean.valueOf(bool) });
            if (rxv == 0) {
              break label688;
            }
            Log.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + rxv);
            if (!(paramq instanceof com.tencent.mm.wallet_core.c.s)) {
              break label638;
            }
            paramString = ((com.tencent.mm.wallet_core.c.s)paramq).getErrDetailUrl();
            if (Util.isNullOrNil(paramString)) {
              break label638;
            }
            Log.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), lAr, null, paramWalletBaseUI.getResources().getString(2131767692), paramWalletBaseUI.getResources().getString(2131755921), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73056);
                g.c(this.RvI);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("rawUrl", paramString);
                f.aA(this.RvI.getContext(), paramAnonymousDialogInterface);
                f.aqm(3);
                AppMethodBeat.o(73056);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73057);
                g.c(this.RvI);
                AppMethodBeat.o(73057);
              }
            });
            clearErr();
            f.aqm(4);
          }
        }
        label456:
        label638:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label643;
          }
          AppMethodBeat.o(73058);
          return;
          if ((!(paramq instanceof com.tencent.mm.wallet_core.tenpay.model.p)) || (!((com.tencent.mm.wallet_core.tenpay.model.p)paramq).checkPaySuccess())) {
            break;
          }
          Log.i("MicroMsg.WalletDispatcher", "delay order pay end");
          localBundle = paramWalletBaseUI.getInput();
          localBundle.putInt("intent_pay_end_errcode", paramInt2);
          localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
          localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
          localBundle.putBoolean("intent_pay_end", true);
          a.m(paramWalletBaseUI, localBundle);
          break;
          Log.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
          break label305;
          Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
          break label305;
          if (((paramWalletBaseUI.getProcess() != null) && (paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramq))) || (paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, paramq)) || (!bool)) {
            break label305;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            rxH = paramInt1;
            rxv = paramInt2;
            lAr = str;
            Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            break label305;
          }
          Log.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
          break label305;
        }
        Log.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), lAr, null, paramWalletBaseUI.getResources().getString(2131767406), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73055);
            g.c(this.RvI);
            if ((paramq != null) && (paramq.getReqResp() != null))
            {
              paramAnonymousDialogInterface = new zs();
              paramAnonymousDialogInterface.efL.uri = paramq.getReqResp().getUri();
              EventCenter.instance.publish(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(73055);
          }
        });
        AppMethodBeat.o(73058);
        return;
        if (!paramWalletBaseUI.onProgressFinish()) {
          paramWalletBaseUI.setContentViewVisibility(0);
        }
        AppMethodBeat.o(73058);
        return;
      }
    }
  }
  
  public static void clearErr()
  {
    rxH = 0;
    rxv = 0;
    lAr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */