package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.b;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public class AdlandingVideoSightView
  extends AdlandingSightPlayImageView
  implements com.tencent.mm.pluginsdk.ui.tools.e
{
  protected String bHM;
  protected int duration;
  private boolean efg;
  private boolean ryH;
  private boolean ryI;
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37459);
    this.duration = 0;
    this.ryI = true;
    this.efg = false;
    init();
    AppMethodBeat.o(37459);
  }
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37458);
    this.duration = 0;
    this.ryI = true;
    this.efg = false;
    init();
    AppMethodBeat.o(37458);
  }
  
  private void init()
  {
    AppMethodBeat.i(37460);
    if (bo.bf(ac.erF.epB, "").equals("other")) {
      ab.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new AdlandingVideoSightView.1(this));
      AppMethodBeat.o(37460);
      return;
      kS(true);
    }
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(37476);
    if (this.ryE != null)
    {
      b localb = this.ryE;
      ab.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bo.dtY().toString() });
      o.j(new b.2(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(37476);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(37479);
    A(paramDouble);
    AppMethodBeat.o(37479);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(37469);
    ab.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(37469);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(37470);
    int i = super.getDuration();
    ab.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(37470);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(37475);
    if (getController() != null)
    {
      b localb = getController();
      if (localb.qTg != -1.0D)
      {
        d = localb.qTg;
        AppMethodBeat.o(37475);
        return d;
      }
      double d = localb.qTd;
      AppMethodBeat.o(37475);
      return d;
    }
    AppMethodBeat.o(37475);
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(37464);
    boolean bool = this.ryE.cmA();
    AppMethodBeat.o(37464);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(37463);
    super.onConfigurationChanged(paramConfiguration);
    if (this.ryI) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(37463);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(37471);
    a.ymk.d(this.ryE.cmD());
    AppMethodBeat.o(37471);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37462);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ab.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.qTX) });
    if ((this.qTX) && (paramInt3 - paramInt1 > 0)) {
      setDrawableWidth(paramInt3 - paramInt1);
    }
    AppMethodBeat.o(37462);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37461);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37461);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37467);
    bl(this.bHM, true);
    AppMethodBeat.o(37467);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.ryI = paramBoolean;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(37468);
    setLoopImp(paramBoolean);
    AppMethodBeat.o(37468);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(37478);
    this.efg = paramBoolean;
    if (!this.efg) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      kS(paramBoolean);
      AppMethodBeat.o(37478);
      return;
    }
  }
  
  public void setOnInfoCallback(e.b paramb) {}
  
  public void setOnSeekCompleteCallback(e.c paramc) {}
  
  public void setOnSurfaceCallback(e.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(e.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(37477);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void lO(long paramAnonymousLong)
        {
          AppMethodBeat.i(37457);
          if (AdlandingVideoSightView.this.duration == 0) {
            AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
          }
          if (AdlandingVideoSightView.this.lxA != null)
          {
            ab.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(AdlandingVideoSightView.this.duration) });
            AdlandingVideoSightView.this.lxA.dP((int)paramAnonymousLong, AdlandingVideoSightView.this.duration);
          }
          AppMethodBeat.o(37457);
        }
      });
      AppMethodBeat.o(37477);
      return;
    }
    setOnDecodeDurationListener(null);
    AppMethodBeat.o(37477);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37474);
    T(paramBitmap);
    AppMethodBeat.o(37474);
  }
  
  public void setVideoCallback(e.a parama)
  {
    this.lxA = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(37465);
    if (this.lxA == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.bHM = paramString;
      if (this.lxA != null) {
        this.lxA.mG();
      }
      AppMethodBeat.o(37465);
      return;
    }
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(37472);
    boolean bool = w(getContext(), false);
    AppMethodBeat.o(37472);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(37466);
    this.ryE.clear();
    AppMethodBeat.o(37466);
  }
  
  public final boolean w(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(37473);
    if (this.bHM == null)
    {
      ab.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(37473);
      return false;
    }
    if ((bo.bf(ac.erF.epB, "").equals("other")) || (!com.tencent.mm.plugin.sight.decode.a.b.Zp(this.bHM)))
    {
      ab.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.bHM, Boolean.valueOf(this.ryH) });
      if ((this.ryH) && (!paramBoolean))
      {
        AppMethodBeat.o(37473);
        return false;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      com.tencent.mm.sdk.platformtools.k.a(paramContext, localIntent, com.tencent.mm.vfs.e.avH(this.bHM), "video/*");
      try
      {
        paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131299853)));
        this.ryH = true;
        AppMethodBeat.o(37473);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
          h.bO(paramContext, paramContext.getResources().getString(2131304519));
        }
      }
    }
    bl(this.bHM, false);
    paramBoolean = bool;
    if (!this.efg) {
      paramBoolean = true;
    }
    kS(paramBoolean);
    AppMethodBeat.o(37473);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView
 * JD-Core Version:    0.7.0.1
 */