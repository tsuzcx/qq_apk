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
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FtsVideoWrapper
  extends RelativeLayout
  implements d.a, i, i.a, i.b, i.c
{
  private i.e HKU;
  private i Kuv;
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
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FtsVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77989);
    this.HKU = i.e.RcG;
    this.lhf = false;
    this.pvh = -1.0F;
    this.mContext = paramContext;
    this.sUi = d.bcs();
    AppMethodBeat.o(77989);
  }
  
  private i exM()
  {
    AppMethodBeat.i(77991);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.setIMMVideoViewCallback(this);
    AppMethodBeat.o(77991);
    return localCommonVideoView;
  }
  
  public final void EW(long paramLong)
  {
    AppMethodBeat.i(78025);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(78025);
  }
  
  public final void KP(String paramString)
  {
    AppMethodBeat.i(78026);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(14349, paramString);
    AppMethodBeat.o(78026);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(77996);
    if (this.Kuv != null)
    {
      paramBoolean = this.Kuv.a(paramDouble, paramBoolean);
      AppMethodBeat.o(77996);
      return paramBoolean;
    }
    AppMethodBeat.o(77996);
    return false;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(78014);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78014);
      return false;
    }
    this.pvh = paramFloat;
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.aO(this.pvh);
      AppMethodBeat.o(78014);
      return bool;
    }
    AppMethodBeat.o(78014);
    return false;
  }
  
  public final void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78015);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(78015);
      return;
    }
    if ((this.Kuv instanceof MMVideoView))
    {
      this.Kuv.stop();
      this.Kuv.egX();
      removeView((View)this.Kuv);
      Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.Kuv = exM();
    }
    for (int i = 1;; i = 0)
    {
      setScaleType(this.HKU);
      aO(this.pvh);
      setMute(this.lhf);
      if (i != 0)
      {
        setVideoFooterView(this.sUd);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.Kuv, paramString);
        this.Kuv.c(this.bjq, this.url, this.pvi);
        this.Kuv.start();
      }
      AppMethodBeat.o(78015);
      return;
    }
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78016);
    Log.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78016);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(77990);
    this.pvi = paramInt;
    this.bjq = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    Util.isNullOrNil(localPString.value);
    this.fEF = false;
    this.url = localPString.value;
    if (this.Kuv == null)
    {
      Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.Kuv = exM();
      paramInt = 1;
    }
    for (;;)
    {
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
      AppMethodBeat.o(77990);
      return;
      if ((this.Kuv instanceof MMVideoView))
      {
        this.Kuv.stop();
        this.Kuv.egX();
        removeView((View)this.Kuv);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv = exM();
        paramInt = 1;
      }
      else
      {
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.Kuv.stop();
        paramInt = 0;
      }
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78019);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sUh != null) {
      this.sUh.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(78019);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78017);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sUh != null) {
      this.sUh.dS(paramString1, paramString2);
    }
    AppMethodBeat.o(78017);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78018);
    Log.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sUh != null) {
      this.sUh.dT(paramString1, paramString2);
    }
    AppMethodBeat.o(78018);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78020);
    Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.sUi.fZ(false);
    if (this.sUh != null) {
      this.sUh.dU(paramString1, paramString2);
    }
    AppMethodBeat.o(78020);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78021);
    Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.sUi.a(this);
    if (this.sUh != null) {
      this.sUh.dV(paramString1, paramString2);
    }
    AppMethodBeat.o(78021);
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78022);
    if (this.sUh != null) {
      this.sUh.dW(paramString1, paramString2);
    }
    AppMethodBeat.o(78022);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78023);
    if (this.sUh != null) {
      this.sUh.dX(paramString1, paramString2);
    }
    AppMethodBeat.o(78023);
  }
  
  public final void egX()
  {
    AppMethodBeat.i(77993);
    if (this.Kuv != null) {
      this.Kuv.egX();
    }
    AppMethodBeat.o(77993);
  }
  
  public final void fC(String paramString1, String paramString2) {}
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(78002);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCacheTimeSec();
      AppMethodBeat.o(78002);
      return i;
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(78000);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCurrPosMs();
      AppMethodBeat.o(78000);
      return i;
    }
    AppMethodBeat.o(78000);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(78001);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getCurrPosSec();
      AppMethodBeat.o(78001);
      return i;
    }
    AppMethodBeat.o(78001);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(77994);
    if (this.Kuv != null)
    {
      int i = this.Kuv.getPlayerType();
      AppMethodBeat.o(77994);
      return i;
    }
    AppMethodBeat.o(77994);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(77999);
    if (this.Kuv != null)
    {
      i = this.Kuv.getVideoDurationSec();
      AppMethodBeat.o(77999);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(77999);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(78004);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.isLive();
      AppMethodBeat.o(78004);
      return bool;
    }
    AppMethodBeat.o(78004);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(78003);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.isPlaying();
      AppMethodBeat.o(78003);
      return bool;
    }
    AppMethodBeat.o(78003);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(78012);
    if (this.Kuv != null) {
      this.Kuv.onUIDestroy();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78012);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(78011);
    if (this.Kuv != null) {
      this.Kuv.onUIPause();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(78011);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(78010);
    if (this.Kuv != null) {
      this.Kuv.onUIResume();
    }
    AppMethodBeat.o(78010);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(77995);
    if (this.Kuv != null)
    {
      boolean bool = this.Kuv.p(paramDouble);
      AppMethodBeat.o(77995);
      return bool;
    }
    AppMethodBeat.o(77995);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(78008);
    if (this.Kuv != null)
    {
      setKeepScreenOn(false);
      this.sUi.fZ(false);
      boolean bool = this.Kuv.pause();
      AppMethodBeat.o(78008);
      return bool;
    }
    AppMethodBeat.o(78008);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78005);
    if (this.Kuv != null) {
      this.Kuv.setCover(paramBitmap);
    }
    AppMethodBeat.o(78005);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(77998);
    if (this.Kuv != null) {
      this.Kuv.setFullDirection(paramInt);
    }
    AppMethodBeat.o(77998);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    this.sUh = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(77997);
    if (this.Kuv != null) {
      this.Kuv.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(77997);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(78024);
    Log.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(78024);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(78009);
    this.lhf = paramBoolean;
    if (this.Kuv != null) {
      this.Kuv.setMute(this.lhf);
    }
    AppMethodBeat.o(78009);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(78013);
    this.HKU = parame;
    if (this.Kuv != null) {
      this.Kuv.setScaleType(this.HKU);
    }
    AppMethodBeat.o(78013);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(77992);
    this.sUd = paramh;
    if (this.Kuv != null) {
      this.Kuv.setVideoFooterView(this.sUd);
    }
    AppMethodBeat.o(77992);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78006);
    if (this.Kuv != null)
    {
      this.Kuv.start();
      setKeepScreenOn(true);
      this.sUi.a(this);
    }
    AppMethodBeat.o(78006);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(78007);
    if (this.Kuv != null)
    {
      this.Kuv.stop();
      this.sUi.fZ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(78007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper
 * JD-Core Version:    0.7.0.1
 */