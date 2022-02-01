package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  extends l
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
          if (a.this.dWS().zAg.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.zxZ) {
            paramAnonymousContext.dWl();
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
        a.this.aM(paramAnonymousIntent);
      }
      label98:
      AppMethodBeat.o(96313);
    }
  };
  public boolean zxU;
  private boolean zxV = true;
  private boolean zxW = false;
  public com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a zxX;
  private volatile boolean zxY = false;
  public boolean zxZ;
  
  public a(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    try
    {
      this.zxX = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.dRv();
      paramContext = d.U(this.context);
      paramx = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramx.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.receiver, paramx);
      ad.v("AbsVideoPlayComp", "register receiver " + this.receiver);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  protected final void aM(Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      i = y.getIntExtra(paramIntent, "TRY_PAUSE_OR_RESUME", 0);
      if (i != 1) {
        break label34;
      }
      this.zxW = true;
      if (isPlaying()) {
        cxt();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.zxW = false;
    } while (isPlaying());
    cxu();
  }
  
  protected void cxt() {}
  
  protected void cxu() {}
  
  public void dRk()
  {
    super.dRk();
  }
  
  public void dRm()
  {
    super.dRm();
    this.zxZ = true;
  }
  
  public void dRn()
  {
    super.dRn();
    this.zxZ = false;
  }
  
  public void dRo()
  {
    super.dRo();
    d.U(this.context).unregisterReceiver(this.receiver);
    this.zxZ = true;
    ad.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
  
  public void dWl()
  {
    this.zxU = false;
  }
  
  public void dWm()
  {
    super.dWm();
    if (this.zxV)
    {
      this.zxV = false;
      if (!dWZ().zAO) {
        dWl();
      }
    }
    else
    {
      return;
    }
    dWn();
  }
  
  public void dWn()
  {
    this.zxU = true;
  }
  
  public final void dWo()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", dWS().zAg);
    d.U(this.context).b(localIntent);
  }
  
  public final int dWp()
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