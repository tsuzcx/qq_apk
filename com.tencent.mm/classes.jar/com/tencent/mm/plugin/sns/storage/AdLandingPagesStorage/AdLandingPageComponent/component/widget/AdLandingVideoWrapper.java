package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.AdLandingMMVideoView;
import com.tencent.mm.modelvideo.FullScreenMMVideoView;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public class AdLandingVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private boolean AJP;
  private i.e HKU;
  private i Kuv;
  private a Kuw;
  public MTimerHandler Kux;
  private boolean bjq;
  private boolean fEF;
  private boolean lhf;
  private Context mContext;
  private float pvh;
  private int pvi;
  private com.tencent.mm.pluginsdk.ui.h sUd;
  private i.b sUh;
  private d sUi;
  private String url;
  
  public AdLandingVideoWrapper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdLandingVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96831);
    this.HKU = i.e.RcG;
    this.lhf = false;
    this.pvh = -1.0F;
    this.AJP = false;
    this.Kux = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(96830);
        if ((AdLandingVideoWrapper.a(AdLandingVideoWrapper.this) == null) || (AdLandingVideoWrapper.b(AdLandingVideoWrapper.this) == null))
        {
          AppMethodBeat.o(96830);
          return false;
        }
        if ((AdLandingVideoWrapper.b(AdLandingVideoWrapper.this) != null) && (AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).isPlaying())) {
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).AS(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.sUi = d.bcs();
    AppMethodBeat.o(96831);
  }
  
  private i exM()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private i exN()
  {
    AppMethodBeat.i(96834);
    AdLandingMMVideoView localAdLandingMMVideoView = new AdLandingMMVideoView(this.mContext);
    localAdLandingMMVideoView.setReporter(this);
    localAdLandingMMVideoView.setIMMVideoViewCallback(this);
    localAdLandingMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.fSq();
    FilePathGenerator.checkMkdir(str);
    localAdLandingMMVideoView.setRootPath(str);
    localAdLandingMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localAdLandingMMVideoView;
  }
  
  private boolean exP()
  {
    return (this.bjq) || (this.fEF);
  }
  
  private i fRH()
  {
    AppMethodBeat.i(194447);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.fSq();
      FilePathGenerator.checkMkdir(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(194447);
      return localFullScreenMMVideoView1;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(194447);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final void EW(long paramLong)
  {
    AppMethodBeat.i(96869);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public final void KP(String paramString)
  {
    AppMethodBeat.i(96870);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.Kuv != null)
    {
      paramBoolean = this.Kuv.a(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.pvh = paramFloat;
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.aO(this.pvh);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    Log.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.pvi = paramInt;
    this.bjq = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!Util.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.fEF = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.Kuv != null) {
          continue;
        }
        if (!exP()) {
          continue;
        }
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv = exM();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        paramInt = 0;
        Log.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv = exN();
        paramInt = i;
        continue;
        if (!exP()) {
          continue;
        }
        if (!(this.Kuv instanceof MMVideoView)) {
          continue;
        }
        this.Kuv.stop();
        this.Kuv.egX();
        removeView((View)this.Kuv);
        try
        {
          Log.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.Kuv = exM();
          paramInt = i;
        }
        catch (Throwable paramString)
        {
          paramInt = j;
        }
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv.stop();
        paramInt = 0;
        continue;
        if (!(this.Kuv instanceof CommonVideoView)) {
          continue;
        }
        if (!this.AJP) {
          continue;
        }
        this.Kuv.stop();
        this.Kuv.egX();
        removeView((View)this.Kuv);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv = fRH();
        paramInt = i;
        continue;
        this.Kuv.stop();
        this.Kuv.egX();
        removeView((View)this.Kuv);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv = exN();
        paramInt = i;
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.HKU);
      aO(this.pvh);
      setMute(this.lhf);
      if (paramInt != 0)
      {
        setVideoFooterView(this.sUd);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.Kuv, paramString);
      }
      this.Kuv.c(this.bjq, this.url, this.pvi);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.AJP) {
        continue;
      }
      Log.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.Kuv = fRH();
      paramInt = i;
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sUh != null) {
      this.sUh.dS(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sUh != null) {
      this.sUh.dT(paramString1, paramString2);
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.sUi.fZ(false);
    if (this.sUh != null) {
      this.sUh.dU(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.sUi.a(this);
    if (this.sUh != null) {
      this.sUh.dV(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.sUh != null) {
      this.sUh.dW(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.sUh != null) {
      this.sUh.dX(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void egX()
  {
    AppMethodBeat.i(96837);
    if (this.Kuv != null) {
      this.Kuv.egX();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void fC(String paramString1, String paramString2) {}
  
  public final void fRI()
  {
    AppMethodBeat.i(96835);
    this.Kux.stopTimer();
    this.Kux.startTimer(1000L);
    AppMethodBeat.o(96835);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCurrPosSec();
      AppMethodBeat.o(96845);
      return i;
    }
    AppMethodBeat.o(96845);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(176282);
    View localView;
    if ((this.Kuv instanceof AdLandingMMVideoView))
    {
      localView = ((AdLandingMMVideoView)this.Kuv).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    if ((this.Kuv instanceof MMVideoView))
    {
      localView = ((MMVideoView)this.Kuv).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.Kuv != null)
    {
      i = this.Kuv.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(96848);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.isLive();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.Kuv != null) {
      this.Kuv.onUIDestroy();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.Kuv != null) {
      this.Kuv.onUIPause();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.Kuv != null) {
      this.Kuv.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.p(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.Kuv != null)
    {
      setKeepScreenOn(false);
      this.sUi.fZ(false);
      boolean bool = this.Kuv.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.Kuv != null) {
      this.Kuv.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.Kuv != null) {
      this.Kuv.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.sUh = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.Kuv != null) {
      this.Kuv.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(96841);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(96868);
    Log.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(96868);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(194495);
    try
    {
      if (this.Kuv != null) {
        this.Kuv.setLoop(paramBoolean);
      }
      AppMethodBeat.o(194495);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      AppMethodBeat.o(194495);
    }
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    AppMethodBeat.i(194497);
    try
    {
      if (this.Kuv != null) {
        this.Kuv.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(194497);
      return;
    }
    catch (Throwable paramd)
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(194497);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.lhf = paramBoolean;
    if (this.Kuv != null) {
      this.Kuv.setMute(this.lhf);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setNeedPause(boolean paramBoolean)
  {
    AppMethodBeat.i(194523);
    if ((this.Kuv instanceof AdLandingMMVideoView)) {
      ((AdLandingMMVideoView)this.Kuv).setNeedPause(paramBoolean);
    }
    AppMethodBeat.o(194523);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(96857);
    this.HKU = parame;
    if (this.Kuv != null) {
      this.Kuv.setScaleType(this.HKU);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(96836);
    this.sUd = paramh;
    if (this.Kuv != null) {
      this.Kuv.setVideoFooterView(this.sUd);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(a parama)
  {
    this.Kuw = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.Kuv != null)
    {
      this.Kuv.start();
      setKeepScreenOn(true);
      this.sUi.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.Kuv != null)
    {
      this.Kuv.stop();
      this.sUi.fZ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
  
  public static abstract interface a
  {
    public abstract void AS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */