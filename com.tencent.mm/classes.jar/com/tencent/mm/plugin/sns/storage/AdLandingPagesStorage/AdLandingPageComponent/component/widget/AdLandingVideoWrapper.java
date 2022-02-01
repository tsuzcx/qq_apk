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
import com.tencent.mm.modelvideo.FullScreenMMVideoView;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;

public class AdLandingVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private boolean bzN;
  private boolean dCQ;
  private boolean hvp;
  private float llC;
  private int llD;
  private Context mContext;
  private boolean mXd;
  private com.tencent.mm.pluginsdk.ui.h osV;
  private i.b osZ;
  private d ota;
  private String url;
  private i.e xyl;
  private i zHQ;
  private a zHR;
  public av zHS;
  
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
    this.xyl = i.e.ESO;
    this.hvp = false;
    this.llC = -1.0F;
    this.mXd = false;
    this.zHS = new av(new av.a()
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
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).tt(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.ota = new d();
    AppMethodBeat.o(96831);
  }
  
  private i cYo()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private i cYp()
  {
    AppMethodBeat.i(96834);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dYb();
    m.aLc(str);
    localMMVideoView.setRootPath(str);
    localMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localMMVideoView;
  }
  
  private boolean cYr()
  {
    return (this.bzN) || (this.dCQ);
  }
  
  private i dXv()
  {
    AppMethodBeat.i(198089);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dYb();
      m.aLc(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(198089);
      return localFullScreenMMVideoView1;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(198089);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.llC = paramFloat;
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.aE(this.llC);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final boolean bhH()
  {
    AppMethodBeat.i(96848);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.bhH();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    ad.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    g.yhR.dD(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.llD = paramInt;
    this.bzN = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bt.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dCQ = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.zHQ != null) {
          continue;
        }
        if (!cYr()) {
          continue;
        }
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ = cYo();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        paramInt = 0;
        ad.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ = cYp();
        paramInt = i;
        continue;
        if (!cYr()) {
          continue;
        }
        if (!(this.zHQ instanceof MMVideoView)) {
          continue;
        }
        this.zHQ.stop();
        this.zHQ.cMk();
        removeView((View)this.zHQ);
        try
        {
          ad.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.zHQ = cYo();
          paramInt = i;
        }
        catch (Throwable paramString)
        {
          paramInt = j;
        }
        continue;
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ.stop();
        paramInt = 0;
        continue;
        if (!(this.zHQ instanceof CommonVideoView)) {
          continue;
        }
        if (!this.mXd) {
          continue;
        }
        this.zHQ.stop();
        this.zHQ.cMk();
        removeView((View)this.zHQ);
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ = dXv();
        paramInt = i;
        continue;
        this.zHQ.stop();
        this.zHQ.cMk();
        removeView((View)this.zHQ);
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ = cYp();
        paramInt = i;
        continue;
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zHQ.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.xyl);
      aE(this.llC);
      setMute(this.hvp);
      if (paramInt != 0)
      {
        setVideoFooterView(this.osV);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.zHQ, paramString);
      }
      this.zHQ.c(this.bzN, this.url, this.llD);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.mXd) {
        continue;
      }
      ad.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.zHQ = dXv();
      paramInt = i;
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.zHQ != null)
    {
      paramBoolean = this.zHQ.c(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final void cMk()
  {
    AppMethodBeat.i(96837);
    if (this.zHQ != null) {
      this.zHQ.cMk();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.osZ != null) {
      this.osZ.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void dXw()
  {
    AppMethodBeat.i(96835);
    this.zHS.stopTimer();
    this.zHS.az(1000L, 1000L);
    AppMethodBeat.o(96835);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.osZ != null) {
      this.osZ.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.osZ != null) {
      this.osZ.dr(paramString1, paramString2);
    }
    g.yhR.dD(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    ad.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.ota.ex(false);
    if (this.osZ != null) {
      this.osZ.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    ad.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.ota.a(this);
    if (this.osZ != null) {
      this.osZ.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.osZ != null) {
      this.osZ.du(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.osZ != null) {
      this.osZ.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getCurrPosSec();
      AppMethodBeat.o(96845);
      return i;
    }
    AppMethodBeat.o(96845);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(176282);
    if ((this.zHQ instanceof MMVideoView))
    {
      View localView = ((MMVideoView)this.zHQ).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.zHQ != null)
    {
      int i = this.zHQ.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.zHQ != null)
    {
      i = this.zHQ.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.llD;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.zHQ != null)
    {
      boolean bool = this.zHQ.o(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.zHQ != null) {
      this.zHQ.onUIDestroy();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.zHQ != null) {
      this.zHQ.onUIPause();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.zHQ != null) {
      this.zHQ.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.zHQ != null)
    {
      setKeepScreenOn(false);
      this.ota.ex(false);
      boolean bool = this.zHQ.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public final void qQ(long paramLong)
  {
    AppMethodBeat.i(96869);
    g.yhR.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.zHQ != null) {
      this.zHQ.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.zHQ != null) {
      this.zHQ.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.mXd = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.osZ = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.zHQ != null) {
      this.zHQ.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(96841);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(96868);
    ad.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.flS() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(96868);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(198090);
    try
    {
      if (this.zHQ != null) {
        this.zHQ.setLoop(paramBoolean);
      }
      AppMethodBeat.o(198090);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      AppMethodBeat.o(198090);
    }
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    AppMethodBeat.i(198091);
    try
    {
      if (this.zHQ != null) {
        this.zHQ.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(198091);
      return;
    }
    catch (Throwable paramd)
    {
      ad.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(198091);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.hvp = paramBoolean;
    if (this.zHQ != null) {
      this.zHQ.setMute(this.hvp);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(96857);
    this.xyl = parame;
    if (this.zHQ != null) {
      this.zHQ.setScaleType(this.xyl);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(96836);
    this.osV = paramh;
    if (this.zHQ != null) {
      this.zHQ.setVideoFooterView(this.osV);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(a parama)
  {
    this.zHR = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.zHQ != null)
    {
      this.zHQ.start();
      setKeepScreenOn(true);
      this.ota.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.zHQ != null)
    {
      this.zHQ.stop();
      this.ota.ex(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
  
  public final void vk(String paramString)
  {
    AppMethodBeat.i(96870);
    g.yhR.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public static abstract interface a
  {
    public abstract void tt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */