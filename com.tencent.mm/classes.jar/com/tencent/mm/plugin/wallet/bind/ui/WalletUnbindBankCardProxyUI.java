package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class WalletUnbindBankCardProxyUI
  extends WalletBaseUI
{
  private String tTG;
  private Bankcard tTH;
  private Map<String, String> tTI;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(45831);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    setResult(0);
    if (localIntent != null)
    {
      this.tTG = localIntent.getStringExtra("packageExt");
      if (!bo.isNullOrNil(this.tTG))
      {
        paramBundle = this.tTG;
        Object localObject2;
        if (!bo.isNullOrNil(paramBundle))
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
              if (!bo.isNullOrNil(str))
              {
                int k = str.indexOf("=");
                paramBundle = str.substring(0, k);
                str = str.substring(k + 1, str.length());
                if ((!bo.isNullOrNil(paramBundle)) && (!bo.isNullOrNil(str))) {
                  ((Map)localObject2).put(paramBundle, str);
                }
              }
              i += 1;
            }
          }
        }
        paramBundle = null;
        this.tTI = paramBundle;
        if ((this.tTI.containsKey("bank_type")) && (this.tTI.containsKey("bind_serial")))
        {
          paramBundle = t.cTL();
          localObject2 = (String)this.tTI.get("bind_serial");
          localObject2 = "select * from WalletBankcard where bindSerial = '" + (String)localObject2 + "'";
          localObject2 = paramBundle.db.a((String)localObject2, null, 2);
          paramBundle = localObject1;
          if (((Cursor)localObject2).moveToNext())
          {
            paramBundle = new Bankcard();
            paramBundle.convertFrom((Cursor)localObject2);
          }
          ((Cursor)localObject2).close();
          this.tTH = paramBundle;
          if (this.tTH == null)
          {
            ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
            setResult(0);
            finish();
            AppMethodBeat.o(45831);
            return;
          }
          localIntent.putExtra("key_is_show_detail", false);
          localIntent.putExtra("key_bankcard", this.tTH);
          localIntent.putExtra("scene", 1);
          com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localIntent.getExtras(), new WalletUnbindBankCardProxyUI.1(this));
          AppMethodBeat.o(45831);
          return;
        }
        ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.tTG);
        setResult(1);
        finish();
        AppMethodBeat.o(45831);
        return;
      }
      ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
      setResult(1);
      finish();
      AppMethodBeat.o(45831);
      return;
    }
    ab.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
    finish();
    AppMethodBeat.o(45831);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(45832);
    finish();
    AppMethodBeat.o(45832);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletUnbindBankCardProxyUI
 * JD-Core Version:    0.7.0.1
 */