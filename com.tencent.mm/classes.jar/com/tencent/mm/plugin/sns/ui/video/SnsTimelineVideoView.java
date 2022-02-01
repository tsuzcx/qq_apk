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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class SnsTimelineVideoView
  extends OnlineVideoView
{
  a ASq;
  public c ASr;
  public String ASs;
  long ASt;
  private View ASu;
  public volatile boolean ASv;
  public boolean ASw;
  public volatile boolean ASx;
  private SnsTimelineVideoView.b ASy;
  
  public SnsTimelineVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(100388);
    this.ASq = a.ASB;
    this.ASt = 0L;
    this.ASv = false;
    this.ASw = false;
    this.ASx = false;
    this.ASy = null;
    init();
    AppMethodBeat.o(100388);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100389);
    this.ASq = a.ASB;
    this.ASt = 0L;
    this.ASv = false;
    this.ASw = false;
    this.ASx = false;
    this.ASy = null;
    init();
    AppMethodBeat.o(100389);
  }
  
  public SnsTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100390);
    this.ASq = a.ASB;
    this.ASt = 0L;
    this.ASv = false;
    this.ASw = false;
    this.ASx = false;
    this.ASy = null;
    init();
    AppMethodBeat.o(100390);
  }
  
  private void aCx(String paramString)
  {
    AppMethodBeat.i(100401);
    if ((this.ASy != null) && (!bu.isNullOrNil(paramString))) {
      post(new SnsTimelineVideoView.2(this, paramString));
    }
    AppMethodBeat.o(100401);
  }
  
  private void ehP()
  {
    AppMethodBeat.i(100399);
    if (this.ASu != null)
    {
      this.ASu.setAlpha(0.0F);
      ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn gone", new Object[] { Integer.valueOf(hashCode()) });
    }
    AppMethodBeat.o(100399);
  }
  
  private void init()
  {
    AppMethodBeat.i(100391);
    this.ASu = findViewById(2131306422);
    AppMethodBeat.o(100391);
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(100397);
    if ((this.oNV instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.oNV).OG();
      AppMethodBeat.o(100397);
      return bool;
    }
    ae.e("MicroMsg.Sns.SnsOnlineVideoView", "videoview not VideoPlayerTextureView");
    AppMethodBeat.o(100397);
    return false;
  }
  
  public final void edW()
  {
    AppMethodBeat.i(100398);
    super.edW();
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s resumePlay, setState PLAYING", new Object[] { Integer.valueOf(hashCode()) });
    this.ASq = a.ASD;
    this.ASt = System.currentTimeMillis();
    ehP();
    eY(true);
    AppMethodBeat.o(100398);
  }
  
  public final void eim()
  {
    AppMethodBeat.i(100395);
    if (this.AkZ != null) {
      this.AkZ.een();
    }
    AppMethodBeat.o(100395);
  }
  
  public final void ein()
  {
    AppMethodBeat.i(100396);
    rM(false);
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlayWithoutChangePlayBtn, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100396);
  }
  
  public final void eio()
  {
    AppMethodBeat.i(100400);
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyAsync", new Object[] { Integer.valueOf(hashCode()) });
    aCx(this.ASs);
    this.ASs = "";
    this.ASv = true;
    if (this.AkZ != null)
    {
      this.AkZ.eef();
      this.AkZ.clear();
      this.AkZ = null;
    }
    edK();
    h.MqF.aO(new Runnable()
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
  
  public final void eip()
  {
    AppMethodBeat.i(100402);
    try
    {
      if (this.ASy != null)
      {
        this.ASy.PR(this.ASs);
        this.ASy = null;
      }
      AppMethodBeat.o(100402);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
      AppMethodBeat.o(100402);
    }
  }
  
  public final void eiq()
  {
    AppMethodBeat.i(100404);
    this.ASs = "";
    super.onDestroy();
    this.ASv = false;
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%d onDestroyWithoutCallback succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100404);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(100403);
    aCx(this.ASs);
    this.ASs = "";
    super.onDestroy();
    this.ASv = false;
    this.ASx = true;
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%d on destroy succ", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(100403);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(100392);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s onDetachedFromWindow, setState AVAILABLE, %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.ASw) });
    this.ASq = a.ASB;
    if (!this.ASw)
    {
      eio();
      AppMethodBeat.o(100392);
      return;
    }
    this.ASw = false;
    AppMethodBeat.o(100392);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100393);
    ehP();
    super.onResume();
    AppMethodBeat.o(100393);
  }
  
  public final void rM(boolean paramBoolean)
  {
    AppMethodBeat.i(100394);
    super.cyX();
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s pausePlay, setState ATTACHING", new Object[] { Integer.valueOf(hashCode()) });
    this.ASq = a.ASC;
    if ((paramBoolean) && (this.ASu != null))
    {
      this.ASu.setAlpha(1.0F);
      ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s refreshPlayBtn visible", new Object[] { Integer.valueOf(hashCode()) });
    }
    edK();
    AppMethodBeat.o(100394);
  }
  
  public void setUICallback(SnsTimelineVideoView.b paramb)
  {
    AppMethodBeat.i(100405);
    ae.i("MicroMsg.Sns.SnsOnlineVideoView", "%s videoview setUICallback", new Object[] { Integer.valueOf(hashCode()) });
    this.ASy = paramb;
    AppMethodBeat.o(100405);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(100387);
      ASB = new a("AVAILABLE", 0);
      ASC = new a("ATTACHING", 1);
      ASD = new a("PLAYING", 2);
      ASE = new a[] { ASB, ASC, ASD };
      AppMethodBeat.o(100387);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */