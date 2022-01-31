package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c
{
  Vibrator kqP;
  Activity mActivity;
  a pmr;
  q pms;
  float pmt = 0.0F;
  int pmu = 20000;
  
  public c(Activity paramActivity, a parama)
  {
    this.mActivity = paramActivity;
    this.pmr = parama;
  }
  
  private void Wn(String paramString)
  {
    AppMethodBeat.i(43493);
    ab.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131305446), getString(2131296888), new c.16(this), new c.17(this));
    AppMethodBeat.o(43493);
  }
  
  private void Wo(String paramString)
  {
    AppMethodBeat.i(43494);
    ab.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131305753), getString(2131296888), new c.18(this), new c.2(this));
    AppMethodBeat.o(43494);
  }
  
  private void Wp(String paramString)
  {
    AppMethodBeat.i(43495);
    ab.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131305729), getString(2131296888), new c.3(this), new c.4(this));
    AppMethodBeat.o(43495);
  }
  
  public static boolean bYT()
  {
    AppMethodBeat.i(43497);
    k.bYF();
    if (k.bYG().plP != null)
    {
      AppMethodBeat.o(43497);
      return true;
    }
    AppMethodBeat.o(43497);
    return false;
  }
  
  public final void a(m paramm, int paramInt, String paramString)
  {
    AppMethodBeat.i(43489);
    a(paramm, paramInt, paramString, null);
    AppMethodBeat.o(43489);
  }
  
  public final void a(m paramm, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(43490);
    ab.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + paramInt + " msg:" + paramString1);
    bYS();
    if (paramInt == 409)
    {
      Wo(paramString1);
      AppMethodBeat.o(43490);
      return;
    }
    if (paramInt == 410)
    {
      Wn(paramString1);
      AppMethodBeat.o(43490);
      return;
    }
    if (paramInt == 413)
    {
      Wp(paramString1);
      AppMethodBeat.o(43490);
      return;
    }
    if (paramInt == 411)
    {
      if ((t.cTN().cUn()) || (t.cTN().cUm()))
      {
        ab.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
        AppMethodBeat.o(43490);
        return;
      }
      if ((k.pkO) && ((this.mActivity instanceof WalletOfflineCoinPurseUI))) {
        ((WalletOfflineCoinPurseUI)this.mActivity).bZn();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(135L, 1L, 1L, true);
        AppMethodBeat.o(43490);
        return;
        com.tencent.mm.plugin.offline.c.a.e(this.mActivity, paramString1);
      }
    }
    if ((this.mActivity instanceof WalletBaseUI))
    {
      if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)this.mActivity, paramm, 1000, paramInt, paramString1)) {
        b.c(this.mActivity, paramString1, paramString2);
      }
      AppMethodBeat.o(43490);
      return;
    }
    b.d(this.mActivity, paramString1);
    AppMethodBeat.o(43490);
  }
  
  public final void a(s.b paramb)
  {
    AppMethodBeat.i(43496);
    if (paramb == null)
    {
      AppMethodBeat.o(43496);
      return;
    }
    ab.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
    if ("1".equals(paramb.plT)) {
      com.tencent.mm.ui.base.h.a(this.mActivity, false, paramb.plV, "", getString(2131305743), getString(2131296888), new c.5(this), new c.6(this));
    }
    AppMethodBeat.o(43496);
  }
  
  public final void bYS()
  {
    AppMethodBeat.i(43492);
    if (this.pms != null)
    {
      this.pms.dismiss();
      this.pms = null;
    }
    AppMethodBeat.o(43492);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(43498);
    String str = this.mActivity.getString(paramInt);
    AppMethodBeat.o(43498);
    return str;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    AppMethodBeat.i(43491);
    ab.i("MicroMsg.OfflineLogicMgr", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " cgi type:" + paramm.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof e))
      {
        paramString = (e)paramm;
        localObject = paramString.plc;
        bYS();
        if ((paramString.pld != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label150;
        }
        com.tencent.mm.plugin.offline.c.a.a(this.mActivity, (String)localObject, paramm);
        this.mActivity.setResult(-1);
        this.mActivity.finish();
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43491);
      return bool;
      label150:
      if ((paramString.pld != 0) && (paramString.cnK != 0) && (paramString.plf == 1))
      {
        ab.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
        a(paramString, paramString.pld, paramString.ple);
      }
      bool = true;
      continue;
      if ((paramm instanceof e))
      {
        localObject = (e)paramm;
        bYS();
        if (((e)localObject).plf == 1)
        {
          ab.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
          a(paramm, paramInt2, paramString);
        }
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c
 * JD-Core Version:    0.7.0.1
 */