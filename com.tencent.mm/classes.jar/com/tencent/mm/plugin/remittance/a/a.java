package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;

public class a
  extends c
{
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
    b(paramActivity, RemittanceAdapterUI.class, paramBundle);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle) {}
  
  public final String aTh()
  {
    return "RemittanceProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    super.ak(paramActivity);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */