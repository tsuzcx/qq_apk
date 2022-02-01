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
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.j.b;
import com.tencent.mm.pluginsdk.ui.tools.j.c;
import com.tencent.mm.pluginsdk.ui.tools.j.d;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class AdlandingVideoSightView
  extends AdlandingSightPlayImageView
  implements j
{
  private boolean EhM;
  private boolean EhN;
  protected String cJp;
  protected int duration;
  private boolean guh;
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96921);
    this.duration = 0;
    this.EhN = true;
    this.guh = false;
    init();
    AppMethodBeat.o(96921);
  }
  
  public AdlandingVideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96920);
    this.duration = 0;
    this.EhN = true;
    this.guh = false;
    init();
    AppMethodBeat.o(96920);
  }
  
  private void init()
  {
    AppMethodBeat.i(96922);
    if (Util.nullAs(ae.gKE.gHE, "").equals("other")) {
      Log.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new b.e()
      {
        public final void Zb(int paramAnonymousInt)
        {
          AppMethodBeat.i(96918);
          if (-1 == paramAnonymousInt)
          {
            if (AdlandingVideoSightView.this.rso != null)
            {
              AdlandingVideoSightView.this.rso.onError(0, 0);
              AppMethodBeat.o(96918);
            }
          }
          else if ((paramAnonymousInt == 0) && (AdlandingVideoSightView.this.rso != null)) {
            AdlandingVideoSightView.this.rso.onCompletion();
          }
          AppMethodBeat.o(96918);
        }
      });
      AppMethodBeat.o(96922);
      return;
      uE(true);
    }
  }
  
  public final boolean E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(96935);
    if (this.cJp == null)
    {
      Log.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(96935);
      return false;
    }
    if ((Util.nullAs(ae.gKE.gHE, "").equals("other")) || (!com.tencent.mm.plugin.sight.decode.a.b.aNy(this.cJp)))
    {
      Log.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.cJp, Boolean.valueOf(this.EhM) });
      if ((this.EhM) && (!paramBoolean))
      {
        AppMethodBeat.o(96935);
        return false;
      }
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      FileProviderHelper.setIntentDataAndType(paramContext, (Intent)localObject, new com.tencent.mm.vfs.o(this.cJp), "video/*", false);
      try
      {
        localObject = Intent.createChooser((Intent)localObject, paramContext.getString(2131759356));
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdlandingVideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.EhM = true;
        AppMethodBeat.o(96935);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
          h.cD(paramContext, paramContext.getResources().getString(2131767073));
        }
      }
    }
    cd(this.cJp, false);
    if (!this.guh) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      uE(paramBoolean);
      AppMethodBeat.o(96935);
      return true;
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
    Log.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(96931);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(96932);
    int i = super.getDuration();
    Log.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(96932);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(96937);
    if (getController() != null)
    {
      b localb = getController();
      if (localb.DmV != -1.0D)
      {
        d = localb.DmV;
        AppMethodBeat.o(96937);
        return d;
      }
      double d = localb.DmS;
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
    boolean bool = this.EhJ.eVy();
    AppMethodBeat.o(96926);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(96925);
    super.onConfigurationChanged(paramConfiguration);
    if (this.EhN) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(96925);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(96933);
    EventCenter.instance.removeListener(this.EhJ.eVB());
    AppMethodBeat.o(96933);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96924);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.Dnx) });
    if ((this.Dnx) && (paramInt3 - paramInt1 > 0)) {
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
    cd(this.cJp, true);
    AppMethodBeat.o(96929);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(96938);
    if (this.EhJ != null)
    {
      b localb = this.EhJ;
      Log.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), Util.getStack().toString() });
      com.tencent.mm.modelvideo.o.g(new b.2(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(96938);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.EhN = paramBoolean;
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
    this.guh = paramBoolean;
    if (!this.guh) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      uE(paramBoolean);
      AppMethodBeat.o(96940);
      return;
    }
  }
  
  public void setOnInfoCallback(j.b paramb) {}
  
  public void setOnSeekCompleteCallback(j.c paramc) {}
  
  public void setOnSurfaceCallback(j.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(j.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(96939);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void JB(long paramAnonymousLong)
        {
          AppMethodBeat.i(96919);
          if (AdlandingVideoSightView.this.duration == 0) {
            AdlandingVideoSightView.this.duration = AdlandingVideoSightView.this.getDuration();
          }
          if (AdlandingVideoSightView.this.rso != null)
          {
            Log.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(AdlandingVideoSightView.this.duration) });
            AdlandingVideoSightView.this.rso.fh((int)paramAnonymousLong, AdlandingVideoSightView.this.duration);
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
    au(paramBitmap);
    AppMethodBeat.o(96936);
  }
  
  public void setVideoCallback(j.a parama)
  {
    this.rso = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(96927);
    if (this.rso == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.cJp = paramString;
      if (this.rso != null) {
        this.rso.tf();
      }
      AppMethodBeat.o(96927);
      return;
    }
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(96934);
    boolean bool = E(getContext(), false);
    AppMethodBeat.o(96934);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96928);
    this.EhJ.clear();
    AppMethodBeat.o(96928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingVideoSightView
 * JD-Core Version:    0.7.0.1
 */