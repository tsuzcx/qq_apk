package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

public class AdlandingVideoSightView
  extends AdlandingSightPlayImageView
  implements f
{
  private boolean dnJ = false;
  protected int duration = 0;
  private boolean oIJ;
  private boolean oIK = true;
  protected String oep;
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (bk.aM(q.dyn.dxD, "").equals("other")) {
      y.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new AdlandingVideoSightView.1(this));
      return;
      iO(true);
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    x(paramDouble);
  }
  
  public int getCurrentPosition()
  {
    y.v("MicroMsg.VideoSightView", "get current position");
    return 0;
  }
  
  public int getDuration()
  {
    int i = super.getDuration();
    y.v("MicroMsg.VideoSightView", "get duration " + i);
    return i;
  }
  
  public double getLastProgresstime()
  {
    if (getController() != null)
    {
      a locala = getController();
      if (locala.oeR != -1.0D) {
        return locala.oeR;
      }
      return locala.oeO;
    }
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    return this.oIG.bBa();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.oIK) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
  }
  
  public final void onDetach()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.oIG.bBd());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.ofJ) });
    if ((this.ofJ) && (paramInt3 - paramInt1 > 0)) {
      setDrawableWidth(paramInt3 - paramInt1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void pause()
  {
    aW(this.oep, true);
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.oep == null) {
      y.e("MicroMsg.VideoSightView", "start::use path is null!");
    }
    do
    {
      return false;
      if ((!bk.aM(q.dyn.dxD, "").equals("other")) && (b.MI(this.oep))) {
        break;
      }
      y.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.oep, Boolean.valueOf(this.oIJ) });
    } while ((this.oIJ) && (!paramBoolean));
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(e.aeP(this.oep), "video/*");
    try
    {
      paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(i.j.favorite_video)));
      this.oIJ = true;
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
        h.bC(paramContext, paramContext.getResources().getString(i.j.video_file_play_faile));
      }
    }
    aW(this.oep, false);
    paramBoolean = bool;
    if (!this.dnJ) {
      paramBoolean = true;
    }
    iO(paramBoolean);
    return true;
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.oIK = paramBoolean;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    setLoopImp(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
    if (!this.dnJ) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      iO(paramBoolean);
      return;
    }
  }
  
  public void setOnInfoCallback(f.b paramb) {}
  
  public void setOnSeekCompleteCallback(f.c paramc) {}
  
  public void setOnSurfaceCallback(f.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(f.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new a.f()
      {
        public final void gj(long paramAnonymousLong)
        {
          if (AdlandingVideoSightView.this.duration == 0) {
            AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
          }
          if (AdlandingVideoSightView.this.joM != null)
          {
            y.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(AdlandingVideoSightView.this.duration) });
            AdlandingVideoSightView.this.joM.cv((int)paramAnonymousLong, AdlandingVideoSightView.this.duration);
          }
        }
      });
      return;
    }
    setOnDecodeDurationListener(null);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    H(paramBitmap);
  }
  
  public void setVideoCallback(f.a parama)
  {
    this.joM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    if (this.joM == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.oep = paramString;
      if (this.joM != null) {
        this.joM.kA();
      }
      return;
    }
  }
  
  public final boolean start()
  {
    return s(getContext(), false);
  }
  
  public final void stop()
  {
    this.oIG.clear();
  }
  
  public final void x(double paramDouble)
  {
    if (this.oIG != null)
    {
      a locala = this.oIG;
      y.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bk.csb().toString() });
      o.g(new a.2(locala, paramDouble), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView
 * JD-Core Version:    0.7.0.1
 */