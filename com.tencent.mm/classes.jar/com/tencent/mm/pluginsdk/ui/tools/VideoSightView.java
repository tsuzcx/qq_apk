package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.ar.a.h;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.4;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class VideoSightView
  extends SightPlayImageView
  implements i
{
  private boolean QTD;
  private boolean QTE;
  protected int duration;
  protected String eDC;
  private boolean lAj;
  
  public VideoSightView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116273);
    this.duration = 0;
    this.QTE = true;
    this.lAj = false;
    init();
    AppMethodBeat.o(116273);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116272);
    this.duration = 0;
    this.QTE = true;
    this.lAj = false;
    init();
    AppMethodBeat.o(116272);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116271);
    this.duration = 0;
    this.QTE = true;
    this.lAj = false;
    init();
    AppMethodBeat.o(116271);
  }
  
  public void H(double paramDouble)
  {
    AppMethodBeat.i(116290);
    if (this.PGy != null)
    {
      SightPlayController localSightPlayController = this.PGy;
      Log.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), Util.getStack().toString() });
      v.h(new SightPlayController.4(localSightPlayController, paramDouble), 0L);
    }
    AppMethodBeat.o(116290);
  }
  
  public final boolean P(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116287);
    if (this.eDC == null)
    {
      Log.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(116287);
      return false;
    }
    if ((Util.nullAs(af.lYj.lVl, "").equals("other")) || (!SightPlayController.aWa(this.eDC)))
    {
      Log.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.eDC, Boolean.valueOf(this.QTD) });
      if ((this.QTD) && (!paramBoolean))
      {
        AppMethodBeat.o(116287);
        return false;
      }
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      FileProviderHelper.setIntentDataAndType(paramContext, (Intent)localObject, new u(this.eDC), "video/*", false);
      try
      {
        localObject = Intent.createChooser((Intent)localObject, paramContext.getString(a.h.app_video_for_icon));
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/tools/VideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/ui/tools/VideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.QTD = true;
        AppMethodBeat.o(116287);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
          com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getResources().getString(a.h.video_file_play_faile));
        }
      }
    }
    super.e(this.eDC, false, 0);
    if (!this.lAj) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Dg(paramBoolean);
      AppMethodBeat.o(116287);
      return true;
    }
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116293);
    H(paramDouble);
    AppMethodBeat.o(116293);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(177106);
    this.eDC = paramString;
    super.e(paramString, paramBoolean, paramInt);
    AppMethodBeat.o(177106);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116283);
    Log.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(116283);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116284);
    int i = super.getDuration();
    Log.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(116284);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(116289);
    if (getController() != null)
    {
      SightPlayController localSightPlayController = getController();
      if (localSightPlayController.PGc != -1.0D)
      {
        d = localSightPlayController.PGc;
        AppMethodBeat.o(116289);
        return d;
      }
      double d = localSightPlayController.PFZ;
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
    if (Util.nullAs(af.lYj.lVl, "").equals("other")) {
      Log.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new SightPlayController.d()
      {
        public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
        {
          AppMethodBeat.i(116269);
          if (-1 == paramAnonymousInt)
          {
            if (VideoSightView.this.yki != null)
            {
              VideoSightView.this.yki.onError(0, 0);
              AppMethodBeat.o(116269);
            }
          }
          else if ((paramAnonymousInt == 0) && (VideoSightView.this.yki != null)) {
            VideoSightView.this.yki.onCompletion();
          }
          AppMethodBeat.o(116269);
        }
      });
      AppMethodBeat.o(116274);
      return;
      Dg(true);
    }
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(116278);
    boolean bool = gYu();
    AppMethodBeat.o(116278);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(116277);
    super.onConfigurationChanged(paramConfiguration);
    if (this.QTE) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(116277);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(116285);
    detach();
    AppMethodBeat.o(116285);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116276);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.PGC) });
    if ((this.PGC) && (paramInt3 - paramInt1 > 0)) {
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
    super.e(this.eDC, true, 0);
    AppMethodBeat.o(116281);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.QTE = paramBoolean;
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
    this.lAj = paramBoolean;
    if (!this.lAj) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Dg(paramBoolean);
      AppMethodBeat.o(116292);
      return;
    }
  }
  
  public void setOnInfoCallback(i.b paramb) {}
  
  public void setOnSeekCompleteCallback(i.c paramc) {}
  
  public void setOnSurfaceCallback(i.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(i.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116291);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new SightPlayController.e()
      {
        public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
        {
          AppMethodBeat.i(116270);
          if (VideoSightView.this.duration == 0) {
            VideoSightView.this.duration = VideoSightView.this.getDuration();
          }
          if (VideoSightView.this.yki != null)
          {
            Log.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightView.this.duration) });
            VideoSightView.this.yki.gw((int)paramAnonymousLong, VideoSightView.this.duration);
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
    aG(paramBitmap);
    AppMethodBeat.o(116288);
  }
  
  public void setVideoCallback(i.a parama)
  {
    this.yki = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116279);
    if (this.yki == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.eDC = paramString;
      if (this.yki != null) {
        this.yki.Qz();
      }
      AppMethodBeat.o(116279);
      return;
    }
  }
  
  public boolean start()
  {
    AppMethodBeat.i(116286);
    boolean bool = P(getContext(), false);
    AppMethodBeat.o(116286);
    return bool;
  }
  
  public void stop()
  {
    AppMethodBeat.i(116280);
    clear();
    AppMethodBeat.o(116280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightView
 * JD-Core Version:    0.7.0.1
 */