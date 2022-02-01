package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  extends m
{
  public boolean KkA;
  private boolean KkB = true;
  private boolean KkC = false;
  public com.tencent.mm.plugin.sns.ad.landingpage.helper.d.a KkD;
  private volatile boolean KkE = false;
  public boolean KkF;
  private BroadcastReceiver receiver = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      AppMethodBeat.i(96313);
      if (paramAnonymousIntent == null)
      {
        AppMethodBeat.o(96313);
        return;
      }
      try
      {
        if ("com.tencent.mm.adlanding.close_exposure_voice".equals(paramAnonymousIntent.getAction()))
        {
          if (a.this.KqB.KmB.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.KkF) {
            paramAnonymousContext.fKr();
          }
          AppMethodBeat.o(96313);
          return;
        }
      }
      catch (Throwable paramAnonymousContext)
      {
        AppMethodBeat.o(96313);
        return;
      }
      if ("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME".equals(paramAnonymousIntent.getAction())) {
        a.this.aX(paramAnonymousIntent);
      }
      label98:
      AppMethodBeat.o(96313);
    }
  };
  
  public a(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    try
    {
      this.KkD = com.tencent.mm.plugin.sns.ad.landingpage.helper.d.a.fKN();
      paramContext = androidx.h.a.a.V(this.context);
      paramaa = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramaa.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.receiver, paramaa);
      Log.v("AbsVideoPlayComp", "register receiver " + this.receiver);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  protected final void aX(Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      i = IntentUtil.getIntExtra(paramIntent, "TRY_PAUSE_OR_RESUME", 0);
      if (i != 1) {
        break label34;
      }
      this.KkC = true;
      if (isPlaying()) {
        dmf();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.KkC = false;
    } while (isPlaying());
    dmg();
  }
  
  protected void dmf() {}
  
  protected void dmg() {}
  
  public void fKk()
  {
    super.fKk();
    this.KkF = true;
  }
  
  public void fKl()
  {
    super.fKl();
    this.KkF = false;
  }
  
  public void fKm()
  {
    super.fKm();
    if (this.KkB)
    {
      this.KkB = false;
      if (!fRp().Knq) {
        fKr();
      }
    }
    else
    {
      return;
    }
    fKs();
  }
  
  public void fKo()
  {
    super.fKo();
    androidx.h.a.a.V(this.context).unregisterReceiver(this.receiver);
    this.KkF = true;
    Log.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
  
  public void fKp()
  {
    super.fKp();
  }
  
  public void fKr()
  {
    this.KkA = false;
  }
  
  public void fKs()
  {
    this.KkA = true;
  }
  
  public final void fQC()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", this.KqB.KmB);
    androidx.h.a.a.V(this.context).c(localIntent);
  }
  
  public final int fQD()
  {
    if (this.context != null) {
      return this.context.hashCode();
    }
    return 0;
  }
  
  public abstract boolean isPlaying();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */