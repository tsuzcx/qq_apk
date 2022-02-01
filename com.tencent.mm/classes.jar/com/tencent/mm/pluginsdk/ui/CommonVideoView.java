package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean bps;
  private boolean hYH = false;
  protected int kOJ = 0;
  protected int kPa;
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
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(133996);
    ac.i(this.TAG, "%s set play rate [%f]", new Object[] { blf(), Float.valueOf(paramFloat) });
    if ((this.odZ instanceof VideoTextureView))
    {
      oQ(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.odZ).aB(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  public boolean bed()
  {
    AppMethodBeat.i(134005);
    boolean bool = blh();
    int i;
    if (this.odZ != null)
    {
      i = this.odZ.getDuration();
      if (!this.bps) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      ac.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { blf(), Boolean.valueOf(bool), Boolean.valueOf(blh()), Integer.valueOf(i), Boolean.valueOf(this.bps) });
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
    ac.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { blf(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.bps = paramBoolean;
    this.url = paramString;
    this.kPa = paramInt;
    aGQ(paramString);
    AppMethodBeat.o(133992);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (bed())
    {
      ac.w(this.TAG, "%s it is live, don't seek ", new Object[] { blf() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  protected h cO(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.kWn = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public final void dLd()
  {
    AppMethodBeat.i(191674);
    super.dLd();
    AppMethodBeat.o(191674);
  }
  
  public final int eML()
  {
    this.kOJ = 0;
    return 0;
  }
  
  public final void ea(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    ac.d(this.TAG, "%s onInfo [%d %d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      eMy();
      eMw();
      oQ(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      eMx();
      eMz();
    }
    AppMethodBeat.o(134003);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.odZ instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.odZ).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { blf() });
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
    if (this.kPa <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.kPa;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.kOJ;
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
    if (bed())
    {
      ac.i(this.TAG, "%s it is live video, do not completion", new Object[] { blf() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.hYH) {
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
    if ((this.odZ != null) && ((this.odZ instanceof VideoTextureView)))
    {
      if (this.kWm)
      {
        play();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.odZ).bld();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.hYH = paramBoolean;
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.odZ instanceof VideoTextureView))
    {
      ((VideoTextureView)this.odZ).setScaleType(parame);
      oQ(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.odZ != null)
    {
      ac.i(this.TAG, "%s start path [%s] [%s]", new Object[] { blf(), this.odZ.getVideoPath(), bs.eWi() });
      if (!bs.isNullOrNil(this.odZ.getVideoPath())) {
        break label103;
      }
      this.odZ.setVideoPath(this.url);
      showLoading();
      dOq();
    }
    for (;;)
    {
      oQ(getReportIdkey() + 1);
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