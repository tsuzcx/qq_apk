package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  extends n
{
  public boolean QIH;
  private boolean QII = true;
  private boolean QIJ = false;
  public com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a QIK;
  private volatile boolean QIL = false;
  public boolean QIM;
  private BroadcastReceiver bJm = new BroadcastReceiver()
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
          if (a.this.QOV.QKG.equals(paramAnonymousIntent.getStringExtra("para_id"))) {
            break label98;
          }
          paramAnonymousContext = a.this;
          if (paramAnonymousContext.QIM) {
            paramAnonymousContext.haw();
          }
        }
      }
      finally
      {
        AppMethodBeat.o(96313);
        return;
      }
      if ("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME".equals(paramAnonymousIntent.getAction())) {
        a.this.bx(paramAnonymousIntent);
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
      this.QIK = com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a.hbd();
      paramContext = androidx.i.a.a.al(this.context);
      paramaa = new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice");
      paramaa.addAction("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
      paramContext.a(this.bJm, paramaa);
      Log.v("AbsVideoPlayComp", "register receiver " + this.bJm);
      return;
    }
    finally {}
  }
  
  public void Gs()
  {
    super.Gs();
  }
  
  protected final void bx(Intent paramIntent)
  {
    int i;
    if (paramIntent != null)
    {
      i = IntentUtil.getIntExtra(paramIntent, "TRY_PAUSE_OR_RESUME", 0);
      if (i != 1) {
        break label34;
      }
      this.QIJ = true;
      if (isPlaying()) {
        dSW();
      }
    }
    label34:
    do
    {
      do
      {
        return;
      } while (i != 2);
      this.QIJ = false;
    } while (isPlaying());
    dSX();
  }
  
  protected void dSW() {}
  
  protected void dSX() {}
  
  public void hao()
  {
    super.hao();
    this.QIM = true;
  }
  
  public void hap()
  {
    super.hap();
    this.QIM = false;
  }
  
  public void haq()
  {
    super.haq();
    if (this.QII)
    {
      this.QII = false;
      if (!hjn().QLv) {
        haw();
      }
    }
    else
    {
      return;
    }
    hax();
  }
  
  public void has()
  {
    super.has();
    androidx.i.a.a.al(this.context).unregisterReceiver(this.bJm);
    this.QIM = true;
    Log.v("AbsVideoPlayComp", "unregister receiver " + this.bJm);
  }
  
  public void hav() {}
  
  public void haw()
  {
    this.QIH = false;
  }
  
  public void hax()
  {
    this.QIH = true;
  }
  
  public final void hiA()
  {
    Intent localIntent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
    localIntent.putExtra("para_id", this.QOV.QKG);
    androidx.i.a.a.al(this.context).d(localIntent);
  }
  
  public final int hiB()
  {
    if (this.context != null) {
      return this.context.hashCode();
    }
    return 0;
  }
  
  public abstract boolean isPlaying();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
 * JD-Core Version:    0.7.0.1
 */