package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean bjq;
  private boolean mfK = false;
  protected int puP = 0;
  protected int pvi;
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
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (isLive())
    {
      Log.w(this.TAG, "%s it is live, don't seek ", new Object[] { bqf() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.a(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(133996);
    Log.i(this.TAG, "%s set play rate [%f]", new Object[] { bqf(), Float.valueOf(paramFloat) });
    if ((this.txH instanceof VideoTextureView))
    {
      EW(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.txH).aO(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133992);
    Log.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bqf(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.bjq = paramBoolean;
    this.url = paramString;
    this.pvi = paramInt;
    bqL(paramString);
    AppMethodBeat.o(133992);
  }
  
  protected k df(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.pDV = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public final void eN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    Log.d(this.TAG, "%s onInfo [%d %d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      hjd();
      hjb();
      EW(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      hjc();
      hje();
    }
    AppMethodBeat.o(134003);
  }
  
  public final void fKt()
  {
    AppMethodBeat.i(204945);
    super.fKt();
    AppMethodBeat.o(204945);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.txH instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.txH).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { bqf() });
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
    if (this.pvi <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.puP;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(133999);
    super.hideLoading();
    AppMethodBeat.o(133999);
  }
  
  public final int hjs()
  {
    this.puP = 0;
    return 0;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(133991);
    super.initView();
    this.TAG = "MicroMsg.CommonVideoView";
    AppMethodBeat.o(133991);
  }
  
  public boolean isLive()
  {
    AppMethodBeat.i(134005);
    boolean bool = ayN();
    int i;
    if (this.txH != null)
    {
      i = this.txH.getDuration();
      if (!this.bjq) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      Log.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { bqf(), Boolean.valueOf(bool), Boolean.valueOf(ayN()), Integer.valueOf(i), Boolean.valueOf(this.bjq) });
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
  
  public void onCompletion()
  {
    AppMethodBeat.i(134004);
    if (isLive())
    {
      Log.i(this.TAG, "%s it is live video, do not completion", new Object[] { bqf() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.mfK) {
      a(0.0D, true);
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
    if ((this.txH != null) && ((this.txH instanceof VideoTextureView)))
    {
      if (this.pDU)
      {
        bqo();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.txH).bXe();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.mfK = paramBoolean;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.txH instanceof VideoTextureView))
    {
      ((VideoTextureView)this.txH).setScaleType(parame);
      EW(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.txH != null)
    {
      Log.i(this.TAG, "%s start path [%s] [%s]", new Object[] { bqf(), this.txH.getVideoPath(), Util.getStack() });
      if (!Util.isNullOrNil(this.txH.getVideoPath())) {
        break label103;
      }
      this.txH.setVideoPath(this.url);
      showLoading();
      fUH();
    }
    for (;;)
    {
      EW(getReportIdkey() + 1);
      AppMethodBeat.o(133994);
      return;
      label103:
      bqo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */