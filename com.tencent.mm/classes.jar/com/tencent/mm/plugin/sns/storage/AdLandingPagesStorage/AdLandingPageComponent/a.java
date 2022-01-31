package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  extends i
{
  public boolean oCa;
  protected boolean oCb = SnsAdNativeLandingPagesUI.oUq;
  public boolean oCc;
  private BroadcastReceiver zm = new a.1(this);
  
  public a(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
    d.Q(this.context).a(this.zm, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
    y.v("AbsVideoPlayComp", "register receiver " + this.zm);
  }
  
  public void W(int paramInt1, int paramInt2, int paramInt3)
  {
    super.W(paramInt1, paramInt2, paramInt3);
  }
  
  public void bER()
  {
    this.oCa = false;
  }
  
  public void bES()
  {
    super.bES();
    d.Q(this.context).unregisterReceiver(this.zm);
    this.oCc = true;
    y.v("AbsVideoPlayComp", "unregister receiver " + this.zm);
  }
  
  public void bET()
  {
    super.bET();
    this.oCc = true;
  }
  
  public void bEU()
  {
    super.bEU();
    this.oCc = false;
  }
  
  public void bEV()
  {
    this.oCa = true;
  }
  
  public final void bEW()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", bFm().oDg);
    d.Q(this.context).a(localIntent);
  }
  
  protected final void bEX()
  {
    super.bEX();
    if (!this.oCb)
    {
      bER();
      return;
    }
    bEV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */