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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c
{
  a AKH;
  com.tencent.mm.plugin.wallet_core.ui.s AKI;
  float AKJ = 0.0F;
  int AKK = 20000;
  Activity mActivity;
  Vibrator paT;
  
  public c(Activity paramActivity, a parama)
  {
    this.mActivity = paramActivity;
    this.AKH = parama;
  }
  
  private void aJg(String paramString)
  {
    AppMethodBeat.i(66391);
    Log.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.c(this.mActivity, paramString, "", getString(2131768113), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66385);
        f.aE(c.this.mActivity, 0);
        Log.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66385);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66391);
  }
  
  private void aJh(String paramString)
  {
    AppMethodBeat.i(66392);
    Log.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.c(this.mActivity, paramString, "", getString(2131768426), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66386);
        f.aE(c.this.mActivity, 0);
        Log.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66386);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66392);
  }
  
  private void aJi(String paramString)
  {
    AppMethodBeat.i(66393);
    Log.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.c(this.mActivity, paramString, "", getString(2131768402), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66373);
        c.this.AKH.ezw();
        Log.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
        AppMethodBeat.o(66373);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66393);
  }
  
  public static boolean ezB()
  {
    AppMethodBeat.i(66395);
    k.ezn();
    if (k.ezo().AKa != null)
    {
      AppMethodBeat.o(66395);
      return true;
    }
    AppMethodBeat.o(66395);
    return false;
  }
  
  public final void a(q paramq, int paramInt, String paramString)
  {
    AppMethodBeat.i(66387);
    a(paramq, paramInt, paramString, null);
    AppMethodBeat.o(66387);
  }
  
  public final void a(q paramq, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(66388);
    Log.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + paramInt + " msg:" + paramString1);
    ezA();
    if (paramInt == 409)
    {
      aJh(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 410)
    {
      aJg(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 413)
    {
      aJi(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 411)
    {
      if ((t.fQI().fRm()) || (t.fQI().fRl()))
      {
        Log.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
        AppMethodBeat.o(66388);
        return;
      }
      if ((k.AIX) && ((this.mActivity instanceof WalletOfflineCoinPurseUI))) {
        ((WalletOfflineCoinPurseUI)this.mActivity).ezV();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(135L, 1L, 1L, true);
        AppMethodBeat.o(66388);
        return;
        com.tencent.mm.plugin.offline.c.a.j(this.mActivity, paramString1);
      }
    }
    if ((this.mActivity instanceof WalletBaseUI))
    {
      if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI)this.mActivity, paramq, 1000, paramInt, paramString1)) {
        b.d(this.mActivity, paramString1, paramString2);
      }
      AppMethodBeat.o(66388);
      return;
    }
    b.i(this.mActivity, paramString1);
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
    Log.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
    if ("1".equals(paramb.AKe)) {
      com.tencent.mm.ui.base.h.a(this.mActivity, false, paramb.AKg, "", getString(2131768416), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(66374);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.offline.c.a.ay(c.this.mActivity);
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
  
  public final void ezA()
  {
    AppMethodBeat.i(66390);
    if (this.AKI != null)
    {
      this.AKI.dismiss();
      this.AKI = null;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(66389);
    Log.i("MicroMsg.OfflineLogicMgr", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " cgi type:" + paramq.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof e))
      {
        paramString = (e)paramq;
        localObject = paramString.AJn;
        ezA();
        if ((paramString.AJo != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label150;
        }
        com.tencent.mm.plugin.offline.c.a.a(this.mActivity, (String)localObject, paramq);
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
      if ((paramString.AJo != 0) && (paramString.dDN != 0) && (paramString.AJq == 1))
      {
        Log.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
        a(paramString, paramString.AJo, paramString.AJp);
      }
      bool = true;
      continue;
      if ((paramq instanceof e))
      {
        localObject = (e)paramq;
        ezA();
        if (((e)localObject).AJq == 1)
        {
          Log.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
          a(paramq, paramInt2, paramString);
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