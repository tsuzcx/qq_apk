package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaz;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.e.a.b;

public final class h
{
  private static String ovI = null;
  private static int vdb;
  private static int vdn = 0;
  
  static
  {
    vdb = 0;
  }
  
  public static void a(WalletBaseUI paramWalletBaseUI, int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(73058);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = paramWalletBaseUI.getString(a.i.wallet_unknown_err);
    }
    boolean bool = true;
    if ((paramq instanceof com.tencent.mm.wallet_core.c.s)) {
      bool = ((com.tencent.mm.wallet_core.c.s)paramq).isBlock();
    }
    if ((paramq instanceof com.tencent.mm.wallet_core.c.p)) {
      bool = ((com.tencent.mm.wallet_core.c.p)paramq).isBlock();
    }
    label559:
    for (;;)
    {
      Log.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool), paramq });
      Bundle localBundle;
      if ((!(paramq instanceof com.tencent.mm.wallet_core.tenpay.model.q)) && (!(paramq instanceof b)))
      {
        if (!(paramq instanceof com.tencent.mm.wallet_core.c.s)) {
          break label559;
        }
        paramString = (com.tencent.mm.wallet_core.c.s)paramq;
        if (!paramString.isPayEnd()) {
          break label459;
        }
        Log.d("MicroMsg.WalletDispatcher", "order pay end!!!");
        localBundle = paramWalletBaseUI.getInput();
        localBundle.putInt("intent_pay_end_errcode", paramInt2);
        localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
        localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
        localBundle.putBoolean("intent_pay_end", true);
        a.m(paramWalletBaseUI, localBundle);
        if ((!bool) || (!com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramq, paramInt1, paramInt2, str)) || (paramString.callbackUIWhenWalletError())) {
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
          if (((paramWalletBaseUI.getProcess() == null) || (!paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramq))) && (!paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, (com.tencent.mm.wallet_core.c.s)paramq)) && (bool))
          {
            if ((paramInt1 != 0) || (paramInt2 != 0))
            {
              vdn = paramInt1;
              vdb = paramInt2;
              ovI = str;
              Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            }
          }
          else
          {
            if (!paramBoolean) {
              break label704;
            }
            Log.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[] { Boolean.valueOf(bool) });
            if (vdb == 0) {
              break label692;
            }
            Log.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + vdb);
            if (!(paramq instanceof com.tencent.mm.wallet_core.c.s)) {
              break label641;
            }
            paramString = ((com.tencent.mm.wallet_core.c.s)paramq).getErrDetailUrl();
            if (Util.isNullOrNil(paramString)) {
              break label641;
            }
            Log.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), ovI, null, paramWalletBaseUI.getResources().getString(a.i.wallet_err_alert_btn_err_detail_text), paramWalletBaseUI.getResources().getString(a.i.app_ok), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73056);
                h.c(this.YXi);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("rawUrl", paramString);
                g.aJ(this.YXi.getContext(), paramAnonymousDialogInterface);
                g.azK(3);
                AppMethodBeat.o(73056);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73057);
                h.c(this.YXi);
                AppMethodBeat.o(73057);
              }
            });
            clearErr();
            g.azK(4);
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
          break label306;
          Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
          break label306;
          if (((paramWalletBaseUI.getProcess() != null) && (paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramq))) || (paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, paramq)) || (!bool)) {
            break label306;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            vdn = paramInt1;
            vdb = paramInt2;
            ovI = str;
            Log.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            break label306;
          }
          Log.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
          break label306;
        }
        Log.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), ovI, null, paramWalletBaseUI.getResources().getString(a.i.wallet_alert_btn_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73055);
            h.c(this.YXi);
            if ((paramq != null) && (paramq.getReqResp() != null))
            {
              paramAnonymousDialogInterface = new aaz();
              paramAnonymousDialogInterface.gab.uri = paramq.getReqResp().getUri();
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
    vdn = 0;
    vdb = 0;
    ovI = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */