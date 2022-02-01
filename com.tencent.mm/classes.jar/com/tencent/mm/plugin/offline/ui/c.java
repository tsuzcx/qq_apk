package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.offline.a.u.b;
import com.tencent.mm.plugin.offline.a.u.h;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c
{
  a MAl;
  com.tencent.mm.plugin.wallet_core.ui.u MAm;
  float MAn = 0.0F;
  int MAo = 20000;
  Activity mActivity;
  Vibrator uAL;
  
  public c(Activity paramActivity, a parama)
  {
    this.mActivity = paramActivity;
    this.MAl = parama;
  }
  
  private void aQF(String paramString)
  {
    AppMethodBeat.i(66391);
    Log.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.k.b(this.mActivity, paramString, "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66385);
        f.bp(c.this.mActivity, 0);
        Log.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66385);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66391);
  }
  
  private void aQG(String paramString)
  {
    AppMethodBeat.i(66392);
    Log.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.k.b(this.mActivity, paramString, "", getString(a.i.wallet_wx_offline_promote_coin_purse_limit_fee), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66386);
        f.bp(c.this.mActivity, 0);
        Log.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66386);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66392);
  }
  
  private void aQH(String paramString)
  {
    AppMethodBeat.i(66393);
    Log.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.k.b(this.mActivity, paramString, "", getString(a.i.wallet_wx_offline_change_pay_method), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66373);
        c.this.MAl.gvt();
        Log.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
        AppMethodBeat.o(66373);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66393);
  }
  
  public static boolean gvy()
  {
    AppMethodBeat.i(66395);
    com.tencent.mm.plugin.offline.k.gvj();
    if (com.tencent.mm.plugin.offline.k.gvk().Mzt != null)
    {
      AppMethodBeat.o(66395);
      return true;
    }
    AppMethodBeat.o(66395);
    return false;
  }
  
  public final void a(p paramp, int paramInt, String paramString)
  {
    AppMethodBeat.i(66387);
    a(paramp, paramInt, paramString, null);
    AppMethodBeat.o(66387);
  }
  
  public final void a(p paramp, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(66388);
    Log.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + paramInt + " msg:" + paramString1);
    gvx();
    if (paramInt == 409)
    {
      aQG(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 410)
    {
      aQF(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 413)
    {
      aQH(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 411)
    {
      if ((com.tencent.mm.plugin.wallet_core.model.u.iiC().ijh()) || (com.tencent.mm.plugin.wallet_core.model.u.iiC().ijg()))
      {
        Log.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
        AppMethodBeat.o(66388);
        return;
      }
      if ((com.tencent.mm.plugin.offline.k.Myo) && ((this.mActivity instanceof WalletOfflineCoinPurseUI))) {
        ((WalletOfflineCoinPurseUI)this.mActivity).gvY();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 1L, 1L, true);
        AppMethodBeat.o(66388);
        return;
        d.m(this.mActivity, paramString1);
      }
    }
    if ((this.mActivity instanceof WalletBaseUI))
    {
      if (!com.tencent.mm.wallet_core.c.h.a((WalletBaseUI)this.mActivity, paramp, 1000, paramInt, paramString1)) {
        b.e(this.mActivity, paramString1, paramString2);
      }
      AppMethodBeat.o(66388);
      return;
    }
    b.l(this.mActivity, paramString1);
    AppMethodBeat.o(66388);
  }
  
  public final void a(u.b paramb)
  {
    AppMethodBeat.i(66394);
    if (paramb == null)
    {
      AppMethodBeat.o(66394);
      return;
    }
    Log.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
    if ("1".equals(paramb.Mzx)) {
      com.tencent.mm.ui.base.k.a(this.mActivity, false, paramb.Mzz, "", getString(a.i.wallet_wx_offline_freeze_btn_text), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(66374);
          paramAnonymousDialogInterface.dismiss();
          d.bg(c.this.mActivity);
          Log.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
          AppMethodBeat.o(66374);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(66375);
          paramAnonymousDialogInterface.dismiss();
          c.this.mActivity.finish();
          AppMethodBeat.o(66375);
        }
      });
    }
    AppMethodBeat.o(66394);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(66396);
    String str = this.mActivity.getString(paramInt);
    AppMethodBeat.o(66396);
    return str;
  }
  
  public final void gvx()
  {
    AppMethodBeat.i(66390);
    if (this.MAm != null)
    {
      this.MAm.dismiss();
      this.MAm = null;
    }
    AppMethodBeat.o(66390);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = false;
    AppMethodBeat.i(66389);
    Log.i("MicroMsg.OfflineLogicMgr", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " cgi type:" + paramp.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.g))
      {
        paramString = (com.tencent.mm.plugin.offline.a.g)paramp;
        localObject = paramString.MyF;
        gvx();
        if ((paramString.MyG != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label150;
        }
        d.a(this.mActivity, (String)localObject, paramp);
        this.mActivity.setResult(-1);
        this.mActivity.finish();
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66389);
      return bool;
      label150:
      if ((paramString.MyG != 0) && (paramString.hAV != 0) && (paramString.MyI == 1))
      {
        Log.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
        a(paramString, paramString.MyG, paramString.MyH);
      }
      bool = true;
      continue;
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.g))
      {
        localObject = (com.tencent.mm.plugin.offline.a.g)paramp;
        gvx();
        if (((com.tencent.mm.plugin.offline.a.g)localObject).MyI == 1)
        {
          Log.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
          a(paramp, paramInt2, paramString);
        }
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c
 * JD-Core Version:    0.7.0.1
 */