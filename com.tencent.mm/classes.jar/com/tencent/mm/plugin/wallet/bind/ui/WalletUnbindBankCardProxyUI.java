package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class WalletUnbindBankCardProxyUI
  extends WalletBaseUI
{
  private String CGA;
  private Bankcard CGB;
  private Map<String, String> CGC;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(69175);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    setResult(0);
    if (localIntent != null)
    {
      this.CGA = localIntent.getStringExtra("packageExt");
      if (!bt.isNullOrNil(this.CGA))
      {
        paramBundle = this.CGA;
        Object localObject2;
        if (!bt.isNullOrNil(paramBundle))
        {
          String[] arrayOfString = paramBundle.split("&");
          localObject2 = new HashMap();
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            int j = arrayOfString.length;
            int i = 0;
            for (;;)
            {
              paramBundle = (Bundle)localObject2;
              if (i >= j) {
                break;
              }
              String str = arrayOfString[i];
              if (!bt.isNullOrNil(str))
              {
                int k = str.indexOf("=");
                paramBundle = str.substring(0, k);
                str = str.substring(k + 1, str.length());
                if ((!bt.isNullOrNil(paramBundle)) && (!bt.isNullOrNil(str))) {
                  ((Map)localObject2).put(paramBundle, str);
                }
              }
              i += 1;
            }
          }
        }
        paramBundle = null;
        this.CGC = paramBundle;
        if ((this.CGC.containsKey("bank_type")) && (this.CGC.containsKey("bind_serial")))
        {
          paramBundle = t.eFv();
          localObject2 = (String)this.CGC.get("bind_serial");
          localObject2 = "select * from WalletBankcard where bindSerial = '" + (String)localObject2 + "'";
          localObject2 = paramBundle.db.a((String)localObject2, null, 2);
          paramBundle = localObject1;
          if (((Cursor)localObject2).moveToNext())
          {
            paramBundle = new Bankcard();
            paramBundle.convertFrom((Cursor)localObject2);
          }
          ((Cursor)localObject2).close();
          this.CGB = paramBundle;
          if (this.CGB == null)
          {
            ad.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
            setResult(0);
            finish();
            AppMethodBeat.o(69175);
            return;
          }
          localIntent.putExtra("key_is_show_detail", false);
          localIntent.putExtra("key_bankcard", this.CGB);
          localIntent.putExtra("scene", 1);
          com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localIntent.getExtras(), new d.a()
          {
            public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
            {
              AppMethodBeat.i(69174);
              switch (paramAnonymousInt)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(69174);
                return null;
                WalletUnbindBankCardProxyUI.this.setResult(0);
                continue;
                WalletUnbindBankCardProxyUI.this.setResult(-1);
                continue;
                WalletUnbindBankCardProxyUI.this.setResult(1);
              }
            }
          });
          AppMethodBeat.o(69175);
          return;
        }
        ad.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.CGA);
        setResult(1);
        finish();
        AppMethodBeat.o(69175);
        return;
      }
      ad.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
      setResult(1);
      finish();
      AppMethodBeat.o(69175);
      return;
    }
    ad.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
    finish();
    AppMethodBeat.o(69175);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69176);
    finish();
    AppMethodBeat.o(69176);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletUnbindBankCardProxyUI
 * JD-Core Version:    0.7.0.1
 */