package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.a, h.b, h.c
{
  private boolean aTq;
  private boolean fcD;
  private g idA;
  private float idC;
  private int idD;
  private boolean idE;
  private d idF;
  private com.tencent.mm.pluginsdk.ui.h idy;
  private Context mContext;
  private h.b ryi;
  private h.d ryj;
  private String url;
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(5777);
    this.ryj = h.d.vQK;
    this.fcD = false;
    this.idC = -1.0F;
    this.mContext = paramContext;
    this.idF = new d();
    AppMethodBeat.o(5777);
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFB()
  {
    AppMethodBeat.i(5779);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(5779);
    return localCommonVideoView;
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(5800);
    if (this.idy != null) {
      this.idy.aEM();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(5800);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(5799);
    if (this.idy != null) {
      this.idy.alo();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(5799);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(5798);
    if (this.idy != null) {
      this.idy.alp();
    }
    AppMethodBeat.o(5798);
  }
  
  public final void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5803);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(5803);
      return;
    }
    if ((this.idy instanceof MMVideoView))
    {
      this.idy.stop();
      this.idy.crA();
      removeView((View)this.idy);
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFB();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.ryj);
      ay(this.idC);
      setMute(this.fcD);
      if (i != 0)
      {
        setVideoFooterView(this.idA);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.idy, paramString);
        this.idy.c(this.aTq, this.url, this.idD);
        this.idy.start();
      }
      AppMethodBeat.o(5803);
      return;
    }
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(5802);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(5802);
      return false;
    }
    this.idC = paramFloat;
    if (this.idy != null)
    {
      boolean bool = this.idy.ay(this.idC);
      AppMethodBeat.o(5802);
      return bool;
    }
    AppMethodBeat.o(5802);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5804);
    ab.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(5804);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(5778);
    this.idD = paramInt;
    this.aTq = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    bo.isNullOrNil(localPString.value);
    this.idE = false;
    this.url = localPString.value;
    if (this.idy == null)
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFB();
      paramInt = 1;
    }
    for (;;)
    {
      setScaleType(this.ryj);
      ay(this.idC);
      setMute(this.fcD);
      if (paramInt != 0)
      {
        setVideoFooterView(this.idA);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.idy, paramString);
      }
      this.idy.c(this.aTq, this.url, this.idD);
      AppMethodBeat.o(5778);
      return;
      if ((this.idy instanceof MMVideoView))
      {
        this.idy.stop();
        this.idy.crA();
        removeView((View)this.idy);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy = aFB();
        paramInt = 1;
      }
      else
      {
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy.stop();
        paramInt = 0;
      }
    }
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5805);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ryi != null) {
      this.ryi.cq(paramString1, paramString2);
    }
    AppMethodBeat.o(5805);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5806);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ryi != null) {
      this.ryi.cr(paramString1, paramString2);
    }
    AppMethodBeat.o(5806);
  }
  
  public final void crA()
  {
    AppMethodBeat.i(5781);
    if (this.idy != null) {
      this.idy.crA();
    }
    AppMethodBeat.o(5781);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5808);
    ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.idF.cJ(false);
    if (this.ryi != null) {
      this.ryi.cs(paramString1, paramString2);
    }
    AppMethodBeat.o(5808);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5809);
    ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.idF.a(this);
    if (this.ryi != null) {
      this.ryi.ct(paramString1, paramString2);
    }
    AppMethodBeat.o(5809);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5810);
    if (this.ryi != null) {
      this.ryi.cu(paramString1, paramString2);
    }
    AppMethodBeat.o(5810);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5811);
    if (this.ryi != null) {
      this.ryi.cv(paramString1, paramString2);
    }
    AppMethodBeat.o(5811);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5807);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(5807);
  }
  
  public final boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(5784);
    if (this.idy != null)
    {
      paramBoolean = this.idy.d(paramDouble, paramBoolean);
      AppMethodBeat.o(5784);
      return paramBoolean;
    }
    AppMethodBeat.o(5784);
    return false;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(5790);
    if (this.idy != null)
    {
      int i = this.idy.getCacheTimeSec();
      AppMethodBeat.o(5790);
      return i;
    }
    AppMethodBeat.o(5790);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(5788);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosMs();
      AppMethodBeat.o(5788);
      return i;
    }
    AppMethodBeat.o(5788);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(5789);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosSec();
      AppMethodBeat.o(5789);
      return i;
    }
    AppMethodBeat.o(5789);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(5782);
    if (this.idy != null)
    {
      int i = this.idy.getPlayerType();
      AppMethodBeat.o(5782);
      return i;
    }
    AppMethodBeat.o(5782);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(5787);
    if (this.idy != null)
    {
      i = this.idy.getVideoDurationSec();
      AppMethodBeat.o(5787);
      return i;
    }
    int i = this.idD;
    AppMethodBeat.o(5787);
    return i;
  }
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(5813);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(5813);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(5792);
    if (this.idy != null)
    {
      boolean bool = this.idy.isLive();
      AppMethodBeat.o(5792);
      return bool;
    }
    AppMethodBeat.o(5792);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(5791);
    if (this.idy != null)
    {
      boolean bool = this.idy.isPlaying();
      AppMethodBeat.o(5791);
      return bool;
    }
    AppMethodBeat.o(5791);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(5796);
    if (this.idy != null)
    {
      setKeepScreenOn(false);
      this.idF.cJ(false);
      boolean bool = this.idy.pause();
      AppMethodBeat.o(5796);
      return bool;
    }
    AppMethodBeat.o(5796);
    return false;
  }
  
  public final boolean r(double paramDouble)
  {
    AppMethodBeat.i(5783);
    if (this.idy != null)
    {
      boolean bool = this.idy.r(paramDouble);
      AppMethodBeat.o(5783);
      return bool;
    }
    AppMethodBeat.o(5783);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(5793);
    if (this.idy != null) {
      this.idy.setCover(paramBitmap);
    }
    AppMethodBeat.o(5793);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(5786);
    if (this.idy != null) {
      this.idy.setFullDirection(paramInt);
    }
    AppMethodBeat.o(5786);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.ryi = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(5785);
    if (this.idy != null) {
      this.idy.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(5785);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(5812);
    ab.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bo.dtY() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(5812);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(5797);
    this.fcD = paramBoolean;
    if (this.idy != null) {
      this.idy.setMute(this.fcD);
    }
    AppMethodBeat.o(5797);
  }
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(5801);
    this.ryj = paramd;
    if (this.idy != null) {
      this.idy.setScaleType(this.ryj);
    }
    AppMethodBeat.o(5801);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(5780);
    this.idA = paramg;
    if (this.idy != null) {
      this.idy.setVideoFooterView(this.idA);
    }
    AppMethodBeat.o(5780);
  }
  
  public final void start()
  {
    AppMethodBeat.i(5794);
    if (this.idy != null)
    {
      this.idy.start();
      setKeepScreenOn(true);
      this.idF.a(this);
    }
    AppMethodBeat.o(5794);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(5795);
    if (this.idy != null)
    {
      this.idy.stop();
      this.idF.cJ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(5795);
  }
  
  public final void xE(String paramString)
  {
    AppMethodBeat.i(5814);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(14349, paramString);
    AppMethodBeat.o(5814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */