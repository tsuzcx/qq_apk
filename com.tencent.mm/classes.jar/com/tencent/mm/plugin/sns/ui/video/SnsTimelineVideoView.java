package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  long FsW;
  private View RUA;
  public volatile boolean RUB;
  public boolean RUC;
  public volatile boolean RUD;
  private b RUE;
  SnsTimelineVideoView.a RUy;
  public d RUz;
  public String Rcp;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(100388);
    this.RUy = SnsTimelineVideoView.a.RUH;
    this.FsW = 0L;
    this.RUB = false;
    this.RUC = false;
    this.RUD = false;
    this.RUE = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(308577);
    this.RUy = SnsTimelineVideoView.a.RUH;
    this.FsW = 0L;
    this.RUB = false;
    this.RUC = false;
    this.RUD = false;
    this.RUE = null;
    init();
    AppMethodBeat.o(308577);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.RUy = SnsTimelineVideoView.a.RUH;
    this.FsW = 0L;
    this.RUB = false;
    this.RUC = false;
    this.RUD = false;
    this.RUE = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.RUy = SnsTimelineVideoView.a.RUH;
    this.FsW = 0L;
    this.RUB = false;
    this.RUC = false;
    this.RUD = false;
    this.RUE = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void bbm(final String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.RUE != null) && (!Util.isNullOrNil(paramString))) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100384);
          try
          {
            SnsTimelineVideoView.a(SnsTimelineVideoView.this).ZW(paramString);
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
  
  private void hce()
  {
    AppMethodBeat.i(100399);
    if (this.RUA != null)
    {
      this.RUA.setAlpha(0.0F);
      Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.RUA = findViewById(b.f.videoview_play_btn);
    AppMethodBeat.o(100391);
  }
  
  public final void Dt(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    bck();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.RUy = SnsTimelineVideoView.a.RUI;
    if ((paramBoolean) && (this.RUA != null))
    {
      this.RUA.setAlpha(1.0F);
      Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    hmt();
    AppMethodBeat.o(100394);
  }
  
  public final boolean aFF()
  {
    AppMethodBeat.i(100397);
    if ((this.wCd instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.wCd).aFF();
      AppMethodBeat.o(100397);
      return bool;
    }
    if ((this.wCd instanceof ThumbPlayerVideoView))
    {
      if (((ThumbPlayerVideoView)this.wCd).state == 6)
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
  
  public final void bck()
  {
    AppMethodBeat.i(308593);
    Object localObject1;
    if ((this.wCd instanceof ThumbPlayerVideoView)) {
      localObject1 = (ThumbPlayerVideoView)this.wCd;
    }
    try
    {
      localObject1 = ((ThumbPlayerVideoView)localObject1).getBitmap(((ThumbPlayerVideoView)localObject1).getWidth() / 2, ((ThumbPlayerVideoView)localObject1).getHeight() / 2);
      if (localObject1 != null) {
        this.RgJ.setImageBitmap((Bitmap)localObject1);
      }
      super.bck();
      AppMethodBeat.o(308593);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.SnsOnlineVideoView", "OOM occurs, ignore bitmap");
        Object localObject2 = null;
      }
    }
  }
  
  public final void bcl()
  {
    AppMethodBeat.i(100398);
    super.bcl();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.RUy = SnsTimelineVideoView.a.RUJ;
    this.FsW = System.currentTimeMillis();
    hce();
    ho(true);
    AppMethodBeat.o(100398);
  }
  
  public View getInnerVideoView()
  {
    if ((this.wCd instanceof View)) {
      return (View)this.wCd;
    }
    return null;
  }
  
  public final void hsj()
  {
    AppMethodBeat.i(100395);
    if (this.RgV != null) {
      this.RgV.hnb();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void hsk()
  {
    AppMethodBeat.i(100396);
    Dt(false);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void hsl()
  {
    AppMethodBeat.i(100400);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    bbm(this.Rcp);
    this.Rcp = "";
    this.RUB = true;
    if (this.RgU != null)
    {
      this.RgU.stop();
      this.RgU = null;
    }
    if (this.RgK != null)
    {
      this.RgK.hmT();
      this.RgK.clear();
      this.RgK = null;
    }
    hmt();
    h.ahAA.bm(new Runnable()
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
  
  public final void hsm()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.RUE != null)
      {
        this.RUE.ZW(this.Rcp);
        this.RUE = null;
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
  
  public final void hsn()
  {
    AppMethodBeat.i(100404);
    this.Rcp = "";
    super.onDestroy();
    this.RUB = false;
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    bbm(this.Rcp);
    this.Rcp = "";
    super.onDestroy();
    this.RUB = false;
    this.RUD = true;
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.RUC) });
    this.RUy = SnsTimelineVideoView.a.RUH;
    if (!this.RUC)
    {
      hsl();
      AppMethodBeat.o(100392);
      return;
    }
    this.RUC = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    hce();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public void setUICallback(b paramb)
  {
    AppMethodBeat.i(100405);
    Log.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.RUE = paramb;
    AppMethodBeat.o(100405);
  }
  
  public static abstract interface b
  {
    public abstract void ZW(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */