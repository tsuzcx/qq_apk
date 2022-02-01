package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean bzP;
  private boolean jqj = false;
  protected int mwI;
  protected int mwp = 0;
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
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(133996);
    Log.i(this.TAG, "%s set play rate [%f]", new Object[] { bgQ(), Float.valueOf(paramFloat) });
    if ((this.qbJ instanceof VideoTextureView))
    {
      yU(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.qbJ).aO(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133992);
    Log.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.bzP = paramBoolean;
    this.url = paramString;
    this.mwI = paramInt;
    bep(paramString);
    AppMethodBeat.o(133992);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (isLive())
    {
      Log.w(this.TAG, "%s it is live, don't seek ", new Object[] { bgQ() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  protected j di(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.mEJ = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public final void ep(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    Log.d(this.TAG, "%s onInfo [%d %d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      got();
      gor();
      yU(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      gos();
      gou();
    }
    AppMethodBeat.o(134003);
  }
  
  public final void fdO()
  {
    AppMethodBeat.i(208751);
    super.fdO();
    AppMethodBeat.o(208751);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.qbJ instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.qbJ).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { bgQ() });
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
    if (this.mwI <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.mwp;
  }
  
  public final int goG()
  {
    this.mwp = 0;
    return 0;
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
  
  public boolean isLive()
  {
    AppMethodBeat.i(134005);
    boolean bool = asa();
    int i;
    if (this.qbJ != null)
    {
      i = this.qbJ.getDuration();
      if (!this.bzP) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      Log.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { bgQ(), Boolean.valueOf(bool), Boolean.valueOf(asa()), Integer.valueOf(i), Boolean.valueOf(this.bzP) });
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
      Log.i(this.TAG, "%s it is live video, do not completion", new Object[] { bgQ() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.jqj) {
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
    if ((this.qbJ != null) && ((this.qbJ instanceof VideoTextureView)))
    {
      if (this.mEI)
      {
        play();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.qbJ).bLe();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.jqj = paramBoolean;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.qbJ instanceof VideoTextureView))
    {
      ((VideoTextureView)this.qbJ).setScaleType(parame);
      yU(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.qbJ != null)
    {
      Log.i(this.TAG, "%s start path [%s] [%s]", new Object[] { bgQ(), this.qbJ.getVideoPath(), Util.getStack() });
      if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
        break label103;
      }
      this.qbJ.setVideoPath(this.url);
      showLoading();
      fgB();
    }
    for (;;)
    {
      yU(getReportIdkey() + 1);
      AppMethodBeat.o(133994);
      return;
      label103:
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */