package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c
{
  Activity mActivity;
  Vibrator mHT;
  a ulb;
  com.tencent.mm.plugin.wallet_core.ui.s ulc;
  float uld = 0.0F;
  int ule = 20000;
  
  public c(Activity paramActivity, a parama)
  {
    this.mActivity = paramActivity;
    this.ulb = parama;
  }
  
  private void ajH(String paramString)
  {
    AppMethodBeat.i(66391);
    ad.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131765660), getString(2131755691), new DialogInterface.OnClickListener()new c.17
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66385);
        f.am(c.this.mActivity, 0);
        ad.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66385);
      }
    }, new c.17(this));
    AppMethodBeat.o(66391);
  }
  
  private void ajI(String paramString)
  {
    AppMethodBeat.i(66392);
    ad.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131765973), getString(2131755691), new DialogInterface.OnClickListener()new c.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66386);
        f.am(c.this.mActivity, 0);
        ad.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66386);
      }
    }, new c.2(this));
    AppMethodBeat.o(66392);
  }
  
  private void ajJ(String paramString)
  {
    AppMethodBeat.i(66393);
    ad.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131765949), getString(2131755691), new c.3(this), new c.4(this));
    AppMethodBeat.o(66393);
  }
  
  public static boolean cYF()
  {
    AppMethodBeat.i(66395);
    k.cYr();
    if (k.cYs().ukv != null)
    {
      AppMethodBeat.o(66395);
      return true;
    }
    AppMethodBeat.o(66395);
    return false;
  }
  
  public final void a(n paramn, int paramInt, String paramString)
  {
    AppMethodBeat.i(66387);
    a(paramn, paramInt, paramString, null);
    AppMethodBeat.o(66387);
  }
  
  public final void a(n paramn, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(66388);
    ad.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + paramInt + " msg:" + paramString1);
    cYE();
    if (paramInt == 409)
    {
      ajI(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 410)
    {
      ajH(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 413)
    {
      ajJ(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 411)
    {
      if ((com.tencent.mm.plugin.wallet_core.model.s.ecc().ecH()) || (com.tencent.mm.plugin.wallet_core.model.s.ecc().ecG()))
      {
        ad.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
        AppMethodBeat.o(66388);
        return;
      }
      if ((k.ujs) && ((this.mActivity instanceof WalletOfflineCoinPurseUI))) {
        ((WalletOfflineCoinPurseUI)this.mActivity).cYZ();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(135L, 1L, 1L, true);
        AppMethodBeat.o(66388);
        return;
        com.tencent.mm.plugin.offline.c.a.e(this.mActivity, paramString1);
      }
    }
    if ((this.mActivity instanceof WalletBaseUI))
    {
      if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)this.mActivity, paramn, 1000, paramInt, paramString1)) {
        b.d(this.mActivity, paramString1, paramString2);
      }
      AppMethodBeat.o(66388);
      return;
    }
    b.d(this.mActivity, paramString1);
    AppMethodBeat.o(66388);
  }
  
  public final void a(s.b paramb)
  {
    AppMethodBeat.i(66394);
    if (paramb == null)
    {
      AppMethodBeat.o(66394);
      return;
    }
    ad.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
    if ("1".equals(paramb.ukz)) {
      com.tencent.mm.ui.base.h.a(this.mActivity, false, paramb.ukB, "", getString(2131765963), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(66374);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.offline.c.a.as(c.this.mActivity);
          ad.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
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
  
  public final void cYE()
  {
    AppMethodBeat.i(66390);
    if (this.ulc != null)
    {
      this.ulc.dismiss();
      this.ulc = null;
    }
    AppMethodBeat.o(66390);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(66396);
    String str = this.mActivity.getString(paramInt);
    AppMethodBeat.o(66396);
    return str;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(66389);
    ad.i("MicroMsg.OfflineLogicMgr", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " cgi type:" + paramn.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof e))
      {
        paramString = (e)paramn;
        localObject = paramString.ujI;
        cYE();
        if ((paramString.ujJ != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label150;
        }
        com.tencent.mm.plugin.offline.c.a.a(this.mActivity, (String)localObject, paramn);
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
      if ((paramString.ujJ != 0) && (paramString.dcG != 0) && (paramString.ujL == 1))
      {
        ad.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
        a(paramString, paramString.ujJ, paramString.ujK);
      }
      bool = true;
      continue;
      if ((paramn instanceof e))
      {
        localObject = (e)paramn;
        cYE();
        if (((e)localObject).ujL == 1)
        {
          ad.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
          a(paramn, paramInt2, paramString);
        }
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c
 * JD-Core Version:    0.7.0.1
 */