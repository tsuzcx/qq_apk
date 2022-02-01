package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.sdk.platformtools.ac;

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
          if (a.this.dKA().yjs.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.yhR) {
            paramAnonymousContext.dJV();
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
        a.this.aH(paramAnonymousIntent);
      }
      label98:
      AppMethodBeat.o(96313);
    }
  };
  public boolean yhN;
  private boolean yhO = true;
  private boolean yhP = false;
  private volatile boolean yhQ = false;
  public boolean yhR;
  
  public a(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    try
    {
      paramContext = d.U(this.context);
      paramx = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramx.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.receiver, paramx);
      ac.v("AbsVideoPlayComp", "register receiver " + this.receiver);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  protected final void aH(Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      i = com.tencent.mm.sdk.platformtools.x.getIntExtra(paramIntent, "TRY_PAUSE_OR_RESUME", 0);
      if (i != 1) {
        break label34;
      }
      this.yhP = true;
      if (isPlaying()) {
        crH();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.yhP = false;
    } while (isPlaying());
    crI();
  }
  
  protected void crH() {}
  
  protected void crI() {}
  
  public void dJV()
  {
    this.yhN = false;
  }
  
  public void dJW()
  {
    super.dJW();
  }
  
  public void dJX()
  {
    super.dJX();
    d.U(this.context).unregisterReceiver(this.receiver);
    this.yhR = true;
    ac.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
  }
  
  public void dJY()
  {
    super.dJY();
    this.yhR = true;
  }
  
  public void dJZ()
  {
    super.dJZ();
    this.yhR = false;
  }
  
  public void dKa()
  {
    super.dKa();
    if (this.yhO)
    {
      this.yhO = false;
      if (!dKH().yjZ) {
        dJV();
      }
    }
    else
    {
      return;
    }
    dKb();
  }
  
  public void dKb()
  {
    this.yhN = true;
  }
  
  public final void dKc()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", dKA().yjs);
    d.U(this.context).b(localIntent);
  }
  
  public abstract boolean isPlaying();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */