package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acw;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.d.a.b;
import com.tencent.mm.wallet_core.tenpay.model.q;

public final class j
{
  private static String rzc = null;
  private static int yoO;
  private static int ypa = 0;
  
  static
  {
    yoO = 0;
  }
  
  public static void a(WalletBaseUI paramWalletBaseUI, int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(73058);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = paramWalletBaseUI.getString(a.i.wallet_unknown_err);
    }
    boolean bool = true;
    if ((paramp instanceof com.tencent.mm.wallet_core.model.s)) {
      bool = ((com.tencent.mm.wallet_core.model.s)paramp).isBlock();
    }
    if ((paramp instanceof com.tencent.mm.wallet_core.model.p)) {
      bool = ((com.tencent.mm.wallet_core.model.p)paramp).isBlock();
    }
    label559:
    for (;;)
    {
      Log.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool), paramp });
      Bundle localBundle;
      if ((!(paramp instanceof q)) && (!(paramp instanceof b)))
      {
        if (!(paramp instanceof com.tencent.mm.wallet_core.model.s)) {
          break label559;
        }
        paramString = (com.tencent.mm.wallet_core.model.s)paramp;
        if (!paramString.isPayEnd()) {
          break label459;
        }
        Log.d("MicroMsg.WalletDispatcher", "order pay end!!!");
        localBundle = paramWalletBaseUI.getInput();
        localBundle.putInt("intent_pay_end_errcode", paramInt2);
        localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
        localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
        localBundle.putBoolean("intent_pay_end", true);
        a.l(paramWalletBaseUI, localBundle);
        if ((!bool) || (!h.a(paramWalletBaseUI, paramp, paramInt1, paramInt2, str)) || (paramString.callbackUIWhenWalletError())) {
          break label710;
        }
      }
      label306:
      label692:
      label704:
      label710:
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          if (((paramWalletBaseUI.getProcess() == null) || (!paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramp))) && (!paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, (com.tencent.mm.wallet_core.model.s)paramp)) && (bool))
          {
            if ((paramInt1 != 0) || (paramInt2 != 0))
            {
              ypa = paramInt1;
              yoO = paramInt2;
              rzc = str;
              Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            }
          }
          else
          {
            if (!paramBoolean) {
              break label704;
            }
            Log.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[] { Boolean.valueOf(bool) });
            if (yoO == 0) {
              break label692;
            }
            Log.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + yoO);
            if (!(paramp instanceof com.tencent.mm.wallet_core.model.s)) {
              break label641;
            }
            paramString = ((com.tencent.mm.wallet_core.model.s)paramp).getErrDetailUrl();
            if (Util.isNullOrNil(paramString)) {
              break label641;
            }
            Log.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
            k.a(paramWalletBaseUI.getContext(), rzc, null, paramWalletBaseUI.getResources().getString(a.i.wallet_err_alert_btn_err_detail_text), paramWalletBaseUI.getResources().getString(a.i.app_ok), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73056);
                j.c(j.this);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("rawUrl", paramString);
                i.aS(j.this.getContext(), paramAnonymousDialogInterface);
                i.aGA(3);
                AppMethodBeat.o(73056);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73057);
                j.c(j.this);
                AppMethodBeat.o(73057);
              }
            });
            clearErr();
            i.aGA(4);
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label646;
          }
          AppMethodBeat.o(73058);
          return;
          label459:
          if ((!(paramp instanceof com.tencent.mm.wallet_core.tenpay.model.p)) || (!((com.tencent.mm.wallet_core.tenpay.model.p)paramp).checkPaySuccess())) {
            break;
          }
          Log.i("MicroMsg.WalletDispatcher", "delay order pay end");
          localBundle = paramWalletBaseUI.getInput();
          localBundle.putInt("intent_pay_end_errcode", paramInt2);
          localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
          localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
          localBundle.putBoolean("intent_pay_end", true);
          a.l(paramWalletBaseUI, localBundle);
          break;
          Log.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
          break label306;
          Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
          break label306;
          if (((paramWalletBaseUI.getProcess() != null) && (paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramp))) || (paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, paramp)) || (!bool)) {
            break label306;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            ypa = paramInt1;
            yoO = paramInt2;
            rzc = str;
            Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            break label306;
          }
          Log.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
          break label306;
        }
        Log.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
        k.a(paramWalletBaseUI.getContext(), rzc, null, paramWalletBaseUI.getResources().getString(a.i.wallet_alert_btn_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73055);
            j.c(j.this);
            if ((paramp != null) && (paramp.getReqResp() != null))
            {
              paramAnonymousDialogInterface = new acw();
              paramAnonymousDialogInterface.igj.uri = paramp.getReqResp().getUri();
              paramAnonymousDialogInterface.publish();
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
    ypa = 0;
    yoO = 0;
    rzc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */