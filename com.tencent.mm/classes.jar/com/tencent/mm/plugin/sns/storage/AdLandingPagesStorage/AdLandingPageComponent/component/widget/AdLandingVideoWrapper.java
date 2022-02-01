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
  private i.e BOo;
  private i Eho;
  private a Ehp;
  public MTimerHandler Ehq;
  private boolean bzP;
  private boolean dLQ;
  private boolean isb;
  private Context mContext;
  private float mwH;
  private int mwI;
  private boolean onr;
  private com.tencent.mm.pluginsdk.ui.h pNf;
  private i.b pNj;
  private d pNk;
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
    this.BOo = i.e.Kcb;
    this.isb = false;
    this.mwH = -1.0F;
    this.onr = false;
    this.Ehq = new MTimerHandler(new MTimerHandler.CallBack()
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
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).xv(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.pNk = new d();
    AppMethodBeat.o(96831);
  }
  
  private i dUF()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private i dUG()
  {
    AppMethodBeat.i(96834);
    AdLandingMMVideoView localAdLandingMMVideoView = new AdLandingMMVideoView(this.mContext);
    localAdLandingMMVideoView.setReporter(this);
    localAdLandingMMVideoView.setIMMVideoViewCallback(this);
    localAdLandingMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.few();
    FilePathGenerator.checkMkdir(str);
    localAdLandingMMVideoView.setRootPath(str);
    localAdLandingMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localAdLandingMMVideoView;
  }
  
  private boolean dUI()
  {
    return (this.bzP) || (this.dLQ);
  }
  
  private i fdP()
  {
    AppMethodBeat.i(203118);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.few();
      FilePathGenerator.checkMkdir(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(203118);
      return localFullScreenMMVideoView1;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(203118);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final void DX(String paramString)
  {
    AppMethodBeat.i(96870);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public final void aO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.mwH = paramFloat;
    if (this.Eho != null)
    {
      boolean bool = this.Eho.aO(this.mwH);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    Log.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.mwI = paramInt;
    this.bzP = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!Util.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dLQ = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.Eho != null) {
          continue;
        }
        if (!dUI()) {
          continue;
        }
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho = dUF();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        paramInt = 0;
        Log.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho = dUG();
        paramInt = i;
        continue;
        if (!dUI()) {
          continue;
        }
        if (!(this.Eho instanceof MMVideoView)) {
          continue;
        }
        this.Eho.stop();
        this.Eho.dFl();
        removeView((View)this.Eho);
        try
        {
          Log.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.Eho = dUF();
          paramInt = i;
        }
        catch (Throwable paramString)
        {
          paramInt = j;
        }
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho.stop();
        paramInt = 0;
        continue;
        if (!(this.Eho instanceof CommonVideoView)) {
          continue;
        }
        if (!this.onr) {
          continue;
        }
        this.Eho.stop();
        this.Eho.dFl();
        removeView((View)this.Eho);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho = fdP();
        paramInt = i;
        continue;
        this.Eho.stop();
        this.Eho.dFl();
        removeView((View)this.Eho);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho = dUG();
        paramInt = i;
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Eho.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.BOo);
      aO(this.mwH);
      setMute(this.isb);
      if (paramInt != 0)
      {
        setVideoFooterView(this.pNf);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.Eho, paramString);
      }
      this.Eho.c(this.bzP, this.url, this.mwI);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.onr) {
        continue;
      }
      Log.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.Eho = fdP();
      paramInt = i;
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.Eho != null)
    {
      paramBoolean = this.Eho.c(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.pNj != null) {
      this.pNj.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void dFl()
  {
    AppMethodBeat.i(96837);
    if (this.Eho != null) {
      this.Eho.dFl();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pNj != null) {
      this.pNj.dH(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.pNj != null) {
      this.pNj.dI(paramString1, paramString2);
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.pNk.fp(false);
    if (this.pNj != null) {
      this.pNj.dJ(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.pNk.a(this);
    if (this.pNj != null) {
      this.pNj.dK(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.pNj != null) {
      this.pNj.dL(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.pNj != null) {
      this.pNj.dM(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void fdQ()
  {
    AppMethodBeat.i(96835);
    this.Ehq.stopTimer();
    this.Ehq.startTimer(1000L);
    AppMethodBeat.o(96835);
  }
  
  public final void fo(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.Eho != null)
    {
      int i = this.Eho.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.Eho != null)
    {
      int i = this.Eho.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.Eho != null)
    {
      int i = this.Eho.getCurrPosSec();
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
    if ((this.Eho instanceof AdLandingMMVideoView))
    {
      localView = ((AdLandingMMVideoView)this.Eho).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    if ((this.Eho instanceof MMVideoView))
    {
      localView = ((MMVideoView)this.Eho).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.Eho != null)
    {
      int i = this.Eho.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.Eho != null)
    {
      i = this.Eho.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(96848);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.isLive();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.Eho != null) {
      this.Eho.onUIDestroy();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.Eho != null) {
      this.Eho.onUIPause();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.Eho != null) {
      this.Eho.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.Eho != null)
    {
      boolean bool = this.Eho.p(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.Eho != null)
    {
      setKeepScreenOn(false);
      this.pNk.fp(false);
      boolean bool = this.Eho.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.Eho != null) {
      this.Eho.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.Eho != null) {
      this.Eho.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.onr = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.pNj = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.Eho != null) {
      this.Eho.setIsShowBasicControls(paramBoolean);
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
    AppMethodBeat.i(203119);
    try
    {
      if (this.Eho != null) {
        this.Eho.setLoop(paramBoolean);
      }
      AppMethodBeat.o(203119);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      AppMethodBeat.o(203119);
    }
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    AppMethodBeat.i(203120);
    try
    {
      if (this.Eho != null) {
        this.Eho.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(203120);
      return;
    }
    catch (Throwable paramd)
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(203120);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.isb = paramBoolean;
    if (this.Eho != null) {
      this.Eho.setMute(this.isb);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setNeedPause(boolean paramBoolean)
  {
    AppMethodBeat.i(203121);
    if ((this.Eho instanceof AdLandingMMVideoView)) {
      ((AdLandingMMVideoView)this.Eho).setNeedPause(paramBoolean);
    }
    AppMethodBeat.o(203121);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(96857);
    this.BOo = parame;
    if (this.Eho != null) {
      this.Eho.setScaleType(this.BOo);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(96836);
    this.pNf = paramh;
    if (this.Eho != null) {
      this.Eho.setVideoFooterView(this.pNf);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(a parama)
  {
    this.Ehp = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.Eho != null)
    {
      this.Eho.start();
      setKeepScreenOn(true);
      this.pNk.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.Eho != null)
    {
      this.Eho.stop();
      this.pNk.fp(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
  
  public final void yU(long paramLong)
  {
    AppMethodBeat.i(96869);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public static abstract interface a
  {
    public abstract void xv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */