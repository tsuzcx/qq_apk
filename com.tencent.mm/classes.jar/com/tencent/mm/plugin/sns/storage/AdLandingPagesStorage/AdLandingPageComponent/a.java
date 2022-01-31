package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a
  extends h
{
  private BroadcastReceiver receiver = new a.1(this);
  private boolean rrA = true;
  public boolean rrB;
  public boolean rrz;
  
  public a(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
    d.R(this.context).a(this.receiver, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
    ab.v("AbsVideoPlayComp", "register receiver " + this.receiver);
  }
  
  public void cqA()
  {
    super.cqA();
    this.rrB = true;
  }
  
  public void cqB()
  {
    super.cqB();
    this.rrB = false;
  }
  
  public void cqC()
  {
    super.cqC();
    if (this.rrA)
    {
      this.rrA = false;
      if (!crc().rtg) {
        cqy();
      }
    }
    else
    {
      return;
    }
    cqD();
  }
  
  public void cqD()
  {
    this.rrz = true;
  }
  
  public final void cqE()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", cqV().rsI);
    d.R(this.context).c(localIntent);
  }
  
  public void cqy()
  {
    this.rrz = false;
  }
  
  public void cqz()
  {
    super.cqz();
    d.R(this.context).unregisterReceiver(this.receiver);
    this.rrB = true;
    ab.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */