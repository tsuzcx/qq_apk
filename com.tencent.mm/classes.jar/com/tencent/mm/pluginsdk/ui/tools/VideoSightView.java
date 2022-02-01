package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.4;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;

public class VideoSightView
  extends SightPlayImageView
  implements h
{
  protected String cnm;
  protected int duration;
  private boolean fqj;
  private boolean xep;
  private boolean xeq;
  
  public VideoSightView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116273);
    this.duration = 0;
    this.xeq = true;
    this.fqj = false;
    init();
    AppMethodBeat.o(116273);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116272);
    this.duration = 0;
    this.xeq = true;
    this.fqj = false;
    init();
    AppMethodBeat.o(116272);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116271);
    this.duration = 0;
    this.xeq = true;
    this.fqj = false;
    init();
    AppMethodBeat.o(116271);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116293);
    q(paramDouble);
    AppMethodBeat.o(116293);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177106);
    this.cnm = paramString;
    super.e(paramString, paramBoolean, paramInt);
    AppMethodBeat.o(177106);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116283);
    ad.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(116283);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116284);
    int i = super.getDuration();
    ad.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(116284);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(116289);
    if (getController() != null)
    {
      b localb = getController();
      if (localb.wrU != -1.0D)
      {
        d = localb.wrU;
        AppMethodBeat.o(116289);
        return d;
      }
      double d = localb.wrR;
      AppMethodBeat.o(116289);
      return d;
    }
    AppMethodBeat.o(116289);
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  protected void init()
  {
    AppMethodBeat.i(116274);
    if (bt.by(ae.fFH.fCR, "").equals("other")) {
      ad.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new b.e()
      {
        public final void c(b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(116269);
          if (-1 == paramAnonymousInt)
          {
            if (VideoSightView.this.oNM != null)
            {
              VideoSightView.this.oNM.onError(0, 0);
              AppMethodBeat.o(116269);
            }
          }
          else if ((paramAnonymousInt == 0) && (VideoSightView.this.oNM != null)) {
            VideoSightView.this.oNM.onCompletion();
          }
          AppMethodBeat.o(116269);
        }
      });
      AppMethodBeat.o(116274);
      return;
      pA(true);
    }
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(116278);
    boolean bool = this.wsq.dqq();
    AppMethodBeat.o(116278);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(116277);
    super.onConfigurationChanged(paramConfiguration);
    if (this.xeq) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(116277);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116285);
    com.tencent.mm.sdk.b.a.ESL.d(this.wsq.dqt());
    AppMethodBeat.o(116285);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116276);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ad.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.wsw) });
    if ((this.wsw) && (paramInt3 - paramInt1 > 0)) {
      setDrawableWidth(paramInt3 - paramInt1);
    }
    AppMethodBeat.o(116276);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116275);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(116275);
  }
  
  public void pause()
  {
    AppMethodBeat.i(116281);
    super.e(this.cnm, true, 0);
    AppMethodBeat.o(116281);
  }
  
  public void q(double paramDouble)
  {
    AppMethodBeat.i(116290);
    if (this.wsq != null)
    {
      b localb = this.wsq;
      ad.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bt.eGN().toString() });
      o.h(new b.4(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(116290);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.xeq = paramBoolean;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116282);
    setLoopImp(paramBoolean);
    AppMethodBeat.o(116282);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(116292);
    this.fqj = paramBoolean;
    if (!this.fqj) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      pA(paramBoolean);
      AppMethodBeat.o(116292);
      return;
    }
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116291);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void b(b paramAnonymousb, long paramAnonymousLong)
        {
          AppMethodBeat.i(116270);
          if (VideoSightView.this.duration == 0) {
            VideoSightView.this.duration = VideoSightView.this.getDuration();
          }
          if (VideoSightView.this.oNM != null)
          {
            ad.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightView.this.duration) });
            VideoSightView.this.oNM.eM((int)paramAnonymousLong, VideoSightView.this.duration);
          }
          AppMethodBeat.o(116270);
        }
      });
      AppMethodBeat.o(116291);
      return;
    }
    setOnDecodeDurationListener(null);
    AppMethodBeat.o(116291);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(116288);
    af(paramBitmap);
    AppMethodBeat.o(116288);
  }
  
  public void setVideoCallback(h.a parama)
  {
    this.oNM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116279);
    if (this.oNM == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.cnm = paramString;
      if (this.oNM != null) {
        this.oNM.rq();
      }
      AppMethodBeat.o(116279);
      return;
    }
  }
  
  public boolean start()
  {
    AppMethodBeat.i(116286);
    boolean bool = y(getContext(), false);
    AppMethodBeat.o(116286);
    return bool;
  }
  
  public void stop()
  {
    AppMethodBeat.i(116280);
    this.wsq.clear();
    AppMethodBeat.o(116280);
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116287);
    if (this.cnm == null)
    {
      ad.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(116287);
      return false;
    }
    if ((bt.by(ae.fFH.fCR, "").equals("other")) || (!b.anp(this.cnm)))
    {
      ad.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.cnm, Boolean.valueOf(this.xep) });
      if ((this.xep) && (!paramBoolean))
      {
        AppMethodBeat.o(116287);
        return false;
      }
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      m.a(paramContext, (Intent)localObject, new e(this.cnm), "video/*");
      try
      {
        localObject = Intent.createChooser((Intent)localObject, paramContext.getString(2131755927));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/ui/tools/VideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/ui/tools/VideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.xep = true;
        AppMethodBeat.o(116287);
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
    super.e(this.cnm, false, 0);
    if (!this.fqj) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      pA(paramBoolean);
      AppMethodBeat.o(116287);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightView
 * JD-Core Version:    0.7.0.1
 */