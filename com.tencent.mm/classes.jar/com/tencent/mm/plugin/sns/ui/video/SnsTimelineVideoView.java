package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  a FcX;
  public c FcY;
  public String FcZ;
  private View Fda;
  public volatile boolean Fdb;
  public boolean Fdc;
  public volatile boolean Fdd;
  private b Fde;
  long vgi;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100388);
    this.FcX = a.Fdh;
    this.vgi = 0L;
    this.Fdb = false;
    this.Fdc = false;
    this.Fdd = false;
    this.Fde = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.FcX = a.Fdh;
    this.vgi = 0L;
    this.Fdb = false;
    this.Fdc = false;
    this.Fdd = false;
    this.Fde = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.FcX = a.Fdh;
    this.vgi = 0L;
    this.Fdb = false;
    this.Fdc = false;
    this.Fdd = false;
    this.Fde = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void aRt(final String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.Fde != null) && (!Util.isNullOrNil(paramString))) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100384);
          try
          {
            SnsTimelineVideoView.a(SnsTimelineVideoView.this).Zl(paramString);
            SnsTimelineVideoView.b(SnsTimelineVideoView.this);
            AppMethodBeat.o(100384);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
            AppMethodBeat.o(100384);
          }
        }
      });
    }
    AppMethodBeat.o(100401);
  }
  
  private void eYc()
  {
    AppMethodBeat.i(100399);
    if (this.Fda != null)
    {
      this.Fda.setAlpha(0.0F);
      Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.Fda = findViewById(2131309853);
    AppMethodBeat.o(100391);
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(100397);
    if ((this.qbJ instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.qbJ).YY();
      AppMethodBeat.o(100397);
      return bool;
    }
    Log.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(100397);
    return false;
  }
  
  public final void eYd()
  {
    AppMethodBeat.i(100398);
    super.eYd();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.FcX = a.Fdj;
    this.vgi = System.currentTimeMillis();
    eYc();
    fO(true);
    AppMethodBeat.o(100398);
  }
  
  public final void fkN()
  {
    AppMethodBeat.i(100395);
    if (this.EtL != null) {
      this.EtL.fgE();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void fkO()
  {
    AppMethodBeat.i(100396);
    vi(false);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void fkP()
  {
    AppMethodBeat.i(100400);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    aRt(this.FcZ);
    this.FcZ = "";
    this.Fdb = true;
    if (this.EtL != null)
    {
      this.EtL.fgw();
      this.EtL.clear();
      this.EtL = null;
    }
    fgc();
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100383);
        SnsTimelineVideoView.this.onDestroy();
        AppMethodBeat.o(100383);
      }
    });
    AppMethodBeat.o(100400);
  }
  
  public final void fkQ()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.Fde != null)
      {
        this.Fde.Zl(this.FcZ);
        this.Fde = null;
      }
      AppMethodBeat.o(100402);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
      AppMethodBeat.o(100402);
    }
  }
  
  public final void fkR()
  {
    AppMethodBeat.i(100404);
    this.FcZ = "";
    super.onDestroy();
    this.Fdb = false;
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    aRt(this.FcZ);
    this.FcZ = "";
    super.onDestroy();
    this.Fdb = false;
    this.Fdd = true;
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Fdc) });
    this.FcX = a.Fdh;
    if (!this.Fdc)
    {
      fkP();
      AppMethodBeat.o(100392);
      return;
    }
    this.Fdc = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    eYc();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public void setUICallback(b paramb)
  {
    AppMethodBeat.i(100405);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.Fde = paramb;
    AppMethodBeat.o(100405);
  }
  
  public final void vi(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    super.cXa();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.FcX = a.Fdi;
    if ((paramBoolean) && (this.Fda != null))
    {
      this.Fda.setAlpha(1.0F);
      Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    fgc();
    AppMethodBeat.o(100394);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(100387);
      Fdh = new a("AVAILABLE", 0);
      Fdi = new a("ATTACHING", 1);
      Fdj = new a("PLAYING", 2);
      Fdk = new a[] { Fdh, Fdi, Fdj };
      AppMethodBeat.o(100387);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void Zl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */