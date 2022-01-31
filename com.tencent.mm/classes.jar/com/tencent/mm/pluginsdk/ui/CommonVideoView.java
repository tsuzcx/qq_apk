package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class CommonVideoView
  extends AbstractVideoView
{
  protected boolean aTq;
  protected int icR = 0;
  protected int idD;
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
  
  public void Es()
  {
    AppMethodBeat.i(117957);
    if (isLive())
    {
      ab.i(this.TAG, "%s it is live video, do not completion", new Object[] { bas() });
      stop();
      start();
      AppMethodBeat.o(117957);
      return;
    }
    super.Es();
    AppMethodBeat.o(117957);
  }
  
  public final int LS(int paramInt)
  {
    this.icR = paramInt;
    return paramInt;
  }
  
  public void alo()
  {
    AppMethodBeat.i(117955);
    super.alo();
    AppMethodBeat.o(117955);
  }
  
  public void alp()
  {
    AppMethodBeat.i(117954);
    super.alp();
    if ((this.kvG != null) && ((this.kvG instanceof VideoTextureView)))
    {
      if (this.vPw)
      {
        play();
        AppMethodBeat.o(117954);
        return;
      }
      ((VideoTextureView)this.kvG).bQB();
    }
    AppMethodBeat.o(117954);
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(117950);
    ab.i(this.TAG, "%s set play rate [%f]", new Object[] { bas(), Float.valueOf(paramFloat) });
    if ((this.kvG instanceof VideoTextureView))
    {
      hB(getReportIdkey() + 13);
      boolean bool = ((VideoTextureView)this.kvG).ay(paramFloat);
      AppMethodBeat.o(117950);
      return bool;
    }
    AppMethodBeat.o(117950);
    return false;
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(117946);
    ab.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[] { bas(), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) });
    this.aTq = paramBoolean;
    this.url = paramString;
    this.idD = paramInt;
    alY(paramString);
    AppMethodBeat.o(117946);
  }
  
  protected e ck(Context paramContext)
  {
    AppMethodBeat.i(117947);
    this.vPx = 0;
    paramContext = new VideoTextureView(paramContext);
    AppMethodBeat.o(117947);
    return paramContext;
  }
  
  public boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(117953);
    if (isLive())
    {
      ab.w(this.TAG, "%s it is live, don't seek ", new Object[] { bas() });
      AppMethodBeat.o(117953);
      return false;
    }
    paramBoolean = super.d(paramDouble, paramBoolean);
    AppMethodBeat.o(117953);
    return paramBoolean;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(117952);
    try
    {
      if ((this.kvG instanceof VideoTextureView))
      {
        int i = ((VideoTextureView)this.kvG).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        i = (int)(i * 1.0F / 100.0F * f);
        AppMethodBeat.o(117952);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, localException, "%s get cache time sec error", new Object[] { bas() });
      AppMethodBeat.o(117952);
    }
    return 0;
  }
  
  protected int getReportIdkey()
  {
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(117951);
    if (this.idD <= 0)
    {
      i = super.getVideoDurationSec();
      AppMethodBeat.o(117951);
      return i;
    }
    int i = this.idD;
    AppMethodBeat.o(117951);
    return i;
  }
  
  public int getVideoSource()
  {
    return this.icR;
  }
  
  public final void he(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117956);
    ab.d(this.TAG, "%s onInfo [%d %d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      showLoading();
      dmR();
      dmP();
      hB(getReportIdkey() + 40);
      AppMethodBeat.o(117956);
      return;
    }
    if (paramInt1 == 702)
    {
      hideLoading();
      dmQ();
      dmS();
    }
    AppMethodBeat.o(117956);
  }
  
  protected void initView()
  {
    AppMethodBeat.i(117945);
    super.initView();
    this.TAG = "MicroMsg.CommonVideoView";
    AppMethodBeat.o(117945);
  }
  
  public boolean isLive()
  {
    AppMethodBeat.i(117958);
    boolean bool = bUC();
    int i;
    if (this.kvG != null)
    {
      i = this.kvG.getDuration();
      if (!this.aTq) {
        break label102;
      }
      bool = true;
    }
    for (;;)
    {
      ab.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[] { bas(), Boolean.valueOf(bool), Boolean.valueOf(bUC()), Integer.valueOf(i), Boolean.valueOf(this.aTq) });
      AppMethodBeat.o(117958);
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
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(117949);
    if ((this.kvG instanceof VideoTextureView))
    {
      ((VideoTextureView)this.kvG).setScaleType(paramd);
      hB(getReportIdkey() + 14);
    }
    AppMethodBeat.o(117949);
  }
  
  public void start()
  {
    AppMethodBeat.i(117948);
    if (this.kvG != null)
    {
      ab.i(this.TAG, "%s start path [%s] [%s]", new Object[] { bas(), this.kvG.getVideoPath(), bo.dtY() });
      if (!bo.isNullOrNil(this.kvG.getVideoPath())) {
        break label103;
      }
      this.kvG.setVideoPath(this.url);
      showLoading();
      cuk();
    }
    for (;;)
    {
      hB(getReportIdkey() + 1);
      AppMethodBeat.o(117948);
      return;
      label103:
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.CommonVideoView
 * JD-Core Version:    0.7.0.1
 */