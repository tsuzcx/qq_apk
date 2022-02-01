package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.b;
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.h.d;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;

public class AdlandingVideoSightView
  extends AdlandingSightPlayImageView
  implements com.tencent.mm.pluginsdk.ui.tools.h
{
  protected String cnm;
  protected int duration;
  private boolean fqj;
  private boolean xep;
  private boolean xeq;
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96921);
    this.duration = 0;
    this.xeq = true;
    this.fqj = false;
    init();
    AppMethodBeat.o(96921);
  }
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96920);
    this.duration = 0;
    this.xeq = true;
    this.fqj = false;
    init();
    AppMethodBeat.o(96920);
  }
  
  private void init()
  {
    AppMethodBeat.i(96922);
    if (bt.by(ae.fFH.fCR, "").equals("other")) {
      ad.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new b.e()
      {
        public final void ML(int paramAnonymousInt)
        {
          AppMethodBeat.i(96918);
          if (-1 == paramAnonymousInt)
          {
            if (AdlandingVideoSightView.this.oNM != null)
            {
              AdlandingVideoSightView.this.oNM.onError(0, 0);
              AppMethodBeat.o(96918);
            }
          }
          else if ((paramAnonymousInt == 0) && (AdlandingVideoSightView.this.oNM != null)) {
            AdlandingVideoSightView.this.oNM.onCompletion();
          }
          AppMethodBeat.o(96918);
        }
      });
      AppMethodBeat.o(96922);
      return;
      pA(true);
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96941);
    q(paramDouble);
    AppMethodBeat.o(96941);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(96931);
    ad.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(96931);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96932);
    int i = super.getDuration();
    ad.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(96932);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(96937);
    if (getController() != null)
    {
      b localb = getController();
      if (localb.wrU != -1.0D)
      {
        d = localb.wrU;
        AppMethodBeat.o(96937);
        return d;
      }
      double d = localb.wrR;
      AppMethodBeat.o(96937);
      return d;
    }
    AppMethodBeat.o(96937);
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96926);
    boolean bool = this.xem.dqq();
    AppMethodBeat.o(96926);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(96925);
    super.onConfigurationChanged(paramConfiguration);
    if (this.xeq) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(96925);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(96933);
    com.tencent.mm.sdk.b.a.ESL.d(this.xem.dqt());
    AppMethodBeat.o(96933);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96924);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ad.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.wsw) });
    if ((this.wsw) && (paramInt3 - paramInt1 > 0)) {
      setDrawableWidth(paramInt3 - paramInt1);
    }
    AppMethodBeat.o(96924);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96923);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(96923);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(96929);
    bt(this.cnm, true);
    AppMethodBeat.o(96929);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(96938);
    if (this.xem != null)
    {
      b localb = this.xem;
      ad.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bt.eGN().toString() });
      o.h(new b.2(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(96938);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.xeq = paramBoolean;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(96930);
    setLoopImp(paramBoolean);
    AppMethodBeat.o(96930);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96940);
    this.fqj = paramBoolean;
    if (!this.fqj) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      pA(paramBoolean);
      AppMethodBeat.o(96940);
      return;
    }
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(96939);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void sV(long paramAnonymousLong)
        {
          AppMethodBeat.i(96919);
          if (AdlandingVideoSightView.this.duration == 0) {
            AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
          }
          if (AdlandingVideoSightView.this.oNM != null)
          {
            ad.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(AdlandingVideoSightView.this.duration) });
            AdlandingVideoSightView.this.oNM.eM((int)paramAnonymousLong, AdlandingVideoSightView.this.duration);
          }
          AppMethodBeat.o(96919);
        }
      });
      AppMethodBeat.o(96939);
      return;
    }
    setOnDecodeDurationListener(null);
    AppMethodBeat.o(96939);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96936);
    af(paramBitmap);
    AppMethodBeat.o(96936);
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.oNM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(96927);
    if (this.oNM == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.cnm = paramString;
      if (this.oNM != null) {
        this.oNM.rq();
      }
      AppMethodBeat.o(96927);
      return;
    }
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(96934);
    boolean bool = y(getContext(), false);
    AppMethodBeat.o(96934);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96928);
    this.xem.clear();
    AppMethodBeat.o(96928);
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(96935);
    if (this.cnm == null)
    {
      ad.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(96935);
      return false;
    }
    if ((bt.by(ae.fFH.fCR, "").equals("other")) || (!com.tencent.mm.plugin.sight.decode.a.b.anp(this.cnm)))
    {
      ad.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.cnm, Boolean.valueOf(this.xep) });
      if ((this.xep) && (!paramBoolean))
      {
        AppMethodBeat.o(96935);
        return false;
      }
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      m.a(paramContext, (Intent)localObject, new e(this.cnm), "video/*");
      try
      {
        localObject = Intent.createChooser((Intent)localObject, paramContext.getString(2131759030));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.xep = true;
        AppMethodBeat.o(96935);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
          com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getResources().getString(2131764680));
        }
      }
    }
    bt(this.cnm, false);
    if (!this.fqj) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      pA(paramBoolean);
      AppMethodBeat.o(96935);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView
 * JD-Core Version:    0.7.0.1
 */