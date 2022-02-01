package com.tencent.mm.plugin.wallet_index.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class b
  implements com.tencent.mm.am.h
{
  public boolean Wai = false;
  public p Waj;
  public Context mContext;
  public Dialog pIx = null;
  
  private void HZ(boolean paramBoolean)
  {
    AppMethodBeat.i(263689);
    if ((!paramBoolean) && (this.pIx == null)) {
      this.pIx = k.a(this.mContext, 3, a.j.LuckyMoneyNoAnimDialog, this.mContext.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(263699);
          if ((b.a(b.this) != null) && (b.a(b.this).isShowing())) {
            b.a(b.this).dismiss();
          }
          AppMethodBeat.o(263699);
        }
      });
    }
    com.tencent.mm.kernel.h.baF();
    this.Waj = new com.tencent.mm.plugin.wallet_index.model.a.b(((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue());
    com.tencent.mm.kernel.h.aZW().a(this.Waj, 0);
    this.Wai = paramBoolean;
    AppMethodBeat.o(263689);
  }
  
  private static ech imi()
  {
    AppMethodBeat.i(263693);
    Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig");
    ech localech = new ech();
    String str = (String)((a)com.tencent.mm.kernel.h.az(a.class)).getWalletCacheStg().get(at.a.adfV, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.HKOfflineLogic", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(263693);
      return localech;
      try
      {
        localech.parseFrom(str.getBytes(StandardCharsets.ISO_8859_1));
        Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.HKOfflineLogic", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean imj()
  {
    AppMethodBeat.i(263697);
    String str = Util.getTopActivityName2(this.mContext);
    if ((!Util.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(263697);
      return true;
    }
    Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(263697);
    return false;
  }
  
  public final void kL(Context paramContext)
  {
    AppMethodBeat.i(263705);
    this.mContext = paramContext;
    this.pIx = null;
    this.Wai = false;
    this.Waj = null;
    com.tencent.mm.kernel.h.aZW().a(2540, this);
    paramContext = imi();
    if (Util.isNullOrNil(paramContext.abhO))
    {
      Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 has no cache");
      HZ(false);
      AppMethodBeat.o(263705);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - paramContext.abhQ;
    Log.d("MicroMsg.HKOfflineLogic", "hk currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(l1), Long.valueOf(paramContext.abhQ), Long.valueOf(l2) });
    if (l2 < paramContext.abhP)
    {
      Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 dont expired，url：%s", new Object[] { paramContext.abhO });
      i.o(this.mContext, paramContext.abhO, false);
      HZ(true);
      AppMethodBeat.o(263705);
      return;
    }
    Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 is expired");
    HZ(false);
    AppMethodBeat.o(263705);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(263712);
    Log.i("MicroMsg.HKOfflineLogic", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.pIx != null) && (this.pIx.isShowing()))
    {
      this.pIx.dismiss();
      this.pIx = null;
    }
    if (((paramp instanceof com.tencent.mm.plugin.wallet_index.model.a.b)) && (paramp.equals(this.Waj)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label386;
      }
      paramp = ((com.tencent.mm.plugin.wallet_index.model.a.b)paramp).iml();
      if (paramp.hNv != 0) {
        break label326;
      }
      Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramp.abhO, Integer.valueOf(paramp.abhP) });
      if ((!this.Wai) && (imj()))
      {
        Log.d("MicroMsg.HKOfflineLogic", "on Scene End jump h5 ");
        i.o(this.mContext, paramp.abhO, false);
      }
      paramp.abhQ = System.currentTimeMillis();
      Log.d("MicroMsg.HKOfflineLogic", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramp.abhQ) });
      Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 setConfig");
      paramString = " ";
      if (paramp == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = new String(paramp.toByteArray(), StandardCharsets.ISO_8859_1);
        Log.e("MicroMsg.HKOfflineLogic", "save config exp, " + paramp.getLocalizedMessage());
      }
      catch (IOException paramp)
      {
        try
        {
          Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 setConfig success");
          ((a)com.tencent.mm.kernel.h.az(a.class)).getWalletCacheStg().set(at.a.adfV, paramString);
          com.tencent.mm.kernel.h.aZW().b(2540, this);
          this.Waj = null;
          AppMethodBeat.o(263712);
          return;
        }
        catch (IOException paramp)
        {
          break label297;
        }
        paramp = paramp;
        paramString = " ";
      }
      label297:
      continue;
      label326:
      Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.Wai) && (imj()))
      {
        k.a(this.mContext, paramp.hNw, "", this.mContext.getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(263698);
            Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
            AppMethodBeat.o(263698);
          }
        });
        continue;
        label386:
        Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.Wai) && (imj())) {
          k.a(this.mContext, paramString, "", this.mContext.getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(263696);
              Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
              AppMethodBeat.o(263696);
            }
          });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.b
 * JD-Core Version:    0.7.0.1
 */