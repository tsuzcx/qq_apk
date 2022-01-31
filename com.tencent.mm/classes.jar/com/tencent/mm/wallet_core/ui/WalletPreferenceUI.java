package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

@a(3)
public abstract class WalletPreferenceUI
  extends MMPreference
  implements f
{
  public c wCg = null;
  public i wCh = null;
  public g wCi = null;
  
  public void aFd()
  {
    ta(this.mController.czv());
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((!g(paramInt1, paramInt2, paramString, paramm)) && (paramInt2 != 0))
    {
      paramm = paramString;
      if (bk.bl(paramString)) {
        paramm = getString(a.i.wallet_data_err);
      }
      h.a(this, paramm, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          WalletPreferenceUI.this.finish();
        }
      });
    }
  }
  
  public final i cNr()
  {
    if (this.wCh == null) {
      this.wCh = new i(this, this);
    }
    return this.wCh;
  }
  
  public abstract boolean g(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    aFd();
    this.wCh = new i(this, this);
    this.wCh.kh(385);
    this.wCh.kh(1518);
    if (getLayoutId() > 0) {
      e.cNo();
    }
  }
  
  public void onDestroy()
  {
    this.wCh.ki(385);
    this.wCh.ki(1518);
    this.wCh = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletPreferenceUI
 * JD-Core Version:    0.7.0.1
 */