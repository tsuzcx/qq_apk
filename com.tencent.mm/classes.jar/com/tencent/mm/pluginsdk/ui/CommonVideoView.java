package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean bqS;
  private boolean hyg = false;
  protected int knG;
  protected int knr = 0;
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
  
  public boolean aXf()
  {
    AppMethodBeat.i(134005);
    boolean bool = ben();
    int i;
    if (this.nAZ != null)
    {
      i = this.nAZ.getDuration();
      if (!this.bqS) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      ad.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { bel(), Boolean.valueOf(bool), Boolean.valueOf(ben()), Integer.valueOf(i), Boolean.valueOf(this.bqS) });
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
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(133996);
    ad.i(this.TAG, "%s set play rate [%f]", new Object[] { bel(), Float.valueOf(paramFloat) });
    if ((this.nAZ instanceof VideoTextureView))
    {
      ln(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.nAZ).ax(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133992);
    ad.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bel(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.bqS = paramBoolean;
    this.url = paramString;
    this.knG = paramInt;
    aBy(paramString);
    AppMethodBeat.o(133992);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (aXf())
    {
      ad.w(this.TAG, "%s it is live, don't seek ", new Object[] { bel() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  protected h cF(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.kuZ = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    ad.d(this.TAG, "%s onInfo [%d %d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      exe();
      exc();
      ln(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      exd();
      exf();
    }
    AppMethodBeat.o(134003);
  }
  
  public final void dwE()
  {
    AppMethodBeat.i(190264);
    super.dwE();
    AppMethodBeat.o(190264);
  }
  
  public final int exr()
  {
    this.knr = 0;
    return 0;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.nAZ instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.nAZ).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { bel() });
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
    if (this.knG <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.knG;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.knr;
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
    if (aXf())
    {
      ad.i(this.TAG, "%s it is live video, do not completion", new Object[] { bel() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.hyg) {
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
    if ((this.nAZ != null) && ((this.nAZ instanceof VideoTextureView)))
    {
      if (this.kuY)
      {
        play();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.nAZ).bej();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.hyg = paramBoolean;
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.nAZ instanceof VideoTextureView))
    {
      ((VideoTextureView)this.nAZ).setScaleType(parame);
      ln(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.nAZ != null)
    {
      ad.i(this.TAG, "%s start path [%s] [%s]", new Object[] { bel(), this.nAZ.getVideoPath(), bt.eGN() });
      if (!bt.isNullOrNil(this.nAZ.getVideoPath())) {
        break label103;
      }
      this.nAZ.setVideoPath(this.url);
      showLoading();
      dzT();
    }
    for (;;)
    {
      ln(getReportIdkey() + 1);
      AppMethodBeat.o(133994);
      return;
      label103:
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */