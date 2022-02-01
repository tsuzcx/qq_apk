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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
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
import com.tencent.thumbplayer.api.ITPPlayer;

public class AdLandingVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private boolean Flq;
  private i.e NHS;
  private i QTf;
  private AdLandingVideoWrapper.a QTg;
  public MTimerHandler QTh;
  private boolean ddk;
  private boolean hJv;
  private Context mContext;
  private boolean nLP;
  private float sAn;
  private int sAo;
  private String url;
  private com.tencent.mm.pluginsdk.ui.h vZr;
  private i.b vZv;
  private d vZw;
  
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
    this.NHS = i.e.XYM;
    this.nLP = false;
    this.sAn = -1.0F;
    this.Flq = false;
    this.QTh = new MTimerHandler(new MTimerHandler.CallBack()
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
          AdLandingVideoWrapper.b(AdLandingVideoWrapper.this).Bh(AdLandingVideoWrapper.a(AdLandingVideoWrapper.this).getCurrPosSec());
        }
        AppMethodBeat.o(96830);
        return true;
      }
    }, true);
    this.mContext = paramContext;
    this.vZw = new d();
    AppMethodBeat.o(96831);
  }
  
  private i fFI()
  {
    AppMethodBeat.i(96833);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(96833);
    return localCommonVideoView;
  }
  
  private i fFJ()
  {
    AppMethodBeat.i(96834);
    AdLandingMMVideoView localAdLandingMMVideoView = new AdLandingMMVideoView(this.mContext);
    localAdLandingMMVideoView.setReporter(this);
    localAdLandingMMVideoView.setIMMVideoViewCallback(this);
    localAdLandingMMVideoView.setIMMDownloadFinish(this);
    String str = k.hkC();
    FilePathGenerator.checkMkdir(str);
    localAdLandingMMVideoView.setRootPath(str);
    localAdLandingMMVideoView.setIOnlineVideoProxy(new a());
    AppMethodBeat.o(96834);
    return localAdLandingMMVideoView;
  }
  
  private boolean fFL()
  {
    return (this.ddk) || (this.hJv);
  }
  
  private i hjM()
  {
    AppMethodBeat.i(307264);
    try
    {
      FullScreenMMVideoView localFullScreenMMVideoView1 = new FullScreenMMVideoView(this.mContext);
      localFullScreenMMVideoView1.setReporter(this);
      localFullScreenMMVideoView1.setIMMVideoViewCallback(this);
      localFullScreenMMVideoView1.setIMMDownloadFinish(this);
      String str = k.hkC();
      FilePathGenerator.checkMkdir(str);
      localFullScreenMMVideoView1.setRootPath(str);
      localFullScreenMMVideoView1.setIOnlineVideoProxy(new a());
      AppMethodBeat.o(307264);
      return localFullScreenMMVideoView1;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", localObject.toString());
      FullScreenMMVideoView localFullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
      AppMethodBeat.o(307264);
      return localFullScreenMMVideoView2;
    }
  }
  
  public final void Du(String paramString)
  {
    AppMethodBeat.i(96870);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(14349, paramString);
    AppMethodBeat.o(96870);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(96839);
    if (this.QTf != null)
    {
      boolean bool = this.QTf.G(paramDouble);
      AppMethodBeat.o(96839);
      return bool;
    }
    AppMethodBeat.o(96839);
    return false;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    j = 1;
    i = 1;
    AppMethodBeat.i(96832);
    this.sAo = paramInt;
    this.ddk = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!Util.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.hJv = paramBoolean;
      this.url = localPString.value;
    }
    for (;;)
    {
      try
      {
        if (this.QTf != null) {
          continue;
        }
        if (!fFL()) {
          continue;
        }
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = fFI();
        paramInt = i;
      }
      finally
      {
        paramInt = 0;
        Log.e("MicroMsg.AdLandingVideoWrapper", paramString.toString());
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = fFJ();
        paramInt = i;
        continue;
        if (!fFL()) {
          continue;
        }
        if (!(this.QTf instanceof MMVideoView)) {
          continue;
        }
        this.QTf.stop();
        this.QTf.eLM();
        removeView((View)this.QTf);
        try
        {
          Log.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.QTf = fFI();
          paramInt = i;
          continue;
        }
        finally
        {
          paramInt = j;
        }
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf.stop();
        paramInt = 0;
        continue;
        if (!(this.QTf instanceof CommonVideoView)) {
          continue;
        }
        if (!this.Flq) {
          continue;
        }
        this.QTf.stop();
        this.QTf.eLM();
        removeView((View)this.QTf);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = hjM();
        paramInt = i;
        continue;
        this.QTf.stop();
        this.QTf.eLM();
        removeView((View)this.QTf);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf = fFJ();
        paramInt = i;
        continue;
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.QTf.stop();
        paramInt = 0;
        continue;
      }
      setScaleType(this.NHS);
      bM(this.sAn);
      setMute(this.nLP);
      if (paramInt != 0)
      {
        setVideoFooterView(this.vZr);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.QTf, paramString);
      }
      this.QTf.b(this.ddk, this.url, this.sAo);
      AppMethodBeat.o(96832);
      return;
      paramBoolean = false;
      break;
      if (!this.Flq) {
        continue;
      }
      Log.i("MicroMsg.AdLandingVideoWrapper", "%d use full screen mm video  view !", new Object[] { Integer.valueOf(hashCode()) });
      this.QTf = hjM();
      paramInt = i;
    }
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(96840);
    if (this.QTf != null)
    {
      paramBoolean = this.QTf.b(paramDouble, paramBoolean);
      AppMethodBeat.o(96840);
      return paramBoolean;
    }
    AppMethodBeat.o(96840);
    return false;
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(96858);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(96858);
      return false;
    }
    this.sAn = paramFloat;
    if (this.QTf != null)
    {
      boolean bool = this.QTf.bM(this.sAn);
      AppMethodBeat.o(96858);
      return bool;
    }
    AppMethodBeat.o(96858);
    return false;
  }
  
  public final void bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96859);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(96859);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96860);
    Log.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.vZv != null) {
      this.vZv.d(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 36);
    AppMethodBeat.o(96860);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96863);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.vZv != null) {
      this.vZv.e(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96863);
  }
  
  public final void eLM()
  {
    AppMethodBeat.i(96837);
    if (this.QTf != null) {
      this.QTf.eLM();
    }
    AppMethodBeat.o(96837);
  }
  
  public final void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96861);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.vZv != null) {
      this.vZv.el(paramString1, paramString2);
    }
    AppMethodBeat.o(96861);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96862);
    Log.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.vZv != null) {
      this.vZv.em(paramString1, paramString2);
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 35);
    AppMethodBeat.o(96862);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96864);
    Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.vZw.gR(false);
    if (this.vZv != null) {
      this.vZv.en(paramString1, paramString2);
    }
    AppMethodBeat.o(96864);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96865);
    Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.vZw.a(this);
    if (this.vZv != null) {
      this.vZv.eo(paramString1, paramString2);
    }
    AppMethodBeat.o(96865);
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96866);
    if (this.vZv != null) {
      this.vZv.ep(paramString1, paramString2);
    }
    AppMethodBeat.o(96866);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96867);
    if (this.vZv != null) {
      this.vZv.eq(paramString1, paramString2);
    }
    AppMethodBeat.o(96867);
  }
  
  public final void gE(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(96846);
    if (this.QTf != null)
    {
      int i = this.QTf.getCacheTimeSec();
      AppMethodBeat.o(96846);
      return i;
    }
    AppMethodBeat.o(96846);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(96844);
    if (this.QTf != null)
    {
      int i = this.QTf.getCurrPosMs();
      AppMethodBeat.o(96844);
      return i;
    }
    AppMethodBeat.o(96844);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(96845);
    if (this.QTf != null)
    {
      int i = this.QTf.getCurrPosSec();
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
    if ((this.QTf instanceof AdLandingMMVideoView))
    {
      localView = ((AdLandingMMVideoView)this.QTf).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    if ((this.QTf instanceof MMVideoView))
    {
      localView = ((MMVideoView)this.QTf).getInnerVideoView();
      AppMethodBeat.o(176282);
      return localView;
    }
    AppMethodBeat.o(176282);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(96838);
    if (this.QTf != null)
    {
      int i = this.QTf.getPlayerType();
      AppMethodBeat.o(96838);
      return i;
    }
    AppMethodBeat.o(96838);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(96843);
    if (this.QTf != null)
    {
      i = this.QTf.getVideoDurationSec();
      AppMethodBeat.o(96843);
      return i;
    }
    int i = this.sAo;
    AppMethodBeat.o(96843);
    return i;
  }
  
  public final void hjN()
  {
    AppMethodBeat.i(96835);
    this.QTh.stopTimer();
    this.QTh.startTimer(1000L);
    AppMethodBeat.o(96835);
  }
  
  public final void hp(long paramLong)
  {
    AppMethodBeat.i(96869);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(96869);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(96848);
    if (this.QTf != null)
    {
      boolean bool = this.QTf.isLive();
      AppMethodBeat.o(96848);
      return bool;
    }
    AppMethodBeat.o(96848);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(96847);
    if (this.QTf != null)
    {
      boolean bool = this.QTf.isPlaying();
      AppMethodBeat.o(96847);
      return bool;
    }
    AppMethodBeat.o(96847);
    return false;
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(96856);
    if (this.QTf != null) {
      this.QTf.onUIDestroy();
    }
    this.vZw.gR(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96856);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(96855);
    if (this.QTf != null) {
      this.QTf.onUIPause();
    }
    this.vZw.gR(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(96855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(96854);
    if (this.QTf != null) {
      this.QTf.onUIResume();
    }
    AppMethodBeat.o(96854);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(96852);
    if (this.QTf != null)
    {
      setKeepScreenOn(false);
      this.vZw.gR(false);
      boolean bool = this.QTf.pause();
      AppMethodBeat.o(96852);
      return bool;
    }
    AppMethodBeat.o(96852);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96849);
    if (this.QTf != null) {
      this.QTf.setCover(paramBitmap);
    }
    AppMethodBeat.o(96849);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(96842);
    if (this.QTf != null) {
      this.QTf.setFullDirection(paramInt);
    }
    AppMethodBeat.o(96842);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.vZv = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(96841);
    if (this.QTf != null) {
      this.QTf.setIsShowBasicControls(paramBoolean);
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
    AppMethodBeat.i(307302);
    try
    {
      if (this.QTf != null) {
        this.QTf.setLoop(paramBoolean);
      }
      AppMethodBeat.o(307302);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", localObject.toString());
      AppMethodBeat.o(307302);
    }
  }
  
  public void setLoopCompletionCallback(i.d paramd)
  {
    AppMethodBeat.i(307305);
    try
    {
      if (this.QTf != null) {
        this.QTf.setLoopCompletionCallback(paramd);
      }
      AppMethodBeat.o(307305);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingVideoWrapper", paramd.toString());
      AppMethodBeat.o(307305);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(96853);
    this.nLP = paramBoolean;
    if (this.QTf != null) {
      this.QTf.setMute(this.nLP);
    }
    AppMethodBeat.o(96853);
  }
  
  public void setNeedPause(boolean paramBoolean)
  {
    AppMethodBeat.i(307388);
    if ((this.QTf instanceof AdLandingMMVideoView)) {
      ((AdLandingMMVideoView)this.QTf).setNeedPause(paramBoolean);
    }
    AppMethodBeat.o(307388);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(96857);
    this.NHS = parame;
    if (this.QTf != null) {
      this.QTf.setScaleType(this.NHS);
    }
    AppMethodBeat.o(96857);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(96836);
    this.vZr = paramh;
    if (this.QTf != null) {
      this.QTf.setVideoFooterView(this.vZr);
    }
    AppMethodBeat.o(96836);
  }
  
  public void setVideoPlayCallback(AdLandingVideoWrapper.a parama)
  {
    this.QTg = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(96850);
    if (this.QTf != null)
    {
      this.QTf.start();
      setKeepScreenOn(true);
      this.vZw.a(this);
    }
    AppMethodBeat.o(96850);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(96851);
    if (this.QTf != null)
    {
      this.QTf.stop();
      this.vZw.gR(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(96851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */