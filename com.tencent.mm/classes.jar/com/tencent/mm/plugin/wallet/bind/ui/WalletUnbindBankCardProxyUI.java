package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class WalletUnbindBankCardProxyUI
  extends WalletBaseUI
{
  private String qkG;
  private Bankcard qkH;
  private Map<String, String> qkI;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    setResult(0);
    if (localIntent != null)
    {
      this.qkG = localIntent.getStringExtra("packageExt");
      if (!bk.bl(this.qkG))
      {
        paramBundle = this.qkG;
        Object localObject2;
        if (!bk.bl(paramBundle))
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
              if (!bk.bl(str))
              {
                int k = str.indexOf("=");
                paramBundle = str.substring(0, k);
                str = str.substring(k + 1, str.length());
                if ((!bk.bl(paramBundle)) && (!bk.bl(str))) {
                  ((Map)localObject2).put(paramBundle, str);
                }
              }
              i += 1;
            }
          }
        }
        paramBundle = null;
        this.qkI = paramBundle;
        if ((this.qkI.containsKey("bank_type")) && (this.qkI.containsKey("bind_serial")))
        {
          paramBundle = o.bVq();
          localObject2 = (String)this.qkI.get("bind_serial");
          localObject2 = "select * from WalletBankcard where bindSerial = '" + (String)localObject2 + "'";
          localObject2 = paramBundle.dXw.a((String)localObject2, null, 2);
          paramBundle = localObject1;
          if (((Cursor)localObject2).moveToNext())
          {
            paramBundle = new Bankcard();
            paramBundle.d((Cursor)localObject2);
          }
          ((Cursor)localObject2).close();
          this.qkH = paramBundle;
          if (this.qkH == null)
          {
            y.e("MicorMsg.WalletUnbindBankCardProxyUI", "can not found bankcard");
            setResult(0);
            finish();
            return;
          }
          localIntent.putExtra("key_is_show_detail", false);
          localIntent.putExtra("key_bankcard", this.qkH);
          localIntent.putExtra("scene", 1);
          com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, localIntent.getExtras(), new WalletUnbindBankCardProxyUI.1(this));
          return;
        }
        y.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param:package error.package==" + this.qkG);
        setResult(1);
        finish();
        return;
      }
      y.e("MicorMsg.WalletUnbindBankCardProxyUI", "jsapi param error");
      setResult(1);
      finish();
      return;
    }
    y.e("MicorMsg.WalletUnbindBankCardProxyUI", "intent is null");
    finish();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletUnbindBankCardProxyUI
 * JD-Core Version:    0.7.0.1
 */