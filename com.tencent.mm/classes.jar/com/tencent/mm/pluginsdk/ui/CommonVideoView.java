package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean bzN;
  private boolean iuX = false;
  protected int lpK = 0;
  protected int lqc;
  protected String url;
  
  public CommonVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(133996);
    ae.i(this.TAG, "%s set play rate [%f]", new Object[] { bpA(), Float.valueOf(paramFloat) });
    if ((this.oNV instanceof VideoTextureView))
    {
      rd(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.oNV).aE(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  public boolean bip()
  {
    AppMethodBeat.i(134005);
    boolean bool = bpC();
    int i;
    if (this.oNV != null)
    {
      i = this.oNV.getDuration();
      if (!this.bzN) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      ae.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { bpA(), Boolean.valueOf(bool), Boolean.valueOf(bpC()), Integer.valueOf(i), Boolean.valueOf(this.bzN) });
      AppMethodBeat.o(134005);
      return bool;
      i = 0;
      break;
      label102:
      if ((bool) && (i <= 0)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133992);
    ae.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bpA(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.bzN = paramBoolean;
    this.url = paramString;
    this.lqc = paramInt;
    aNN(paramString);
    AppMethodBeat.o(133992);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (bip())
    {
      ae.w(this.TAG, "%s it is live, don't seek ", new Object[] { bpA() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  protected h cN(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.lxL = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public final void eaX()
  {
    AppMethodBeat.i(220270);
    super.eaX();
    AppMethodBeat.o(220270);
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    ae.d(this.TAG, "%s onInfo [%d %d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      ffj();
      ffh();
      rd(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      ffi();
      ffk();
    }
    AppMethodBeat.o(134003);
  }
  
  public final int ffx()
  {
    this.lpK = 0;
    return 0;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.oNV instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.oNV).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { bpA() });
      AppMethodBeat.o(133998);
    }
    return 0;
  }
  
  protected int getReportIdkey()
  {
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(133997);
    if (this.lqc <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.lqc;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.lpK;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(133999);
    super.hideLoading();
    AppMethodBeat.o(133999);
  }
  
  protected void initView()
  {
    AppMethodBeat.i(133991);
    super.initView();
    this.TAG = "MicroMsg.CommonVideoView";
    AppMethodBeat.o(133991);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(134004);
    if (bip())
    {
      ae.i(this.TAG, "%s it is live video, do not completion", new Object[] { bpA() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.iuX) {
      c(0.0D, true);
    }
    AppMethodBeat.o(134004);
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(134002);
    super.onUIPause();
    AppMethodBeat.o(134002);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(134001);
    super.onUIResume();
    if ((this.oNV != null) && ((this.oNV instanceof VideoTextureView)))
    {
      if (this.lxK)
      {
        play();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.oNV).bpy();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.iuX = paramBoolean;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.oNV instanceof VideoTextureView))
    {
      ((VideoTextureView)this.oNV).setScaleType(parame);
      rd(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.oNV != null)
    {
      ae.i(this.TAG, "%s start path [%s] [%s]", new Object[] { bpA(), this.oNV.getVideoPath(), bu.fpN() });
      if (!bu.isNullOrNil(this.oNV.getVideoPath())) {
        break label103;
      }
      this.oNV.setVideoPath(this.url);
      showLoading();
      eek();
    }
    for (;;)
    {
      rd(getReportIdkey() + 1);
      AppMethodBeat.o(133994);
      return;
      label103:
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */