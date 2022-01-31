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
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;

public class AdLandingVideoWrapper
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
  private AdLandingVideoWrapper.a ryk;
  public ap ryl;
  private String url;
  
  public AdLandingVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37370);
    this.ryj = h.d.vQK;
    this.fcD = false;
    this.idC = -1.0F;
    this.ryl = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(37369);
        if ((AdLandingVideoWrapper.a(AdLandingVideoWrapper.this) == null) || (AdLandingVideoWrapper.b(AdLandingVideoWrapper.this) == null))
        {
          AppMethodBeat.o(37369);
          return false;
        }
        if ((AdLandingVideoWrapper.b(AdLandingVideoWrapper.this) != null) && (AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).isPlaying())) {
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).Ef(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(37369);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.idF = new d();
    AppMethodBeat.o(37370);
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFB()
  {
    AppMethodBeat.i(37372);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(37372);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFC()
  {
    AppMethodBeat.i(37373);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.crV();
    j.akQ(str);
    localMMVideoView.setRootPath(str);
    localMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(37373);
    return localMMVideoView;
  }
  
  private boolean cry()
  {
    return (this.aTq) || (this.idE);
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(37395);
    if (this.idy != null) {
      this.idy.aEM();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(37395);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(37394);
    if (this.idy != null) {
      this.idy.alo();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(37394);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(37393);
    if (this.idy != null) {
      this.idy.alp();
    }
    AppMethodBeat.o(37393);
  }
  
  public final void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37398);
    ab.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(37398);
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(37397);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(37397);
      return false;
    }
    this.idC = paramFloat;
    if (this.idy != null)
    {
      boolean bool = this.idy.ay(this.idC);
      AppMethodBeat.o(37397);
      return bool;
    }
    AppMethodBeat.o(37397);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37399);
    ab.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    com.tencent.mm.plugin.report.service.h.qsU.cT(955, 36);
    AppMethodBeat.o(37399);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(37371);
    this.idD = paramInt;
    this.aTq = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bo.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.idE = paramBoolean;
      this.url = localPString.value;
      if (this.idy != null) {
        break label269;
      }
      if (!cry()) {
        break label233;
      }
      ab.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFB();
      paramInt = i;
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
      AppMethodBeat.o(37371);
      return;
      paramBoolean = false;
      break;
      label233:
      ab.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFC();
      paramInt = i;
      continue;
      label269:
      if (cry())
      {
        if ((this.idy instanceof MMVideoView))
        {
          this.idy.stop();
          this.idy.crA();
          removeView((View)this.idy);
          ab.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.idy = aFB();
          paramInt = i;
        }
        else
        {
          ab.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.idy.stop();
          paramInt = 0;
        }
      }
      else if ((this.idy instanceof CommonVideoView))
      {
        this.idy.stop();
        this.idy.crA();
        removeView((View)this.idy);
        ab.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy = aFC();
        paramInt = i;
      }
      else
      {
        ab.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy.stop();
        paramInt = 0;
      }
    }
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37400);
    ab.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ryi != null) {
      this.ryi.cq(paramString1, paramString2);
    }
    AppMethodBeat.o(37400);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37401);
    ab.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.ryi != null) {
      this.ryi.cr(paramString1, paramString2);
    }
    com.tencent.mm.plugin.report.service.h.qsU.cT(955, 35);
    AppMethodBeat.o(37401);
  }
  
  public final void crA()
  {
    AppMethodBeat.i(37376);
    if (this.idy != null) {
      this.idy.crA();
    }
    AppMethodBeat.o(37376);
  }
  
  public final void crz()
  {
    AppMethodBeat.i(37374);
    this.ryl.stopTimer();
    this.ryl.ag(1000L, 1000L);
    AppMethodBeat.o(37374);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37403);
    ab.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.idF.cJ(false);
    if (this.ryi != null) {
      this.ryi.cs(paramString1, paramString2);
    }
    AppMethodBeat.o(37403);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37404);
    ab.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.idF.a(this);
    if (this.ryi != null) {
      this.ryi.ct(paramString1, paramString2);
    }
    AppMethodBeat.o(37404);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37405);
    if (this.ryi != null) {
      this.ryi.cu(paramString1, paramString2);
    }
    AppMethodBeat.o(37405);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37406);
    if (this.ryi != null) {
      this.ryi.cv(paramString1, paramString2);
    }
    AppMethodBeat.o(37406);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37402);
    ab.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ryi != null) {
      this.ryi.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(37402);
  }
  
  public final boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(37379);
    if (this.idy != null)
    {
      paramBoolean = this.idy.d(paramDouble, paramBoolean);
      AppMethodBeat.o(37379);
      return paramBoolean;
    }
    AppMethodBeat.o(37379);
    return false;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(37385);
    if (this.idy != null)
    {
      int i = this.idy.getCacheTimeSec();
      AppMethodBeat.o(37385);
      return i;
    }
    AppMethodBeat.o(37385);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(37383);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosMs();
      AppMethodBeat.o(37383);
      return i;
    }
    AppMethodBeat.o(37383);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(37384);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosSec();
      AppMethodBeat.o(37384);
      return i;
    }
    AppMethodBeat.o(37384);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(37377);
    if (this.idy != null)
    {
      int i = this.idy.getPlayerType();
      AppMethodBeat.o(37377);
      return i;
    }
    AppMethodBeat.o(37377);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(37382);
    if (this.idy != null)
    {
      i = this.idy.getVideoDurationSec();
      AppMethodBeat.o(37382);
      return i;
    }
    int i = this.idD;
    AppMethodBeat.o(37382);
    return i;
  }
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(37408);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(37408);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(37387);
    if (this.idy != null)
    {
      boolean bool = this.idy.isLive();
      AppMethodBeat.o(37387);
      return bool;
    }
    AppMethodBeat.o(37387);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(37386);
    if (this.idy != null)
    {
      boolean bool = this.idy.isPlaying();
      AppMethodBeat.o(37386);
      return bool;
    }
    AppMethodBeat.o(37386);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(37391);
    if (this.idy != null)
    {
      setKeepScreenOn(false);
      this.idF.cJ(false);
      boolean bool = this.idy.pause();
      AppMethodBeat.o(37391);
      return bool;
    }
    AppMethodBeat.o(37391);
    return false;
  }
  
  public final boolean r(double paramDouble)
  {
    AppMethodBeat.i(37378);
    if (this.idy != null)
    {
      boolean bool = this.idy.r(paramDouble);
      AppMethodBeat.o(37378);
      return bool;
    }
    AppMethodBeat.o(37378);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37388);
    if (this.idy != null) {
      this.idy.setCover(paramBitmap);
    }
    AppMethodBeat.o(37388);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(37381);
    if (this.idy != null) {
      this.idy.setFullDirection(paramInt);
    }
    AppMethodBeat.o(37381);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    this.ryi = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(37380);
    if (this.idy != null) {
      this.idy.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(37380);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(37407);
    ab.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bo.dtY() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(37407);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(37392);
    this.fcD = paramBoolean;
    if (this.idy != null) {
      this.idy.setMute(this.fcD);
    }
    AppMethodBeat.o(37392);
  }
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(37396);
    this.ryj = paramd;
    if (this.idy != null) {
      this.idy.setScaleType(this.ryj);
    }
    AppMethodBeat.o(37396);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(37375);
    this.idA = paramg;
    if (this.idy != null) {
      this.idy.setVideoFooterView(this.idA);
    }
    AppMethodBeat.o(37375);
  }
  
  public void setVideoPlayCallback(AdLandingVideoWrapper.a parama)
  {
    this.ryk = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(37389);
    if (this.idy != null)
    {
      this.idy.start();
      setKeepScreenOn(true);
      this.idF.a(this);
    }
    AppMethodBeat.o(37389);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(37390);
    if (this.idy != null)
    {
      this.idy.stop();
      this.idF.cJ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(37390);
  }
  
  public final void xE(String paramString)
  {
    AppMethodBeat.i(37409);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(14349, paramString);
    AppMethodBeat.o(37409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */