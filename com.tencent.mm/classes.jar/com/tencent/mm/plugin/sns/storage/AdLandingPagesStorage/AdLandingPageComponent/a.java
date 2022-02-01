package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  extends k
{
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
          if (a.this.dwb().wWE.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.wVd) {
            paramAnonymousContext.dvw();
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
        a.this.aF(paramAnonymousIntent);
      }
      label98:
      AppMethodBeat.o(96313);
    }
  };
  public boolean wUZ;
  private boolean wVa = true;
  private boolean wVb = false;
  private volatile boolean wVc = false;
  public boolean wVd;
  
  public a(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    try
    {
      paramContext = d.T(this.context);
      paramx = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramx.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.receiver, paramx);
      com.tencent.mm.sdk.platformtools.ad.v("AbsVideoPlayComp", "register receiver " + this.receiver);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  protected final void aF(Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      i = y.getIntExtra(paramIntent, "TRY_PAUSE_OR_RESUME", 0);
      if (i != 1) {
        break label34;
      }
      this.wVb = true;
      if (isPlaying()) {
        cka();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.wVb = false;
    } while (isPlaying());
    ckb();
  }
  
  protected void cka() {}
  
  protected void ckb() {}
  
  public void dvA()
  {
    super.dvA();
    this.wVd = false;
  }
  
  public void dvB()
  {
    super.dvB();
    if (this.wVa)
    {
      this.wVa = false;
      if (!dwi().wXk) {
        dvw();
      }
    }
    else
    {
      return;
    }
    dvC();
  }
  
  public void dvC()
  {
    this.wUZ = true;
  }
  
  public final void dvD()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", dwb().wWE);
    d.T(this.context).b(localIntent);
  }
  
  public void dvw()
  {
    this.wUZ = false;
  }
  
  public void dvx()
  {
    super.dvx();
  }
  
  public void dvy()
  {
    super.dvy();
    d.T(this.context).unregisterReceiver(this.receiver);
    this.wVd = true;
    com.tencent.mm.sdk.platformtools.ad.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
  
  public void dvz()
  {
    super.dvz();
    this.wVd = true;
  }
  
  public abstract boolean isPlaying();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */