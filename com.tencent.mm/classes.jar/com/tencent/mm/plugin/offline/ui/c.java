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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xv;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c
{
  Activity mActivity;
  Vibrator njY;
  a vtX;
  com.tencent.mm.plugin.wallet_core.ui.s vtY;
  float vtZ = 0.0F;
  int vua = 20000;
  
  public c(Activity paramActivity, a parama)
  {
    this.mActivity = paramActivity;
    this.vtX = parama;
  }
  
  private void aoF(String paramString)
  {
    AppMethodBeat.i(66391);
    ac.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131765660), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66385);
        f.as(c.this.mActivity, 0);
        ac.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66385);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66391);
  }
  
  private void aoG(String paramString)
  {
    AppMethodBeat.i(66392);
    ac.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131765973), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66386);
        f.as(c.this.mActivity, 0);
        ac.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
        AppMethodBeat.o(66386);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66392);
  }
  
  private void aoH(String paramString)
  {
    AppMethodBeat.i(66393);
    ac.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(paramString)));
    com.tencent.mm.ui.base.h.d(this.mActivity, paramString, "", getString(2131765949), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66373);
        c.this.vtX.dmi();
        ac.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
        AppMethodBeat.o(66373);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(66393);
  }
  
  public static boolean dmn()
  {
    AppMethodBeat.i(66395);
    k.dlZ();
    if (k.dma().vtr != null)
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
    ac.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + paramInt + " msg:" + paramString1);
    dmm();
    if (paramInt == 409)
    {
      aoG(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 410)
    {
      aoF(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 413)
    {
      aoH(paramString1);
      AppMethodBeat.o(66388);
      return;
    }
    if (paramInt == 411)
    {
      if ((com.tencent.mm.plugin.wallet_core.model.s.ery().esc()) || (com.tencent.mm.plugin.wallet_core.model.s.ery().esb()))
      {
        ac.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
        AppMethodBeat.o(66388);
        return;
      }
      if ((k.vso) && ((this.mActivity instanceof WalletOfflineCoinPurseUI))) {
        ((WalletOfflineCoinPurseUI)this.mActivity).dmH();
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(135L, 1L, 1L, true);
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
    ac.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
    if ("1".equals(paramb.vtv)) {
      com.tencent.mm.ui.base.h.a(this.mActivity, false, paramb.vtx, "", getString(2131765963), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(66374);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.plugin.offline.c.a.aw(c.this.mActivity);
          ac.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
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
  
  public final void dmm()
  {
    AppMethodBeat.i(66390);
    if (this.vtY != null)
    {
      this.vtY.dismiss();
      this.vtY = null;
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
    ac.i("MicroMsg.OfflineLogicMgr", "errType:" + paramInt1 + "  errCode" + paramInt2 + " errMsg:" + paramString + " cgi type:" + paramn.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof e))
      {
        paramString = (e)paramn;
        localObject = paramString.vsE;
        dmm();
        if ((paramString.vsF != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
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
      if ((paramString.vsF != 0) && (paramString.dae != 0) && (paramString.vsH == 1))
      {
        ac.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
        a(paramString, paramString.vsF, paramString.vsG);
      }
      bool = true;
      continue;
      if ((paramn instanceof e))
      {
        localObject = (e)paramn;
        dmm();
        if (((e)localObject).vsH == 1)
        {
          ac.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
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