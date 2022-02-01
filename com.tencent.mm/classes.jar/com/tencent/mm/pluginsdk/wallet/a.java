package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Map;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract boolean TenPaySDKABTestKindaEnable();
  
  public abstract boolean canOpenKindaCashier(Context paramContext);
  
  public abstract long getColorByMode(long paramLong1, long paramLong2);
  
  public abstract Activity getCrossActivity();
  
  public abstract boolean isSwitch2InWxAppPay(String paramString);
  
  public abstract void notifyUploadCardSuccess();
  
  public abstract void startBindCardUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startFastBindUseCase(String paramString, int paramInt, Runnable paramRunnable);
  
  public abstract void startInWxAppPayUseCase(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void startJSApiWCPaySecurityCrosscut(Map<String, Object> paramMap);
  
  public abstract void startJsApiComponentUseCase(Context paramContext, WalletJsapiData paramWalletJsapiData, MMActivity.a parama, int paramInt);
  
  public abstract void startLqtFixedDepositMakePlanUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startLqtFixedDepositPlanListUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startModifyPwdUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startOfflinePay(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract boolean startOverseaWalletSuccPageUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract boolean startPayIBGJsGetSuccPageUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startResetPwdUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startSNSPay(Context paramContext, PayInfo paramPayInfo);
  
  public abstract void startScanQRCodePay(Context paramContext, int paramInt1, String paramString, int paramInt2);
  
  public abstract void startUseCase(String paramString, Object paramObject1, Object paramObject2);
  
  public abstract void startWalletBalanceFetchUseCase(Context paramContext, Bundle paramBundle);
  
  public abstract void startWxpayAppPay(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void startWxpayH5Pay(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void startWxpayJsApiPay(Context paramContext, WalletJsapiData paramWalletJsapiData, MMActivity.a parama, int paramInt);
  
  public abstract void startWxpayQueryCashierPay(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.a
 * JD-Core Version:    0.7.0.1
 */