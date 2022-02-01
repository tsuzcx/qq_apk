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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;

public class AdLandingVideoWrapper
  extends RelativeLayout
  implements d.a, com.tencent.mm.pluginsdk.ui.h, h.a, h.b, h.c
{
  private boolean bqS;
  private boolean dtp;
  private boolean gCJ;
  private float knF;
  private int knG;
  private boolean lUw;
  private Context mContext;
  private g nno;
  private h.b nns;
  private d nnt;
  private String url;
  private h.e vhJ;
  private com.tencent.mm.pluginsdk.ui.h xdR;
  private AdLandingVideoWrapper.a xdS;
  public av xdT;
  
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
    this.vhJ = h.e.BVs;
    this.gCJ = false;
    this.knF = -1.0F;
    this.lUw = false;
    this.xdT = new av(new av.a()
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
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).sa(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.nnt = new d();
    AppMethodBeat.o(96831);
  }
  
  private boolean cCB()
  {
    return (this.bqS) || (this.dtp);
  }
  
  private com.tencent.mm.pluginsdk.ui.h cCy()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h cCz()
  {
    AppMethodBeat.i(96834);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dxm();
    l.aAk(str);
    localMMVideoView.setRootPath(str);
    localMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localMMVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h dwF()
  {
    AppMethodBeat.i(187500);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dxm();
      l.aAk(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(187500);
      return localFullScreenMMVideoView1;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(187500);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final void aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(96848);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.aXf();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.knF = paramFloat;
    if (this.xdR != null)
    {
      boolean bool = this.xdR.ax(this.knF);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    ad.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.knG = paramInt;
    this.bqS = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bt.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dtp = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.xdR != null) {
          continue;
        }
        if (!cCB()) {
          continue;
        }
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR = cCy();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        paramInt = 0;
        ad.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR = cCz();
        paramInt = i;
        continue;
        if (!cCB()) {
          continue;
        }
        if (!(this.xdR instanceof MMVideoView)) {
          continue;
        }
        this.xdR.stop();
        this.xdR.cCC();
        removeView((View)this.xdR);
        try
        {
          ad.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.xdR = cCy();
          paramInt = i;
        }
        catch (Throwable paramString)
        {
          paramInt = j;
        }
        continue;
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR.stop();
        paramInt = 0;
        continue;
        if (!(this.xdR instanceof CommonVideoView)) {
          continue;
        }
        if (!this.lUw) {
          continue;
        }
        this.xdR.stop();
        this.xdR.cCC();
        removeView((View)this.xdR);
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR = dwF();
        paramInt = i;
        continue;
        this.xdR.stop();
        this.xdR.cCC();
        removeView((View)this.xdR);
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR = cCz();
        paramInt = i;
        continue;
        ad.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.xdR.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.vhJ);
      ax(this.knF);
      setMute(this.gCJ);
      if (paramInt != 0)
      {
        setVideoFooterView(this.nno);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.xdR, paramString);
      }
      this.xdR.c(this.bqS, this.url, this.knG);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.lUw) {
        continue;
      }
      ad.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.xdR = dwF();
      paramInt = i;
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.xdR != null)
    {
      paramBoolean = this.xdR.c(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final void cCC()
  {
    AppMethodBeat.i(96837);
    if (this.xdR != null) {
      this.xdR.cCC();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.nns != null) {
      this.nns.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nns != null) {
      this.nns.db(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    ad.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.nns != null) {
      this.nns.dc(paramString1, paramString2);
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    ad.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.nnt.ea(false);
    if (this.nns != null) {
      this.nns.dd(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    ad.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.nnt.a(this);
    if (this.nns != null) {
      this.nns.de(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.nns != null) {
      this.nns.dg(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.nns != null) {
      this.nns.dh(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void dwG()
  {
    AppMethodBeat.i(96835);
    this.xdT.stopTimer();
    this.xdT.av(1000L, 1000L);
    AppMethodBeat.o(96835);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.xdR != null)
    {
      int i = this.xdR.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.xdR != null)
    {
      int i = this.xdR.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.xdR != null)
    {
      int i = this.xdR.getCurrPosSec();
      AppMethodBeat.o(96845);
      return i;
    }
    AppMethodBeat.o(96845);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(176282);
    if ((this.xdR instanceof MMVideoView))
    {
      View localView = ((MMVideoView)this.xdR).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.xdR != null)
    {
      int i = this.xdR.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.xdR != null)
    {
      i = this.xdR.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.knG;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final void jw(String paramString1, String paramString2) {}
  
  public final void ln(long paramLong)
  {
    AppMethodBeat.i(96869);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.xdR != null) {
      this.xdR.onUIDestroy();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.xdR != null) {
      this.xdR.onUIPause();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.xdR != null) {
      this.xdR.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.xdR != null)
    {
      boolean bool = this.xdR.p(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.xdR != null)
    {
      setKeepScreenOn(false);
      this.nnt.ea(false);
      boolean bool = this.xdR.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public final void pj(String paramString)
  {
    AppMethodBeat.i(96870);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.xdR != null) {
      this.xdR.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.xdR != null) {
      this.xdR.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.lUw = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.nns = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.xdR != null) {
      this.xdR.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(96841);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(96868);
    ad.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.eGN() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(96868);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(187501);
    try
    {
      if (this.xdR != null) {
        this.xdR.setLoop(paramBoolean);
      }
      AppMethodBeat.o(187501);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      AppMethodBeat.o(187501);
    }
  }
  
  public void setLoopCompletionCallback(h.d paramd)
  {
    AppMethodBeat.i(187502);
    try
    {
      if (this.xdR != null) {
        this.xdR.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(187502);
      return;
    }
    catch (Throwable paramd)
    {
      ad.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(187502);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.gCJ = paramBoolean;
    if (this.xdR != null) {
      this.xdR.setMute(this.gCJ);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(96857);
    this.vhJ = parame;
    if (this.xdR != null) {
      this.xdR.setScaleType(this.vhJ);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(96836);
    this.nno = paramg;
    if (this.xdR != null) {
      this.xdR.setVideoFooterView(this.nno);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(AdLandingVideoWrapper.a parama)
  {
    this.xdS = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.xdR != null)
    {
      this.xdR.start();
      setKeepScreenOn(true);
      this.nnt.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.xdR != null)
    {
      this.xdR.stop();
      this.nnt.ea(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */