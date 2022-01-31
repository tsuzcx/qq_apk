package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletOpenECardProxyUI
  extends WalletECardBaseUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        setResult(0);
        paramIntent = cNj();
        if (paramIntent != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_process_result_code", 0);
          paramIntent.l(this, localBundle);
          return;
        }
        finish();
        return;
      }
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(4);
    paramBundle = cNj();
    int i;
    if (paramBundle != null)
    {
      i = this.BX.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.qJR, 0);
      bool = this.BX.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.qKj, false);
      y.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (bool) {
        cNk().m(new Object[] { Integer.valueOf(2), Integer.valueOf(i), Boolean.valueOf(true) });
      }
    }
    else
    {
      return;
    }
    String str = this.BX.getString(com.tencent.mm.plugin.wallet_ecard.a.a.qJS);
    boolean bool = this.BX.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.qJU, false);
    y.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bk.bl(str)), Boolean.valueOf(bool) });
    if (!bk.bl(str))
    {
      cNk().m(new Object[] { Integer.valueOf(1), Integer.valueOf(i), str });
      return;
    }
    paramBundle.a(this.mController.uMN, 0, this.BX);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i = paramIntent.getIntExtra("key_process_result_code", -1);
    boolean bool = paramIntent.getBooleanExtra("key_process_is_end", false);
    y.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (i == -1)
    {
      setResult(-1);
      paramIntent = cNj();
      if (!bool) {
        break label78;
      }
      finish();
    }
    label78:
    while (paramIntent == null)
    {
      return;
      setResult(0);
      break;
    }
    paramIntent.ak(this.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI
 * JD-Core Version:    0.7.0.1
 */