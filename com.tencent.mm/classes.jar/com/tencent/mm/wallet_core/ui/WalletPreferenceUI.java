package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;

@com.tencent.mm.ui.base.a(3)
public abstract class WalletPreferenceUI
  extends MMPreference
  implements f
{
  private g mNetController = null;
  private com.tencent.mm.wallet_core.c.i mNetSceneMgr = null;
  private e mProcess = null;
  
  public abstract boolean d(int paramInt1, int paramInt2, String paramString, p paramp);
  
  public final g getNetController()
  {
    if (this.mNetController == null)
    {
      if (this.mProcess == null) {
        this.mProcess = com.tencent.mm.wallet_core.a.cm(this);
      }
      this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
    }
    return this.mNetController;
  }
  
  public final com.tencent.mm.wallet_core.c.i jPx()
  {
    if (this.mNetSceneMgr == null) {
      this.mNetSceneMgr = new com.tencent.mm.wallet_core.c.i(this, this);
    }
    return this.mNetSceneMgr;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setStatusColor();
    this.mNetSceneMgr = new com.tencent.mm.wallet_core.c.i(this, this);
    this.mNetSceneMgr.addSceneEndListener(385);
    this.mNetSceneMgr.addSceneEndListener(1518);
    if (getLayoutId() > 0) {
      i.jPs();
    }
  }
  
  public void onDestroy()
  {
    this.mNetSceneMgr.removeSceneEndListener(385);
    this.mNetSceneMgr.removeSceneEndListener(1518);
    this.mNetSceneMgr = null;
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    if ((!d(paramInt1, paramInt2, paramString, paramp)) && (paramInt2 != 0))
    {
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = getString(a.i.wallet_data_err);
      }
      k.a(this, paramp, null, false, new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletPreferenceUI
 * JD-Core Version:    0.7.0.1
 */