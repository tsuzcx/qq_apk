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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  SnsTimelineVideoView.a ziV;
  public c ziW;
  public String ziX;
  long ziY;
  private View ziZ;
  public volatile boolean zja;
  public boolean zjb;
  public volatile boolean zjc;
  private b zjd;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100388);
    this.ziV = SnsTimelineVideoView.a.zjg;
    this.ziY = 0L;
    this.zja = false;
    this.zjb = false;
    this.zjc = false;
    this.zjd = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.ziV = SnsTimelineVideoView.a.zjg;
    this.ziY = 0L;
    this.zja = false;
    this.zjb = false;
    this.zjc = false;
    this.zjd = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.ziV = SnsTimelineVideoView.a.zjg;
    this.ziY = 0L;
    this.zja = false;
    this.zjb = false;
    this.zjc = false;
    this.zjd = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void avZ(final String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.zjd != null) && (!bs.isNullOrNil(paramString))) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100384);
          try
          {
            SnsTimelineVideoView.a(SnsTimelineVideoView.this).LP(paramString);
            SnsTimelineVideoView.b(SnsTimelineVideoView.this);
            AppMethodBeat.o(100384);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
            AppMethodBeat.o(100384);
          }
        }
      });
    }
    AppMethodBeat.o(100401);
  }
  
  private void dSm()
  {
    AppMethodBeat.i(100399);
    if (this.ziZ != null)
    {
      this.ziZ.setAlpha(0.0F);
      ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.ziZ = findViewById(2131306422);
    AppMethodBeat.o(100391);
  }
  
  public final boolean MZ()
  {
    AppMethodBeat.i(100397);
    if ((this.odZ instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.odZ).MZ();
      AppMethodBeat.o(100397);
      return bool;
    }
    ac.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(100397);
    return false;
  }
  
  public final void dOc()
  {
    AppMethodBeat.i(100398);
    super.dOc();
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.ziV = SnsTimelineVideoView.a.zji;
    this.ziY = System.currentTimeMillis();
    dSm();
    eT(true);
    AppMethodBeat.o(100398);
  }
  
  public final void dSk()
  {
    AppMethodBeat.i(100395);
    if (this.yCx != null) {
      this.yCx.dOt();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void dSl()
  {
    AppMethodBeat.i(100396);
    rb(false);
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void dSn()
  {
    AppMethodBeat.i(100400);
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    avZ(this.ziX);
    this.ziX = "";
    this.zja = true;
    if (this.yCx != null)
    {
      this.yCx.dOl();
      this.yCx.clear();
      this.yCx = null;
    }
    dNR();
    h.JZN.aS(new Runnable()
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
  
  public final void dSo()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.zjd != null)
      {
        this.zjd.LP(this.ziX);
        this.zjd = null;
      }
      AppMethodBeat.o(100402);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
      AppMethodBeat.o(100402);
    }
  }
  
  public final void dSp()
  {
    AppMethodBeat.i(100404);
    this.ziX = "";
    super.onDestroy();
    this.zja = false;
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    avZ(this.ziX);
    this.ziX = "";
    super.onDestroy();
    this.zja = false;
    this.zjc = true;
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.zjb) });
    this.ziV = SnsTimelineVideoView.a.zjg;
    if (!this.zjb)
    {
      dSn();
      AppMethodBeat.o(100392);
      return;
    }
    this.zjb = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    dSm();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public final void rb(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    super.crK();
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.ziV = SnsTimelineVideoView.a.zjh;
    if ((paramBoolean) && (this.ziZ != null))
    {
      this.ziZ.setAlpha(1.0F);
      ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    dNR();
    AppMethodBeat.o(100394);
  }
  
  public void setUICallback(b paramb)
  {
    AppMethodBeat.i(100405);
    ac.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.zjd = paramb;
    AppMethodBeat.o(100405);
  }
  
  public static abstract interface b
  {
    public abstract void LP(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */