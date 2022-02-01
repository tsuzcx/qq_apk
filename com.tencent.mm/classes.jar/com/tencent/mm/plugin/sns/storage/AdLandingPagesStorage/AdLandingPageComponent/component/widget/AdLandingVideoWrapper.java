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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;

public class AdLandingVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.a, h.b, h.c
{
  private boolean bps;
  private boolean dqZ;
  private boolean hdh;
  private float kOZ;
  private int kPa;
  private Context mContext;
  private boolean mwy;
  private g nQo;
  private h.b nQs;
  private d nQt;
  private String url;
  private h.e wqv;
  private com.tencent.mm.pluginsdk.ui.h yqG;
  private a yqH;
  public au yqI;
  
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
    this.wqv = h.e.DnJ;
    this.hdh = false;
    this.kOZ = -1.0F;
    this.mwy = false;
    this.yqI = new au(new au.a()
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
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).sQ(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.nQt = new d();
    AppMethodBeat.o(96831);
  }
  
  private com.tencent.mm.pluginsdk.ui.h cPJ()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h cPK()
  {
    AppMethodBeat.i(96834);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dLL();
    l.aFC(str);
    localMMVideoView.setRootPath(str);
    localMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localMMVideoView;
  }
  
  private boolean cPM()
  {
    return (this.bps) || (this.dqZ);
  }
  
  private com.tencent.mm.pluginsdk.ui.h dLe()
  {
    AppMethodBeat.i(200304);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dLL();
      l.aFC(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(200304);
      return localFullScreenMMVideoView1;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(200304);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.kOZ = paramFloat;
    if (this.yqG != null)
    {
      boolean bool = this.yqG.aB(this.kOZ);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    ac.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final boolean bed()
  {
    AppMethodBeat.i(96848);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.bed();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    ac.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    com.tencent.mm.plugin.report.service.h.wUl.dB(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.kPa = paramInt;
    this.bps = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bs.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dqZ = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.yqG != null) {
          continue;
        }
        if (!cPM()) {
          continue;
        }
        ac.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG = cPJ();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        paramInt = 0;
        ac.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        ac.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG = cPK();
        paramInt = i;
        continue;
        if (!cPM()) {
          continue;
        }
        if (!(this.yqG instanceof MMVideoView)) {
          continue;
        }
        this.yqG.stop();
        this.yqG.cDR();
        removeView((View)this.yqG);
        try
        {
          ac.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.yqG = cPJ();
          paramInt = i;
        }
        catch (Throwable paramString)
        {
          paramInt = j;
        }
        continue;
        ac.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG.stop();
        paramInt = 0;
        continue;
        if (!(this.yqG instanceof CommonVideoView)) {
          continue;
        }
        if (!this.mwy) {
          continue;
        }
        this.yqG.stop();
        this.yqG.cDR();
        removeView((View)this.yqG);
        ac.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG = dLe();
        paramInt = i;
        continue;
        this.yqG.stop();
        this.yqG.cDR();
        removeView((View)this.yqG);
        ac.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG = cPK();
        paramInt = i;
        continue;
        ac.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.yqG.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.wqv);
      aB(this.kOZ);
      setMute(this.hdh);
      if (paramInt != 0)
      {
        setVideoFooterView(this.nQo);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.yqG, paramString);
      }
      this.yqG.c(this.bps, this.url, this.kPa);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.mwy) {
        continue;
      }
      ac.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.yqG = dLe();
      paramInt = i;
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.yqG != null)
    {
      paramBoolean = this.yqG.c(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final void cDR()
  {
    AppMethodBeat.i(96837);
    if (this.yqG != null) {
      this.yqG.cDR();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    ac.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nQs != null) {
      this.nQs.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void dLf()
  {
    AppMethodBeat.i(96835);
    this.yqI.stopTimer();
    this.yqI.au(1000L, 1000L);
    AppMethodBeat.o(96835);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    ac.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nQs != null) {
      this.nQs.jdMethod_do(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    ac.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nQs != null) {
      this.nQs.dp(paramString1, paramString2);
    }
    com.tencent.mm.plugin.report.service.h.wUl.dB(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    ac.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.nQt.ev(false);
    if (this.nQs != null) {
      this.nQs.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    ac.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.nQt.a(this);
    if (this.nQs != null) {
      this.nQs.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.nQs != null) {
      this.nQs.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.nQs != null) {
      this.nQs.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void eJ(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.yqG != null)
    {
      int i = this.yqG.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.yqG != null)
    {
      int i = this.yqG.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.yqG != null)
    {
      int i = this.yqG.getCurrPosSec();
      AppMethodBeat.o(96845);
      return i;
    }
    AppMethodBeat.o(96845);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(176282);
    if ((this.yqG instanceof MMVideoView))
    {
      View localView = ((MMVideoView)this.yqG).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.yqG != null)
    {
      int i = this.yqG.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.yqG != null)
    {
      i = this.yqG.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.kPa;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.yqG != null)
    {
      boolean bool = this.yqG.o(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final void oQ(long paramLong)
  {
    AppMethodBeat.i(96869);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.yqG != null) {
      this.yqG.onUIDestroy();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.yqG != null) {
      this.yqG.onUIPause();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.yqG != null) {
      this.yqG.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.yqG != null)
    {
      setKeepScreenOn(false);
      this.nQt.ev(false);
      boolean bool = this.yqG.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.yqG != null) {
      this.yqG.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.yqG != null) {
      this.yqG.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.mwy = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nQs = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.yqG != null) {
      this.yqG.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(96841);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(96868);
    ac.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bs.eWi() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(96868);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(200305);
    try
    {
      if (this.yqG != null) {
        this.yqG.setLoop(paramBoolean);
      }
      AppMethodBeat.o(200305);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      AppMethodBeat.o(200305);
    }
  }
  
  public void setLoopCompletionCallback(h.d paramd)
  {
    AppMethodBeat.i(200306);
    try
    {
      if (this.yqG != null) {
        this.yqG.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(200306);
      return;
    }
    catch (Throwable paramd)
    {
      ac.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(200306);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.hdh = paramBoolean;
    if (this.yqG != null) {
      this.yqG.setMute(this.hdh);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(96857);
    this.wqv = parame;
    if (this.yqG != null) {
      this.yqG.setScaleType(this.wqv);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(96836);
    this.nQo = paramg;
    if (this.yqG != null) {
      this.yqG.setVideoFooterView(this.nQo);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(a parama)
  {
    this.yqH = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.yqG != null)
    {
      this.yqG.start();
      setKeepScreenOn(true);
      this.nQt.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.yqG != null)
    {
      this.yqG.stop();
      this.nQt.ev(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
  
  public final void sv(String paramString)
  {
    AppMethodBeat.i(96870);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public static abstract interface a
  {
    public abstract void sQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */