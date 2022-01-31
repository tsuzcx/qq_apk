package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c
{
  Vibrator ibr;
  Activity mActivity;
  a mMb;
  com.tencent.mm.plugin.wallet_core.ui.o mMc;
  float mMd = 0.0F;
  int mMe = 20000;
  
  public c(Activity paramActivity, a parama)
  {
    this.mActivity = paramActivity;
    this.mMb = parama;
  }
  
  public static boolean bqn()
  {
    k.bpX();
    return k.bpY().mLy != null;
  }
  
  public final void a(m paramm, int paramInt, String paramString)
  {
    a(paramm, paramInt, paramString, null);
  }
  
  public final void a(m paramm, int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + paramInt + " msg:" + paramString1);
    bqm();
    if (paramInt == 409)
    {
      y.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:" + paramString1);
      com.tencent.mm.ui.base.h.a(this.mActivity, paramString1, "", getString(a.i.wallet_wx_offline_promote_coin_purse_limit_fee), getString(a.i.app_cancel), new c.18(this), new c.2(this));
    }
    do
    {
      return;
      if (paramInt == 410)
      {
        y.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:" + paramString1);
        com.tencent.mm.ui.base.h.a(this.mActivity, paramString1, "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new c.16(this), new c.17(this));
        return;
      }
      if (paramInt == 413)
      {
        y.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:" + paramString1);
        com.tencent.mm.ui.base.h.a(this.mActivity, paramString1, "", getString(a.i.wallet_wx_offline_change_pay_method), getString(a.i.app_cancel), new c.3(this), new c.4(this));
        return;
      }
      if (paramInt == 411)
      {
        if ((com.tencent.mm.plugin.wallet_core.model.o.bVs().bVK()) || (com.tencent.mm.plugin.wallet_core.model.o.bVs().bVO()))
        {
          y.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
          return;
        }
        if ((k.mKz) && ((this.mActivity instanceof WalletOfflineCoinPurseUI)))
        {
          paramm = (WalletOfflineCoinPurseUI)this.mActivity;
          paramm.mMD.setVisibility(4);
          paramm.mMV.a(paramm.mMv, new WalletOfflineCoinPurseUI.27(paramm), 6);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(135L, 1L, 1L, true);
          return;
          com.tencent.mm.plugin.offline.c.a.c(this.mActivity, paramString1);
        }
      }
      if (!(this.mActivity instanceof WalletBaseUI)) {
        break;
      }
    } while (com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)this.mActivity, paramm, 1000, paramInt, paramString1));
    Activity localActivity = this.mActivity;
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramm = localActivity.getString(a.i.wallet_unknown_err);; paramm = paramString1)
    {
      if (!bk.bl(paramString2))
      {
        y.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
        com.tencent.mm.ui.base.h.a(localActivity, paramm, null, localActivity.getResources().getString(a.i.wallet_err_alert_btn_err_detail_text), localActivity.getResources().getString(a.i.app_ok), true, new b.2(paramString2, localActivity), new b.3());
        return;
      }
      b.b(localActivity, paramm);
      return;
      b.b(this.mActivity, paramString1);
      return;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (paramb == null) {}
    do
    {
      return;
      y.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
    } while (!"1".equals(paramb.mLC));
    com.tencent.mm.ui.base.h.a(this.mActivity, false, paramb.mLE, "", getString(a.i.wallet_wx_offline_freeze_btn_text), getString(a.i.app_cancel), new c.5(this), new c.6(this));
  }
  
  public final void bqm()
  {
    if (this.mMc != null)
    {
      this.mMc.dismiss();
      this.mMc = null;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    y.i("MicroMsg.OfflineLogicMgr", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " cgi type:" + paramm.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof e))
      {
        paramString = (e)paramm;
        localObject = paramString.mKL;
        bqm();
        if ((paramString.mKM != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label138;
        }
        com.tencent.mm.plugin.offline.c.a.a(this.mActivity, (String)localObject, paramm);
        this.mActivity.setResult(-1);
        this.mActivity.finish();
        bool = true;
      }
    }
    label138:
    while (!(paramm instanceof e))
    {
      return bool;
      if ((paramString.mKM != 0) && (paramString.iHq != 0) && (paramString.mKO == 1))
      {
        y.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
        a(paramString, paramString.mKM, paramString.mKN);
      }
      return true;
    }
    Object localObject = (e)paramm;
    bqm();
    if (((e)localObject).mKO == 1)
    {
      y.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
      a(paramm, paramInt2, paramString);
    }
    return true;
  }
  
  final String getString(int paramInt)
  {
    return this.mActivity.getString(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c
 * JD-Core Version:    0.7.0.1
 */