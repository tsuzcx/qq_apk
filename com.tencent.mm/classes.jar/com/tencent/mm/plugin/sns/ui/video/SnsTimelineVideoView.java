package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  private b LrA;
  a Lrt;
  public d Lru;
  public String Lrv;
  private View Lrw;
  public volatile boolean Lrx;
  public boolean Lry;
  public volatile boolean Lrz;
  long zXq;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(100388);
    this.Lrt = a.LrD;
    this.zXq = 0L;
    this.Lrx = false;
    this.Lry = false;
    this.Lrz = false;
    this.LrA = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(225558);
    this.Lrt = a.LrD;
    this.zXq = 0L;
    this.Lrx = false;
    this.Lry = false;
    this.Lrz = false;
    this.LrA = null;
    init();
    AppMethodBeat.o(225558);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.Lrt = a.LrD;
    this.zXq = 0L;
    this.Lrx = false;
    this.Lry = false;
    this.Lrz = false;
    this.LrA = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.Lrt = a.LrD;
    this.zXq = 0L;
    this.Lrx = false;
    this.Lry = false;
    this.Lrz = false;
    this.LrA = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void bcy(final String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.LrA != null) && (!Util.isNullOrNil(paramString))) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100384);
          try
          {
            SnsTimelineVideoView.a(SnsTimelineVideoView.this).agY(paramString);
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
  
  private void fLI()
  {
    AppMethodBeat.i(100399);
    if (this.Lrw != null)
    {
      this.Lrw.setAlpha(0.0F);
      Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.Lrw = findViewById(i.f.videoview_play_btn);
    AppMethodBeat.o(100391);
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(100397);
    if ((this.txH instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.txH).adH();
      AppMethodBeat.o(100397);
      return bool;
    }
    if ((this.txH instanceof ThumbPlayerVideoView))
    {
      if (((ThumbPlayerVideoView)this.txH).state == 6)
      {
        AppMethodBeat.o(100397);
        return true;
      }
      AppMethodBeat.o(100397);
      return false;
    }
    Log.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(100397);
    return false;
  }
  
  public final void dmi()
  {
    AppMethodBeat.i(225571);
    if ((this.txH instanceof ThumbPlayerVideoView)) {
      this.KHj.setImageBitmap(((ThumbPlayerVideoView)this.txH).getBitmap());
    }
    super.dmi();
    AppMethodBeat.o(225571);
  }
  
  public final void fLJ()
  {
    AppMethodBeat.i(100398);
    super.fLJ();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.Lrt = a.LrF;
    this.zXq = System.currentTimeMillis();
    fLI();
    gA(true);
    AppMethodBeat.o(100398);
  }
  
  public final void fYY()
  {
    AppMethodBeat.i(100395);
    if (this.KHv != null) {
      this.KHv.fUK();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void fYZ()
  {
    AppMethodBeat.i(100396);
    yp(false);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void fZa()
  {
    AppMethodBeat.i(100400);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    bcy(this.Lrv);
    this.Lrv = "";
    this.Lrx = true;
    if (this.KHu != null)
    {
      this.KHu.stop();
      this.KHu = null;
    }
    if (this.KHk != null)
    {
      this.KHk.fUC();
      this.KHk.clear();
      this.KHk = null;
    }
    fTZ();
    h.ZvG.be(new Runnable()
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
  
  public final void fZb()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.LrA != null)
      {
        this.LrA.agY(this.Lrv);
        this.LrA = null;
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
  
  public final void fZc()
  {
    AppMethodBeat.i(100404);
    this.Lrv = "";
    super.onDestroy();
    this.Lrx = false;
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public View getInnerVideoView()
  {
    if ((this.txH instanceof View)) {
      return (View)this.txH;
    }
    return null;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    bcy(this.Lrv);
    this.Lrv = "";
    super.onDestroy();
    this.Lrx = false;
    this.Lrz = true;
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Lry) });
    this.Lrt = a.LrD;
    if (!this.Lry)
    {
      fZa();
      AppMethodBeat.o(100392);
      return;
    }
    this.Lry = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    fLI();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public void setUICallback(b paramb)
  {
    AppMethodBeat.i(100405);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.LrA = paramb;
    AppMethodBeat.o(100405);
  }
  
  public final void yp(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    dmi();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.Lrt = a.LrE;
    if ((paramBoolean) && (this.Lrw != null))
    {
      this.Lrw.setAlpha(1.0F);
      Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    fTZ();
    AppMethodBeat.o(100394);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(100387);
      LrD = new a("AVAILABLE", 0);
      LrE = new a("ATTACHING", 1);
      LrF = new a("PLAYING", 2);
      LrG = new a[] { LrD, LrE, LrF };
      AppMethodBeat.o(100387);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void agY(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */