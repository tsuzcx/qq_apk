package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean aLW;
  protected int gDO = 0;
  protected int gEz;
  public String url;
  
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
  
  public final int DU(int paramInt)
  {
    this.gDO = paramInt;
    return paramInt;
  }
  
  public void Se()
  {
    super.Se();
  }
  
  public void Sf()
  {
    super.Sf();
    if ((this.iuC != null) && ((this.iuC instanceof VideoTextureView)))
    {
      if (this.rYH) {
        play();
      }
    }
    else {
      return;
    }
    ((VideoTextureView)this.iuC).biz();
  }
  
  public final boolean aj(float paramFloat)
  {
    boolean bool = false;
    y.i(this.TAG, "%s set play rate [%f]", new Object[] { ayL(), Float.valueOf(paramFloat) });
    if ((this.iuC instanceof VideoTextureView))
    {
      cB(getReportIdkey() + 13);
      bool = ((VideoTextureView)this.iuC).aj(paramFloat);
    }
    return bool;
  }
  
  public f bF(Context paramContext)
  {
    this.rYI = 0;
    return new VideoTextureView(paramContext);
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    y.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { ayL(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.aLW = paramBoolean;
    this.url = paramString;
    this.gEz = paramInt;
    Ws(paramString);
  }
  
  public final void eX(int paramInt1, int paramInt2)
  {
    y.d(this.TAG, "%s onInfo [%d %d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      apT();
      cmb();
      clZ();
      cB(getReportIdkey() + 40);
    }
    while (paramInt1 != 702) {
      return;
    }
    bdC();
    cma();
    cmc();
  }
  
  public int getCacheTimeSec()
  {
    try
    {
      if ((this.iuC instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.iuC).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { ayL() });
    }
    return 0;
  }
  
  public int getReportIdkey()
  {
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.gEz <= 0) {
      return super.getVideoDurationSec();
    }
    return this.gEz;
  }
  
  public int getVideoSource()
  {
    return this.gDO;
  }
  
  public void initView()
  {
    super.initView();
    this.TAG = "MicroMsg.CommonVideoView";
  }
  
  public final boolean isLive()
  {
    boolean bool = isPrepared();
    int i;
    if (this.iuC != null)
    {
      i = this.iuC.getDuration();
      if (!this.aLW) {
        break label92;
      }
      bool = true;
    }
    for (;;)
    {
      y.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { ayL(), Boolean.valueOf(bool), Boolean.valueOf(isPrepared()), Integer.valueOf(i), Boolean.valueOf(this.aLW) });
      return bool;
      i = 0;
      break;
      label92:
      if ((bool) && (i <= 0)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void setScaleType(h.d paramd)
  {
    if ((this.iuC instanceof VideoTextureView))
    {
      ((VideoTextureView)this.iuC).setScaleType(paramd);
      cB(getReportIdkey() + 14);
    }
  }
  
  public void start()
  {
    if (this.iuC != null)
    {
      y.i(this.TAG, "%s start path [%s] [%s]", new Object[] { ayL(), this.iuC.getVideoPath(), bk.csb() });
      if (!bk.bl(this.iuC.getVideoPath())) {
        break label93;
      }
      this.iuC.setVideoPath(this.url);
      apT();
      bHW();
    }
    for (;;)
    {
      cB(getReportIdkey() + 1);
      return;
      label93:
      play();
    }
  }
  
  public void ug()
  {
    if (isLive())
    {
      y.i(this.TAG, "%s it is live video, do not completion", new Object[] { ayL() });
      stop();
      start();
      return;
    }
    super.ug();
  }
  
  public boolean y(int paramInt, boolean paramBoolean)
  {
    if (isLive())
    {
      y.w(this.TAG, "%s it is live, don't seek ", new Object[] { ayL() });
      return false;
    }
    return super.y(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */