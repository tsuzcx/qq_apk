package com.tencent.mm.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

@a(3)
public abstract class WalletPreferenceUI
  extends MMPreference
  implements f
{
  protected g mNetController = null;
  protected i mNetSceneMgr = null;
  protected c mProcess = null;
  
  public final i dSV()
  {
    if (this.mNetSceneMgr == null) {
      this.mNetSceneMgr = new i(this, this);
    }
    return this.mNetSceneMgr;
  }
  
  public abstract boolean e(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public void onCreate(Bundle paramBundle)
  {
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setStatusColor();
    this.mNetSceneMgr = new i(this, this);
    this.mNetSceneMgr.addSceneEndListener(385);
    this.mNetSceneMgr.addSceneEndListener(1518);
    if (getLayoutId() > 0) {
      e.dSS();
    }
  }
  
  public void onDestroy()
  {
    this.mNetSceneMgr.removeSceneEndListener(385);
    this.mNetSceneMgr.removeSceneEndListener(1518);
    this.mNetSceneMgr = null;
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((!e(paramInt1, paramInt2, paramString, paramm)) && (paramInt2 != 0))
    {
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = getString(2131305032);
      }
      h.a(this, paramm, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(49334);
          WalletPreferenceUI.this.finish();
          AppMethodBeat.o(49334);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletPreferenceUI
 * JD-Core Version:    0.7.0.1
 */