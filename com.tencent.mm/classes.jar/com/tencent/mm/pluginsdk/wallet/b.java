package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.ui.MMActivity.a;

public abstract interface b
  extends a
{
  public abstract boolean TenPaySDKABTestKindaEnable();
  
  public abstract boolean canOpenKindaCashier(Context paramContext);
  
  public abstract Activity getCrossActivity();
  
  public abstract boolean kindaCacheServiceGetBool(String paramString);
  
  public abstract void kindaCacheServiceSetBool(String paramString, boolean paramBoolean);
  
  public abstract void startOfflinePay(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void startSNSPay(Context paramContext, PayInfo paramPayInfo);
  
  public abstract void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2);
  
  public abstract void startWxpayAppPay(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void startWxpayH5Pay(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void startWxpayJsApiPay(Context paramContext, WalletJsapiData paramWalletJsapiData, MMActivity.a parama, int paramInt);
  
  public abstract void startWxpayQueryCashierPay(Context paramContext, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.b
 * JD-Core Version:    0.7.0.1
 */