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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;

public class AdLandingVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private boolean bzN;
  private boolean dDV;
  private boolean hyd;
  private float lqb;
  private int lqc;
  private Context mContext;
  private boolean ncj;
  private i.b ozA;
  private d ozB;
  private com.tencent.mm.pluginsdk.ui.h ozw;
  private String url;
  private i.e xOi;
  private i zYX;
  private a zYY;
  public aw zYZ;
  
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
    this.xOi = i.e.Flj;
    this.hyd = false;
    this.lqb = -1.0F;
    this.ncj = false;
    this.zYZ = new aw(new aw.a()
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
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).tx(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.ozB = new d();
    AppMethodBeat.o(96831);
  }
  
  private i daY()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private i daZ()
  {
    AppMethodBeat.i(96834);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.ebF();
    n.aMy(str);
    localMMVideoView.setRootPath(str);
    localMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localMMVideoView;
  }
  
  private boolean dbb()
  {
    return (this.bzN) || (this.dDV);
  }
  
  private i eaY()
  {
    AppMethodBeat.i(219601);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.ebF();
      n.aMy(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(219601);
      return localFullScreenMMVideoView1;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(219601);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.lqb = paramFloat;
    if (this.zYX != null)
    {
      boolean bool = this.zYX.aE(this.lqb);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    ae.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final boolean bip()
  {
    AppMethodBeat.i(96848);
    if (this.zYX != null)
    {
      boolean bool = this.zYX.bip();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    ae.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ozA != null) {
      this.ozA.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    g.yxI.dD(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.lqc = paramInt;
    this.bzN = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bu.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dDV = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.zYX != null) {
          continue;
        }
        if (!dbb()) {
          continue;
        }
        ae.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX = daY();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        paramInt = 0;
        ae.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        ae.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX = daZ();
        paramInt = i;
        continue;
        if (!dbb()) {
          continue;
        }
        if (!(this.zYX instanceof MMVideoView)) {
          continue;
        }
        this.zYX.stop();
        this.zYX.cOS();
        removeView((View)this.zYX);
        try
        {
          ae.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.zYX = daY();
          paramInt = i;
        }
        catch (Throwable paramString)
        {
          paramInt = j;
        }
        continue;
        ae.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX.stop();
        paramInt = 0;
        continue;
        if (!(this.zYX instanceof CommonVideoView)) {
          continue;
        }
        if (!this.ncj) {
          continue;
        }
        this.zYX.stop();
        this.zYX.cOS();
        removeView((View)this.zYX);
        ae.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX = eaY();
        paramInt = i;
        continue;
        this.zYX.stop();
        this.zYX.cOS();
        removeView((View)this.zYX);
        ae.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX = daZ();
        paramInt = i;
        continue;
        ae.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.zYX.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.xOi);
      aE(this.lqb);
      setMute(this.hyd);
      if (paramInt != 0)
      {
        setVideoFooterView(this.ozw);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.zYX, paramString);
      }
      this.zYX.c(this.bzN, this.url, this.lqc);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.ncj) {
        continue;
      }
      ae.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.zYX = eaY();
      paramInt = i;
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.zYX != null)
    {
      paramBoolean = this.zYX.c(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final void cOS()
  {
    AppMethodBeat.i(96837);
    if (this.zYX != null) {
      this.zYX.cOS();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    ae.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ozA != null) {
      this.ozA.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    ae.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ozA != null) {
      this.ozA.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    ae.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ozA != null) {
      this.ozA.dt(paramString1, paramString2);
    }
    g.yxI.dD(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    ae.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.ozB.ez(false);
    if (this.ozA != null) {
      this.ozA.du(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    ae.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.ozB.a(this);
    if (this.ozA != null) {
      this.ozA.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.ozA != null) {
      this.ozA.dw(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.ozA != null) {
      this.ozA.dx(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void eX(String paramString1, String paramString2) {}
  
  public final void eaZ()
  {
    AppMethodBeat.i(96835);
    this.zYZ.stopTimer();
    this.zYZ.ay(1000L, 1000L);
    AppMethodBeat.o(96835);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.zYX != null)
    {
      int i = this.zYX.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.zYX != null)
    {
      int i = this.zYX.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.zYX != null)
    {
      int i = this.zYX.getCurrPosSec();
      AppMethodBeat.o(96845);
      return i;
    }
    AppMethodBeat.o(96845);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(176282);
    if ((this.zYX instanceof MMVideoView))
    {
      View localView = ((MMVideoView)this.zYX).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.zYX != null)
    {
      int i = this.zYX.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.zYX != null)
    {
      i = this.zYX.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.lqc;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.zYX != null)
    {
      boolean bool = this.zYX.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.zYX != null)
    {
      boolean bool = this.zYX.o(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.zYX != null) {
      this.zYX.onUIDestroy();
    }
    this.ozB.ez(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.zYX != null) {
      this.zYX.onUIPause();
    }
    this.ozB.ez(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.zYX != null) {
      this.zYX.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.zYX != null)
    {
      setKeepScreenOn(false);
      this.ozB.ez(false);
      boolean bool = this.zYX.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public final void rd(long paramLong)
  {
    AppMethodBeat.i(96869);
    g.yxI.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.zYX != null) {
      this.zYX.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.zYX != null) {
      this.zYX.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.ncj = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.ozA = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.zYX != null) {
      this.zYX.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(96841);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(96868);
    ae.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bu.fpN() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(96868);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(219602);
    try
    {
      if (this.zYX != null) {
        this.zYX.setLoop(paramBoolean);
      }
      AppMethodBeat.o(219602);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AdLandingVideoWrapper", localThrowable.toString());
      AppMethodBeat.o(219602);
    }
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    AppMethodBeat.i(219603);
    try
    {
      if (this.zYX != null) {
        this.zYX.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(219603);
      return;
    }
    catch (Throwable paramd)
    {
      ae.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(219603);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.hyd = paramBoolean;
    if (this.zYX != null) {
      this.zYX.setMute(this.hyd);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(96857);
    this.xOi = parame;
    if (this.zYX != null) {
      this.zYX.setScaleType(this.xOi);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(96836);
    this.ozw = paramh;
    if (this.zYX != null) {
      this.zYX.setVideoFooterView(this.ozw);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(a parama)
  {
    this.zYY = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.zYX != null)
    {
      this.zYX.start();
      setKeepScreenOn(true);
      this.ozB.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.zYX != null)
    {
      this.zYX.stop();
      this.ozB.ez(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
  
  public final void vG(String paramString)
  {
    AppMethodBeat.i(96870);
    g.yxI.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public static abstract interface a
  {
    public abstract void tx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */