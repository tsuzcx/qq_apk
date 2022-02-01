package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.ah;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  SnsTimelineVideoView.a xVZ;
  public c xWa;
  public String xWb;
  long xWc;
  private View xWd;
  public volatile boolean xWe;
  public boolean xWf;
  public volatile boolean xWg;
  private b xWh;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100388);
    this.xVZ = SnsTimelineVideoView.a.xWk;
    this.xWc = 0L;
    this.xWe = false;
    this.xWf = false;
    this.xWg = false;
    this.xWh = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.xVZ = SnsTimelineVideoView.a.xWk;
    this.xWc = 0L;
    this.xWe = false;
    this.xWf = false;
    this.xWg = false;
    this.xWh = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.xVZ = SnsTimelineVideoView.a.xWk;
    this.xWc = 0L;
    this.xWe = false;
    this.xWf = false;
    this.xWg = false;
    this.xWh = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void aqQ(final String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.xWh != null) && (!bt.isNullOrNil(paramString))) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100384);
          try
          {
            SnsTimelineVideoView.a(SnsTimelineVideoView.this).HL(paramString);
            SnsTimelineVideoView.b(SnsTimelineVideoView.this);
            AppMethodBeat.o(100384);
            return;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
            AppMethodBeat.o(100384);
          }
        }
      });
    }
    AppMethodBeat.o(100401);
  }
  
  private void dDO()
  {
    AppMethodBeat.i(100399);
    if (this.xWd != null)
    {
      this.xWd.setAlpha(0.0F);
      ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.xWd = findViewById(2131306422);
    AppMethodBeat.o(100391);
  }
  
  public final boolean Nb()
  {
    AppMethodBeat.i(100397);
    if ((this.nAZ instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.nAZ).Nb();
      AppMethodBeat.o(100397);
      return bool;
    }
    ad.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(100397);
    return false;
  }
  
  public final void dDM()
  {
    AppMethodBeat.i(100395);
    if (this.xpH != null) {
      this.xpH.dzW();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void dDN()
  {
    AppMethodBeat.i(100396);
    qc(false);
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void dDP()
  {
    AppMethodBeat.i(100400);
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    aqQ(this.xWb);
    this.xWb = "";
    this.xWe = true;
    if (this.xpH != null)
    {
      this.xpH.dzO();
      this.xpH.clear();
      this.xpH = null;
    }
    dzu();
    h.Iye.aP(new Runnable()
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
  
  public final void dDQ()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.xWh != null)
      {
        this.xWh.HL(this.xWb);
        this.xWh = null;
      }
      AppMethodBeat.o(100402);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
      AppMethodBeat.o(100402);
    }
  }
  
  public final void dDR()
  {
    AppMethodBeat.i(100404);
    this.xWb = "";
    super.onDestroy();
    this.xWe = false;
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public final void dzF()
  {
    AppMethodBeat.i(100398);
    super.dzF();
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.xVZ = SnsTimelineVideoView.a.xWm;
    this.xWc = System.currentTimeMillis();
    dDO();
    ez(true);
    AppMethodBeat.o(100398);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    aqQ(this.xWb);
    this.xWb = "";
    super.onDestroy();
    this.xWe = false;
    this.xWg = true;
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.xWf) });
    this.xVZ = SnsTimelineVideoView.a.xWk;
    if (!this.xWf)
    {
      dDP();
      AppMethodBeat.o(100392);
      return;
    }
    this.xWf = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    dDO();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public final void qc(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    super.ckd();
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.xVZ = SnsTimelineVideoView.a.xWl;
    if ((paramBoolean) && (this.xWd != null))
    {
      this.xWd.setAlpha(1.0F);
      ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    dzu();
    AppMethodBeat.o(100394);
  }
  
  public void setUICallback(b paramb)
  {
    AppMethodBeat.i(100405);
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.xWh = paramb;
    AppMethodBeat.o(100405);
  }
  
  public static abstract interface b
  {
    public abstract void HL(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */