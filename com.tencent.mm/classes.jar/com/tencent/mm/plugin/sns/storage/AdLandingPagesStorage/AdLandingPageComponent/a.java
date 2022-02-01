package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  extends m
{
  public boolean DXr;
  private boolean DXs = true;
  private boolean DXt = false;
  public com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a DXu;
  private volatile boolean DXv = false;
  public boolean DXw;
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
          if (a.this.fdk().DZi.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.DXw) {
            paramAnonymousContext.fcJ();
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
  
  public a(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    try
    {
      this.DXu = com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a.eXm();
      paramContext = d.W(this.context);
      paramz = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramz.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.receiver, paramz);
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
      this.DXt = true;
      if (isPlaying()) {
        cWX();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.DXt = false;
    } while (isPlaying());
    cWY();
  }
  
  protected void cWX() {}
  
  protected void cWY() {}
  
  public void eWZ()
  {
    super.eWZ();
    this.DXw = true;
  }
  
  public void eXa()
  {
    super.eXa();
    this.DXw = false;
  }
  
  public void eXb()
  {
    super.eXb();
    if (this.DXs)
    {
      this.DXs = false;
      if (!fds().DZV) {
        fcJ();
      }
    }
    else
    {
      return;
    }
    fcK();
  }
  
  public void eXd()
  {
    super.eXd();
    d.W(this.context).unregisterReceiver(this.receiver);
    this.DXw = true;
    Log.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
  
  public void eXe()
  {
    super.eXe();
  }
  
  public void fcJ()
  {
    this.DXr = false;
  }
  
  public void fcK()
  {
    this.DXr = true;
  }
  
  public final void fcL()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", fdk().DZi);
    d.W(this.context).b(localIntent);
  }
  
  public final int fcM()
  {
    if (this.context != null) {
      return this.context.hashCode();
    }
    return 0;
  }
  
  public abstract boolean isPlaying();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */