package com.tencent.mm.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.i;

@com.tencent.mm.ui.base.a(3)
public abstract class WalletPreferenceUI
  extends MMPreference
  implements f
{
  private com.tencent.mm.wallet_core.d.g mNetController = null;
  private i mNetSceneMgr = null;
  private d mProcess = null;
  
  public abstract boolean f(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final com.tencent.mm.wallet_core.d.g getNetController()
  {
    if (this.mNetController == null)
    {
      if (this.mProcess == null) {
        this.mProcess = com.tencent.mm.wallet_core.a.bF(this);
      }
      this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
    }
    return this.mNetController;
  }
  
  public final i ijz()
  {
    if (this.mNetSceneMgr == null) {
      this.mNetSceneMgr = new i(this, this);
    }
    return this.mNetSceneMgr;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setStatusColor();
    this.mNetSceneMgr = new i(this, this);
    this.mNetSceneMgr.addSceneEndListener(385);
    this.mNetSceneMgr.addSceneEndListener(1518);
    if (getLayoutId() > 0) {
      g.iju();
    }
  }
  
  public void onDestroy()
  {
    this.mNetSceneMgr.removeSceneEndListener(385);
    this.mNetSceneMgr.removeSceneEndListener(1518);
    this.mNetSceneMgr = null;
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean)
  {
    if ((!f(paramInt1, paramInt2, paramString, paramq)) && (paramInt2 != 0))
    {
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(a.i.wallet_data_err);
      }
      h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73060);
          WalletPreferenceUI.this.finish();
          AppMethodBeat.o(73060);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void setStatusColor()
  {
    setActionbarColor(getActionbarColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletPreferenceUI
 * JD-Core Version:    0.7.0.1
 */