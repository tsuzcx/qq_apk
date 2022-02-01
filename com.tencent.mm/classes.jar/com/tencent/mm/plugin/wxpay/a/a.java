package com.tencent.mm.plugin.wxpay.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.message.k.b;
import com.tencent.mm.wallet_core.model.ab;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract void beforeJumpRedPacketPreviewUI();
  
  public abstract void doRedPacketPreviewLoading(Context paramContext, String paramString);
  
  public abstract ab getWalletCacheStg();
  
  public abstract void gotoLuckyMoneyReceiveUI(Context paramContext, Bundle paramBundle, k.b paramb);
  
  public abstract void gotoRedPacketPreviewUI(Context paramContext, String paramString);
  
  public abstract boolean hasInitBiometricManager();
  
  public abstract boolean isPayScene(Activity paramActivity);
  
  public abstract void onExitRedPacketPreviewChatting();
  
  public abstract void triggerSoterReInit();
  
  public abstract void unMarkLuckyMoneyRedFlag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.a.a
 * JD-Core Version:    0.7.0.1
 */