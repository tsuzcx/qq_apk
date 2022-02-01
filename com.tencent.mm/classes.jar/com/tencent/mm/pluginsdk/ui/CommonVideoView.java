package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean ddk;
  private boolean oYG = false;
  protected int sAo;
  protected int szV = 0;
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
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133992);
    Log.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bNL(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.ddk = paramBoolean;
    this.url = paramString;
    this.sAo = paramInt;
    bqA(paramString);
    AppMethodBeat.o(133992);
  }
  
  public boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134000);
    if (isLive())
    {
      Log.w(this.TAG, "%s it is live, don't seek ", new Object[] { bNL() });
      AppMethodBeat.o(134000);
      return false;
    }
    paramBoolean = super.b(paramDouble, paramBoolean);
    AppMethodBeat.o(134000);
    return paramBoolean;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(133996);
    Log.i(this.TAG, "%s set play rate [%f]", new Object[] { bNL(), Float.valueOf(paramFloat) });
    if ((this.wCd instanceof VideoTextureView))
    {
      hp(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.wCd).bM(paramFloat);
      AppMethodBeat.o(133996);
      return bool;
    }
    AppMethodBeat.o(133996);
    return false;
  }
  
  protected i dY(Context paramContext)
  {
    AppMethodBeat.i(133993);
    this.sJh = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(133993);
    return paramContext;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(133998);
    try
    {
      if ((this.wCd instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.wCd).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(133998);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { bNL() });
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
    if (this.sAo <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(133997);
      return i;
    }
    int i = this.sAo;
    AppMethodBeat.o(133997);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.szV;
  }
  
  public final void hay()
  {
    AppMethodBeat.i(245102);
    super.hay();
    AppMethodBeat.o(245102);
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(133999);
    super.hideLoading();
    AppMethodBeat.o(133999);
  }
  
  public final int iKk()
  {
    this.szV = 0;
    return 0;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(133991);
    super.initView();
    this.TAG = "MicroMsg.CommonVideoView";
    this.XXD = "VideoView.CommonVideoView";
    AppMethodBeat.o(133991);
  }
  
  public boolean isLive()
  {
    AppMethodBeat.i(134005);
    boolean bool = cxs();
    int i;
    if (this.wCd != null)
    {
      i = this.wCd.getDuration();
      if (!this.ddk) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      Log.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { bNL(), Boolean.valueOf(bool), Boolean.valueOf(cxs()), Integer.valueOf(i), Boolean.valueOf(this.ddk) });
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
      Log.i(this.TAG, "%s it is live video, do not completion", new Object[] { bNL() });
      stop();
      start();
      AppMethodBeat.o(134004);
      return;
    }
    super.onCompletion();
    if (this.oYG) {
      b(0.0D, true);
    }
    AppMethodBeat.o(134004);
  }
  
  public void onInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134003);
    Log.d(this.TAG, "%s onInfo [%d %d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      iJY();
      iJW();
      hp(getReportIdkey() + 40);
      AppMethodBeat.o(134003);
      return;
    }
    if (paramInt1 == 702)
    {
      super.hideLoading();
      iJX();
      iJZ();
    }
    AppMethodBeat.o(134003);
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
    if ((this.wCd != null) && ((this.wCd instanceof VideoTextureView)))
    {
      if (this.sJg)
      {
        bNU();
        AppMethodBeat.o(134001);
        return;
      }
      ((VideoTextureView)this.wCd).cxp();
    }
    AppMethodBeat.o(134001);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.oYG = paramBoolean;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(133995);
    if ((this.wCd instanceof VideoTextureView))
    {
      ((VideoTextureView)this.wCd).setScaleType(parame);
      hp(getReportIdkey() + 14);
    }
    AppMethodBeat.o(133995);
  }
  
  public void start()
  {
    AppMethodBeat.i(133994);
    if (this.wCd != null)
    {
      Log.i(this.TAG, "%s start path [%s] [%s]", new Object[] { bNL(), this.wCd.getVideoPath(), Util.getStack() });
      if (!Util.isNullOrNil(this.wCd.getVideoPath())) {
        break label103;
      }
      this.wCd.setVideoPath(this.url);
      showLoading();
      hmY();
    }
    for (;;)
    {
      hp(getReportIdkey() + 1);
      AppMethodBeat.o(133994);
      return;
      label103:
      bNU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */