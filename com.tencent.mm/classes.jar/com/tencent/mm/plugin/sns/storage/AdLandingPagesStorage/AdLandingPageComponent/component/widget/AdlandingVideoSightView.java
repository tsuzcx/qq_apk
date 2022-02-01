package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.b;
import com.tencent.mm.pluginsdk.ui.tools.h.c;
import com.tencent.mm.pluginsdk.ui.tools.h.d;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public class AdlandingVideoSightView
  extends AdlandingSightPlayImageView
  implements com.tencent.mm.pluginsdk.ui.tools.h
{
  protected String cvr;
  protected int duration;
  private boolean fOX;
  private boolean zZv;
  private boolean zZw;
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96921);
    this.duration = 0;
    this.zZw = true;
    this.fOX = false;
    init();
    AppMethodBeat.o(96921);
  }
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96920);
    this.duration = 0;
    this.zZw = true;
    this.fOX = false;
    init();
    AppMethodBeat.o(96920);
  }
  
  private void init()
  {
    AppMethodBeat.i(96922);
    if (bu.bI(com.tencent.mm.compatible.deviceinfo.ae.geX.gcg, "").equals("other")) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new b.e()
      {
        public final void Rd(int paramAnonymousInt)
        {
          AppMethodBeat.i(96918);
          if (-1 == paramAnonymousInt)
          {
            if (AdlandingVideoSightView.this.qbr != null)
            {
              AdlandingVideoSightView.this.qbr.onError(0, 0);
              AppMethodBeat.o(96918);
            }
          }
          else if ((paramAnonymousInt == 0) && (AdlandingVideoSightView.this.qbr != null)) {
            AdlandingVideoSightView.this.qbr.onCompletion();
          }
          AppMethodBeat.o(96918);
        }
      });
      AppMethodBeat.o(96922);
      return;
      ri(true);
    }
  }
  
  public final boolean B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(96935);
    if (this.cvr == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(96935);
      return false;
    }
    if ((bu.bI(com.tencent.mm.compatible.deviceinfo.ae.geX.gcg, "").equals("other")) || (!com.tencent.mm.plugin.sight.decode.a.b.ayO(this.cvr)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.cvr, Boolean.valueOf(this.zZv) });
      if ((this.zZv) && (!paramBoolean))
      {
        AppMethodBeat.o(96935);
        return false;
      }
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      com.tencent.mm.sdk.platformtools.o.a(paramContext, (Intent)localObject, new com.tencent.mm.vfs.k(this.cvr), "video/*");
      try
      {
        localObject = Intent.createChooser((Intent)localObject, paramContext.getString(2131759030));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.zZv = true;
        AppMethodBeat.o(96935);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
          com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getResources().getString(2131764680));
        }
      }
    }
    bL(this.cvr, false);
    if (!this.fOX) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ri(paramBoolean);
      AppMethodBeat.o(96935);
      return true;
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96941);
    p(paramDouble);
    AppMethodBeat.o(96941);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(96931);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(96931);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96932);
    int i = super.getDuration();
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(96932);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(96937);
    if (getController() != null)
    {
      b localb = getController();
      if (localb.zie != -1.0D)
      {
        d = localb.zie;
        AppMethodBeat.o(96937);
        return d;
      }
      double d = localb.zib;
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
    boolean bool = this.zZs.dTz();
    AppMethodBeat.o(96926);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(96925);
    super.onConfigurationChanged(paramConfiguration);
    if (this.zZw) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(96925);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(96933);
    com.tencent.mm.sdk.b.a.IvT.d(this.zZs.dTC());
    AppMethodBeat.o(96933);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96924);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.ziG) });
    if ((this.ziG) && (paramInt3 - paramInt1 > 0)) {
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
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(96938);
    if (this.zZs != null)
    {
      b localb = this.zZs;
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bu.fpN().toString() });
      com.tencent.mm.modelvideo.o.i(new b.2(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(96938);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(96929);
    bL(this.cvr, true);
    AppMethodBeat.o(96929);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.zZw = paramBoolean;
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
    this.fOX = paramBoolean;
    if (!this.fOX) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ri(paramBoolean);
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
        public final void Au(long paramAnonymousLong)
        {
          AppMethodBeat.i(96919);
          if (AdlandingVideoSightView.this.duration == 0) {
            AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
          }
          if (AdlandingVideoSightView.this.qbr != null)
          {
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(AdlandingVideoSightView.this.duration) });
            AdlandingVideoSightView.this.qbr.eU((int)paramAnonymousLong, AdlandingVideoSightView.this.duration);
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
    aj(paramBitmap);
    AppMethodBeat.o(96936);
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.qbr = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(96927);
    if (this.qbr == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.cvr = paramString;
      if (this.qbr != null) {
        this.qbr.ta();
      }
      AppMethodBeat.o(96927);
      return;
    }
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(96934);
    boolean bool = B(getContext(), false);
    AppMethodBeat.o(96934);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96928);
    this.zZs.clear();
    AppMethodBeat.o(96928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView
 * JD-Core Version:    0.7.0.1
 */