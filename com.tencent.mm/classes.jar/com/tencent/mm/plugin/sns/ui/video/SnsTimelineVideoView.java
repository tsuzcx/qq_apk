package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  SnsTimelineVideoView.a AAV;
  public c AAW;
  public String AAX;
  long AAY;
  private View AAZ;
  public volatile boolean ABa;
  public boolean ABb;
  public volatile boolean ABc;
  private b ABd;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100388);
    this.AAV = SnsTimelineVideoView.a.ABg;
    this.AAY = 0L;
    this.ABa = false;
    this.ABb = false;
    this.ABc = false;
    this.ABd = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.AAV = SnsTimelineVideoView.a.ABg;
    this.AAY = 0L;
    this.ABa = false;
    this.ABb = false;
    this.ABc = false;
    this.ABd = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.AAV = SnsTimelineVideoView.a.ABg;
    this.AAY = 0L;
    this.ABa = false;
    this.ABb = false;
    this.ABc = false;
    this.ABd = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void aBg(final String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.ABd != null) && (!bt.isNullOrNil(paramString))) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100384);
          try
          {
            SnsTimelineVideoView.a(SnsTimelineVideoView.this).Pj(paramString);
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
  
  private void eeG()
  {
    AppMethodBeat.i(100399);
    if (this.AAZ != null)
    {
      this.AAZ.setAlpha(0.0F);
      ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.AAZ = findViewById(2131306422);
    AppMethodBeat.o(100391);
  }
  
  public final boolean OI()
  {
    AppMethodBeat.i(100397);
    if ((this.oHt instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.oHt).OI();
      AppMethodBeat.o(100397);
      return bool;
    }
    ad.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(100397);
    return false;
  }
  
  public final void eaq()
  {
    AppMethodBeat.i(100398);
    super.eaq();
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.AAV = SnsTimelineVideoView.a.ABi;
    this.AAY = System.currentTimeMillis();
    eeG();
    eV(true);
    AppMethodBeat.o(100398);
  }
  
  public final void eeE()
  {
    AppMethodBeat.i(100395);
    if (this.zTS != null) {
      this.zTS.eaH();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void eeF()
  {
    AppMethodBeat.i(100396);
    rF(false);
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void eeH()
  {
    AppMethodBeat.i(100400);
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    aBg(this.AAX);
    this.AAX = "";
    this.ABa = true;
    if (this.zTS != null)
    {
      this.zTS.eaz();
      this.zTS.clear();
      this.zTS = null;
    }
    eae();
    h.LTJ.aR(new Runnable()
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
  
  public final void eeI()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.ABd != null)
      {
        this.ABd.Pj(this.AAX);
        this.ABd = null;
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
  
  public final void eeJ()
  {
    AppMethodBeat.i(100404);
    this.AAX = "";
    super.onDestroy();
    this.ABa = false;
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    aBg(this.AAX);
    this.AAX = "";
    super.onDestroy();
    this.ABa = false;
    this.ABc = true;
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.ABb) });
    this.AAV = SnsTimelineVideoView.a.ABg;
    if (!this.ABb)
    {
      eeH();
      AppMethodBeat.o(100392);
      return;
    }
    this.ABb = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    eeG();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public final void rF(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    super.cxw();
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.AAV = SnsTimelineVideoView.a.ABh;
    if ((paramBoolean) && (this.AAZ != null))
    {
      this.AAZ.setAlpha(1.0F);
      ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    eae();
    AppMethodBeat.o(100394);
  }
  
  public void setUICallback(b paramb)
  {
    AppMethodBeat.i(100405);
    ad.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.ABd = paramb;
    AppMethodBeat.o(100405);
  }
  
  public static abstract interface b
  {
    public abstract void Pj(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */