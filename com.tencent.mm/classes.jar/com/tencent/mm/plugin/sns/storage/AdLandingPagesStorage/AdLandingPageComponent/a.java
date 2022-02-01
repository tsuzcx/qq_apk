package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.z;

public abstract class a
  extends m
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
          if (a.this.eaw().zRg.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.zPy) {
            paramAnonymousContext.dZN();
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
        a.this.aN(paramAnonymousIntent);
      }
      label98:
      AppMethodBeat.o(96313);
    }
  };
  public boolean zPt;
  private boolean zPu = true;
  private boolean zPv = false;
  public com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a zPw;
  private volatile boolean zPx = false;
  public boolean zPy;
  
  public a(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
    try
    {
      this.zPw = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.dUT();
      paramContext = d.V(this.context);
      paramy = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramy.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.receiver, paramy);
      ae.v("AbsVideoPlayComp", "register receiver " + this.receiver);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  protected final void aN(Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      i = z.getIntExtra(paramIntent, "TRY_PAUSE_OR_RESUME", 0);
      if (i != 1) {
        break label34;
      }
      this.zPv = true;
      if (isPlaying()) {
        cyU();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.zPv = false;
    } while (isPlaying());
    cyV();
  }
  
  protected void cyU() {}
  
  protected void cyV() {}
  
  public void dUI()
  {
    super.dUI();
  }
  
  public void dUK()
  {
    super.dUK();
    this.zPy = true;
  }
  
  public void dUL()
  {
    super.dUL();
    this.zPy = false;
  }
  
  public void dUM()
  {
    super.dUM();
    d.V(this.context).unregisterReceiver(this.receiver);
    this.zPy = true;
    ae.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
  
  public void dZN()
  {
    this.zPt = false;
  }
  
  public void dZO()
  {
    super.dZO();
    if (this.zPu)
    {
      this.zPu = false;
      if (!eaD().zRO) {
        dZN();
      }
    }
    else
    {
      return;
    }
    dZP();
  }
  
  public void dZP()
  {
    this.zPt = true;
  }
  
  public final void dZQ()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", eaw().zRg);
    d.V(this.context).b(localIntent);
  }
  
  public final int dZR()
  {
    if (this.context != null) {
      return this.context.hashCode();
    }
    return 0;
  }
  
  public abstract boolean isPlaying();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */