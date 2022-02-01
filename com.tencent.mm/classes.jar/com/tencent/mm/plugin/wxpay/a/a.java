package com.tencent.mm.plugin.wxpay.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.wallet_core.c.aa;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract void beforeJumpRedPacketPreviewUI();
  
  public abstract void doRedPacketPreviewLoading(Context paramContext, String paramString);
  
  public abstract aa getWalletCacheStg();
  
  public abstract void gotoLuckyMoneyReceiveUI(Context paramContext, Bundle paramBundle, k.b paramb);
  
  public abstract void gotoRedPacketPreviewUI(Context paramContext, String paramString);
  
  public abstract boolean hasInitBiometricManager();
  
  public abstract void onExitRedPacketPreviewChatting();
  
  public abstract void triggerSoterReInit();
  
  public abstract void unMarkLuckyMoneyRedFlag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpay.a.a
 * JD-Core Version:    0.7.0.1
 */