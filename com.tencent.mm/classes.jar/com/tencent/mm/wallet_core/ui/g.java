package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.e.a.b;

public final class g
{
  private static String kwn = null;
  private static int qgL = 0;
  private static int qgz = 0;
  
  public static void a(WalletBaseUI paramWalletBaseUI, int paramInt1, int paramInt2, final String paramString, final n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(73058);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = paramWalletBaseUI.getString(2131765901);
    }
    boolean bool = true;
    if ((paramn instanceof s)) {
      bool = ((s)paramn).isBlock();
    }
    if ((paramn instanceof com.tencent.mm.wallet_core.c.p)) {
      bool = ((com.tencent.mm.wallet_core.c.p)paramn).isBlock();
    }
    label556:
    for (;;)
    {
      ae.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str, Boolean.valueOf(bool), paramn });
      Bundle localBundle;
      if ((!(paramn instanceof com.tencent.mm.wallet_core.tenpay.model.q)) && (!(paramn instanceof b)))
      {
        if (!(paramn instanceof s)) {
          break label556;
        }
        paramString = (s)paramn;
        if (!paramString.isPayEnd()) {
          break label456;
        }
        ae.d("MicroMsg.WalletDispatcher", "order pay end!!!");
        localBundle = paramWalletBaseUI.getInput();
        localBundle.putInt("intent_pay_end_errcode", paramInt2);
        localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
        localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
        localBundle.putBoolean("intent_pay_end", true);
        com.tencent.mm.wallet_core.a.l(paramWalletBaseUI, localBundle);
        if ((!bool) || (!com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramn, paramInt1, paramInt2, str)) || (paramString.callbackUIWhenWalletError())) {
          break label697;
        }
      }
      label305:
      label691:
      label697:
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          if (((paramWalletBaseUI.getProcess() == null) || (!paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramn))) && (!paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, (s)paramn)) && (bool))
          {
            if ((paramInt1 != 0) || (paramInt2 != 0))
            {
              qgL = paramInt1;
              qgz = paramInt2;
              kwn = str;
              ae.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            }
          }
          else
          {
            if (!paramBoolean) {
              break label691;
            }
            ae.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[] { Boolean.valueOf(bool) });
            if (qgz == 0) {
              break label679;
            }
            ae.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + qgz);
            if (!(paramn instanceof s)) {
              break label638;
            }
            paramString = ((s)paramn).getErrDetailUrl();
            if (bu.isNullOrNil(paramString)) {
              break label638;
            }
            ae.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), kwn, null, paramWalletBaseUI.getResources().getString(2131765249), paramWalletBaseUI.getResources().getString(2131755835), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73056);
                g.c(this.LWS);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("rawUrl", paramString);
                f.an(this.LWS.getContext(), paramAnonymousDialogInterface);
                f.aha(3);
                AppMethodBeat.o(73056);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(73057);
                g.c(this.LWS);
                AppMethodBeat.o(73057);
              }
            });
            clearErr();
            f.aha(4);
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
          if ((!(paramn instanceof com.tencent.mm.wallet_core.tenpay.model.p)) || (!((com.tencent.mm.wallet_core.tenpay.model.p)paramn).checkPaySuccess())) {
            break;
          }
          ae.i("MicroMsg.WalletDispatcher", "delay order pay end");
          localBundle = paramWalletBaseUI.getInput();
          localBundle.putInt("intent_pay_end_errcode", paramInt2);
          localBundle.putString("intent_pay_app_url", paramString.getReturnUrl());
          localBundle.putString("intent_wap_pay_jump_url", paramString.getWappayJumpUrl());
          localBundle.putBoolean("intent_pay_end", true);
          com.tencent.mm.wallet_core.a.l(paramWalletBaseUI, localBundle);
          break;
          ae.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
          break label305;
          ae.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
          break label305;
          if (((paramWalletBaseUI.getProcess() != null) && (paramWalletBaseUI.getNetController().onSceneEnd(paramInt1, paramInt2, str, paramn))) || (paramWalletBaseUI.onSceneEnd(paramInt1, paramInt2, str, paramn)) || (!bool)) {
            break label305;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            qgL = paramInt1;
            qgz = paramInt2;
            kwn = str;
            ae.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
            break label305;
          }
          ae.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
          break label305;
        }
        ae.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI.getContext(), kwn, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(73055);
            g.c(this.LWS);
            if ((paramn != null) && (paramn.getReqResp() != null))
            {
              paramAnonymousDialogInterface = new yn();
              paramAnonymousDialogInterface.dNQ.uri = paramn.getReqResp().getUri();
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
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
    qgL = 0;
    qgz = 0;
    kwn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */