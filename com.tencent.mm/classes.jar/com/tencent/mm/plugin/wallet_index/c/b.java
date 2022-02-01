package com.tencent.mm.plugin.wallet_index.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class b
  implements i
{
  public boolean IqH = false;
  public q IqI;
  public Dialog jUC = null;
  public Context mContext;
  
  public static daj fUn()
  {
    AppMethodBeat.i(214267);
    Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig");
    daj localdaj = new daj();
    String str = (String)((a)g.ah(a.class)).getWalletCacheStg().get(ar.a.OnN, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.HKOfflineLogic", "OfflineH5 get PayIBGQuickGetOverseaWalletConfig failed");
    }
    for (;;)
    {
      AppMethodBeat.o(214267);
      return localdaj;
      try
      {
        localdaj.parseFrom(str.getBytes(StandardCharsets.ISO_8859_1));
        Log.d("MicroMsg.HKOfflineLogic", "OfflineH5 getConfig success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.HKOfflineLogic", "OfflineH5 parse PayIBGQuickGetOverseaWalletConfig fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  private boolean fUo()
  {
    AppMethodBeat.i(214269);
    String str = Util.getTopActivityName2(this.mContext);
    if ((!Util.isNullOrNil(str)) && (str.equals("LauncherUI")))
    {
      Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is on ActivityTask Top ");
      AppMethodBeat.o(214269);
      return true;
    }
    Log.d("MicroMsg.HKOfflineLogic", "LauncherUI is not on ActivityTask Top：%s", new Object[] { str });
    AppMethodBeat.o(214269);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(214268);
    Log.i("MicroMsg.HKOfflineLogic", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.jUC != null) && (this.jUC.isShowing()))
    {
      this.jUC.dismiss();
      this.jUC = null;
    }
    if (((paramq instanceof com.tencent.mm.plugin.wallet_index.c.a.b)) && (paramq.equals(this.IqI)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label374;
      }
      paramq = ((com.tencent.mm.plugin.wallet_index.c.a.b)paramq).fUq();
      if (paramq.dOK != 0) {
        break label315;
      }
      Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd ok，pay_wallet_wxapp_h5_url：%s, cache_time：%s", new Object[] { paramq.MFD, Integer.valueOf(paramq.MFE) });
      if ((!this.IqH) && (fUo()))
      {
        Log.d("MicroMsg.HKOfflineLogic", "on Scene End jump h5 ");
        f.o(this.mContext, paramq.MFD, false);
      }
      paramq.MFF = System.currentTimeMillis();
      Log.d("MicroMsg.HKOfflineLogic", "on Scene End currentTime ：%s ", new Object[] { Long.valueOf(paramq.MFF) });
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
          ((a)g.ah(a.class)).getWalletCacheStg().set(ar.a.OnN, paramString);
          g.azz().b(2540, this);
          this.IqI = null;
          AppMethodBeat.o(214268);
          return;
        }
        catch (IOException paramq)
        {
          break label287;
        }
        paramq = paramq;
        paramString = " ";
      }
      label287:
      continue;
      label315:
      Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd failed show dialog ");
      if ((!this.IqH) && (fUo()))
      {
        h.a(this.mContext, paramq.dOL, "", this.mContext.getString(2131768713), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(214264);
            Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
            AppMethodBeat.o(214264);
          }
        });
        continue;
        label374:
        Log.i("MicroMsg.HKOfflineLogic", "NetScenePayIBGQuickGetOverseaWallet on SceneEnd faile show error dialog ");
        if ((!this.IqH) && (fUo())) {
          h.a(this.mContext, paramString, "", this.mContext.getString(2131768713), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(214265);
              Log.d("MicroMsg.HKOfflineLogic", "onDialogClick() ");
              AppMethodBeat.o(214265);
            }
          });
        }
      }
    }
  }
  
  public final void yz(boolean paramBoolean)
  {
    AppMethodBeat.i(214266);
    if ((!paramBoolean) && (this.jUC == null)) {
      this.jUC = h.a(this.mContext, 3, 2131821007, this.mContext.getString(2131762446), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(214263);
          if ((b.this.jUC != null) && (b.this.jUC.isShowing())) {
            b.this.jUC.dismiss();
          }
          AppMethodBeat.o(214263);
        }
      });
    }
    g.aAi();
    this.IqI = new com.tencent.mm.plugin.wallet_index.c.a.b(((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue());
    g.azz().a(this.IqI, 0);
    this.IqH = paramBoolean;
    AppMethodBeat.o(214266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b
 * JD-Core Version:    0.7.0.1
 */