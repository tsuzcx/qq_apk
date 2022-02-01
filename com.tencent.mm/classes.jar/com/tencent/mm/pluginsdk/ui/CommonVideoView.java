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
  protected boolean bzN;
  private boolean isd = false;
  protected int llD;
  protected int llm = 0;
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
    ad.i(this.TAG, "%s set play rate [%f]", new Object[] { boQ(), Float.valueOf(paramFloat) });
    if ((this.oHt instanceof VideoTextureView))
    {
      qQ(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.oHt).aE(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  public boolean bhH()
  {
    AppMethodBeat.i(134005);
    boolean bool = boS();
    int i;
    if (this.oHt != null)
    {
      i = this.oHt.getDuration();
      if (!this.bzN) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      ad.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { boQ(), Boolean.valueOf(bool), Boolean.valueOf(boS()), Integer.valueOf(i), Boolean.valueOf(this.bzN) });
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
    ad.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { boQ(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.bzN = paramBoolean;
    this.url = paramString;
    this.llD = paramInt;
    aMr(paramString);
    AppMethodBeat.o(133992);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (bhH())
    {
      ad.w(this.TAG, "%s it is live, don't seek ", new Object[] { boQ() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  protected h cL(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.ltm = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public final void dXu()
  {
    AppMethodBeat.i(197036);
    super.dXu();
    AppMethodBeat.o(197036);
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    ad.d(this.TAG, "%s onInfo [%d %d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      fbv();
      fbt();
      qQ(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      fbu();
      fbw();
    }
    AppMethodBeat.o(134003);
  }
  
  public final int fbJ()
  {
    this.llm = 0;
    return 0;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.oHt instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.oHt).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { boQ() });
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
    if (this.llD <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.llD;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.llm;
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
    if (bhH())
    {
      ad.i(this.TAG, "%s it is live video, do not completion", new Object[] { boQ() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.isd) {
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
    if ((this.oHt != null) && ((this.oHt instanceof VideoTextureView)))
    {
      if (this.ltl)
      {
        play();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.oHt).boO();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.isd = paramBoolean;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.oHt instanceof VideoTextureView))
    {
      ((VideoTextureView)this.oHt).setScaleType(parame);
      qQ(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.oHt != null)
    {
      ad.i(this.TAG, "%s start path [%s] [%s]", new Object[] { boQ(), this.oHt.getVideoPath(), bt.flS() });
      if (!bt.isNullOrNil(this.oHt.getVideoPath())) {
        break label103;
      }
      this.oHt.setVideoPath(this.url);
      showLoading();
      eaE();
    }
    for (;;)
    {
      qQ(getReportIdkey() + 1);
      AppMethodBeat.o(133994);
      return;
      label103:
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */