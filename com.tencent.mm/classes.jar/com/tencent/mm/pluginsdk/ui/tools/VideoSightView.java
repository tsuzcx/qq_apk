package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.3;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.io.File;

public class VideoSightView
  extends SightPlayImageView
  implements e
{
  protected String bHM;
  protected int duration;
  private boolean efg;
  private boolean ryH;
  private boolean ryI;
  
  public VideoSightView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(70419);
    this.duration = 0;
    this.ryI = true;
    this.efg = false;
    init();
    AppMethodBeat.o(70419);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(70418);
    this.duration = 0;
    this.ryI = true;
    this.efg = false;
    init();
    AppMethodBeat.o(70418);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(70417);
    this.duration = 0;
    this.ryI = true;
    this.efg = false;
    init();
    AppMethodBeat.o(70417);
  }
  
  public void A(double paramDouble)
  {
    AppMethodBeat.i(70436);
    if (this.qTR != null)
    {
      b localb = this.qTR;
      ab.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bo.dtY().toString() });
      o.j(new b.3(localb, paramDouble), 0L);
    }
    AppMethodBeat.o(70436);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(70439);
    A(paramDouble);
    AppMethodBeat.o(70439);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(70429);
    ab.v("MicroMsg.VideoSightView", "get current position");
    AppMethodBeat.o(70429);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(70430);
    int i = super.getDuration();
    ab.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(i)));
    AppMethodBeat.o(70430);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(70435);
    if (getController() != null)
    {
      b localb = getController();
      if (localb.qTg != -1.0D)
      {
        d = localb.qTg;
        AppMethodBeat.o(70435);
        return d;
      }
      double d = localb.qTd;
      AppMethodBeat.o(70435);
      return d;
    }
    AppMethodBeat.o(70435);
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  protected void init()
  {
    AppMethodBeat.i(70420);
    if (bo.bf(ac.erF.epB, "").equals("other")) {
      ab.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new VideoSightView.1(this));
      AppMethodBeat.o(70420);
      return;
      kS(true);
    }
  }
  
  public boolean isPlaying()
  {
    AppMethodBeat.i(70424);
    boolean bool = this.qTR.cmA();
    AppMethodBeat.o(70424);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(70423);
    super.onConfigurationChanged(paramConfiguration);
    if (this.ryI) {
      setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
    }
    AppMethodBeat.o(70423);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(70431);
    a.ymk.d(this.qTR.cmD());
    AppMethodBeat.o(70431);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(70422);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ab.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.qTX) });
    if ((this.qTX) && (paramInt3 - paramInt1 > 0)) {
      setDrawableWidth(paramInt3 - paramInt1);
    }
    AppMethodBeat.o(70422);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70421);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(70421);
  }
  
  public void pause()
  {
    AppMethodBeat.i(70427);
    bl(this.bHM, true);
    AppMethodBeat.o(70427);
  }
  
  public void setEnableConfigChanged(boolean paramBoolean)
  {
    this.ryI = paramBoolean;
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(70428);
    setLoopImp(paramBoolean);
    AppMethodBeat.o(70428);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(70438);
    this.efg = paramBoolean;
    if (!this.efg) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      kS(paramBoolean);
      AppMethodBeat.o(70438);
      return;
    }
  }
  
  public void setOnInfoCallback(e.b paramb) {}
  
  public void setOnSeekCompleteCallback(e.c paramc) {}
  
  public void setOnSurfaceCallback(e.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(e.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(70437);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new VideoSightView.2(this));
      AppMethodBeat.o(70437);
      return;
    }
    setOnDecodeDurationListener(null);
    AppMethodBeat.o(70437);
  }
  
  public void setThumb(Bitmap paramBitmap)
  {
    AppMethodBeat.i(70434);
    T(paramBitmap);
    AppMethodBeat.o(70434);
  }
  
  public void setVideoCallback(e.a parama)
  {
    this.lxA = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(70425);
    if (this.lxA == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.bHM = paramString;
      if (this.lxA != null) {
        this.lxA.mG();
      }
      AppMethodBeat.o(70425);
      return;
    }
  }
  
  public boolean start()
  {
    AppMethodBeat.i(70432);
    boolean bool = w(getContext(), false);
    AppMethodBeat.o(70432);
    return bool;
  }
  
  public void stop()
  {
    AppMethodBeat.i(70426);
    this.qTR.clear();
    AppMethodBeat.o(70426);
  }
  
  public final boolean w(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(70433);
    if (this.bHM == null)
    {
      ab.e("MicroMsg.VideoSightView", "start::use path is null!");
      AppMethodBeat.o(70433);
      return false;
    }
    if ((bo.bf(ac.erF.epB, "").equals("other")) || (!b.Zp(this.bHM)))
    {
      ab.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.bHM, Boolean.valueOf(this.ryH) });
      if ((this.ryH) && (!paramBoolean))
      {
        AppMethodBeat.o(70433);
        return false;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      com.tencent.mm.sdk.platformtools.k.a(paramContext, localIntent, new File(this.bHM), "video/*");
      try
      {
        paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131297103)));
        this.ryH = true;
        AppMethodBeat.o(70433);
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
    AppMethodBeat.o(70433);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightView
 * JD-Core Version:    0.7.0.1
 */