package com.tencent.mm.plugin.wallet_index.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class b
  implements i
{
  public boolean Pjq = false;
  public q Pjr;
  public Context mContext;
  public Dialog mLP = null;
  
  public static djx gMT()
  {
    AppMethodBeat.i(191788);
    Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig");
    djx localdjx = new djx();
    String str = (String)((a)com.tencent.mm.kernel.h.ag(a.class)).getWalletCacheStg().get(ar.a.VDb, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.HKOfflineLogic", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(191788);
      return localdjx;
      try
      {
        localdjx.parseFrom(str.getBytes(StandardCharsets.ISO_8859_1));
        Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.HKOfflineLogic", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean gMU()
  {
    AppMethodBeat.i(191805);
    String str = Util.getTopActivityName2(this.mContext);
    if ((!Util.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(191805);
      return true;
    }
    Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(191805);
    return false;
  }
  
  public final void Cu(boolean paramBoolean)
  {
    AppMethodBeat.i(191782);
    if ((!paramBoolean) && (this.mLP == null)) {
      this.mLP = com.tencent.mm.ui.base.h.a(this.mContext, 3, a.j.LuckyMoneyNoAnimDialog, this.mContext.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(275632);
          if ((b.a(b.this) != null) && (b.a(b.this).isShowing())) {
            b.a(b.this).dismiss();
          }
          AppMethodBeat.o(275632);
        }
      });
    }
    com.tencent.mm.kernel.h.aHH();
    this.Pjr = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue());
    com.tencent.mm.kernel.h.aGY().a(this.Pjr, 0);
    this.Pjq = paramBoolean;
    AppMethodBeat.o(191782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(191800);
    Log.i("MicroMsg.HKOfflineLogic", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.mLP != null) && (this.mLP.isShowing()))
    {
      this.mLP.dismiss();
      this.mLP = null;
    }
    if (((paramq instanceof com.tencent.mm.plugin.wallet_index.c.a.b)) && (paramq.equals(this.Pjr)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label382;
      }
      paramq = ((com.tencent.mm.plugin.wallet_index.c.a.b)paramq).gMW();
      if (paramq.fHV != 0) {
        break label322;
      }
      Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramq.TRp, Integer.valueOf(paramq.TRq) });
      if ((!this.Pjq) && (gMU()))
      {
        Log.d("MicroMsg.HKOfflineLogic", "on Scene End jump h5 ");
        g.o(this.mContext, paramq.TRp, false);
      }
      paramq.TRr = System.currentTimeMillis();
      Log.d("MicroMsg.HKOfflineLogic", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramq.TRr) });
      Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 setConfig");
      paramString = " ";
      if (paramq == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = new String(paramq.toByteArray(), StandardCharsets.ISO_8859_1);
        Log.e("MicroMsg.HKOfflineLogic", "save config exp, " + paramq.getLocalizedMessage());
      }
      catch (IOException paramq)
      {
        try
        {
          Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 setConfig success");
          ((a)com.tencent.mm.kernel.h.ag(a.class)).getWalletCacheStg().set(ar.a.VDb, paramString);
          com.tencent.mm.kernel.h.aGY().b(2540, this);
          this.Pjr = null;
          AppMethodBeat.o(191800);
          return;
        }
        catch (IOException paramq)
        {
          break label293;
        }
        paramq = paramq;
        paramString = " ";
      }
      label293:
      continue;
      label322:
      Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.Pjq) && (gMU()))
      {
        com.tencent.mm.ui.base.h.a(this.mContext, paramq.fHW, "", this.mContext.getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(266013);
            Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
            AppMethodBeat.o(266013);
          }
        });
        continue;
        label382:
        Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.Pjq) && (gMU())) {
          com.tencent.mm.ui.base.h.a(this.mContext, paramString, "", this.mContext.getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(277557);
              Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
              AppMethodBeat.o(277557);
            }
          });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b
 * JD-Core Version:    0.7.0.1
 */